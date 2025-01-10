package model;

public class Detail {
	private int newsid;
	private String newstitle;
	private String newscontent;
	private int authorid;
	private int menuid;
	private String image;
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Detail(int newsid, String newstitle, String newscontent, int authorid, int menuid, String image) {
		super();
		this.newsid = newsid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.authorid = authorid;
		this.menuid = menuid;
		this.image = image;
	}
	
	public Detail(String newstitle, String newscontent, int authorid, int menuid, String image) {
		super();
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.authorid = authorid;
		this.menuid = menuid;
		this.image = image;
	}
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewscontent() {
		return newscontent;
	}
	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "News [newsid=" + newsid + ", newstitle=" + newstitle + ", newscontent=" + newscontent + ", authorid="
				+ authorid + ", menuid=" + menuid + ", image=" + image + "]";
	}
	
}
