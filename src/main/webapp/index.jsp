<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="resources/ueditor/ueditor.config.js" type="text/javascript"></script>
<script src="resources/ueditor/ueditor.all.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="resources/ueditor/lang/zh-cn/zh-cn.js"></script>
<link href="resources/ueditor/themes/default/css/ueditor.css"
	rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div id="myEditor" style="height:400px"></div>
<script type="text/javascript">
        var ue = new baidu.editor.ui.Editor();
        ue.render("myEditor");   //这里填写要改变为编辑器的控件id
</script>
</body>
</html>