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

import model.Photo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.AlbumDao;
import dao.PhotoDao;

/**
 * Servlet implementation class PhotoUploader
 */
@WebServlet("/PhotoUploader")
public class UploadServlet extends HttpServlet {
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
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta content=\"text/html; UTF-8\" http-equiv=\"content-type\">");
		out.println("<title>觀看線上書籤</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table style=\"text-align: left; width: 100%;\" border=\"0\" >");
		out.println("  <tbody>");
		out.println("  <tr>");
		out.println("  <td style=\"background-color: rgb(51, 255, 255);\">網頁</td>");
		out.println("  <td style=\"background-color: rgb(51, 255, 255);\">分類</td>");
		out.println("  </tr>");
		out.println("  </tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
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
		// TODO Auto-generated method stub
		String uploadPath = this.getServletContext().getRealPath("/");
		uploadPath += ("album/");
		System.out.println("uploader::uploadPath:" + uploadPath);
		String message = null, content = null, dtme = null;
		int counter = 0;
		String albumId = null;
		List<Photo> photoSet = new ArrayList<Photo>();

		if (ServletFileUpload.isMultipartContent(request)) {
			System.out.println("uploader::isMultipartContent:"
					+ ServletFileUpload.isMultipartContent(request));
			DiskFileItemFactory disk = new DiskFileItemFactory();
			disk.setSizeThreshold(20 * 1024);
			disk.setRepository(disk.getRepository());
			ServletFileUpload up = new ServletFileUpload(disk);
			int maxsize = 2 * 1024 * 1024;
			List list;

			try {
				list = up.parseRequest(request);
				Iterator i = list.iterator();
				System.out.println("uploader::list:" + list.toString());
				Photo photo = new Photo();
				while (i.hasNext()) {

					FileItem fileItem = (FileItem) i.next();
					System.out.println("uploader::isFormField:"
							+ fileItem.isFormField());
					if (!fileItem.isFormField()) {
						String filePath = fileItem.getName();
						String fileName = "";
						int startIndex = filePath.lastIndexOf("\\");

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

						System.out.println("uploader:fileName=" + fileName);

						if (fileItem.getSize() > maxsize) {
							message = "over 2 MB";
							System.out.println("uploader:message=" + message);
							break;
						}

						String fileSize = new Long(fileItem.getSize())
								.toString();
						if (((fileName == null) || (fileName.equals("")))
								&& (fileSize.equals("0"))) {
							message = "empty file";
							System.out.println("uploader:message=" + message);
							break;
						}
						long timeStr = System.currentTimeMillis();
						photo.setTitle(fileName);
						DateFormat df = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						Date time = new Date(timeStr);

						photo.setDate(df.format(time));

						fileName = String.valueOf(timeStr) + (counter++)
								+ fileType;
						System.out.println("uploader:fileName=" + fileName);

						File saveFile = new File(uploadPath, fileName);
						try {
							fileItem.write(saveFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						photo.setPath("album/" + albumId + "/");
						photo.setFile(fileName);
						message = "upload success!";
						photoSet.add(photo);
						photo = new Photo();
						System.out.println("uploader:message=" + message);
					} else {
						String foeName = fileItem.getFieldName();
						String formContent = fileItem.getString("UTF-8"); // 編碼
						System.out.println(foeName + "=" + formContent);
						if (foeName.equals("textBox")) {
							photo.setDesc(formContent);
						} else if (foeName.equals("date")) {
							photo.setDate(formContent);

						} else if (foeName.equals("photo-albumId")) {
							albumId = formContent;
							uploadPath += formContent + "/";
							File dir = new File(uploadPath);
							if (!dir.exists()) {
								dir.mkdirs();

							}
							AlbumDao.mkdir(Integer.parseInt(albumId),
									uploadPath);
							photo.setAlbumId(formContent);
						}
						System.out.println("uploader:formContent="
								+ formContent);

					}

				}// end of while
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("upload #:" + photoSet.size());
		System.out.println(photoSet.toString());
		try {
			if (albumId != "") {
				PhotoDao.save(photoSet, albumId);
				AlbumDao.mkdir(Integer.parseInt(albumId), uploadPath);
				System.out.println("save photos: success");
			} else {
				System.out.println("lack name = photo-albumId");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
