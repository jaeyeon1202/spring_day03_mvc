package com.care.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("red")
public class LoginController {
	public LoginController() {
		System.out.println("로그인 컨트롤러 생성자");
	}
	
	@GetMapping("index")
	public String index() {
		System.out.println("red_index 실행");
		
		return "test/index";
	}
	
	@PostMapping("login_chk")
	public String loginChk(@RequestParam String id, @RequestParam String pwd, 
								RedirectAttributes ra) {
		System.out.println("login_chk실행");
		
		System.out.println("id: "+id);
		System.out.println("pwd:"+pwd);
		
		String DBId = "1", DBPwd="1"; //임시
		if(id.equals(DBId) &&pwd.equals(DBPwd)) {
			//return "redirect:/red/main";
			//return "redirect:main01?id="+id;
			//ra.addAttribute("id", id); //키벨류 형식 //하나의 값을 넘길때
			//return "redirect:main02";
			TestDTO dto = new TestDTO();
			dto.setId("aaa");
			dto.setPwd("aaa");
			dto.setName("홍길동");
			ra.addFlashAttribute(dto); //객체를 넘겨줄때
			return "redirect:main03";
		}
		
		return "redirect:/red/index";
	}

	@GetMapping("main03")
	public String main03(TestDTO d) { //해당하는 자료형으로 받는다.
		System.out.println("main03실행");
		System.out.println("==로그인 성공3!==>"+d.getId());
		System.out.println("==로그인 성공3!==>"+d.getPwd());
		System.out.println("==로그인 성공3!==>"+d.getName());
		return null;
	}
	
	@GetMapping("main02")
	public String main02(@RequestParam String id) {
		System.out.println("main02실행");
		System.out.println("==로그인 성공!==>"+id);
		return null;
	}
	
	@GetMapping("main01")
	public String main01(@RequestParam String id) {
		System.out.println("main01실행");
		System.out.println("==로그인 성공!==>" +id);
		return null;
	}
	
	@GetMapping("main")
	public String main() {
		System.out.println("main실행");
		System.out.println("==로그인 성공!==");
		return null;
	}
}
