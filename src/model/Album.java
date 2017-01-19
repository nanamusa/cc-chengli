package model;

/* album */
public class Album {

	/* 活動櫥窗 */
	private String date;// 日期
	private String title;// 相簿名稱
	private String desc;// 描述
	private String type;//
	private int tag; // 編號
	private String cover_id;// 圖片
	private int id; // 編號

	public Album() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public String getPic() {
		return cover_id;
	}

	public void setPic(String pic) {
		this.cover_id = pic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


}
