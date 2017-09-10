package com.xs.cypda.manager;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.xs.cypda.entity.User;

@Service("userManager")
public class UserManager {

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public User userLogin(String xm, String sfzmhm) {
		List<User> users = (List<User>) hibernateTemplate.find("from User where xm=? and sfzmhm like ?", xm,
				"%" + sfzmhm);
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
