package com.xs.cypda.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.xs.common.BeanXMLUtil;
import com.xs.cypda.service.client.TmriJaxRpcOutAccessServiceStub;
import com.xs.cypda.service.client.TmriJaxRpcOutAccessServiceStub.QueryObjectOutResponse;
import com.xs.cypda.service.client.TmriJaxRpcOutAccessServiceStub.WriteObjectOutResponse;
import com.xs.cypda.service.client.TmriJaxRpcOutNewAccessServiceStub;
import com.xs.cypda.service.client.TmriJaxRpcOutNewAccessServiceStub.QueryObjectOutNewResponse;
import com.xs.cypda.service.client.TmriJaxRpcOutNewAccessServiceStub.WriteObjectOutNewResponse;
import com.xs.cypda.service.client.TmriJaxRpcOutService;

@Service("checkManage")
public class CheckManage {

	private static Logger logger = Logger.getLogger(CheckManage.class);

	private TmriJaxRpcOutAccessServiceStub tro = null;

	@Value("${jkxlh}")
	private String jkxlh;

	@Value("${xtlb}")
	private String xtlb;
	
	@Autowired
	private TmriJaxRpcOutService tmriJaxRpcOutService;

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

//	public CheckManage() {
//		try {
//			tro = new TmriJaxRpcOutAccessServiceStub();
//		} catch (AxisFault e) {
//			logger.error("链接专网查验平台失败", e);
//		} catch (IOException e) {
//			logger.error("加载rca配置文件出错", e);
//		}
//	}

	public Document write(String jkid, Map data)
			throws UnsupportedEncodingException, RemoteException, DocumentException {
		try {
			//TmriJaxRpcOutAccessServiceStub.WriteObjectOut woo = new TmriJaxRpcOutAccessServiceStub.WriteObjectOut();
			TmriJaxRpcOutNewAccessServiceStub trias =tmriJaxRpcOutService.createTmriJaxRpcOutNewAccessServiceStub();
			TmriJaxRpcOutNewAccessServiceStub.WriteObjectOutNew woo = tmriJaxRpcOutService.createWriteObjectOut();
			woo.setJkid(jkid);
			//woo.setXtlb(xtlb);
			//woo.setJkxlh(jkxlh);
			Document xml = BeanXMLUtil.map2xml(data, "vehpara");
			logger.info("BO===:" + xml.asXML());
			woo.setUTF8XmlDoc(xml.asXML());
			WriteObjectOutNewResponse wor = trias.writeObjectOutNew(woo);
			String response = wor.getWriteObjectOutNewReturn();
			response = URLDecoder.decode(response, "utf-8");
			Document document = DocumentHelper.parseText(response);
			logger.info(document.asXML());
			return document;
		} catch (UnsupportedEncodingException e) {
			logger.error("xmlencoding异常", e);
			throw e;
		} catch (RemoteException e) {
			logger.error("远程连接异常", e);
			throw e;
		} catch (DocumentException e) {
			logger.error("response parseText异常", e);
			throw e;
		}
	}

	public Document queryws(String jkid, Map param)
			throws RemoteException, UnsupportedEncodingException, DocumentException {

		//TmriJaxRpcOutAccessServiceStub.QueryObjectOut qoo = new TmriJaxRpcOutAccessServiceStub.QueryObjectOut();
		TmriJaxRpcOutNewAccessServiceStub trias = tmriJaxRpcOutService.createTmriJaxRpcOutNewAccessServiceStub();
		TmriJaxRpcOutNewAccessServiceStub.QueryObjectOutNew qoo = tmriJaxRpcOutService.createQueryObjectOut();
		qoo.setJkid(jkid);
		//qoo.setXtlb(xtlb);
		//qoo.setJkxlh(jkxlh);
		Document xml = BeanXMLUtil.map2xml(param, "QueryCondition");
		logger.info("BO===:" + xml.asXML());

		qoo.setUTF8XmlDoc(xml.asXML());
		QueryObjectOutNewResponse qoor = trias.queryObjectOutNew(qoo);

		String response = qoor.getQueryObjectOutNewReturn();
		response = URLDecoder.decode(response, "utf-8");
		Document document = DocumentHelper.parseText(response);
		logger.info(document.asXML());
		return document;
	}

	public List<Map<String, Object>> getGonggaoList(final String clxh) {
		return this.hibernateTemplate.execute(new HibernateCallback<List<Map<String, Object>>>() {
			@Override
			public List<Map<String, Object>> doInHibernate(Session session) throws HibernateException {
				return (List<Map<String, Object>>) session.createSQLQuery("select * from trffpn_app.PCB_FINAL_PARA where clxh LIKE ?")
						.setParameter(0, clxh + "%").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			}

		});
	}
}
