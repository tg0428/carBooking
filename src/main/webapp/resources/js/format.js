/**
 * bootstrap—table formater
 */

function view_detail(value, row, index){
	return [
	        '<button id="view" type="button" class="am-btn am-btn-primary am-round am-btn-xs">查看详情</button>'
	        ].join('');
}

function modify_del(value, row, index){
	return [
	        '<button id="modify_car" type="button" class="am-btn am-btn-warning am-round am-btn-xs">修改</button>',
	        '<button id="del_car" type="button" class="am-btn am-btn-danger am-round am-btn-xs">删除</button>'
	        ].join('');
}

function article_modify_del(value, row, index){
	return [
	        '<button id="modify_article" type="button" class="am-btn am-btn-warning am-round am-btn-xs">修改</button>',
	        '<button id="del_article" type="button" class="am-btn am-btn-danger am-round am-btn-xs">删除</button>'
	        ].join('');
}