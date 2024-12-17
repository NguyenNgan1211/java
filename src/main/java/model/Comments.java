package model;

import java.sql.Date;
/**
 * 
 */
public class Comments {
	private int cmtid;
	private int userid;
	private int newid;
	private String content;
	private String status;
	private Date created_at;
	private user user;
	private News News;
	public Comments() {
	}

	

	public Comments(int cmtid, int userid, int newid, String content, String status, Date created_at,
			user user,News news) {
		
		this.cmtid = cmtid;
		this.userid = userid;
		this.newid = newid;
		this.content = content;
		this.status = status;
		this.created_at = created_at;
		this.user = user;
		this.News = news;
	}
	
	public int getCmtid() {
		return cmtid ;
	}
	public void setCmtid(int cmtid) {
		this.cmtid = cmtid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getNewid() {
		return newid;
	}
	public void setNewid(int newid) {
		this.newid = newid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public News getNews() {
		return News;
	}
	public void setNews(News news) {
		News = news;
	}
	@Override
	public String toString() {
		return "Comments [cmtid=" + cmtid + ", userid=" + userid + ", newid=" + newid + ", content=" + content
				+ ", status=" + status + ", created_at=" + created_at + ", user=" + user + ", News=" + News + "]";
	}



	
	

	

	

}