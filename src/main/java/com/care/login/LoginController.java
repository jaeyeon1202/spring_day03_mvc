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
		System.out.println("�α��� ��Ʈ�ѷ� ������");
	}
	
	@GetMapping("index")
	public String index() {
		System.out.println("red_index ����");
		
		return "test/index";
	}
	
	@PostMapping("login_chk")
	public String loginChk(@RequestParam String id, @RequestParam String pwd, 
								RedirectAttributes ra) {
		System.out.println("login_chk����");
		
		System.out.println("id: "+id);
		System.out.println("pwd:"+pwd);
		
		String DBId = "1", DBPwd="1"; //�ӽ�
		if(id.equals(DBId) &&pwd.equals(DBPwd)) {
			//return "redirect:/red/main";
			//return "redirect:main01?id="+id;
			//ra.addAttribute("id", id); //Ű���� ���� //�ϳ��� ���� �ѱ涧
			//return "redirect:main02";
			TestDTO dto = new TestDTO();
			dto.setId("aaa");
			dto.setPwd("aaa");
			dto.setName("ȫ�浿");
			ra.addFlashAttribute(dto); //��ü�� �Ѱ��ٶ�
			return "redirect:main03";
		}
		
		return "redirect:/red/index";
	}

	@GetMapping("main03")
	public String main03(TestDTO d) { //�ش��ϴ� �ڷ������� �޴´�.
		System.out.println("main03����");
		System.out.println("==�α��� ����3!==>"+d.getId());
		System.out.println("==�α��� ����3!==>"+d.getPwd());
		System.out.println("==�α��� ����3!==>"+d.getName());
		return null;
	}
	
	@GetMapping("main02")
	public String main02(@RequestParam String id) {
		System.out.println("main02����");
		System.out.println("==�α��� ����!==>"+id);
		return null;
	}
	
	@GetMapping("main01")
	public String main01(@RequestParam String id) {
		System.out.println("main01����");
		System.out.println("==�α��� ����!==>" +id);
		return null;
	}
	
	@GetMapping("main")
	public String main() {
		System.out.println("main����");
		System.out.println("==�α��� ����!==");
		return null;
	}
}
