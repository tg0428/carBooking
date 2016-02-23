/**
 * 用于初始化表格，包含用户table,车辆table,新闻table,公告table,活动table
 */

var init = {
		
		car : function(URL){
			$("#Table").bootstrapTable({
			    url: URL, // 接口 URL 地址
			    cache: false, // 不缓存
			    striped: true, // 隔行加亮
			    pagination: true, // 开启分页功能
			    pageSize: 10, // 设置默认分页为 50
			    pageList: [10, 25, 50, 100, 200], // 自定义分页列表
			    minimumCountColumns: 2, // 设置最少显示列个数
			    clickToSelect: false, // 单击行即可以选中
			    sortName: 'id', // 设置默认排序为 name
			    sortOrder: 'desc', // 设置排序为反序 desc
			    smartDisplay: true, // 智能显示 pagination 和 cardview 等
			    columns: [{ // 列设置
			        field: 'state',
			        checkbox: true // 使用复选框
			    }, {
			        field: 'car_name',
			        title: '车辆名称',
			        align: 'center',
			        valign: 'middle'
			    }, {
			        field: 'leaguer_price',
			        title: '会员价',
			        align: 'left',
			        valign: 'top'
			    }, {
			        field: 'retail_price',
			        title: '门市价',
			        align: 'left',
			        valign: 'top'
			    }, {
			        field: 'car_detail',
			        title: '车辆详情',
			        align: 'center',
			        valign: 'top',
			        events: operateEvents,
			        formatter:view_detail
			    }, {
			        field: 'type_detail',
			        title: '优惠类型',
			        align: 'left',
			        valign: 'top'
			    }, {
			        field: 'operate',
			        title: '操作',
			        align: 'center',
			        valign: 'middle',
			        events: operateEvents,
			        formatter:modify_del
			    }],
			    onClickRow: function (row) {
			        //TODO
			      },
			});
		},
		user : function(URL){
			$("#Table").bootstrapTable({
			    url: URL, // 接口 URL 地址
			    cache: false, // 不缓存
			    striped: true, // 隔行加亮
			    pagination: true, // 开启分页功能
			    pageSize: 10, // 设置默认分页为 50
			    pageList: [10, 25, 50, 100, 200], // 自定义分页列表
			    minimumCountColumns: 2, // 设置最少显示列个数
			    clickToSelect: false, // 单击行即可以选中
			    sortName: 'id', // 设置默认排序为 name
			    sortOrder: 'desc', // 设置排序为反序 desc
			    smartDisplay: true, // 智能显示 pagination 和 cardview 等
			    columns: [{ // 列设置
			        field: 'state',
			        checkbox: true // 使用复选框
			    }, {
			        field: 'name',
			        title: '用户名',
			        align: 'center',
			        valign: 'middle'
			    }, {
			        field: 'phone',
			        title: '联系方式',
			        align: 'left',
			        valign: 'top'
			    }, {
			        field: 'car_name',
			        title: '预定车辆名称',
			        align: 'left',
			        valign: 'top'
			    }, {
			        field: 'pu_car_time',
			        title: '取车时间',
			        align: 'left',
			        valign: 'top'
			    }, {
			        field: 'gb_car_time',
			        title: '还车时间',
			        align: 'left',
			        valign: 'top',
			        sortable: true // 开启排序功能
			    }, {
			        field: 'operate',
			        title: '操作',
			        align: 'center',
			        valign: 'middle',
			        clickToSelect: false
			    }],
			    onClickRow: function (row) {
			        //TODO
			      },
			});
		},
		news : function(URL){
			$("#Table").bootstrapTable({
			    url: URL, // 接口 URL 地址
			    cache: false, // 不缓存
			    striped: true, // 隔行加亮
			    pagination: true, // 开启分页功能
			    pageSize: 10, // 设置默认分页为 50
			    pageList: [10, 25, 50, 100, 200], // 自定义分页列表
			    minimumCountColumns: 2, // 设置最少显示列个数
			    clickToSelect: false, // 单击行即可以选中
			    sortName: 'article_priority', // 设置默认排序为 name
			    sortOrder: 'desc', // 设置排序为反序 desc
			    smartDisplay: true, // 智能显示 pagination 和 cardview 等
			    columns: [{ // 列设置
			        field: 'state',
			        checkbox: true // 使用复选框
			    },{
			        field: 'article_title',
			        title: '标题',
			        align: 'center',
			        valign: 'middle'
			    }, {
			        field: 'article_time',
			        title: '发布时间',
			        align: 'left',
			        valign: 'top'
			    }, {
			        field: 'article_priority',
			        title: '优先级',
			        align: 'left',
			        valign: 'top'
			    }, {
			        field: 'operate',
			        title: '操作',
			        align: 'center',
			        valign: 'middle',
			        events: operateEvents,
			        formatter:article_modify_del
			    }],
			    onClickRow: function (row) {
			        //TODO
			      },
			});
		},
		notice : function(URL){
			$("#Table").bootstrapTable({
			    url: URL, // 接口 URL 地址
			    cache: false, // 不缓存
			    striped: true, // 隔行加亮
			    pagination: true, // 开启分页功能
			    pageSize: 10, // 设置默认分页为 50
			    pageList: [10, 25, 50, 100, 200], // 自定义分页列表
			    minimumCountColumns: 2, // 设置最少显示列个数
			    clickToSelect: false, // 单击行即可以选中
			    sortName: 'article_priority', // 设置默认排序为 name
			    sortOrder: 'desc', // 设置排序为反序 desc
			    smartDisplay: true, // 智能显示 pagination 和 cardview 等
			    columns: [{ // 列设置
			        field: 'state',
			        checkbox: true // 使用复选框
			    },{
			        field: 'article_title',
			        title: '标题',
			        align: 'center',
			        valign: 'middle'
			    }, {
			        field: 'article_time',
			        title: '发布时间',
			        align: 'left',
			        valign: 'top'
			    },{
			        field: 'article_priority',
			        title: '优先级',
			        align: 'left',
			        valign: 'top'
			    },{
			        field: 'operate',
			        title: '操作',
			        align: 'center',
			        valign: 'middle',
			        events: operateEvents,
			        formatter:article_modify_del
			    }],
			    onClickRow: function (row) {
			        //TODO
			      },
			});
		},
		activity : function(URL){
			$("#Table").bootstrapTable({
			    url: URL, // 接口 URL 地址
			    cache: false, // 不缓存
			    striped: true, // 隔行加亮
			    pagination: true, // 开启分页功能
			    pageSize: 10, // 设置默认分页为 50
			    pageList: [10, 25, 50, 100, 200], // 自定义分页列表
			    minimumCountColumns: 2, // 设置最少显示列个数
			    clickToSelect: false, // 单击行即可以选中
			    sortName: 'article_priority', // 设置默认排序为 name
			    sortOrder: 'desc', // 设置排序为反序 desc
			    smartDisplay: true, // 智能显示 pagination 和 cardview 等
			    columns: [{ // 列设置
			        field: 'state',
			        checkbox: true // 使用复选框
			    }, {
			        field: 'article_title',
			        title: '标题',
			        align: 'center',
			        valign: 'middle'
			    }, {
			        field: 'article_time',
			        title: '发布时间',
			        align: 'left',
			        valign: 'top'
			    },{
			        field: 'article_priority',
			        title: '优先级',
			        align: 'left',
			        valign: 'top'
			    },{
			        field: 'operate',
			        title: '操作',
			        align: 'center',
			        valign: 'middle',
			        events: operateEvents,
			        formatter:article_modify_del
			    }],
			    onClickRow: function (row) {
			        //TODO
			      },
			});
		}
}

