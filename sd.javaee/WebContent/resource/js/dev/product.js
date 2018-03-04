
$(function(){
	
	$("#btn_upload").click(function(){ //上传按钮触发事件

		//h5表单数据
		var fd = new FormData();
		fd.append("vedio" , $("#vedio")[0].files[0]);     
		
		$.ajax({
			url : 'http://localhost:8080/sd.javaee/product?method=addProductVedio' ,  
			type : 'post' , 
			data : fd , 
			processData : false , 
			contentType : false , 
			xhr : function() {   //xhr ---> level 2
				var xhr = $.ajaxSettings.xhr();
				xhr.upload.onload = function() {
				}
				
				xhr.upload.onprogress = function(e) { //当上传过程中 . . .
					if(e.lengthComputable) {
						var precent = e.loaded * 100 / e.total ;
						$("#curr").width(precent*2); //控制进度条
						$("#curr").html(Math.floor(precent,2)+"%")   //显示百分比
					}
				}
				return xhr;
			} , 
			success : function(data) {
				alert("文件上传成功 . . . ")
			}
		});
		
	})
	
	
});