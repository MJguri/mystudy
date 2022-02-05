package mj.guri.vo;

import java.util.Date;

public class AdminQnaVO {
	
	private int qnaBoardNum;
	private String qnaBoardTitle;
	private String memberName;
	private Date qnaBoardRegdate;
	private int qnaBoardCount;
	private String commentYn;
	
	public AdminQnaVO() {}
	
	public AdminQnaVO(int qnaBoardNum, String qnaBoardTitle, String memberName, Date qnaBoardRegdate,
			int qnaBoardCount, String commentYn) {
		super();
		this.qnaBoardNum = qnaBoardNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.memberName = memberName;
		this.qnaBoardRegdate = qnaBoardRegdate;
		this.qnaBoardCount = qnaBoardCount;
		this.commentYn = commentYn;
	}
	
	public int getQnaBoardNum() {
		return qnaBoardNum;
	}
	public void setQnaBoardNum(int qnaBoardNum) {
		this.qnaBoardNum = qnaBoardNum;
	}
	public String getQnaBoardTitle() {
		return qnaBoardTitle;
	}
	public void setQnaBoardTitle(String qnaBoardTitle) {
		this.qnaBoardTitle = qnaBoardTitle;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getQnaBoardRegdate() {
		return qnaBoardRegdate;
	}
	public void setQnaBoardRegdate(Date qnaBoardRegdate) {
		this.qnaBoardRegdate = qnaBoardRegdate;
	}
	public int getQnaBoardCount() {
		return qnaBoardCount;
	}
	public void setQnaBoardCount(int qnaBoardCount) {
		this.qnaBoardCount = qnaBoardCount;
	}
	public String getCommentYn() {
		return commentYn;
	}

	public void setCommentYn(String commentYn) {
		this.commentYn = commentYn;
	}
	
}
