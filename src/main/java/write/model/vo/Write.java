package write.model.vo;

import java.sql.Date;

public class Write {
	private int noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private String noticeWriter;
	private Date noticeDate;
	private int noticeGood;
	private int noticeView;
	private int noticeComment;
	
	
	
	public Write(String noticeSubject, String noticeContent, String noticeWriter) {
		super();
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeSubject() {
		return noticeSubject;
	}
	public void setNoticeSubject(String noticeSubject) {
		this.noticeSubject = noticeSubject;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public int getNoticeGood() {
		return noticeGood;
	}
	public void setNoticeGood(int noticeGood) {
		this.noticeGood = noticeGood;
	}
	public int getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}
	public int getNoticeComment() {
		return noticeComment;
	}
	public void setNoticeComment(int noticeComment) {
		this.noticeComment = noticeComment;
	}
	
	
	
}	
