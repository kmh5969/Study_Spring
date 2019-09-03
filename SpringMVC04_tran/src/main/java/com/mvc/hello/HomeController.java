package com.mvc.hello;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.hello.dto.CustomerDto;
import com.mvc.hello.model.biz.CustomerBiz;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private CustomerBiz biz;

	@RequestMapping(value = "/list.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "selectlist";
	}
	@RequestMapping(value = "/selectone.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String selectOne(Model model, String id) {
		
		model.addAttribute("dto",biz.selectone(id));
		
		return "selectone";
	}
	@RequestMapping(value = "/insertform.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String insertform() {
		return "insertform";
	}
	@RequestMapping(value = "/updateform.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String updateform(Model model,String id) {
		model.addAttribute("dto",biz.selectone(id));
		return "updateform";
	}
	@RequestMapping(value = "/insert.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String insert(CustomerDto dto) {
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:insertform.do";
		}
	}
	@RequestMapping(value = "/update.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String update(CustomerDto dto) {
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:selectone.do?id="+dto.getId();
		}else {
			return "redirect:updateform.do?id="+dto.getId();
		}
	}
	@RequestMapping(value = "/delete.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String delete(String id) {
		int res = biz.delete(id);
		
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:selectOne.do?id"+id;
		}
		
	}
	@RequestMapping(value = "/loginform.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String loginform() {
		return "login";
	}
	
	@RequestMapping(value = "/loginajax.do", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String, Boolean> loginAjax(String id, String pw, HttpSession session) {
		//@ResponseBody : java 객체를 response 객체에 binding
		
		CustomerDto dto = biz.login(id, pw);
		boolean loginchk = false;
		
		if(dto != null) {
			session.setAttribute("dto", dto);
			loginchk = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("loginchk", loginchk);
		
		return map;
	}
	
	@RequestMapping(value = "/test.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String test() {
		
		biz.test();
		
		return "redirect:list.do";
	}
}
