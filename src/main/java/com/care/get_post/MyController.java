package com.care.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")
public class MyController {
	public MyController() {
		System.out.println("������ ����");
	}
	
	@RequestMapping("/index") //url���
	public String index() {
		System.out.println("index ����");
		return "get_post/index"; //views ���
	}
	
	@RequestMapping(value="/result", method=RequestMethod.GET) 
	public String result(HttpServletRequest req, Model model) {
		System.out.println("result ����");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		System.out.println("���۹��: "+req.getMethod());
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("method", req.getMethod());
		
		return "get_post/result"; //views ���
	}
	
	@PostMapping("/result") //(/my/result)�� (my/result) ���� ����
	public String resultPost(@RequestParam String name, @RequestParam("age")int a,
							HttpServletRequest req, Model model) {
		System.out.println("resultPost ����");
		
		model.addAttribute("name", name);
		model.addAttribute("age", a);
		model.addAttribute("method", req.getMethod());
		
		
		return "get_post/result";
	}
	
	@PostMapping("/dto") 
	public String dto(MyDTO dto, Model model) {
		System.out.println("dto ����");
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		System.out.println(dto.getAddr());
		
		model.addAttribute("dto", dto);
		
		return "get_post/dto";
	}
}