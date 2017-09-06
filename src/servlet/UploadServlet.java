package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;
import model.Photo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import util.util_log;
import dao.ArticleDao;
import dao.PhotoDao;

/**
 * Servlet implementation class PhotoUploader
 */
@WebServlet("/PhotoUploader")
public class UploadServlet extends HttpServlet {

	static util_log LOG = new util_log();
	static String msg = "Photo::";
	static int opt = 1;

	static String uploadPath = "";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		out.println("use POST method to upload file.");
		out.println(request.getLocalAddr());
		out.println(request.getQueryString());
		out.println(request.getRemoteAddr());
		out.println(request.getUserPrincipal());
		out.println(request.getRemoteUser());
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	@SuppressWarnings({ "unused", "rawtypes" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 上傳圖片server - 圖片名稱, 相簿名稱, 實體位置uploadPath
		// 儲存圖片資訊 -

		uploadPath = this.getServletContext().getRealPath("/");
		msg = "uploader::uploadPath:" + uploadPath;

		LOG.DEBUG_LOG(msg, opt);
		String dtme = null;
		int counter = 0;

		List<Photo> photoSet = new ArrayList<Photo>();
		String tmpDir = "";
		String tmpPath = "";
		int maxsize = 2 * 1024 * 1024;

		String textBox;

		if (ServletFileUpload.isMultipartContent(request)) {
			msg = "uploader::isMultipartContent: "
					+ ServletFileUpload.isMultipartContent(request);

			DiskFileItemFactory disk = new DiskFileItemFactory();
			disk.setSizeThreshold(20 * 1024);
			disk.setRepository(disk.getRepository());
			ServletFileUpload up = new ServletFileUpload(disk);

			List formList;
			// LOG.DEBUG_LOG(msg, opt);
			try {
				formList = up.parseRequest(request);
				Iterator i = formList.iterator();
				msg = "::list: " + formList.toString();
				Photo tmpPhoto = new Photo();
				// LOG.DEBUG_LOG(msg, opt);
				while (i.hasNext()) {

					FileItem fileItem = (FileItem) i.next();
					msg = fileItem.toString();
					// LOG.DEBUG_LOG(msg, opt);

					String field = fileItem.getFieldName();
					switch (field) {
					case "photo-albumId":
						tmpDir = fileItem.getString("UTF-8"); // 編碼
						if (tmpDir.equals("blog")) {
							tmpPath = "album/blog/";
						} else {
							tmpPath = "album/" + tmpDir + "/";
						}
						uploadPath += tmpPath;
						continue;

					case "textBox":

						tmpPhoto.setPath(tmpPath);
						tmpPhoto.setAlbumId(tmpDir);

						tmpPhoto.setDesc(fileItem.getString("UTF-8")); // 編碼
						long timeStr = System.currentTimeMillis();
						DateFormat df = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						Date time = new Date(timeStr);

						tmpPhoto.setDate(df.format(time));

						String tmpFileName = "";
						if (tmpPhoto.getAlbumId().equals("blog")) {
							tmpFileName = "blog-" + tmpPhoto.getDesc();
						} else {

							tmpFileName = String.valueOf(timeStr) + (counter++);

						}
						tmpPhoto.setFile(tmpFileName);
						continue;

					case "file":
						msg = tmpPhoto.toString();
						break;

					default:
						msg = "UNDEFINED";

					}
					// LOG.DEBUG_LOG(msg, opt);

					if (!fileItem.isFormField()) {
						LOG.DEBUG_LOG("upload file:" + msg, opt);

						String filePath = fileItem.getName();
						String fileName = "";
						int startIndex = filePath.lastIndexOf("\\");

						// get the original name of the file
						if (startIndex != -1) {
							fileName = filePath.substring(startIndex + 1);
						} else {
							fileName = filePath;
						}

						String fileType = ".tmp";
						startIndex = filePath.lastIndexOf(".");
						if (startIndex != -1) {
							fileType = filePath.substring(startIndex);
						}

						msg = "uploader::" + fileName + "\n";
						// file size limitation
						if (fileItem.getSize() > maxsize) {
							msg += ": over 2 MB";
							break;
						}

						String fileSize = new Long(fileItem.getSize())
								.toString();
						if (((fileName == null) || (fileName.equals("")))
								&& (fileSize.equals("0"))) {
							msg += ": empty file";
							break;
						}
						fileName = tmpPhoto.getFile() + fileType;
						// uploadPath += tmpPhoto.getPath();

						File dir = new File(uploadPath);
						if (!dir.isDirectory()) {
							dir.mkdirs();
							Album album = new Album("Blog", uploadPath, 2);
							album.setDate(tmpPhoto.getDate());
							dao.AlbumDao.create(album);
						}

						File saveFile = new File(uploadPath, fileName);
						try {
							tmpPhoto.setFile(fileName);

							if (tmpDir.equals("blog")) {
								ArticleDao.updatePic(fileName,
										tmpPhoto.getDesc());
							}

							if (saveFile.exists()) {

							} else {

								photoSet.add(tmpPhoto);
								tmpPhoto = new Photo();
							}
							fileItem.write(saveFile);

						} catch (Exception e) {
							e.printStackTrace();
						}

						// if (saveFile.exists()) {
						// tmpPhoto.setFile(fileName);
						// msg = tmpPhoto.toString();
						// // LOG.DEBUG_LOG("save " + msg, opt);
						// photoSet.add(tmpPhoto);
						// tmpPhoto = new Photo();
						// }

					}

				}// end of while
				msg = "end upload files: " + photoSet.toString();// size();
				// LOG.DEBUG_LOG(msg, opt);

				if (photoSet.size() > 0) {
					msg = "=> ";
					boolean ret = false;

					try {
						ret = PhotoDao.save(photoSet);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// AlbumDao.mkdir(albumId, uploadPath);
					msg += "save Photos: " + ret;
					LOG.DEBUG_LOG(msg, opt);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}

		}

	}

}
