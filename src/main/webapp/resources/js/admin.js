/**
 * 
 */
var admin = {
			
			summary : function(){
				admin.ObjectClick($("#summary"),"发布简介",1,function(){
					$.get("/carBooking/cmsMg/getList?type=1",function(data){
						$("#article_type").val(1);
						$("#article_id").val(data[0].article_id);
						$("#title").val(data[0].article_title);
						$("#time").val(data[0].article_time);
						admin.insert(data[0]);
					});
				});
			},
			activity : function(){
				admin.ObjectClick($("#activity"),"发布活动",5);
			},
			notice : function(){
				admin.ObjectClick($("#notice"),"发布公告",3);
			},
			help : function(){
				admin.ObjectClick($("#help"),"发布帮助信息",2,function(){
					$.get("/carBooking/cmsMg/getList?type=2",function(data){
						$("#article_type").val(2);
						$("#article_id").val(data[0].article_id);
						$("#title").val(data[0].article_title);
						$("#time").val(data[0].article_time);
						admin.insert(data[0]);
					});
				});
			},
			news : function(){
				admin.ObjectClick($("#news"),"发布新闻",4);
			},
			loadtype : function(){
				$.post("/carBooking/cmsMg/getType",function(data){
					$.each(data,function(index,key){
						$("#car_type").append("<option>"+key.type_detail+"</option>");
					});
				})
			},
			addCar : function(){
				$("#car").click(function(){
					admin.loadtype();
					$('#car-modal').modal({width:700,height:580});
					admin.submitForm();
				});
			},
			picManager : function(){
				$("#picManager").click(function(){
					$.get("/carBooking/cmsMg/getPictures",function(data){
						switchArea.showedit();
						$("#admin-content").html(data);
					})
				});
			},
			rest :　function(){
				$("#car-modal").on('closed.modal.amui',function(){
					$("#car_type").find("option").each(function(index){
						if (index != 0){
							$(this).remove();
						}
					});
					$("#car_name").val("");
					$("#leaguer_price").val("");
					$("#retail_price").val("");
					$("#car_detail").val("");
					$("#file").val("");
					$("#tips").val("");
				});
			},
			submitForm : function(){
				$("#s_add_car").unbind('click').click(function(){
					if (admin.checkValidate()){
						$("#addCarForm").ajaxSubmit({
							type : 'post',
							url : '/carBooking/cmsMg/addCar',
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
								} else {
									utils.showTips(data.msg);
								}
							}
						});
					} else {
						return;
					}
				});
			},
			checkEmpty : function(){
				var c_f = $("#car_name").val()==""?true:false;
				var l_f = $("#leaguer_price").val()==""?true:false;
				var r_f = $("#retail_price").val()==""?true:false;
				var t_f = $("#car_detail").val()==""?true:false;
				var tp_f = $("#tips").val()==""?true:false;
				var s_f = $("#car_type option:selected").index()==0?true:false;
				var f_f = $("#file").val()==""?true:false
						
				/**校验除文件上传外的输入框是否为空*/
				if (c_f || l_f || r_f || t_f || s_f){
					return false;
				} else {
					return true;
				}
				
			},
			checkLength : function(){
				var c_name_l = $("#car_name").val().length;
				var c_detail_l = $("#car_detail").val().length;
				
				if (c_name_l > 15){
					utils.showTips("车辆标题超出限定长度（1-15）");
					return false;
				}
				if (c_detail_l > 200){
					utils.showTips("车辆详情所填写内容超过限定长度1-200");
					return false;
				}
				return true;
			},
			checkValidate : function(){
				if (admin.checkLength() && admin.checkEmpty()){
					return true;
				} else {
					return false;
				}
			},
			ObjectClick : function(o, str, type, fn){
				o.click(function(){	
					$.get("/carBooking/edit",function(data){
						switchArea.showedit();
						$("#admin-content").html(data);
						$("#publish").append(str);
						$("#article_type").val(type);
						//可在渲染页面结束后执行函数
						if (fn && fn instanceof Function){
							fn();
						}
					});
				});
			},
			digitInput : function(el, e){
				var val = el.val();  
			    var val2 = val.replace(/[^\d]/g, '');  
			    el.val(val2);
			},
			checkDigit : function(o){
				o.keydown(function(e) {  
			        admin.digitInput($(this), e);  
			    }); 
			},
			insert : function(row){
	    		ue.ready(function(){
	    			ue.execCommand('insertHtml', row.article_content);
	    		});
	    	}
	}
function publishArticle(){
	var content = ue.getContent();
	publish.publishArticle(content);
}
$(function(){
    admin.summary();
    admin.activity();
    admin.picManager();	
    admin.notice();
    admin.help();
    admin.news();
    admin.addCar();
    admin.rest();
    admin.submitForm()
    admin.checkDigit($("#leaguer_price"));
    admin.checkDigit($("#retail_price"));
})
