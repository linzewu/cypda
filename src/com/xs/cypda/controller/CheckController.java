package com.xs.cypda.controller;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xs.cypda.manager.CheckManage;
import com.xs.cypda.manager.UserManager;

import net.sf.json.xml.XMLSerializer;

@Controller
@RequestMapping("/check")
public class CheckController {
	
	static Logger logger = Logger.getLogger(CheckController.class);
	
	@Resource(name="userManager")
	private UserManager userManager;
	
	@Resource(name="checkManage")
	private CheckManage checkManage;
	
	
	@RequestMapping("/write")
	public @ResponseBody String write(@RequestParam Map<String,Object> param) throws UnsupportedEncodingException, RemoteException, DocumentException{
		String jkid=(String) param.remove("jkid");
		logger.info("jkid:"+jkid);
		logger.info(param);
		Document doc = checkManage.write(jkid, param);
		return new XMLSerializer().read(doc.asXML()).toString();
	}

	@RequestMapping("/query")
	public @ResponseBody String query(@RequestParam Map<String,Object> param) throws UnsupportedEncodingException, RemoteException, DocumentException{
		String jkid=(String) param.remove("jkid");
		logger.info("jkid:"+jkid);
		logger.info(param);
		Document doc = checkManage.queryws(jkid, param);
		return new XMLSerializer().read(doc.asXML()).toString();
	}
	
	@RequestMapping("/getGonggaoList")
	public @ResponseBody List<Map<String,Object>> getGonggaoList(@RequestParam String clxh){
		return checkManage.getGonggaoList(clxh);
	}
}
