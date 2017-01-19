package demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class FileUpload
 */
//@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("承利保經後台 - 登入 Login Servlet ...");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String saveDirectory = this.getServletContext().getRealPath("/admin/upload");
		System.out.println(saveDirectory);
		//String saveDirectory = "/Users/nana/Documents/workspace/chengli/WebContent/admin/album";

		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("isMultipart=" + isMultipart + "<br>");

		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Create a progress listener
		ProgressListener progressListener = new ProgressListener() {
			private long megaBytes = -1;

			public void update(long pBytesRead, long pContentLength, int pItems) {
				long mBytes = pBytesRead / 1000000;
				if (megaBytes == mBytes) {
					return;
				}
				megaBytes = mBytes;
				System.out.println("We are currently reading item " + pItems);
				if (pContentLength == -1) {
					System.out.println("So far, " + pBytesRead
							+ " bytes have been read.");
				} else {
					System.out.println("So far, " + pBytesRead + " of "
							+ pContentLength + " bytes have been read.");
				}
			}
		};
		upload.setProgressListener(progressListener);

		// Parse the request
		List items;
		try {
			items = upload.parseRequest(request);
			// Process the uploaded items
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				if (item.isFormField()) {
					// Process a regular form field
					// processFormField(item);
					String name = item.getFieldName();
					String value = item.getString();
					value = new String(value.getBytes("UTF-8"), "ISO-8859-1");
					System.out.println(name + "=" + value + "<br>");
				} else {
					// Process a file upload
					// processUploadedFile(item);
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					System.out.println("fieldName=" + fieldName + "<br>");
					System.out.println("fileName=" + fileName + "<br>");
					System.out.println("contentType=" + contentType + "<br>");
					System.out.println("isInMemory=" + isInMemory + "<br>");
					System.out.println("sizeInBytes=" + sizeInBytes + "<br>");
					if (fileName != null && !"".equals(fileName)) {
						fileName = FilenameUtils.getName(fileName);
						System.out.println("fileName saved=" + fileName + "<br>");
						File uploadedFile = new File(saveDirectory, fileName);
						item.write(uploadedFile);
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
