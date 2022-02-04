package mj.guri.vo;

import java.util.Date;

public class QnaDetailVO {
	
	private String qnaBoardTitle;
	private Date qnaBoardRegdate;
	private String memberName;
	private int qnaBoardCount;
	private String qnaBoardContent;
	private String commentContent;
	private Date commentRegdate;
	
	public QnaDetailVO() {}
	
	public QnaDetailVO(String qnaBoardTitle, Date qnaBoardRegdate, String memberName, int qnaBoardCount,
			String qnaBoardContent, String commentContent, Date commentRegdate) {
		super();
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardRegdate = qnaBoardRegdate;
		this.memberName = memberName;
		this.qnaBoardCount = qnaBoardCount;
		this.qnaBoardContent = qnaBoardContent;
		this.commentContent = commentContent;
		this.commentRegdate = commentRegdate;
	}
	public String getQnaBoardTitle() {
		return qnaBoardTitle;
	}
	public void setQnaBoardTitle(String qnaBoardTitle) {
		this.qnaBoardTitle = qnaBoardTitle;
	}
	public Date getQnaBoardRegdate() {
		return qnaBoardRegdate;
	}
	public void setQnaBoardRegdate(Date qnaBoardRegdate) {
		this.qnaBoardRegdate = qnaBoardRegdate;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getQnaBoardCount() {
		return qnaBoardCount;
	}
	public void setQnaBoardCount(int qnaBoardCount) {
		this.qnaBoardCount = qnaBoardCount;
	}
	public String getQnaBoardContent() {
		return qnaBoardContent;
	}
	public void setQnaBoardContent(String qnaBoardContent) {
		this.qnaBoardContent = qnaBoardContent;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentRegdate() {
		return commentRegdate;
	}
	public void setCommentRegdate(Date commentRegdate) {
		this.commentRegdate = commentRegdate;
	}
	
	

}
