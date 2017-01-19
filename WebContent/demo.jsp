<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>File Upload</title>
<meta http-equiv="Content-Type" content="text/html; charset=big5">
</head>
<body>
	<p>
		<font size="5" color="#FF0000"><b>檔案上傳</b></font>
	</p>

	<!-- <form name="upload" enctype="multipart/form-data" method="post"
		action="./UploadServlet">
		<p>
			上傳檔案： <input type="file" name="file" size="20" maxlength="20">
		</p>
		<p>
			檔案說明： <input type="text" name="filedesc" size="30" maxlength="50">
		</p>
		<p>
			上傳檔案： <input type="file" name="file" size="20" maxlength="20">
		</p>
		<p>
			檔案說明： <input type="text" name="filedesc" size="30" maxlength="50">
		</p>
		<p>
			<input type="submit" value="上傳"> <input type="reset"
				value="清除">
		</p>
	</form> -->

	<form name="upload" enctype="multipart/form-data" method="post"
		action="./UploadServlet" class="form-horizontal" role="form" >
		<!-- #section:elements.form -->
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right"
				for="form-field-1"> 日期 </label>
			<div class="col-sm-9" for="dnt_date">
				<div class="input-group col-xs-10 col-sm-5">
					<span class="input-group-addon"> <i
						class="fa fa-calendar bigger-110"></i>
					</span> <input id="news_date" class="form-control" type="date"
						name="date-picker" id="date-picker-1">
				</div>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right"
				for="form-field-1"> 文章標題 </label>

			<div class="col-sm-9" for="dnt_name">
				<input id="news_title" name="dnt_name" type="text" id="form-field-1"
					placeholder="文章標題" class="col-xs-10 col-sm-5" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right"
				for="form-field-1"> 內文 </label>

			<div class="col-sm-9" for="dnt_ikt">
				<!-- <input id="dnt_ikt" name="dnt_ikt" type="text"
													id="form-field-1" placeholder="內文"
													class="col-xs-10 col-sm-5" required /> -->
				<textarea class="col-xs-10 col-sm-5" id="news_content" name="news_content"
					placeholder="文章內容"></textarea>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right"
				for="form-field-1"> 文章圖片 </label>

			<div class="col-sm-9">
				<div class="input-group col-xs-10 col-sm-5">
					<!-- <input type="file" id="id-input-file-3" /> -->
						 <input type="file" name="file">
				</div>
			</div>
		</div>

		<div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-info" type="submit">
					<i class="ace-icon fa fa-check bigger-110"></i> <font
						style="color: #fff;">儲存</font>
				</button>

				&nbsp; &nbsp; &nbsp;
				<button class="btn btn-cancel" type="reset">
					<i class="ace-icon fa fa-undo bigger-110"></i> 取消
				</button>
			</div>
		</div>
	</form>

</body>
</html>

