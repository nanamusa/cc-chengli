var rootURL = "../api";

function getAll() {
	console.log('getAll Admin: ');
	$.ajax({
		type : 'GET',
		url : rootURL + '/admin',
		dataType : "json",
		success : function(data) {
			// console.log("getAll Admin ing...");
			renderAdminList(data);
			$("#simple-table").removeClass("hide");
		}
	});
}

function getAdminById(id) {
	console.log('getById Admin: ');
	$.ajax({
		type : 'GET',
		url : rootURL + '/admin/' + id,
		dataType : "json",
		success : function(data) {
			// console.log("getById Admin ing...");
			renderDetail(data);
		}
	});
}

function saveAdmin() {
	console.log('saveAdmin Admin: ');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootURL + '/admin',
		dataType : "json",
		data : formToJSON(),
		success : function() {
			// console.log("saveAdmin Admin success...");
			$('.form-horizontal').trigger('reset');
			getAll();
		}
	});
}

function deleteAdmin(id) {
	console.log('deleteAdmin');
	$.ajax({
		type : 'DELETE',
		url : rootURL + '/admin/' + id,
		success : function(data, textStatus, jqXHR) {
			alert('Admin deleted successfully');
			getAll();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('delete Admin fail');
		}
	});
}

function renderDetail(data) {
	var list = data == null ? [] : (data instanceof Array ? data : [ data ]);
	// alert(list[0].id);
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an
	// object (not an 'array of one')

	$('.form-horizontal').attr("data-id", list[0].id);
	$('#ad_name').val(list[0].name);
	$('#ad_uid').val(list[0].uid);
	$('#ad_upwd').val(list[0].upwd);
	$('#ad_email').val(list[0].email);
}

function renderAdminList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an
	// object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [ data ]);

	$("#simple-table tbody").empty();

	var dntBox = "";

	$
			.each(
					list,
					function(index, dnt) {
						// if(index%4 == 0){
						dntBox = '';
						// }
						var btns = '<td><div class="hidden-sm hidden-xs btn-group"><button class="btn btn-xs btn-info" data-id="'
								+ dnt.id
								+ '"><i class="ace-icon fa fa-pencil bigger-120"><font style="color: #fff;">編輯</font></i></button><button class="btn btn-xs btn-danger" data-id="'
								+ dnt.id
								+ '"><i class="ace-icon fa fa-trash-o bigger-120">刪除</i></button></div><div class="hidden-md hidden-lg"><div class="inline pos-rel"><button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto" data-id="'
								+ dnt.id
								+ '"><i class="ace-icon fa fa-cog icon-only bigger-110"></i></button><ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close"><li><a class="tooltip-success" data-rel="tooltip" title="Edit" data-id="'
								+ dnt.id
								+ '"><span class="green"><i class="ace-icon fa fa-pencil-square-o bigger-120"></i></span></a></li><li><a class="tooltip-error" data-rel="tooltip" title="Delete" data-id="'
								+ dnt.id
								+ '"><span class="red"><i class="ace-icon fa fa-trash-o bigger-120"></i></span></a></li></ul></div></div></td>';

						dntBox = '<td width="5%" class="center">' + (index + 1)
								+ '</td><td width="20%">' + dnt.name
								+ '</td><td width="20%">' + dnt.email
								+ '</td><td width="20%">' + dnt.uid
								+ '</td><td width="20%">' + dnt.upwd + '</td>';

						$("#simple-table tbody").append('<tr>' + dntBox + btns);

					});
}

/* save */
$('.form-horizontal').on('click', '.btn-info', function(event) {
	if ($('.form-horizontal').valid()) {
		saveAdmin();
		$('.form-horizontal').addClass("hide");
	} else {
		alert("Valid: " + $('.form-horizontal').valid());
	}
	// alert('saved!! /ndata-id:'+$('.form-horizontal').attr('data-id'));

})
/* cancel */
$('.form-horizontal').on('click', '.btn-cancel', function(event) {
	$('.form-horizontal').addClass("hide");
	// $('.form-horizontal').hide();
	// alert('cancel!!');
	getAll();
	// validator.resetForm();
})

/* 新增 */
$('#simple-table').on('click', '.btn-insert', function(event) {
	$('.form-horizontal').attr("data-id", '0');
	$('#simple-table').addClass("hide");
	$('.form-horizontal').removeClass("hide");
	// $('.form-horizontal').show();
	// $('#simple-table').hide();
	// alert('on insert');
});

/* 編輯 */
$('#simple-table').on('click', '.btn-info', function(event) {
	// alert('Edit: id='+$(this).data('id'));
	getAdminById($(this).data('id'));
	$('.form-horizontal').removeClass("hide");
	$('#simple-table').addClass("hide");
});
$('#simple-table').on('click', '.tooltip-success', function(event) {
	// alert('Edit: id='+ $(this).data('id'));
	getAdminById($(this).data('id'));
	$('.form-horizontal').removeClass("hide");
	$('#simple-table').addClass("hide");
});

/* 刪除 */
$('#simple-table').on('click', '.btn-danger', function(event) {
	// alert('Delete: id='+$(this).data('id'));
	deleteAdmin($(this).data('id'));
});
$('#simple-table').on('click', '.tooltip-error', function(event) {
	deleteAdmin($(this).data('id'));
});

/* <!-- util --> */
// console.log(formToJSON());
// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var _id = $('.form-horizontal').attr('data-id');
	var _key = '0';
	var _name = $('#ad_name').val() || '0';
	var _email = $('#ad_email').val() || '0';
	var _uid = $('#ad_uid').val() || '0';
	var _upwd = $('#ad_upwd').val() || '0';
	console.log('formToJSON');
	return JSON.stringify({
		"id" : _id,
		"name" : _name,
		"email" : _email,
		"uid" : _uid,
		"upwd" : _upwd,
		"key" : _key
	});
}

/* init Page */
// $('.form-horizontal').hide();
// $("#simple-table tbody").empty();
$("#simple-table").addClass("hide");
$('.form-horizontal').addClass("hide");
getAll();
/* --------- */
