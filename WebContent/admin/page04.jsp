<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="html" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>承利保險經紀人 後台管理 - 活動櫥窗</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
<link rel="stylesheet" href="./assets/css/font-awesome.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="./assets/css/jquery-ui.custom.css" />
<link rel="stylesheet" href="./assets/css/chosen.css" />
<link rel="stylesheet" href="./assets/css/datepicker.css" />
<link rel="stylesheet" href="./assets/css/bootstrap-timepicker.css" />
<link rel="stylesheet" href="./assets/css/daterangepicker.css" />
<link rel="stylesheet" href="./assets/css/bootstrap-datetimepicker.css" />
<link rel="stylesheet" href="./assets/css/colorpicker.css" />
<link rel="stylesheet" href="./assets/css/dropzone.css" />

<!-- text fonts -->
<link rel="stylesheet" href="./assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="./assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.css" />
		<![endif]-->

<!-- custome styles -->
<link rel="stylesheet" href="./css/style.css" />
<!-- 卡卡 -->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="./assets/js/ace-extra.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.js"></script>
		<![endif]-->
</head>

<body class="no-skin">
	<!-- #section:basics/navbar.layout -->
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<!-- #section:basics/sidebar.mobile.toggle -->
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<!-- /section:basics/sidebar.mobile.toggle -->
			<div class="navbar-header pull-left">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> 承利保險經紀人&nbsp; 後台管理
				</small>
				</a>

				<!-- /section:basics/navbar.layout.brand -->

				<!-- #section:basics/navbar.toggle -->

				<!-- /section:basics/navbar.toggle -->
			</div>

			<!-- #section:basics/navbar.dropdown -->
			<div class="navbar-buttons navbar-header pull-right"
				role="navigation">
				<ul class="nav ace-nav">
					<!-- #section:basics/navbar.user_menu -->
					<li class="light-blue"><a href="login.html"> <i
							class="ace-icon fa fa-power-off"></i> 登出
					</a></li>

					<!-- /section:basics/navbar.user_menu -->
				</ul>
			</div>

			<!-- /section:basics/navbar.dropdown -->
		</div>
		<!-- /.navbar-container -->
	</div>

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<!-- #section:basics/sidebar -->
		<div id="sidebar" class="sidebar responsive">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="nav nav-list">
				<li><a href="admin.jsp"> <span class="menu-text">
							後台帳號管理 </span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="page02.jsp"> <span class="menu-text">
							最新消息管理 </span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="page03.jsp"> <span
						class="menu-text"> 菁英薈萃管理 </span>
				</a> <b class="arrow"></b></li>

				<li class="active"><a href="page04.jsp"> <span class="menu-text">
							活動櫥窗管理 </span>
				</a> <b class="arrow"></b></li>
			</ul>
			<!-- /.nav-list -->

			<!-- #section:basics/sidebar.layout.minimize -->
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>

			<!-- /section:basics/sidebar.layout.minimize -->
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}
			</script>
		</div>

		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">首頁</a>
						</li>
						<li class="active">活動櫥窗</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<!-- /section:basics/content.breadcrumbs -->

				<div class="page-content">

					<div class="page-header">
						<h1>活動櫥窗管理</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12"></div>
						<!-- /.row -->
						<table id="simple-table"
							class="table table-striped table-bordered table-hover col-xs-10">
							<thead>
								<tr>
									<th class="center" width="7%">編號</th>
									<th class="center" width="20%">相簿名稱</th>
									<th width="20%">圖片</th>
									<th width="10%">日期</th>
									<th width="13%">
										<button id="btn-add" class="btn btn-insert btn-xs btn-primary">
											<i class="ace-icon fa fa-plus bigger-120">&nbsp;新增</i>
										</button>
									</th>
								</tr>
							</thead>

							<tbody id="table-album-list">
								<tr>
									<td width="7%" style="vertical-align: middle;" class="center">(index
										+ 1)</td>
									<td width="20%" style="vertical-align: middle;">ALBUM NAME</td>
									<td width="20%" class="center"><img src="images/user.jpg"
										height="100" />
									<td width="10%" style="vertical-align: middle;">DATE</td>
									<td width="13%" style="vertical-align: middle;">
										<div class="hidden-sm hidden-xs btn-group">
											<button class="btn btn-xs btn-info" id="btn-edit">
												<i class="ace-icon fa fa-pencil bigger-110">&nbsp;編輯</i>
											</button>
											<button class="btn btn-xs btn-warning" id="btn-upload">
												<i class="ace-icon fa fa-cloud-upload bigger-110">&nbsp;上傳</i>
											</button>
											<button class="btn btn-xs btn-danger" id="btn-delete">
												<i class="ace-icon fa fa-trash-o bigger-110">&nbsp;刪除</i>
											</button>
										</div>
									</td>
									<!-- function btn END -->
								</tr>
							</tbody>
						</table>
						<!-- FORM CONTENT -->
						<!-- ALBUM INFO -->
						<!-- //相片內容 -->

						<form class="form-horizontal" id="validation-form" method="get"
							action="./">
							<input type="text" id="album-id" value="ForTest" class="">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="title"> 活動標題 </label>
								<div class="col-sm-9">
									<div class="clearfix">
										<input type="text" id="album-title" name="title"
											placeholder="活動標題" class="col-xs-10 col-sm-5">
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="date"> 活動日期 </label>
								<div class="col-sm-9" for="dnt_date">
									<div class="input-group col-xs-10 col-sm-5">
										<span class="input-group-addon"> <i
											class="fa fa-calendar bigger-110"></i>
										</span> <input id="album-date" class="form-control" type="date"
											name="date" id="date-picker-1">
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right"
									for="state">活動標籤</label>

								<div class="col-xs-12 col-sm-9">
									<select id="state" name="state" class="select"
										data-placeholder="選擇活動標籤">
										<option value="">-- 選擇活動標籤 --</option>
										<option value="1">頒給典禮</option>
										<option value="2">活動花絮</option>
										<option value="3">環遊世界</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 活動封面 </label>
								<div class="col-sm-9">
									<div class="input-group col-xs-10 col-sm-5">
										<div class="clearfix">
											<input type="file" id="id-input-file-3" />
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 活動封面 </label>

								<div class="col-sm-9">
									<input id="album-cover" type="text" placeholder="活動封面"
										class="col-xs-10 col-sm-5" disabled />
								</div>
							</div>

							<div id="btngp-album-content" class="row">
								<div class="col-xs-12">
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											&nbsp; &nbsp; &nbsp;
											<button id="btn-save-add" class="btn btn-info" type="submit">
												<i class="ace-icon fa fa-check bigger-110"></i> 儲存
											</button>

											&nbsp; &nbsp; &nbsp;
											<button id="btn-cancel-add" class="btn" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i> 取消
											</button>
										</div>
									</div>
								</div>
							</div>
							<div id="btngp-reEdit" class="row hide">
								<div class="col-xs-12">
									<div class="clearfix form-actions">
										<div class="col-md-offset-7 col-md-11">
											&nbsp; &nbsp; &nbsp;
											<button id="btn-edit-add" class="btn btn-info">
												<i class="ace-icon fa fa-pencil bigger-110"></i> 編輯
											</button>
										</div>
									</div>
								</div>
							</div>

							<div class="alert alert-success hide">
								<button type="button" class="close" data-dismiss="alert">
									<i class="ace-icon fa fa-times"></i>
								</button>

								<strong> <i class="ace-icon fa fa-check"></i> Well
									done!
								</strong> 新增相簿成功！ <br />
							</div>

							<div class="alert alert-danger hide">
								<button type="button" class="close" data-dismiss="alert">
									<i class="ace-icon fa fa-times"></i>
								</button>

								<strong> <i class="ace-icon fa fa-times"></i> Oops!
								</strong> 相簿新增失敗，請再試一次。 <br />
							</div>

						</form>

						<!-- ALBUM INFO END -->
						<!-- PAGE CONTENT BEGINS -->
						<div class="widget-body">
							<div class="widget-main">
								<!-- #section:plugins/fuelux.wizard -->
								<div id="fuelux-wizard-container">
									<div>
										<!-- #section:plugins/fuelux.wizard.steps -->
										<ul class="steps">
											<!-- <li data-step="1" class="active"><span class="step"><i
													class="ace-icon fa fa-book bigger-120"></i></span> <span
												class="title">相簿內容</span></li> -->

											<li data-step="1" class="active"><span class="step"><i
													class="ace-icon fa fa-cloud-upload bigger-120"></i></span> <span
												class="title">相片上傳</span></li>

											<li data-step="2"><span class="step"><i
													class="ace-icon fa fa-camera-retro bigger-120"></i></span> <span
												class="title">相片集</span></li>
										</ul>

										<!-- /section:plugins/fuelux.wizard.steps -->
									</div>

									<hr />

									<!-- #section:plugins/fuelux.wizard.container -->
									<div class="step-content pos-rel">

										<div class="step-pane active" data-step="1">
											<div class="center hide">
												<h3 class="green">Congrats!</h3>
												Your product is ready to ship! Click finish to continue!
											</div>
											<div class="row" id="upload-photo">
												<div class="col-xs-12">
													<form action="../UploadServlet" method="post"
														enctype="multipart/form-data" class="dropzone"
														id="dropzone">
														<div class="fallback">
															<input type="file" name="filename" multiple="" />
														</div>
														<input type="text" id="passAlbumId" name="passAlbumId"
															value="1234" class="">

													</form>
												</div>
											</div>
										</div>

										<div class="step-pane" data-step="2">
											<div class="center hide">
												<h3 class="green">Congrats!</h3>
												Your product is ready to ship! Click finish to continue!
											</div>
											<div class="row">
												<div class="col-xs-12">
													<ul class="ace-thumbnails clearfix" id="_gallery">

														<!-- #section:pages/gallery.caption -->
														<li><a href="./images/act-1.jpg" data-rel="colorbox">
																<img width="150" height="150" alt="150x150"
																src="./images/act-1.jpg" />
														</a>
															<div class="tools tools-bottom" data_id="0">
																<a href="#"> <i class="ace-icon fa fa-times red"></i>
																</a>
															</div></li>
													</ul>
												</div>
											</div>
										</div>

									</div>

									<!-- /section:plugins/fuelux.wizard.container -->
								</div>

								<hr />
								<div class="wizard-actions">
									<!-- #section:plugins/fuelux.wizard.buttons -->

									<button class="btn btn-prev">
										<i class="ace-icon fa fa-arrow-left"></i> 上一步
									</button>

									<button class="btn btn-success btn-next" data-last="完成">
										下一步 <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
									</button>

									<!-- /section:plugins/fuelux.wizard.buttons -->
								</div>

								<!-- /section:plugins/fuelux.wizard -->
							</div>
						</div>
					</div>
					<!-- /.widget-main -->
				</div>
				<!-- /.widget-body -->
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div>
	</div>
	<!-- /.page-content -->
	<!-- /.main-content -->

	<html:ad_foot headline="承利保險經紀人 後台管理" />

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document.write("<script src='assets/js/jquery.js'>"
						+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document.write("<script src='assets/js/jquery.mobile.custom.js'>"
					+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.js"></script>

	<!-- page specific plugin scripts -->
	<script src="assets/js/dropzone.js"></script>

	<!--[if lte IE 8]>
		  <script src="../assets/js/excanvas.js"></script>
		<![endif]-->
	<script src="./assets/js/jquery-ui.custom.js"></script>
	<script src="./assets/js/jquery.ui.touch-punch.js"></script>
	<script src="./assets/js/chosen.jquery.js"></script>
	<script src="./assets/js/fuelux/fuelux.spinner.js"></script>
	<script src="./assets/js/fuelux/fuelux.wizard.js"></script>
	<script src="./assets/js/date-time/bootstrap-datepicker.js"></script>
	<script src="./assets/js/date-time/bootstrap-timepicker.js"></script>
	<script src="./assets/js/date-time/moment.js"></script>
	<script src="./assets/js/date-time/daterangepicker.js"></script>
	<script src="./assets/js/date-time/bootstrap-datetimepicker.js"></script>
	<script src="./assets/js/bootstrap-colorpicker.js"></script>
	<script src="./assets/js/jquery.knob.js"></script>
	<script src="./assets/js/jquery.autosize.js"></script>
	<script src="./assets/js/jquery.inputlimiter.1.3.1.js"></script>
	<script src="./assets/js/jquery.maskedinput.js"></script>
	<script src="./assets/js/bootstrap-tag.js"></script>

	<!-- ace scripts -->
	<script src="./assets/js/ace/elements.scroller.js"></script>
	<script src="./assets/js/ace/elements.colorpicker.js"></script>
	<script src="./assets/js/ace/elements.fileinput.js"></script>
	<script src="./assets/js/ace/elements.typeahead.js"></script>
	<script src="./assets/js/ace/elements.wysiwyg.js"></script>
	<script src="./assets/js/ace/elements.spinner.js"></script>
	<script src="./assets/js/ace/elements.treeview.js"></script>
	<script src="./assets/js/ace/elements.wizard.js"></script>
	<script src="./assets/js/ace/elements.aside.js"></script>
	<script src="./assets/js/ace/ace.js"></script>
	<script src="./assets/js/ace/ace.ajax-content.js"></script>
	<script src="./assets/js/ace/ace.touch-drag.js"></script>
	<script src="./assets/js/ace/ace.sidebar.js"></script>
	<script src="./assets/js/ace/ace.sidebar-scroll-1.js"></script>
	<script src="./assets/js/ace/ace.submenu-hover.js"></script>
	<script src="./assets/js/ace/ace.widget-box.js"></script>
	<script src="./assets/js/ace/ace.settings.js"></script>
	<script src="./assets/js/ace/ace.settings-rtl.js"></script>
	<script src="./assets/js/ace/ace.settings-skin.js"></script>
	<script src="./assets/js/ace/ace.widget-on-reload.js"></script>
	<script src="./assets/js/ace/ace.searchbox-autocomplete.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			/* #dropzone */
			try {
				Dropzone.autoDiscover = false;
				var myDropzone = new Dropzone(
						"#dropzone",
						{
							paramName : "file", // The name that will be used to transfer the file
							maxFilesize : 1, // MB
							acceptedFiles : ".jpg, .jpeg",
							//autoProcessQueue : false, // 不主動提交
							parallelUploads : 10, // 同時上傳多少文件
							//url: "upload", // 文件提交頁面
							maxFiles : 10, // 限制檔案上傳數量
							uploadMultiple : true, // 一次上傳
							//addRemoveLinks : true,
							dictDefaultMessage : '<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> 將檔案拖放到這裡</span> 上傳圖片<br> \
				<span class="smaller-80 grey"> (您可以上傳10張 jpg, jpeg 圖檔)</span> <br /> \
				<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>',
							dictFallbackMessage : "您的瀏覽器不支援拖放檔案上傳",
							dictFallbackText : "您的瀏覽器不支援拖放檔案上傳",
							dictFileTooBig : "檔案大小限制：{{maxFilesize}}MB, 檔案太大 ({{filesize}}MB)",
							dictInvalidFileType : "您可以上傳 jpg, jpeg 圖檔",
							dictCancelUpload : "取消上傳",
							dictCancelUploadConfirmation : "您確定取消上傳這張圖檔嗎？",
							dictRemoveFile : "刪除檔案",
							//dictRemoveFileConfirmation : "您確定刪除這張圖檔嗎？",
							dictMaxFilesExceeded : "檔案個數限制：10",

							dictResponseError : 'Error while uploading file!',

							//change the previewTemplate to use Bootstrap progress bars
							previewTemplate : "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>"

						});

				$(document).one('ajaxloadstart.page', function(e) {
					try {
						myDropzone.destroy();
					} catch (e) {
					}
				});

			} catch (e) {
				alert('Dropzone.js does not support older browsers!');
			}

		});
	</script>



	<script type="text/javascript">
		jQuery(function($) {

			$('#fuelux-wizard-container').ace_wizard({
			//step: 2 //optional argument. wizard will jump to step "2" at first
			//buttons: '.wizard-actions:eq(0)'
			}).on('actionclicked.fu.wizard', function(e, info) {
				if (info.step == 1) {
					console.log("loadPhotoSet : #" + $('#passAlbumId').val());
					loadPhotoSet($('#passAlbumId').val());
				}
			}).on('finished.fu.wizard', function(e) {
				location.reload();
				/* bootbox
						.dialog({
							message : "Thank you! Your information was successfully saved!",
							buttons : {
								"success" : {
									"label" : "OK",
									"className" : "btn-sm btn-primary"
								}
							}
						}); */
			}).on('stepclick.fu.wizard', function(e) {
				//e.preventDefault();//this will prevent clicking and selecting steps
			});
			/******************/

			$('#id-disable-check').on('click', function() {
				var inp = $('#form-input-readonly').get(0);
				if (inp.hasAttribute('disabled')) {
					inp.setAttribute('readonly', 'true');
					inp.removeAttribute('disabled');
					inp.value = "This text field is readonly!";
				} else {
					inp.setAttribute('disabled', 'disabled');
					inp.removeAttribute('readonly');
					inp.value = "This text field is disabled!";
				}
			});

			if (!ace.vars['touch']) {
				$('.chosen-select').chosen({
					allow_single_deselect : true
				});
				//resize the chosen on window resize

				$(window).off('resize.chosen').on('resize.chosen', function() {
					$('.chosen-select').each(function() {
						var $this = $(this);
						$this.next().css({
							'width' : $this.parent().width()
						});
					})
				}).trigger('resize.chosen');
				//resize chosen on sidebar collapse/expand
				$(document).on('settings.ace.chosen',
						function(e, event_name, event_val) {
							if (event_name != 'sidebar_collapsed')
								return;
							$('.chosen-select').each(function() {
								var $this = $(this);
								$this.next().css({
									'width' : $this.parent().width()
								});
							})
						});

				$('#chosen-multiple-style .btn').on(
						'click',
						function(e) {
							var target = $(this).find('input[type=radio]');
							var which = parseInt(target.val());
							if (which == 2)
								$('#form-field-select-4').addClass(
										'tag-input-style');
							else
								$('#form-field-select-4').removeClass(
										'tag-input-style');
						});
			}

			$('[data-rel=tooltip]').tooltip({
				container : 'body'
			});
			$('[data-rel=popover]').popover({
				container : 'body'
			});

			$('textarea[class*=autosize]').autosize({
				append : "\n"
			});
			$('textarea.limited').inputlimiter({
				remText : '%n character%s remaining...',
				limitText : 'max allowed : %n.'
			});

			$("#input-size-slider").css('width', '200px').slider(
					{
						value : 1,
						range : "min",
						min : 1,
						max : 8,
						step : 1,
						slide : function(event, ui) {
							var sizing = [ '', 'input-sm', 'input-lg',
									'input-mini', 'input-small',
									'input-medium', 'input-large',
									'input-xlarge', 'input-xxlarge' ];
							var val = parseInt(ui.value);
							$('#form-field-4').attr('class', sizing[val]).val(
									'.' + sizing[val]);
						}
					});

			$("#input-span-slider").slider(
					{
						value : 1,
						range : "min",
						min : 1,
						max : 12,
						step : 1,
						slide : function(event, ui) {
							var val = parseInt(ui.value);
							$('#form-field-5').attr('class', 'col-xs-' + val)
									.val('.col-xs-' + val);
						}
					});

			//"jQuery UI Slider"
			//range slider tooltip example
			$("#slider-range")
					.css('height', '200px')
					.slider(
							{
								orientation : "vertical",
								range : true,
								min : 0,
								max : 100,
								values : [ 17, 67 ],
								slide : function(event, ui) {
									var val = ui.values[$(ui.handle).index() - 1]
											+ "";

									if (!ui.handle.firstChild) {
										$(
												"<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
												.prependTo(ui.handle);
									}
									$(ui.handle.firstChild).show().children()
											.eq(1).text(val);
								}
							}).find('span.ui-slider-handle').on('blur',
							function() {
								$(this.firstChild).hide();
							});

			$("#slider-range-max").slider({
				range : "max",
				min : 1,
				max : 10,
				value : 2
			});

			$("#slider-eq > span").css({
				width : '90%',
				'float' : 'left',
				margin : '15px'
			}).each(function() {
				// read initial values from markup and remove that
				var value = parseInt($(this).text(), 10);
				$(this).empty().slider({
					value : value,
					range : "min",
					animate : true

				});
			});

			$("#slider-eq > span.ui-slider-purple").slider('disable');//disable third item

			$('#id-input-file-1 , #id-input-file-2').ace_file_input({
				no_file : 'No File ...',
				btn_choose : 'Choose',
				btn_change : 'Change',
				droppable : false,
				onchange : null,
				thumbnail : false
			//| true | large
			//whitelist:'gif|png|jpg|jpeg'
			//blacklist:'exe|php'
			//onchange:''
			//
			});
			//pre-show a file name, for example a previously selected file
			//$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])

			$('#id-input-file-3').ace_file_input({
				style : 'well',
				btn_choose : 'Drop files here or click to choose',
				btn_change : null,
				no_icon : 'ace-icon fa fa-cloud-upload',
				droppable : true,
				thumbnail : 'fit'//'small'//large | fit
				//,icon_remove:null//set null, to hide remove/reset button
				/**,before_change:function(files, dropped) {
					//Check an example below
					//or examples/file-upload.html
					return true;
				}*/
				/**,before_remove : function() {
					return true;
				}*/
				,
				preview_error : function(filename, error_code) {
					//name of the file that failed
					//error_code values
					//1 = 'FILE_LOAD_FAILED',
					//2 = 'IMAGE_LOAD_FAILED',
					//3 = 'THUMBNAIL_FAILED'
					//alert(error_code);
				}

			}).on('change', function() {
				//console.log($(this).data('ace_input_files'));
				//console.log($(this).data('ace_input_method'));
			});

			//$('#id-input-file-3')
			//.ace_file_input('show_file_list', [
			//{type: 'image', name: 'name of image', path: 'http://path/to/image/for/preview'},
			//{type: 'file', name: 'hello.txt'}
			//]);

			//dynamically change allowed formats by changing allowExt && allowMime function
			$('#id-file-format').removeAttr('checked').on(
					'change',
					function() {
						var whitelist_ext, whitelist_mime;
						var btn_choose
						var no_icon
						if (this.checked) {
							btn_choose = "Drop images here or click to choose";
							no_icon = "ace-icon fa fa-picture-o";

							whitelist_ext = [ "jpeg", "jpg", "png", "gif",
									"bmp" ];
							whitelist_mime = [ "image/jpg", "image/jpeg",
									"image/png", "image/gif", "image/bmp" ];
						} else {
							btn_choose = "Drop files here or click to choose";
							no_icon = "ace-icon fa fa-cloud-upload";

							whitelist_ext = null;//all extensions are acceptable
							whitelist_mime = null;//all mimes are acceptable
						}
						var file_input = $('#id-input-file-3');
						file_input.ace_file_input('update_settings', {
							'btn_choose' : btn_choose,
							'no_icon' : no_icon,
							'allowExt' : whitelist_ext,
							'allowMime' : whitelist_mime
						})
						file_input.ace_file_input('reset_input');

						file_input.off('file.error.ace').on('file.error.ace',
								function(e, info) {
									//console.log(info.file_count);//number of selected files
									//console.log(info.invalid_count);//number of invalid files
									//console.log(info.error_list);//a list of errors in the following format

									//info.error_count['ext']
									//info.error_count['mime']
									//info.error_count['size']

									//info.error_list['ext']  = [list of file names with invalid extension]
									//info.error_list['mime'] = [list of file names with invalid mimetype]
									//info.error_list['size'] = [list of file names with invalid size]

									/**
									if( !info.dropped ) {
										//perhapse reset file field if files have been selected, and there are invalid files among them
										//when files are dropped, only valid files will be added to our file array
										e.preventDefault();//it will rest input
									}
									 */

									//if files have been selected (not dropped), you can choose to reset input
									//because browser keeps all selected files anyway and this cannot be changed
									//we can only reset file field to become empty again
									//on any case you still should check files with your server side script
									//because any arbitrary file can be uploaded by user and it's not safe to rely on browser-side measures
								});

					});

			$('#spinner1').ace_spinner({
				value : 0,
				min : 0,
				max : 200,
				step : 10,
				btn_up_class : 'btn-info',
				btn_down_class : 'btn-info'
			}).closest('.ace-spinner').on('changed.fu.spinbox', function() {
				//alert($('#spinner1').val())
			});
			$('#spinner2').ace_spinner({
				value : 0,
				min : 0,
				max : 10000,
				step : 100,
				touch_spinner : true,
				icon_up : 'ace-icon fa fa-caret-up bigger-110',
				icon_down : 'ace-icon fa fa-caret-down bigger-110'
			});
			$('#spinner3').ace_spinner({
				value : 0,
				min : -100,
				max : 100,
				step : 10,
				on_sides : true,
				icon_up : 'ace-icon fa fa-plus bigger-110',
				icon_down : 'ace-icon fa fa-minus bigger-110',
				btn_up_class : 'btn-success',
				btn_down_class : 'btn-danger'
			});
			$('#spinner4').ace_spinner({
				value : 0,
				min : -100,
				max : 100,
				step : 10,
				on_sides : true,
				icon_up : 'ace-icon fa fa-plus',
				icon_down : 'ace-icon fa fa-minus',
				btn_up_class : 'btn-purple',
				btn_down_class : 'btn-purple'
			});

			//$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
			//or
			//$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
			//$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0

			//datepicker plugin
			//link
			$('.date-picker').datepicker({
				autoclose : true,
				todayHighlight : true
			})
			//show datepicker when clicking on the icon
			.next().on(ace.click_event, function() {
				$(this).prev().focus();
			});

			//or change it into a date range picker
			$('.input-daterange').datepicker({
				autoclose : true
			});

			//to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
			$('input[name=date-range-picker]').daterangepicker({
				'applyClass' : 'btn-sm btn-success',
				'cancelClass' : 'btn-sm btn-default',
				locale : {
					applyLabel : 'Apply',
					cancelLabel : 'Cancel',
				}
			}).prev().on(ace.click_event, function() {
				$(this).next().focus();
			});

			$('#timepicker1').timepicker({
				minuteStep : 1,
				showSeconds : true,
				showMeridian : false
			}).next().on(ace.click_event, function() {
				$(this).prev().focus();
			});

			$('#date-timepicker1').datetimepicker().next().on(ace.click_event,
					function() {
						$(this).prev().focus();
					});

			$('#colorpicker1').colorpicker();

			$('#simple-colorpicker-1').ace_colorpicker();
			//$('#simple-colorpicker-1').ace_colorpicker('pick', 2);//select 2nd color
			//$('#simple-colorpicker-1').ace_colorpicker('pick', '#fbe983');//select #fbe983 color
			//var picker = $('#simple-colorpicker-1').data('ace_colorpicker')
			//picker.pick('red', true);//insert the color if it doesn't exist

			$(".knob").knob();

			var tag_input = $('#form-field-tags');
			try {
				tag_input.tag({
					placeholder : tag_input.attr('placeholder'),
					//enable typeahead by specifying the source array
					source : ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
				/**
				//or fetch data from database, fetch those that match "query"
				source: function(query, process) {
				  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
				  .done(function(result_items){
					process(result_items);
				  });
				}
				 */
				})

				//programmatically add a new
				var $tag_obj = $('#form-field-tags').data('tag');
				$tag_obj.add('Programmatically Added');
			} catch (e) {
				//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
				tag_input.after(
						'<textarea id="' + tag_input.attr('id') + '" name="'
								+ tag_input.attr('name') + '" rows="3">'
								+ tag_input.val() + '</textarea>').remove();
				//$('#form-field-tags').autosize({append: "\n"});
			}

			/////////
			$('#modal-form input[type=file]').ace_file_input({
				style : 'well',
				btn_choose : 'Drop files here or click to choose',
				btn_change : null,
				no_icon : 'ace-icon fa fa-cloud-upload',
				droppable : true,
				thumbnail : 'large'
			})

			//chosen plugin inside a modal will have a zero width because the select element is originally hidden
			//and its width cannot be determined.
			//so we set the width after modal is show
			$('#modal-form').on(
					'shown.bs.modal',
					function() {
						if (!ace.vars['touch']) {
							$(this).find('.chosen-container').each(
									function() {
										$(this).find('a:first-child').css(
												'width', '210px');
										$(this).find('.chosen-drop').css(
												'width', '210px');
										$(this).find('.chosen-search input')
												.css('width', '200px');
									});
						}
					})
			/**
			//or you can activate the chosen plugin after modal is shown
			//this way select element becomes visible with dimensions and chosen works as expected
			$('#modal-form').on('shown', function () {
				$(this).find('.modal-chosen').chosen();
			})
			 */
			/* Nana Edit*/

			/* $('#simple-table').on('click', '#btn-add', function(event) {
				//alert('btn-add');
				//$validation = true;//false;

				//$('#simple-table').hide();
				$('.widget-body').removeClass('hide');
				$('#validation-form').removeClass('hide');
				$("#validation-form").trigger('reset');
				//$('.wizard-actions').addClass('hide');

				/* cancel
				$('#validation-form').addClass('hide');
				$('#simple-table').show();
			 */
			//}) 
			$('#validation-form').on('click', '#btn-save-add', function(event) {
				FormCtrl("valid");

				SelectContent("List", "en");
				SelectContent("Form", "dis");

				saveAlbum(TYPEID);
			})

			$('#validation-form').on('click', '#btn-cancel-add',
					function(event) {
						ListCtrl("Clean");
						Validator.resetForm();
						ListCtrl("render");

						SelectContent("List", "en");
						SelectContent("Form", "dis");
					})

			function disableForm(fn) {
				$('#album-title').attr('disabled', fn);
				$('#album-date').attr('disabled', fn);
				$('#state').attr('disabled', fn);
				//alert(fn);
				if (fn) {
					$('#btngp-album-content').addClass('hide');
					$('#btngp-reEdit').removeClass('hide');
				} else {
					$('#btngp-album-content').removeClass('hide');
					$('#btngp-reEdit').addClass('hide');
				}
			}

			/* $('#upload-photo').on('click', '#btn-upload-done', function(event) {
				//alert('btn-upload-done');

				$('#btngp-upload-done').addClass('hide');
				$('.wizard-actions').removeClass('hide');
			}) */

			$.mask.definitions['~'] = '[+-]';
			$('#phone').mask('9999-999-999');

			jQuery.validator.addMethod("phone", function(value, element) {
				return this.optional(element)
						|| /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
			}, "Enter a valid phone number.");

			var Validator = $('#validation-form')
					.validate(
							{
								errorElement : 'div',
								errorClass : 'help-block',
								focusInvalid : false,
								ignore : "",
								rules : {

									name : {
										required : true
									},
									state : {
										required : true
									},
									date : {
										required : true,
										date : true
									},
									title : {
										required : true,
									}
								},

								messages : {
									state : "請選擇活動分類",
									date : "必要欄位",
									title : "必要欄位",
								},

								highlight : function(e) {
									$(e).closest('.form-group').removeClass(
											'has-info').addClass('has-error');
								},

								success : function(e) {
									$(e).closest('.form-group').removeClass(
											'has-error');//.addClass('has-info');
									$(e).remove();
								},

								errorPlacement : function(error, element) {
									if (element.is('input[type=checkbox]')
											|| element.is('input[type=radio]')) {
										var controls = element
												.closest('div[class*="col-"]');
										if (controls.find(':checkbox,:radio').length > 1)
											controls.append(error);
										else
											error.insertAfter(element.nextAll(
													'.lbl:eq(0)').eq(0));
									} else if (element.is('.select2')) {
										error
												.insertAfter(element
														.siblings('[class*="select2-container"]:eq(0)'));
									} else if (element.is('.chosen-select')) {
										error
												.insertAfter(element
														.siblings('[class*="chosen-container"]:eq(0)'));
									} else
										error.insertAfter(element.parent());
								},

								submitHandler : function(form) {
								},
								invalidHandler : function(form) {
								}
							});

			$('#modal-wizard-container').ace_wizard();
			$('#modal-wizard .wizard-actions .btn[data-dismiss=modal]')
					.removeAttr('disabled');

			/* Nana Edit END */

			$(document)
					.one(
							'ajaxloadstart.page',
							function(e) {
								$('textarea[class*=autosize]').trigger(
										'autosize.destroy');
								$('.limiterBox,.autosizejs').remove();
								$(
										'.daterangepicker.dropdown-menu,.colorpicker.dropdown-menu,.bootstrap-datetimepicker-widget.dropdown-menu')
										.remove();
							});

		});
	</script>

	<!-- the following scripts are used in demo only for onpage help and you don't need them -->
	<link rel="stylesheet" href="./assets/css/ace.onpage-help.css" />
	<link rel="stylesheet" href="./docs/assets/js/themes/sunburst.css" />

	<script type="text/javascript">
		ace.vars['base'] = '..';
	</script>
	<script src="./assets/js/ace/elements.onpage-help.js"></script>
	<script src="./assets/js/ace/ace.onpage-help.js"></script>
	<script src="./docs/assets/js/rainbow.js"></script>
	<script src="./docs/assets/js/language/generic.js"></script>
	<script src="./docs/assets/js/language/html.js"></script>
	<script src="./docs/assets/js/language/css.js"></script>
	<script src="./docs/assets/js/language/javascript.js"></script>
	<script src="./js/jquery.validate.js"></script>

	<script>
		var rootURL = "../api";
		var TYPEID = '3'; //#3 champion

		function getAll(TYPEID) {
			console.log('getAll album: ' + TYPEID);
			$.ajax({
				type : 'GET',
				url : rootURL + '/album/' + TYPEID,
				dataType : "json",
				success : function(data) {
					//console.log("getAll #3 Champion album ing...");
					renderList(data);
				}
			});
		}
		function loadAlbumInfo(id) {
			console.log('get Album info : ');
			$.ajax({
				type : 'GET',
				url : rootURL + '/album/id:' + id,
				dataType : "json",
				success : function(data) {
					//renderDonationList(data);
					//console.log("get Album Info ing...");
					renderAlbumInfo(data);
					console.log(data);
					//$("#_gallery").show();
				}
			});
		}

		function saveAlbum(TYPEID) {
			console.log('saveAlbum:');
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : rootURL + '/album',
				dataType : "json",
				data : formToJSON(TYPEID),
				success : function(data, textStatus, jqXHR) {
					//console.log("saveAlbum success...");
					ListCtrl("render");
				}
			});
		}

		function deleteAlbum(id) {
			console.log('deleteAlbum');
			$.ajax({
				type : 'DELETE',
				url : rootURL + '/album/' + id,
				success : function(data, textStatus, jqXHR) {
					//alert('delete successfully');
					ListCtrl("render");
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('deleteAlbum error');
				}
			});
		}

		function loadPhotoSet(id) {
			console.log('get PhotoSet : ' + id);
			$.ajax({
				type : 'GET',
				url : rootURL + '/photo/' + id,
				dataType : "json",
				success : function(data) {
					renderGallery(data);
				}
			});
		}

		function renderAlbumInfo(data) {
			var list = data == null ? [] : (data instanceof Array ? data
					: [ data ]);
			//alert(list[0].tag);
			$('#passAlbumId').val(list[0].id);
			$('#album-id').val(list[0].id);
			$('#album-title').attr("data-id", list[0].id);
			//getiktList(list[0].ikt);
			// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
			$('#album-date').val(list[0].date);
			$('#album-title').val(list[0].title);//
			$('#state').val(list[0].tag);
			//$('#opt_ikt option:eq(2)').attr('selected',true);
		}

		function renderGallery(data) {
			// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
			var list = data == null ? [] : (data instanceof Array ? data
					: [ data ]);
			var photoBox = '';

			$("#_gallery").empty();

			$
					.each(
							list,
							function(index, item) {
								imgUrl = 'album/' + item.path + item.file;

								photoBox = '<li>'
										+ '<a href="#_gallery"'
								+ '" data-rel="colorbox"><img width="150" height="150" alt="150x150" src="../' + imgUrl+ '" />' //* album/main_2.jpg */" >'
										//+"" +'" />'
										+ '</a><div class="tools tools-bottom"><button id="btn-delete-photo" class="btn btn-xs btn-danger" data-id="'
								+ item.id
								+'"><i class="ace-icon fa fa-trash-o bigger-120">&nbsp;刪除</i></button>&nbsp;&nbsp;'
										+ '<button id="btn-fn-photo" class="btn btn-xs btn-info" data-id="'
								+ item.id +'"><i class="ace-icon fa fa-heart-o bigger-120">&nbsp;封面</i></button></div></li>';

								$("#_gallery").append(photoBox);

							});
		}

		function renderList(data) {
			/*  <td width="7%" style="vertical-align: middle;" class="center">(index
										+ 1)</td>
									<td width="20%" style="vertical-align: middle;">ALBUM NAME</td>
									<td width="20%" class="center"><img src="images/user.jpg"
										height="100" />
									<td width="10%" style="vertical-align: middle;">DATE</td>
									<td width="13%" style="vertical-align: middle;">
										<div class="hidden-sm hidden-xs btn-group">
											<button class="btn btn-xs btn-info" id="btn-edit">
												<i class="ace-icon fa fa-pencil bigger-110">&nbsp;編輯</i>
											</button>
											<button class="btn btn-xs btn-warning" id="btn-upload">
												<i class="ace-icon fa fa-cloud-upload bigger-110">&nbsp;上傳</i>
											</button>
											<button class="btn btn-xs btn-danger" id="btn-delete">
												<i class="ace-icon fa fa-trash-o bigger-110">&nbsp;刪除</i>
											</button>
										</div>
									</td>  */
			// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
			var list = data == null ? [] : (data instanceof Array ? data
					: [ data ]);

			$("#simple-table tbody").empty();

			var dntBox = "";
			var cover_imgsrc = "";

			$
					.each(
							list,
							function(index, item) {
								dntBox = '';

								var btns = '<td width="13%" style="vertical-align: middle;"><div class="btn-group">'
										+ '<button class="btn btn-xs btn-info" id="btn-edit" data-id="'+item.id+'">'
										+ '<i class="ace-icon fa fa-pencil bigger-120"><font style="color: #fff;">&nbsp;編輯</font></i></button>'
										+ '<button class="btn btn-xs btn-warning" id="btn-upload" data-id="'+item.id +'">'
										+ '<i class="ace-icon fa fa-cloud-upload bigger-110">&nbsp;上傳</i></button>'
										+ '<button class="btn btn-xs btn-danger" id="btn-delete" data-id="'+item.id+'"><i class="ace-icon fa fa-trash-o bigger-120">&nbsp;刪除</i></button>'
										+ '</div></td>';

								dntBox = '<td width="7%" style="vertical-align: middle;" class="center">'
										+ (index + 1);
								if (item.cover_id) {
									cover_imgsrc = item.id + '/' + cover_id;
								} else {
									cover_imgsrc = "images/cover_default.jpg";
								}
								dntBox = dntBox
										+ '</td><td width="20%" style="vertical-align: middle;">'
										+ item.title
										+ '<td width="20%" class="center"><img src="'
										+ cover_imgsrc
										//+ 'images/cover_default.jpg'
										+ '" height="100" /><td width="10%" style="vertical-align: middle;">'
										+ item.date + '</td>';

								$("#simple-table tbody").append(
										'<tr>' + dntBox + btns + '</tr>');

							});
		}

		/* 新增 */
		$('#simple-table').on('click', '#btn-add', function(event) {

			//loadAlbumInfo($(this).data('id'));
			FormCtrl("clean");
			
			SelectContent("List", "dis");
			SelectContent("Form", "en");

		});
		
		/* 編輯 */
		$('#simple-table').on('click', '#btn-edit', function(event) {

			loadAlbumInfo($(this).data('id'));

			SelectContent("List", "dis");
			SelectContent("Form", "en");

		});
		
		/* 上傳 */
		$('#simple-table').on('click', '#btn-upload', function(event) {

			$('#passAlbumId').val($(this).data('id'));

			SelectContent("List", "dis");
			SelectContent("Gallery", "en");

		});

		/* 刪除 */
		$('#simple-table').on('click', '#btn-delete', function(event) {

			deleteAlbum($(this).data('id'));

		});

		/* <!-- util --> */
		//console.log(formToJSON());
		// Helper function to serialize all the form fields into a JSON string
		function formToJSON(TYPEID) {
			var _id = $('#album-title').attr('data-id');

			var _title = $('#album-title').val() || '0';
			var _date = $('#album-date').val() || '0';
			var _tag =  $("#state option:selected").val();
			var _type = TYPEID == '3' ? "Champion" : "Activity";
			console.log("_tag=" + _tag);
			//console.log($('#album-title').val());
			return JSON.stringify({
				"id" : _id,
				"title" : _title,
				"date" : _date,
				"type" : _type,
				"tag" : _tag
			});
		}

		function SelectContent(part, opt) {
			var Content = "";
			// part = {List, Form, Gallery}
			if (part == "List") {
				Content = $('#simple-table');
			} else if (part == "Form") {
				Content = $('#validation-form');
			} else if (part == "Gallery") {
				Content = $('.widget-body');
			}
			// opt = {dis, en}
			if (opt == "dis") {
				Content.addClass("hide");
			} else if (opt == "en") {
				Content.removeClass("hide");
			}
			console.log(part + " opt:" + opt);
		}

		function ListCtrl(opt) {
			var Content = $("#simple-table tbody");

			if (opt == "render") {
				getAll(TYPEID);
			} else if (opt == "clean") {
				Content.empty();
			}
		}

		function FormCtrl(opt) {
			var Content = $('#validation-form');

			if (opt == "render") {
				loadAlbumInfo();
			} else if (opt == "clean") {
				Content.trigger('reset');
			} else if (opt == "valid") {
				Content.valid()
			} /* else if (opt == "2JSON") {
								var _id = $('#album-title').attr('data-id');
								var _title = $('#album-title').val() || '0';
								var _date = $('#album-date').val() || '0';
								var _tag = TYPEID == '3' ? '0' : $("#state option:selected")
										.val();
								var _type = TYPEID == '3' ? "Champion" : "Activity";
								console.log("_tag=" + _tag);
								//console.log($('#album-title').val());
								return JSON.stringify({
									"id" : _id,
									"title" : _title,
									"date" : _date,
									"type" : _type,
									"tag" : _tag
								});
							} */

		}

		function GalleryCtrl(opt) {
			var Content = $("#_gallery");

			if (opt == "render") {
				loadPhotoSet();
			} else if (opt == "clean") {
				Content.empty();
			}

		}
		/** init page  **/
		ListCtrl("render");
		SelectContent("List", "en");
		SelectContent("Form", "dis");
		SelectContent("Gallery", "dis");
		/** init page end **/
	</script>
</body>
</html>

