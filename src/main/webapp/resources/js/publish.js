/**
 * cms 发布
 */
var publish = {

	checkValidate : function(content) {
		var title = $("#title").val().length;
		var time = $("#time").val().length;

		if (title == 0) {
			utils.showTips("标题不能为空");
			return false;
		} else if (title > 15) {
			utils.showTips("标题长度过长（1-15）");
			return false;
		}

		if (content.length == 0) {
			utils.showTips("正文不能为空");
			return false;
		}

		if (time == 0) {
			utils.showTips("发布时间未选择");
			return false;
		}
		
		return true;
	},
	publishArticle : function(content) {
		
		var title = $("#title").val();
		var content = content;
		var time = $("#time").val();
		var id = $("#article_id").val();
		
		//发布公司简介
		if ($("#article_type").val() == 1) {
			if (publish.checkValidate(content)){
				var data = publish.buildData(id,1,title,content,time);
				publish.judegePorUpd(id,data,1);
			}
		}
		//发布帮助中心
		if ($("#article_type").val() == 2) {
			if (publish.checkValidate(content)){
				var data = publish.buildData(id,2,title,content,time);
				publish.judegePorUpd(id,data,2);
			}
		}
		//发布公司公告
		if ($("#article_type").val() == 3) {
			if (publish.checkValidate(content)){
				var data = publish.buildData(id,3,title,content,time);
				publish.judegePorUpd(id,data);
			}
		}
		//发布公司新闻
		if ($("#article_type").val() == 4) {
			if (publish.checkValidate(content)){
				var data = publish.buildData(id,4,title,content,time);
				publish.judegePorUpd(id,data);
			}
		}
		//发布公司活动
		if ($("#article_type").val() == 5){
			if (publish.checkValidate(content)){
				var data = publish.buildData(id,5,title,content,time);
				publish.judegePorUpd(id,data);
			}
		}
	},
	ajaxAddSubmitInfo : function(data,type){
		$.post('/carBooking/cmsMg/publish',data,function(result){
			if (result.msg == "true"){
				utils.showSuccessTips("发布成功",type);
			} else {
				utils.showTips("发布出错");
			}
		});
	},
	ajaxUpdateSubmitInfo : function(data,type){
		$.post('/carBooking/cmsMg/update',data,function(result){
			if (result.msg == "true"){
				utils.showSuccessTips("更新成功",type);
			} else {
				utils.showTips("更新失败");
			}
		});
	},
	buildData : function(id,type,title,content,time){
		return {'article_id' : id, 'article_type' : type , 'article_title' : title, 'article_content' : content, 'article_time' : time};
	},
	judegePorUpd : function(id,data,type){
		if (id == 0){
			publish.ajaxAddSubmitInfo(data,type);
		} else {
			publish.ajaxUpdateSubmitInfo(data,type);
		}
	}
	
}
