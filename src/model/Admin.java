package model;
/* ikt branch */
public class Admin {

	private int id;
	private String name;
	private String uid;
	private String upwd;
	private String email;
	private String key;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", uid=");
		builder.append(uid);
		builder.append(", upwd=");
		builder.append(upwd);
		builder.append(", email=");
		builder.append(email);
		builder.append(", key=");
		builder.append(key);
		builder.append("]");
		return builder.toString();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	
	
	
}
