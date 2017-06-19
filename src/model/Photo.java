package model;

/* album */
public class Photo {

	// public static final String dbPhoto = null;
	/* 活動櫥窗 */
	private int id; // 編號 v
	private String date; // upload date
	private String album_id; // 相簿名稱 v
	private String path; // directory v
	private String file; // uploaded save name v
	private String title;
	private String desc; // v
	// private boolean isInMemory;
	// private long sizeInBytes;
	public static String dbPhoto = "photo"; // table name
	public static String sqlSavePhoto = "(path, fileName, album_id)";
	public static String sqlUpdateDesc = "(desc)";

	public Photo() {

	}

	public Photo(String dir, String file, String album) {
		// this.setPath(dir);
		this.setPath("album/" + album + "/");
		this.setFile(file);
		this.setAlbumId(album);
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

	public String getAlbumId() {
		return album_id;
	}

	public void setAlbumId(String albumId) {
		this.album_id = albumId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String dir) {
		this.path = dir;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Photo [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", album_id=");
		builder.append(album_id);
		builder.append(", path=");
		builder.append(path);
		builder.append(", file=");
		builder.append(file);
		builder.append(", title=");
		builder.append(title);
		builder.append(", desc=");
		builder.append(desc);
		builder.append("]");
		return builder.toString();
	}

}