<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="html" tagdir="/WEB-INF/tags"%>
<%-- <%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("login.html");
	}
%> --%>

<!DOCTYPE html>
<html lang="en">
<html:ad_head headline="最新消息" />

<body class="no-skin">
	<!-- #section:basics/navbar.layout -->
	<html:ad_nav headline="承利保險經紀人 後台管理" />
	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<!-- #section:basics/sidebar -->
		<div id="sidebar" class="sidebar                  responsive">
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

				<li class="active"><a href="page02.jsp"> <span
						class="menu-text"> 最新消息管理 </span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="page03.jsp"> <span class="menu-text">
							菁英薈萃管理 </span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="page04.jsp"> <span class="menu-text">
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
						<li class="active">最新消息管理</li>
					</ul>
					<!-- /.breadcrumb -->

					<!-- #section:basics/content.searchbox -->
					<!-- <div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div> -->
					<!-- /.nav-search -->

					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<div class="page-header">
						<h1>最新消息管理</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="row">
								<div class="col-xs-12">

									<table id="simple-table"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th class="center" width="7%">編號</th>
												<th width="20%">文章標題</th>
												<th width="30%">內文</th>
												<th width="20%">圖片</th>
												<th width="10%">日期</th>
												<th width="13%">
													<button class="btn btn-insert btn-xs btn-primary">
														<i class="ace-icon fa fa-search-plus bigger-120">新增</i>
													</button>
												</th>
											</tr>
										</thead>

										<tbody>
											<tr>

											</tr>
										</tbody>
									</table>

									<form class="form-horizontal" role="form" hidden="true">
										<!-- #section:elements.form -->
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"
												for="form-field-1"> 文章標題 </label>

											<div class="col-sm-9">
												<input id="news_title" name="dnt_name" type="text"
													id="form-field-1" placeholder="文章標題"
													class="col-xs-10 col-sm-5" />
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
													cols="30" rows="20" wrap="soft" placeholder="文章內容"></textarea>
											</div>
										</div>

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
												for="form-field-1"> 文章圖片 </label>

											<div class="col-sm-9">
												<input id="news_file" type="text" placeholder="文章圖片"
													class="col-xs-10 col-sm-5" disabled />
												<h5>
													&nbsp;<a href="#fileUpload" data-toggle="modal"><i
														class="ace-icon fa fa-cloud-upload bigger-120"></i> 上傳文章圖片</a>
												</h5>
											</div>
										</div>

										<div class="clearfix form-actions">
											<div class="col-md-offset-3 col-md-9">
												<button id="btn_save" class="btn btn-info" type="button">
													<i class="ace-icon fa fa-check bigger-110"></i> <font
														style="color: #fff;">儲存</font>
												</button>

												&nbsp; &nbsp; &nbsp;
												<button id="btn_cancel" class="btn btn-cancel" type="reset">
													<i class="ace-icon fa fa-undo bigger-110"></i> 取消
												</button>
											</div>
										</div>
									</form>
								</div>
								<!-- /.span -->
							</div>
							<!-- /.row -->
							<div id="fileUpload" class="modal">
								<div class="modal-dialog">
									<form action="../UploadServlet" method="post"
										enctype="multipart/form-data">
										<div class="modal-content">
											<div id="modal-wizard-container">
												<div class="modal-header">
													<div class="center">
														<h4 class="blue">請選擇要上傳的圖片</h4>
													</div>
												</div>

												<div class="modal-body">
													<div class="center">
														<input type="text" id="passBlogId" name="passBlogId"
															value="1234" class="hide" /> <input type="file"
															name="fileName" />
													</div>

												</div>
											</div>

											<div class="modal-footer wizard-actions">
												<button class="btn btn-success btn-sm btn-next"
													type="submit" data-last="Finish">
													<i class="ace-icon fa fa-check bigger-110"></i>確定
												</button>

												<button class="btn btn-danger btn-sm" type="reset"
													data-dismiss="modal">
													<i class="ace-icon fa fa-times"></i>取消
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<html:ad_foot headline="承利保險經紀人 後台管理" />

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
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
	<script src="./assets/js/bootstrap.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="../assets/js/excanvas.js"></script>
		<![endif]-->
	<script src="./assets/js/jquery-ui.custom.js"></script>
	<script src="./assets/js/jquery.ui.touch-punch.js"></script>
	<script src="./assets/js/jquery.easypiechart.js"></script>
	<script src="./assets/js/jquery.sparkline.js"></script>
	<script src="./assets/js/flot/jquery.flot.js"></script>
	<script src="./assets/js/flot/jquery.flot.pie.js"></script>
	<script src="./assets/js/flot/jquery.flot.resize.js"></script>

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

			$('.sparkline').each(
					function() {
						var $box = $(this).closest('.infobox');
						var barColor = !$box.hasClass('infobox-dark') ? $box
								.css('color') : '#FFF';
						$(this).sparkline('html', {
							tagValuesAttribute : 'data-values',
							type : 'bar',
							barColor : barColor,
							chartRangeMin : $(this).data('min') || 0
						});
					});

			//flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
			//but sometimes it brings up errors with normal resize event handlers
			$.resize.throttleWindow = false;

			var placeholder = $('#piechart-placeholder').css({
				'width' : '90%',
				'min-height' : '150px'
			});
			var data = [ {
				label : "social networks",
				data : 38.7,
				color : "#68BC31"
			}, {
				label : "search engines",
				data : 24.5,
				color : "#2091CF"
			}, {
				label : "ad campaigns",
				data : 8.2,
				color : "#AF4E96"
			}, {
				label : "direct traffic",
				data : 18.6,
				color : "#DA5430"
			}, {
				label : "other",
				data : 10,
				color : "#FEE074"
			} ]

			/**
			we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			so that's not needed actually.
			 */

			//pie chart tooltip example
			var $tooltip = $(
					"<div class='tooltip top in'><div class='tooltip-inner'></div></div>")
					.hide().appendTo('body');
			var previousPoint = null;

			placeholder.on('plothover', function(event, pos, item) {
				if (item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : "
								+ item.series['percent'] + '%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({
						top : pos.pageY + 10,
						left : pos.pageX + 10
					});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}

			});

			/////////////////////////////////////
			$(document).one('ajaxloadstart.page', function(e) {
				$tooltip.remove();
			});

			var d1 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d1.push([ i, Math.sin(i) ]);
			}

			var d2 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d2.push([ i, Math.cos(i) ]);
			}

			var d3 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.2) {
				d3.push([ i, Math.tan(i) ]);
			}

			var sales_charts = $('#sales-charts').css({
				'width' : '100%',
				'height' : '220px'
			});
			$.plot("#sales-charts", [ {
				label : "Domains",
				data : d1
			}, {
				label : "Hosting",
				data : d2
			}, {
				label : "Services",
				data : d3
			} ], {
				hoverable : true,
				shadowSize : 0,
				series : {
					lines : {
						show : true
					},
					points : {
						show : true
					}
				},
				xaxis : {
					tickLength : 0
				},
				yaxis : {
					ticks : 10,
					min : -2,
					max : 2,
					tickDecimals : 3
				},
				grid : {
					backgroundColor : {
						colors : [ "#fff", "#fff" ]
					},
					borderWidth : 1,
					borderColor : '#555'
				}
			});

			$('#recent-box [data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('.tab-content')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				//var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}

			$('.dialogs,.comments').ace_scroll({
				size : 300
			});

			//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
			//so disable dragging when clicking on label
			var agent = navigator.userAgent.toLowerCase();
			if ("ontouchstart" in document && /applewebkit/.test(agent)
					&& /android/.test(agent))
				$('#tasks').on('touchstart', function(e) {
					var li = $(e.target).closest('#tasks li');
					if (li.length == 0)
						return;
					var label = li.find('label.inline').get(0);
					if (label == e.target || $.contains(label, e.target))
						e.stopImmediatePropagation();
				});

			$('#tasks').sortable({
				opacity : 0.8,
				revert : true,
				forceHelperSize : true,
				placeholder : 'draggable-placeholder',
				forcePlaceholderSize : true,
				tolerance : 'pointer',
				stop : function(event, ui) {
					//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
					$(ui.item).css('z-index', 'auto');
				}
			});
			$('#tasks').disableSelection();
			$('#tasks input:checkbox').removeAttr('checked').on('click',
					function() {
						if (this.checked)
							$(this).closest('li').addClass('selected');
						else
							$(this).closest('li').removeClass('selected');
					});

			//show the dropdowns on top or bottom depending on window height and menu position
			$('#task-tab .dropdown-hover').on('mouseenter', function(e) {
				var offset = $(this).offset();

				var $w = $(window)
				if (offset.top > $w.scrollTop() + $w.innerHeight() - 100)
					$(this).addClass('dropup');
				else
					$(this).removeClass('dropup');
			});

		})
	</script>

	<!-- the following scripts are used in demo only for onpage help and you don't need them -->
	<link rel="stylesheet" href="./assets/css/ace.onpage-help.css" />
	<link rel="stylesheet" href="docs/assets/js/themes/sunburst.css" />

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
	<script src="./js/additional-methods.min.js"></script>
	<!-- <script src="messages_zh_TW.min.js"></script> -->

	<script type="text/javascript">
	jQuery(function($) {

		$('#id-disable-check').on('click', function() {
			var inp = $('#form-input-readonly').get(0);
			if(inp.hasAttribute('disabled')) {
				inp.setAttribute('readonly' , 'true');
				inp.removeAttribute('disabled');
				inp.value="This text field is readonly!";
			}
			else {
				inp.setAttribute('disabled' , 'disabled');
				inp.removeAttribute('readonly');
				inp.value="This text field is disabled!";
			}
		});
	
	
		if(!ace.vars['touch']) {
			$('.chosen-select').chosen({allow_single_deselect:true}); 
			//resize the chosen on window resize
	
			$(window)
			.off('resize.chosen')
			.on('resize.chosen', function() {
				$('.chosen-select').each(function() {
					 var $this = $(this);
					 $this.next().css({'width': $this.parent().width()});
				})
			}).trigger('resize.chosen');
			//resize chosen on sidebar collapse/expand
			$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
				if(event_name != 'sidebar_collapsed') return;
				$('.chosen-select').each(function() {
					 var $this = $(this);
					 $this.next().css({'width': $this.parent().width()});
				})
			});
	
	
			$('#chosen-multiple-style .btn').on('click', function(e){
				var target = $(this).find('input[type=radio]');
				var which = parseInt(target.val());
				if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
				 else $('#form-field-select-4').removeClass('tag-input-style');
			});
		}
	
	
		$('[data-rel=tooltip]').tooltip({container:'body'});
		$('[data-rel=popover]').popover({container:'body'});
		
		$('textarea[class*=autosize]').autosize({append: "\n"});
		$('textarea.limited').inputlimiter({
			remText: '%n character%s remaining...',
			limitText: 'max allowed : %n.'
		});
	
		$.mask.definitions['~']='[+-]';
		$('.input-mask-date').mask('99/99/9999');
		$('.input-mask-phone').mask('(999) 999-9999');
		$('.input-mask-eyescript').mask('~9.99 ~9.99 999');
		$(".input-mask-product").mask("a*-999-a999",{placeholder:" ",completed:function(){alert("You typed the following: "+this.val());}});
	
	
	
		$( "#input-size-slider" ).css('width','200px').slider({
			value:1,
			range: "min",
			min: 1,
			max: 8,
			step: 1,
			slide: function( event, ui ) {
				var sizing = ['', 'input-sm', 'input-lg', 'input-mini', 'input-small', 'input-medium', 'input-large', 'input-xlarge', 'input-xxlarge'];
				var val = parseInt(ui.value);
				$('#form-field-4').attr('class', sizing[val]).val('.'+sizing[val]);
			}
		});
	
		$( "#input-span-slider" ).slider({
			value:1,
			range: "min",
			min: 1,
			max: 12,
			step: 1,
			slide: function( event, ui ) {
				var val = parseInt(ui.value);
				$('#form-field-5').attr('class', 'col-xs-'+val).val('.col-xs-'+val);
			}
		});
	
	
		
		//"jQuery UI Slider"
		//range slider tooltip example
		$( "#slider-range" ).css('height','200px').slider({
			orientation: "vertical",
			range: true,
			min: 0,
			max: 100,
			values: [ 17, 67 ],
			slide: function( event, ui ) {
				var val = ui.values[$(ui.handle).index()-1] + "";
	
				if( !ui.handle.firstChild ) {
					$("<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
					.prependTo(ui.handle);
				}
				$(ui.handle.firstChild).show().children().eq(1).text(val);
			}
		}).find('span.ui-slider-handle').on('blur', function(){
			$(this.firstChild).hide();
		});
		
		
		$( "#slider-range-max" ).slider({
			range: "max",
			min: 1,
			max: 10,
			value: 2
		});
		
		$( "#slider-eq > span" ).css({width:'90%', 'float':'left', margin:'15px'}).each(function() {
			// read initial values from markup and remove that
			var value = parseInt( $( this ).text(), 10 );
			$( this ).empty().slider({
				value: value,
				range: "min",
				animate: true
				
			});
		});
		
		$("#slider-eq > span.ui-slider-purple").slider('disable');//disable third item
	
		
		$('#id-input-file-1 , #id-input-file-2').ace_file_input({
			no_file:'No File ...',
			btn_choose:'Choose',
			btn_change:'Change',
			droppable:false,
			onchange:null,
			thumbnail:false //| true | large
			//whitelist:'gif|png|jpg|jpeg'
			//blacklist:'exe|php'
			//onchange:''
			//
		});
		//pre-show a file name, for example a previously selected file
		//$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])
	
	
		$('#id-input-file-3').ace_file_input({
			style:'well',
			btn_choose:'Drop files here or click to choose',
			btn_change:null,
			no_icon:'ace-icon fa fa-cloud-upload',
			droppable:true,
			thumbnail:'fit'//'small'//large | fit
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
	
		}).on('change', function(){
			//console.log($(this).data('ace_input_files'));
			//console.log($(this).data('ace_input_method'));
		});
		
		
		//$('#id-input-file-3')
		//.ace_file_input('show_file_list', [
			//{type: 'image', name: 'name of image', path: 'http://path/to/image/for/preview'},
			//{type: 'file', name: 'hello.txt'}
		//]);
	
		
		
	
		//dynamically change allowed formats by changing allowExt && allowMime function
		$('#id-file-format').removeAttr('checked').on('change', function() {
			var whitelist_ext, whitelist_mime;
			var btn_choose
			var no_icon
			if(this.checked) {
				btn_choose = "Drop images here or click to choose";
				no_icon = "ace-icon fa fa-picture-o";
	
				whitelist_ext = ["jpeg", "jpg", "png", "gif" , "bmp"];
				whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"];
			}
			else {
				btn_choose = "Drop files here or click to choose";
				no_icon = "ace-icon fa fa-cloud-upload";
				
				whitelist_ext = null;//all extensions are acceptable
				whitelist_mime = null;//all mimes are acceptable
			}
			var file_input = $('#id-input-file-3');
			file_input
			.ace_file_input('update_settings',
			{
				'btn_choose': btn_choose,
				'no_icon': no_icon,
				'allowExt': whitelist_ext,
				'allowMime': whitelist_mime
			})
			file_input.ace_file_input('reset_input');
			
			file_input
			.off('file.error.ace')
			.on('file.error.ace', function(e, info) {
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
	
		$('#spinner1').ace_spinner({value:0,min:0,max:200,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
		.closest('.ace-spinner')
		.on('changed.fu.spinbox', function(){
			//alert($('#spinner1').val())
		}); 
		$('#spinner2').ace_spinner({value:0,min:0,max:10000,step:100, touch_spinner: true, icon_up:'ace-icon fa fa-caret-up bigger-110', icon_down:'ace-icon fa fa-caret-down bigger-110'});
		$('#spinner3').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus bigger-110', icon_down:'ace-icon fa fa-minus bigger-110', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
		$('#spinner4').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus', icon_down:'ace-icon fa fa-minus', btn_up_class:'btn-purple' , btn_down_class:'btn-purple'});
	
		//$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
		//or
		//$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
		//$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0
	
	
		//datepicker plugin
		//link
		$('.date-picker').datepicker({
			autoclose: true,
			todayHighlight: true
		})
		//show datepicker when clicking on the icon
		.next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
	
		//or change it into a date range picker
		$('.input-daterange').datepicker({autoclose:true});
	
	
		//to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
		$('input[name=date-range-picker]').daterangepicker({
			'applyClass' : 'btn-sm btn-success',
			'cancelClass' : 'btn-sm btn-default',
			locale: {
				applyLabel: 'Apply',
				cancelLabel: 'Cancel',
			}
		})
		.prev().on(ace.click_event, function(){
			$(this).next().focus();
		});
	
	
		$('#timepicker1').timepicker({
			minuteStep: 1,
			showSeconds: true,
			showMeridian: false
		}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
		$('#date-timepicker1').datetimepicker().next().on(ace.click_event, function(){
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
		try{
			tag_input.tag(
			  {
				placeholder:tag_input.attr('placeholder'),
				//enable typeahead by specifying the source array
				source: ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
				/**
				//or fetch data from database, fetch those that match "query"
				source: function(query, process) {
				  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
				  .done(function(result_items){
					process(result_items);
				  });
				}
				*/
			  }
			)
	
			//programmatically add a new
			var $tag_obj = $('#form-field-tags').data('tag');
			$tag_obj.add('Programmatically Added');
		}
		catch(e) {
			//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
			tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
			//$('#form-field-tags').autosize({append: "\n"});
		}
		
		
		/////////
		$('#modal-form input[type=file]').ace_file_input({
			style:'well',
			btn_choose:'Drop files here or click to choose',
			btn_change:null,
			no_icon:'ace-icon fa fa-cloud-upload',
			droppable:true,
			thumbnail:'large'
		})
		
		//chosen plugin inside a modal will have a zero width because the select element is originally hidden
		//and its width cannot be determined.
		//so we set the width after modal is show
		$('#modal-form').on('shown.bs.modal', function () {
			if(!ace.vars['touch']) {
				$(this).find('.chosen-container').each(function(){
					$(this).find('a:first-child').css('width' , '210px');
					$(this).find('.chosen-drop').css('width' , '210px');
					$(this).find('.chosen-search input').css('width' , '200px');
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
	
		
		
		$(document).one('ajaxloadstart.page', function(e) {
			$('textarea[class*=autosize]').trigger('autosize.destroy');
			$('.limiterBox,.autosizejs').remove();
			$('.daterangepicker.dropdown-menu,.colorpicker.dropdown-menu,.bootstrap-datetimepicker-widget.dropdown-menu').remove();
		});
	
	});
</script>

	<script>
		var rootURL = "../api";

		function getAll() {
			console.log('getAll news: ');
			$.ajax({
				type : 'GET',
				url : rootURL + '/articles/0',
				dataType : "json",
				success : function(data) {
					//renderDonationList(data);
					console.log("getAll articles ing...");
					renderList(data);
					$("#simple-table").show();
				}
			});
		}

		function getNewsBySid(sid) {
			$.ajax({
				type : 'GET',
				url : rootURL + '/articles/' + sid,
				dataType : "json",
				success : function(data) {
					console.log("getNewsBySid ing...");
					renderDetail(data);
				}
			});
		}
		function saveNews() {
			console.log('saveNews:');
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : rootURL + '/articles',
				dataType : "json",
				data : formToJSON(),
				success : function(data, textStatus, jqXHR) {
					console.log("saveNews success...");
					$('.form-horizontal').trigger('reset');
					getAll();
				}
			});
		}
		
		function deleteDonation(id) {
			console.log('deleteDonation');
			$.ajax({
				type : 'DELETE',
				url : rootURL + '/articles/' + id,
				success : function(data, textStatus, jqXHR) {
					alert('delete successfully');
					getAll();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('deleteDonation error');
				}
			});
		}

		function renderDetail(data) {
			var list = data == null ? [] : (data instanceof Array ? data
					: [ data ]);
			//alert(list[0].sid);
			$('#passBlogId').val("Blog_"+list[0].id);
			alert($('#passBlogId').val());
			$('.form-horizontal').attr("data-id", list[0].id);
			//getiktList(list[0].ikt);
			// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
			$('#news_title').val(list[0].title);
			$('#news_content').val(list[0].content);
			$('#news_file').val(list[0].pic);
			$('#news_date').val(list[0].date);
			//$('#opt_ikt option:eq(2)').attr('selected',true);
		}

		function renderList(data) {
			console.log("render news List: ");
			// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
			var list = data == null ? [] : (data instanceof Array ? data
					: [ data ]);

			$("#simple-table tbody").empty();

			var dntBox = "";

			$
					.each(
							list,
							function(index, item) {
								dntBox = '';

								var btns = '<td><div class="hidden-sm hidden-xs btn-group"><button class="btn btn-xs btn-info" data-id="'
								+item.id
								+'"><i class="ace-icon fa fa-pencil bigger-120"><font style="color: #fff;">編輯</font></i></button><button class="btn btn-xs btn-danger" data-id="'
								+item.id
								+'"><i class="ace-icon fa fa-trash-o bigger-120">刪除</i></button></div><div class="hidden-md hidden-lg"><div class="inline pos-rel"><button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto" data-id="'
								+item.id
								+'"><i class="ace-icon fa fa-cog icon-only bigger-110"></i></button><ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close"><li><a class="tooltip-success" data-rel="tooltip" title="Edit" data-id="'
								+item.id
								+'"><span class="green"><i class="ace-icon fa fa-pencil-square-o bigger-120"></i></span></a></li><li><a class="tooltip-error" data-rel="tooltip" title="Delete" data-id="'
								+item.id
								+'"><span class="red"><i class="ace-icon fa fa-trash-o bigger-120"></i></span></a></li></ul></div></div></td>';

								dntBox = '<td class="center" width="7%">' + (index+1)
										+ '</td><td width="20%">' + item.title.substr(0,12)	//文章標題
										+ '</td><td width="30%">' + item.content.substr(0,100) + "..." 	//內文
										+ '</td><td width="20%" class="center"><img src="images/user.jpg'+/* ' + item.file +' */'" height="100" />' 	//圖片
										+ '</td><td width="10%">' + item.date + '</td>>';	//日期

								$("#simple-table tbody").append(
										'<tr>' + dntBox + btns);

							});

			console.log('renderBeta : bye');
		}

		var validator = $('.form-horizontal').validate({
				  rules: { 
					news_title: { required: true,
							    maxlength: 20,
							    minlength:3 
					},
						   
					news_content: { required: true,
							   // maxlength: 20,
							    minlength:3 
					},

					news_date: { required: true,
								dateISO: true
					}

				},
				errorPlacement: function(error, element) {
					// Append error within linked label
					$( element )
						.closest( "form" )
						.find( "div[for='" + element.attr( "id" ) + "']" )
						.append( error );
		},
		errorElement: "span"
		});

		/* save */
		$('.form-horizontal').on('click', '.btn-info', function(event) {
			
				//alert( "Valid: " + $('.form-horizontal').valid() );
			if($('.form-horizontal').valid()){
				saveNews();
				$('.form-horizontal').hide();
			}else{
				alert( "Valid: " + $('.form-horizontal').valid() );
			}
			//alert('saved!!');\
		});
		
		/* cancel */
		$('.form-horizontal').on('click', '.btn-cancel', function(event) {
			
			validator.resetForm();
			$('.form-horizontal').hide();
			//alert('cancel!!');
			getAll();
		})

		/* 新增 */
		$('#simple-table').on('click', '.btn-insert', function(event) {
			$('.form-horizontal').attr("data-id", '0');
			$('.form-horizontal').show();
			
			$('#simple-table').hide();
			//alert('on insert');
		});

		/* 編輯 */
		$('#simple-table').on('click', '.btn-info', function(event){
			//alert('Edit: id='+$(this).data('id'));
			getNewsBySid($(this).data('id'));
			$('.form-horizontal').show();
			$('#simple-table').hide();
		});
		$('#simple-table').on('click', '.tooltip-success', function(event) {
			getNewsBySid($(this).data('id'));
			$('.form-horizontal').show();
			$('#simple-table').hide();
			//$('.form-horizontal').validate();
			validForm();
		});

		/* 刪除 */
		$('#simple-table').on('click', '.btn-danger', function(event) {
			//alert('Delete: id=' + $(this).data('id'));
			deleteDonation($(this).data('id'));
		});
		$('#simple-table').on('click', '.tooltip-error', function(event) {
			//alert('Delete: id=' + $(this).data('id'));
			deleteDonation($(this).data('id'));
		});

		/* <!-- util --> */
		//console.log(formToJSON());
		// Helper function to serialize all the form fields into a JSON string
		function formToJSON() {
			var _id = $('.form-horizontal').attr('data-id');
			var _title = $('#news_title').val();// || '0';
			var _content = $('#news_content').val();// || '0';
			var _date = $('#news_date').val();// || '0';
			var _file = $('#news_file').val();// || '0';
			console.log('formToJSON');
			return JSON.stringify({
				"id" : _id,
				"title" : _title,
				"content" : _content,
				"date" : _date,
				"file" : _file
			});
		}

		/* init Page */
		$('.form-horizontal').hide();
		//$("#simple-table tbody").empty();
		getAll();

		/* --------- */
	</script>
	<style>
.error {
	color: red;
}
</style>
</body>
</html>

