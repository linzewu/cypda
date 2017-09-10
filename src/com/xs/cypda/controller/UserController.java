package com.xs.cypda.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xs.common.Constant;
import com.xs.common.ResultHandler;
import com.xs.cypda.entity.User;
import com.xs.cypda.manager.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userManager")
	private UserManager userManager;
	
	
	@RequestMapping("/login")
	public @ResponseBody Map userLogin(@RequestParam String xm,@RequestParam String sfzmhm){
		
		User user = this.userManager.userLogin(xm, sfzmhm);
		
		if(user!=null){
			return ResultHandler.toMyJSON(Constant.ConstantState.STATE_SUCCESS, "登陆成功", user);
		}else{
			return ResultHandler.toMyJSON(Constant.ConstantState.STATE_ERROR, "登陆失败",null);
		}
		
	}

}
