package model;

/* news */
public class CLNews {

	/* 最新消息 */
	private String date;// 日期
	private String title;// 標題
	private String content;// 內文
	private String file;// 圖片
	private int id; // 編號

	public CLNews() {

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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
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
		builder.append("news [date=");
		builder.append(date);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", file=");
		builder.append(file);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}


}
