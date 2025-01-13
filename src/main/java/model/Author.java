package model;

public class Author {
	private int id;
	private String authorname;
	private String email;
	private String phone;

	public Author() {
		
	}
	public Author (int id,String authorname, String Email, String Phone)
	{
		this.id = id;
		this.authorname = authorname;
		this.email = Email;
		this.phone = Phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Author [id=" + id + ", authorname=" + authorname + ", email=" + email + ", phone=" + phone + "]";
	}
}