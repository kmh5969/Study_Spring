package com.mvc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.hello.dto.CustomerDto;
import com.mvc.hello.model.biz.CustomerBizImpl;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerBizImpl biz;

	@RequestMapping(value = "/list.d○", method = {RequestMethod.GET,RequestMethod.POST})
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "selectlist";
	}
	@RequestMapping(value = "/selectone.d○", method = {RequestMethod.GET,RequestMethod.POST})
	public String selectOne(Model model, String id) {
		
		model.addAttribute("dt○", biz.selectone(id));
		
		return "selectone";
	}
	@RequestMapping(value = "/insertform.d○", method = {RequestMethod.GET,RequestMethod.POST})
	public String insertform() {
		return "insertform";
	}
	@RequestMapping(value = "/updateform.d○", method = {RequestMethod.GET,RequestMethod.POST})
	public String updateform(Model model,String id) {
		model.addAttribute("dt○", biz.selectone(id));
		return "updateform";
	}
	@RequestMapping(value = "/insert.d○", method = {RequestMethod.GET,RequestMethod.POST})
	public String insert(CustomerDto dto) {
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.d○";
			
		}else {
			return "redirect:insertform.d○";
		}
	}
	@RequestMapping(value = "/update.d○", method = {RequestMethod.GET,RequestMethod.POST})
	public String update(CustomerDto dto) {
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:selectone.do?id=" + dto.getId();
			
		}else {
			return "redirect:updateform.do?id=" + dto.getId();
		}
	}
	@RequestMapping(value = "/delete.d○", method = {RequestMethod.GET,RequestMethod.POST})
	public String delete(String id) {
		int res = biz.delete(id);
		
		if(res>0) {
			return "redirect:list.d○";
			
		}else {
			return "redirect:selectOne.do?id" + id;
		}
		
	}
}
