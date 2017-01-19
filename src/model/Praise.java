package model;
/* praise */
public class Praise {

	private int id;
	private String name; //活動名稱
	private String title;//獎項
	private String ppl;	//獲獎人
	private String file;//圖片
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPpl() {
		return ppl;
	}
	public void setPpl(String ppl) {
		this.ppl = ppl;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("praise [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", name=");
		builder.append(name);
		builder.append(", ppl=");
		builder.append(ppl);
		builder.append(", file=");
		builder.append(file);
		builder.append("]");
		return builder.toString();
	}
	
	
}
