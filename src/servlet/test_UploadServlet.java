package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Photo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import dao.PhotoDao;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class test_UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("use POTH method to upload file.");
		response.getWriter().println(request.getLocalAddr());
		response.getWriter().println(request.getQueryString());
		response.getWriter().println(request.getRemoteAddr());
		response.getWriter().println(request.getUserPrincipal());
		response.getWriter().println(request.getRemoteUser());
		response.sendRedirect("admin/page02.jsp"); // blog management

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	// disable unchecked warning
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int MaxMemorySize = 1024 * 1024 * 1024;
		File TempDirectory = new File("/tmp");
		int MaxRequestSize = 1024 * 1024 * 1024;
		boolean writeToFile = true;
		String allowedFileTypes = ".gif .jpg .jpeg .png";
		// Photo photo = new Photo();

		String photoSetPath = request.getSession().getServletContext()
				.getRealPath("/");// request.getServletContext().getRealPath("")
		String Path = "tmp/";
		String saveDirectory = photoSetPath + "album/";

		System.out.println(saveDirectory);

		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("isMultipart=" + isMultipart);

		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory(MaxMemorySize,
				TempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);

		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);

			// Process the uploaded items
			Iterator iter = items.iterator();
			String pAlbumId = "blog";
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				String dir = saveDirectory;

				if (item.isFormField()) {
					// Process a regular form field
					// processFormField(item);
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					if ("passAlbumId".equals(name)) {
						pAlbumId = value;
						System.out.println(pAlbumId);
					} else if ("passBlogId".equals(name)) {
						pAlbumId = value;
						System.out.println("passBlogId : " + pAlbumId);
					}
					System.out.println(name + "=" + value);
				} else {
					// Process a file upload
					// processUploadedFile(item);
					// String fieldName = item.getFieldName();
					String fileName = item.getName();
					// String contentType = item.getContentType();
					// boolean isInMemory = item.isInMemory();
					// long sizeInBytes = item.getSize();
					// System.out.println("fieldName=" + fieldName);
					// System.out.println("fileName=" + fileName);
					// System.out.println("contentType=" + contentType);
					// System.out.println("isInMemory=" + isInMemory);
					// System.out.println("sizeInBytes=" + sizeInBytes);
					if (fileName != null && !"".equals(fileName)) {
						if (writeToFile) {
							fileName = FilenameUtils.getName(fileName);
							System.out.println("fileName to be saved="
									+ fileName);
							String extension = FilenameUtils
									.getExtension(fileName);
							if (allowedFileTypes.indexOf(extension
									.toLowerCase()) != -1) {
								System.out.println(pAlbumId);
								if (pAlbumId != null) {
									System.out.println("Path=" + pAlbumId);
									Path = pAlbumId + "/";
									// dir = saveDirectory + Path;
								}
								dir = saveDirectory + Path;
								File uploadedFile = new File(dir, fileName);
								if (!uploadedFile.exists()) {
									System.out.println("create document: "
											+ uploadedFile.getParentFile());
									uploadedFile.getParentFile().mkdirs();
								}
								item.write(uploadedFile);
								Photo photo = new Photo(Path, fileName,
										pAlbumId);
								PhotoDao.save(photo);
							} else {
								System.out.println("上傳的檔案不能是" + extension);
							}
						} else {
							// InputStream uploadedStream =
							// item.getInputStream();
							// ...
							// uploadedStream.close();
							// Process a file upload in memory
							byte[] data = item.get();
							System.out.println("data size=" + data.length);
						}
					}
				}
			}
		} catch (FileUploadException ex1) {
			System.out.println("上傳檔案超過最大檔案允許大小" + MaxRequestSize
					/ (1024 * 1024) + "MB !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if (pAlbumId.empty())
		response.sendRedirect("admin/page02.jsp"); // blog management

		// File file = null;
		// String desc = null;

		// DiskFileUpload dfu = new DiskFileUpload();

		// try {
		// List<FileItem> list = dfu.parseRequest(request); // 將結果放在list
		// System.out.println("visit all the file items...");
		// for (FileItem fileItem : list) {
		//
		// }
		//
		// } catch (FileUploadException e) {
		// e.printStackTrace();
		// }

	}
	// protected void doPost(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// System.out.println("updload.do");
	//
	//
	//
	// String photoSetPath =
	// request.getSession().getServletContext().getRealPath("/")//request.getServletContext().getRealPath("")
	// + "album/";// "/Users/nana/Pictures/";
	// String albumId = "";
	// String Path = "album/" + albumId;
	//
	// System.out.println("psp == " + photoSetPath); // picture save
	// System.out.println("album == " + albumId);
	// System.out.println("path == " + Path); // web read
	//
	// // 讀取請求本體
	// byte[] body = readBody(request);
	//
	// // 取得所有本體內容的字串表示
	// String textBody = new String(body, "UTF-8");// "ISO-8859-1");
	// // System.out.println(textBody);
	// // 取得上傳的檔案名稱
	// String filename = getFilename(textBody);
	// System.out.println(filename);
	// Photo photo = new Photo(Path, filename, "0");
	// try {
	// PhotoDao.save(photo);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// // 取得檔案啟始與結束位置
	// Position p = getFilePosition(request, textBody);
	//
	// // 輸出至檔案
	// File dir = new File(photoSetPath);
	//
	// if (!dir.exists()) {
	// System.out.println("create document: " + dir.getAbsolutePath());
	// dir.mkdirs();
	// }
	// writeTo(filename, body, p, photoSetPath);
	//
	// }
	//
	// class Position {
	// int begin;
	// int end;
	//
	// Position(int begin, int end) {
	// this.begin = begin;
	// this.end = end;
	// }
	// }
	//
	// private byte[] readBody(HttpServletRequest request) throws IOException {
	// int formDataLength = request.getContentLength();
	// DataInputStream dataStream = new DataInputStream(
	// request.getInputStream());
	// byte body[] = new byte[formDataLength];
	// int totalBytes = 0;
	// while (totalBytes < formDataLength) {
	// int bytes = dataStream.read(body, totalBytes, formDataLength);
	// totalBytes += bytes;
	// }
	// return body;
	// }
	//
	// private Position getFilePosition(HttpServletRequest request, String
	// textBody)
	// throws IOException {
	// // 取得檔案區段邊界資訊
	// String contentType = request.getContentType();
	// String boundaryText = contentType.substring(
	// contentType.lastIndexOf("=") + 1, contentType.length());
	// // 取得實際上傳檔案的起始與結束位置
	// int pos = textBody.indexOf("filename=\"");
	// pos = textBody.indexOf("\n", pos) + 1;
	// pos = textBody.indexOf("\n", pos) + 1;
	// pos = textBody.indexOf("\n", pos) + 1;
	// int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
	// int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
	// int end = ((textBody.substring(0,
	// boundaryLoc)).getBytes("ISO-8859-1")).length;
	// return new Position(begin, end);
	// }
	//
	// private String getFilename(String reqBody) {
	// String filename = reqBody
	// .substring(reqBody.indexOf("filename=\"") + 10);
	// filename = filename.substring(0, filename.indexOf("\n"));
	// filename = filename.substring(filename.lastIndexOf("\\") + 1,
	// filename.indexOf("\""));
	// return filename;
	// }
	//
	// private void writeTo(String filename, byte[] body, Position p, String
	// Path)
	// throws FileNotFoundException, IOException {
	// FileOutputStream fileOutputStream = new FileOutputStream(Path
	// + filename);
	// fileOutputStream.write(body, p.begin, (p.end - p.begin));
	// fileOutputStream.flush();
	// fileOutputStream.close();
	// }

}
