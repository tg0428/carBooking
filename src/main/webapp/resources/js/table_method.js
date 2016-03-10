/**
 * bootstrap-table operate method
 */
window.operateEvents = {
	'click #view' : function(e,value,row,index){
		table_method.view(row);
	},
	'click #modify_car' : function(e,value,row,index){
		table_method.modify_car(row);
	},
	'click #del_car' : function(e,value,row,index){
		table_method.del_car(row);
	},
	'click #modify_article' : function(e,value,row,index){
		table_method.modify_article(row);
	},
	'click #del_article' : function(e,value,row,index){
		table_method.del_article(row);
	}
}

var table_method = {
		
		view : function(row){
			$("#viewCar").html(
					"<tr><td width=130 class='am-primary'><strong>车辆名称</strong></td><td colspan='2' class='am-active' style='font-size:14px'>"+row.car_name+"</td></tr>" +
					"<tr><td class='am-primary'><strong>会员价</strong></td><td colspan='2' class='am-active' style='font-size:14px'>"+row.leaguer_price+"元</td></tr>"+
					"<tr><td class='am-primary'><strong>门市价</strong></td><td colspan='2' class='am-active' style='font-size:14px'>"+row.retail_price+"元</td></tr>" +
					"<tr><td class='am-primary'><strong>车辆详情</strong></td><td colspan='2' class='am-active' style='font-size:14px'><span>"+row.car_detail+"</span></td></tr>" +
					"<tr><td class='am-primary'><strong>优惠类型</strong></td><td colspan='2' class='am-active' style='font-size:14px'>"+row.type_detail+"</td></tr>" +
					"<tr><td class='am-primary'><strong>车辆图片</strong></td><td colspan='2' class='am-active' style='font-size:14px'><img class='am-radius' height='140' width='120' src='"+(row.image_server_url==null?'http://image.bitautoimg.com/autoalbum/V2.1/images/150-100.gif':row.image_server_url)+"'  class='am-img-responsive' alt=''/></td></tr>" +
					"<tr><td class='am-primary'><strong>备注说明</strong></td><td colspan='2' class='am-active' style='font-size:14px'>"+(row.tips==""?'暂无':row.tips)+"</td></tr>");
			$("#viewCarDetail").modal({width:700,height:550});
		},
		modify_car : function(row){
			admin.loadtype();
			$("#car_id").val(row.car_id);
			$("#car_name").val(row.car_name);
			$("#leaguer_price").val(row.leaguer_price);
			$("#retail_price").val(row.retail_price);
			$("#car_detail").val(row.car_detail);
			$("#tips").val(row.tips);
			$("#car-modal").modal({width:700,height:580});
			$("#s_add_car").unbind('click').click(function(){
				if (admin.checkValidate()){
					$("#addCarForm").ajaxSubmit({
						type : 'post',
						url : '/carBooking/cmsMg/updataCar',
						beforeSubmit : function(data){
							var fileDataIndex = -1;
							
							 $.each(data, function(index, value) {
						          if (value.name == "file"){
						              if (value.value.length == 0){
						                  fileDataIndex = index;
						              }
						          }
						        });

						     if (fileDataIndex != -1){
						    	 data.splice(fileDataIndex,1); 
						     }
						},
						success : function(data){
							if (data.msg == "true"){
								$("#car-modal").modal('close');
								init.car('/carBooking/cmsMg/getCarList');
								$("#Table").bootstrapTable('refresh');
							}
						}
					});
				} else {
					return;
				}
			});
		},
		modify_article : function(row){
			
			//发布公司公告
			if (row.article_type == 3){
				table_method.showEdit("发布公告",3,row);
			}
			//发布新闻
			if (row.article_type == 4){
				table_method.showEdit("发布新闻",4,row);
			}
			//发布活动
			if (row.article_type == 5){
				table_method.showEdit("发布活动",5,row);
			}
		},
		del_car : function(row){
			var data = {'car_id' : row.car_id};
			table_method.warning("确定要删除吗","删除不恢复","已删除",function(){
				$.post("/carBooking/cmsMg/delCar",data,function(result){
						$("#Table").bootstrapTable('refresh');
				});
				return true;
			});
		},
		del_article : function(row){
			var data = {'article_id' : row.article_id};
			table_method.warning("确定要删除吗","删除不恢复","已删除",function(){
				$.post("/carBooking/cmsMg/delArticle",data,function(result){
					if (result.msg == "true")
						$("#Table").bootstrapTable('refresh');
				});
				return true;
			});
		},
		warning : function(title,text,alt,callback){
			sweetAlert({
				  title: title,
				  text: text,
				  type: "warning",
				  showCancelButton: true,
				  confirmButtonColor: "#DD6B55",
				  confirmButtonText: "删除",
				  cancelButtonText: "取消",
				  closeOnConfirm: false
				}, function(){
					if (callback && callback instanceof Function){
						if (callback()){
							swal("成功", alt, "success");
						}
					}
				});
		},
		showEdit : function(str,type,row){
			$.get("/carBooking/edit",function(data){
				switchArea.showedit();
				$("#admin-content").html(data);
				$("#publish").append(str);
				$("#article_type").val(type);
				$("#article_id").val(row.article_id);
				$("#title").val(row.article_title);
				$("#time").val(row.article_time);
				$("#priority").val(row.article_priority);
				admin.insert(row);
			});
		}
}