<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page
	import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.util.Streams"%>
<%@ page import="org.apache.commons.io.FilenameUtils"%>
<%
	String saveDirectory = application.getRealPath("/admin/album");
	System.out.println("save Dir: " + saveDirectory);
	// for local test path
	saveDirectory = "/Users/nana/Documents/workspace/chengli/WebContent/admin/album";
	
	
	// Check that we have a file upload request
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	out.println("isMultipart=" + isMultipart + "<br>");

	// Create a new file upload handler
	ServletFileUpload upload = new ServletFileUpload();

	//Create a progress listener
	ProgressListener progressListener = new ProgressListener() {
		private long megaBytes = -1;

		public void update(long pBytesRead, long pContentLength,
				int pItems) {
			long mBytes = pBytesRead / 1000000;
			if (megaBytes == mBytes) {
				return;
			}
			megaBytes = mBytes;
			System.out.println("We are currently reading item "
					+ pItems);
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
	List<String> fileDescList = new ArrayList<String>();
	List<String> fileNameList = new ArrayList<String>();
	FileItemIterator iter = upload.getItemIterator(request);
	while (iter.hasNext()) {
		FileItemStream item = iter.next();
		String name = item.getFieldName();
		InputStream stream = item.openStream();
		if (item.isFormField()) {
			String value = Streams.asString(stream);
			out.println(name + "=" + value + "<br>");
			if ("filedesc".equals(name)) {
				fileDescList.add(value);
			}
		} else {
			System.out.println("File field " + name
					+ " with file name " + item.getName()
					+ " detected.");
			// Process the input stream
			String fieldName = item.getFieldName();
			String fileName = item.getName();
			String contentType = item.getContentType();
			out.println("fieldName=" + fieldName + "<br>");
			out.println("fileName=" + fileName + "<br>");
			out.println("contentType=" + contentType + "<br>");
			if (fileName != null && !"".equals(fileName)) {
				fileName = FilenameUtils.getName(fileName);
				out.println("fileName saved=" + fileName + "<br>");
				fileNameList.add(fileName);
				File uploadedFile = new File(saveDirectory, fileName);
				FileOutputStream uploadedFileStream = new FileOutputStream(
						uploadedFile);
				Streams.copy(stream, uploadedFileStream, true);
			}
		}
	}
	for (int i = 0; i < fileNameList.size(); i++) {
		String fileDesc = fileDescList.get(i);
		String fileName = fileNameList.get(i);
		out.println(fileName + ":" + fileDesc + "<br>");
		// save to database for future use
	}
%>
