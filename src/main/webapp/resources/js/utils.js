/**
 * 工具js文件
 */

var utils = {
		showTips :　function(tips,TimeShown, autoHide){
			 jError(
				      tips,
				      {
				          autoHide: autoHide || true, // added in v2.0
				          TimeShown: TimeShown || 1500,
				          HorizontalPosition: 'center',
				          VerticalPosition: 'center',
				          ShowOverlay: true,
				          ColorOverlay: '#000',
				          onCompleted: function () { // added in v2.0
				          }
				      }
				    );
		},
		showSuccessTips :　function(tips, type, TimeShown, autoHide){
			 jNotify(
				      tips,
				      {
				          autoHide: autoHide || true, // added in v2.0
				          TimeShown: TimeShown || 1000,
				          HorizontalPosition: 'center',
				          VerticalPosition: 'top',
				          ShowOverlay: true,
				          ColorOverlay: '#000',
				          onClosed: function () { // added in v2.0
				        	  if (type == 1 || type == 2){
				        		  $("#tableArea").hide();
				        		  $("#admin-content").hide();
				        	  } else {
				        		  switchArea.showtable();
				        	  }
				          }
				      }
				    );
		}
}
