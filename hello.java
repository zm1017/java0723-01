package com.ujiuye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujiuye.po.Mobile;
import com.ujiuye.service.MobileService;
//这是一个java类
@Controller
public class MobileController {

	@Autowired
	MobileService service;
	
	@RequestMapping("/getOneNum")
	public String getOneNum(String number,Model model){
		Mobile mobile =null;
		mobile = service.getMobileByNum(number);
		String msg="";
		if(mobile!=null){
			msg="号码归属地--"+mobile.getArea()+"区段--"+mobile.getMobiletype();
		}else{
			msg=mobile+"不存在";
		}
		model.addAttribute("mobile",msg);
		return "index";
	}
}
