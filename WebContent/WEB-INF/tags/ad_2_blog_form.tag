<%@tag description="TEST MSG" pageEncoding="UTF-8"%>
<%@attribute name="headline"%>
<form class="form-horizontal" role="form" hidden="true">
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
			<textarea class="col-xs-10 col-sm-5" id="news_content"
				placeholder="文章內容"></textarea>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right"
			for="form-field-1"> 文章圖片 </label>

		<div class="col-sm-9">
			<div class="input-group col-xs-10 col-sm-5">
				<!-- <input type="file" id="id-input-file-3" /> -->
				<form class="form-upload" role="form" method="post">
					<input id="news_file" />
					<button type="submit">test</button>
				</form>
			</div>
		</div>
	</div>

	<div class="clearfix form-actions">
		<div class="col-md-offset-3 col-md-9">
			<button class="btn btn-info" type="button">
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