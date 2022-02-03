package mj.guri.vo;

public class MemberRegiVO {
	
	private String memberId;
	private String memberPassword;
	private String memberConfirmPassword;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	
	public boolean isPasswordEqualToConfirmPassword() { // 프론트엔드 자바스크립트로 만드는 영역
		return memberPassword.equals(memberConfirmPassword);
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberConfirmPassword() {
		return memberConfirmPassword;
	}
	public void setMemberConfirmPassword(String memberConfirmPassword) {
		this.memberConfirmPassword = memberConfirmPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	

}