var switchArea = {
	
	showtable : function(){
		$("#admin-content").hide();
		$("#Table").bootstrapTable('refresh');
		$("#tableArea").show();
	},
	showedit : function(){
		$("#tableArea").hide();
		$("#admin-content").show();
	}

}

$(function(){
	
	$("#userlist").click(function(){
		$("#Table").bootstrapTable('destroy');
		switchArea.showtable();
		init.user('/carBooking/cmsMg/getUserList');
	});
	$("#carlist").click(function(){
		$("#Table").bootstrapTable('destroy');
		switchArea.showtable();
		init.car('/carBooking/cmsMg/getCarList');
	});
	$("#newslist").click(function(){
		$("#Table").bootstrapTable('destroy');
		switchArea.showtable();
		init.news('/carBooking/cmsMg/getList?type=4');
	});
	$("#activitylist").click(function(){
		$("#Table").bootstrapTable('destroy');
		switchArea.showtable();
		init.activity('/carBooking/cmsMg/getList?type=5');
	});
	$("#noticelist").click(function(){
		$("#Table").bootstrapTable('destroy');
		switchArea.showtable();
		init.notice('/carBooking/cmsMg/getList?type=3');
	});
	
	//-----------------------------------------------------
	$("#notice_home").click(function(){
		$("#Table").bootstrapTable('destroy');
		init.notice('/carBooking/cmsMg/getList?type=3');
	});
	$("#car_home").click(function(){
		$("#Table").bootstrapTable('destroy');
		init.car('/carBooking/cmsMg/getCarList');
	});
	$("#news_home").click(function(){
		$("#Table").bootstrapTable('destroy');
		init.news('/carBooking/cmsMg/getList?type=4');
	});
	$("#activity_home").click(function(){
		$("#Table").bootstrapTable('destroy');
		init.activity('/carBooking/cmsMg/getList?type=5');
	});
})