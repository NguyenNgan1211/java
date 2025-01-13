package model;

public class Author {
	private int authorid;
	private String authorname;
	private String email;
	private String phone;

	public Author() {
		
	}

	public Author(int authorid, String authorname, String email, String phone) {
		super();
		this.authorid = authorid;
		this.authorname = authorname;
		this.email = email;
		this.phone = phone;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", authorname=" + authorname + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	
}