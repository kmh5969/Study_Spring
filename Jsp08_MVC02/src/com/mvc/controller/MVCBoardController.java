package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

@Controller
public class MVCBoardController {
	
	@Autowired
	private MVCBoardBizImpl biz;
	
	@RequestMapping("/boardlist.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping("/selectone.do")
	public String selectOne(Model model, int seq) {
		
		model.addAttribute("selectone", biz.selectOne(seq));
		
		return "boardselectone";
	}
	
	@RequestMapping(value = "/insertform.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertForm() {
		
		return "boardinsertform";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(Model model, @ModelAttribute MVCBoardDto dto) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			return "redirect:boardlist.do";
			
		} else {
			return "boardinsertform";
		}
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "boardupdateform";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(Model model, MVCBoardDto dto) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			model.addAttribute("seq", dto.getSeq());
			return "redirect:selectone.do";
			
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "updateform.do";
		}
	}
	
	@RequestMapping("/deleteone.do")
	public String delete(Model model, int seq) {
		
		int res = biz.delete(seq);
		
		if(res > 0) {
			return "redirect:boardlist.do";
			
		} else {
			model.addAttribute("seq", seq);
			return "boardselectone";
		}
		
	}

}
