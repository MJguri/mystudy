package spring.exception;

public class AlreadyExistingmemberException extends RuntimeException{
	// 회원가입시 아이디 이미 있음
	public AlreadyExistingmemberException(String msg) {
		super(msg);
	}

}
