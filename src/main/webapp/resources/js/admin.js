/**
 * 
 */
var admin = {
			
			summary : function(){
				admin.ObjectClick($("#summary"),"发布简介");
			},
			activity : function(){
				admin.ObjectClick($("#activity"),"发布活动");
			},
			notice : function(){
				admin.ObjectClick($("#notice"),"发布公告");
			},
			help : function(){
				admin.ObjectClick($("#help"),"发布帮助信息");
			},
			news : function(){
				admin.ObjectClick($("#news"),"发布新闻");
			},
			ObjectClick : function(o, str){
				o.click(function(){
					$.get("/carBooking/edit",function(data){
						$("#admin-content").html(data);
						$("#publish").html(str);
					});
				});
			}
	}
$(function(){
    admin.summary();
    admin.activity();
    admin.notice();
    admin.help();
    admin.news();
})
