/**
 * 工具js文件
 */

var utils = {
		showTips :　function(tips, TimeShown, autoHide){
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
				              //alert('jNofity is completed !');
				          }
				      }
				    );
		}
}
