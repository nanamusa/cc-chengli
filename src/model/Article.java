package model;

/* news */
public class Article {

	/* 最新消息 */
	private String date;// 日期
	private String title;// 標題
	private String content;// 內文
	private String pic;// 圖片
	private int id; // 編號

	public Article() {

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("article [date=");
		builder.append(date);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", pic=");
		builder.append(pic);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}


}
