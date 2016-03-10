/**
 * 初始化cms jedate
 */
$(function(){
	jeDate({
				dateCell:"#time",
	    		format:"YYYY-MM-DD hh:mm:ss",
	   			isTime:true, 
	    		minDate:"2014-09-19 00:00:00"
	});
});