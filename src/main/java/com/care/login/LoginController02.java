package com.care.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController02 {
	
	public LoginController02() {
		System.out.println("�α�����Ʈ�ѷ�02 �����ڽ���");
	}
	
	@GetMapping("form")
	public String form() {
		System.out.println("form ����");
		return "login/form";
	}
	
	@PostMapping("login_chk")
	public String loginchk(@RequestParam String id, @RequestParam String pwd,
							HttpSession session) {
		System.out.println("login_chk ����");
		
		String DBId ="1", DBPwd="1", nick="hong";
		
		if(id.equals(DBId) && pwd.equals(DBPwd)) {
			session.setAttribute("id", id);
			session.setAttribute("nick", nick);
			return "redirect:main";
		}
		return "redirect:form";
	}
	
	@GetMapping("main")
	public String main(Model model) {
		System.out.println("main ����");
		model.addAttribute("id","abcd");
		return "login/main";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession se01, HttpServletRequest req) {
		System.out.println("logout ����");
		HttpSession se02 = req.getSession();
		System.out.println("se01 : "+se02.getAttribute("nick"));
		System.out.println("se02 : "+se02.getAttribute("nick"));
		
		se02.invalidate(); //��� ���� ����
		
		return "redirect:form";
	}
}
