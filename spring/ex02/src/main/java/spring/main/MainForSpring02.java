package spring.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.exception.AlreadyExistingmemberException;
import spring.exception.IdPasswordNotMatchingException;
import spring.exception.MemberNotFoundException;
import spring.printer.MemberListPrinter;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class MainForSpring02 {

	static Scanner scan = new Scanner(System.in);
	private static ApplicationContext ctx = null;

	public static void main(String[] args) {
		ctx = new GenericXmlApplicationContext("classpath:appCtx02.xml");// 스프링 설정파일 읽어오기
		
		// 회원 가입기능을 만들어봅시다.
		
		while(true) {
			menu();
			String selectMenu = scan.nextLine();
			
			if(selectMenu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
			}
			else if(selectMenu.equals("1")) { // 회원 가입 기능
				processNewCommand();
				continue;
			}
			else if(selectMenu.equals("2")) { // 비밀번호 변경 기능 
				processChangeCommand();
			}
			else if(selectMenu.equals("3")) { // 리스트 보기 기능
				processListcommand();
			}
			else {
				System.out.println("잘못 입력했습니다. 다시 입력하세요");
			}
		}
		

	}
	
	private static void processListcommand() { // 회원 목록 보기
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		
		listPrinter.printAll();
		
	}

	private static void processNewCommand() {
		System.out.println("회원가입을 진행합니다.");
		System.out.println("이메일");
		String email = scan.nextLine();
		System.out.println("이름");
		String name = scan.nextLine();
		System.out.println("비밀번호");
		String password = scan.nextLine();
		System.out.println("비밀번호확인");
		String confirmPassword = scan.nextLine();
		
		//입력받은 정보를 한꺼번에 묶어서 처리하기 위한 VO 객체 : RegisterRequest 생성
		
		RegisterRequest reg = new RegisterRequest();
		reg.setEmail(email);
		reg.setName(name);
		reg.setPassword(password);
		reg.setConfirmPassword(confirmPassword);
		
		if(!reg.isPasswordEqualToConfirmPassword()) { // 입력비밀번호화 확인 비밀번호를 체크
			System.out.println("비밀번호가 일치하지않습니다.");
			return;
		}
		
		//실제적으로 회원 가입 처리
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		try {
			regSvc.regist(reg);
			System.out.println("가입이 완료되었습니다.");
		}
		catch(AlreadyExistingmemberException e) {
			System.out.println("이미 존재하는 이메일 입니다.");
		}
	}
	
	private static void processChangeCommand() {
		//비밀번호 변경 기능 
		System.out.println("비밀번호를 변경합니다.");
		
		System.out.println("비밀번호를 변경할 이메일 계정을 입력하세요.");
		String email = scan.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		String oldPassword = scan.nextLine();
		System.out.println("바꿀 비밀번호를 입력하세요");
		String newPassword = scan.nextLine();
		
		//실제 비밀번호를 변경할 기능을 가진 객체를 불러와야 한다.
		ChangePasswordService changeSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			changeSvc.changePassword(email, oldPassword, newPassword);
			System.out.println("비밀번호가 변경되었습니다.");
		}
		catch(MemberNotFoundException e){
			System.out.println("존재하지 않는 이메일입니다.");
		}
		catch(IdPasswordNotMatchingException e) {
			System.out.println("아이디와 패스워드가 일치하지않습니다");
		}
		
	}
		
		

	private static void menu() {
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.회원가입");
		System.out.println("2.비밀번호변경");
		System.out.println("3.회원목록보기");
		System.out.println("0.프로그램종료");
	}
}
		
