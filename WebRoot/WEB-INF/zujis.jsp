<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>编辑足迹</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/style1.css" />
<link rel="stylesheet" type="text/css" href="css/book.css">

<style type="text/css">
/* 鼠标悬停状态 */
	.test:HOVER{
		color: red;
		text-decoration: underline;
	}
</style>

</head>
<body>
	<section id="knowledge" class="viewBlock"> <span
		style="color: white;font-size: 18px;position:absolute;right: 0px">欢迎【${user.username
		}】登陆 <a href="EscServlet" style="color: red;"
		onclick="return confirm('确认退出吗？')">安全退出</a> </span> <a href="MainServlet">
		<img style="width: 50px;height: 50px" alt="" src="image/返回.png">
	</a>
	<div class="">


		<table border="1px solder black" width="1000px" cellspacing="0" style="margin: auto;">
			<tr align="center">
				<td>编号</td>
				<td>标题</td>
				<td width="300px">简介</td>
				<td>时间</td>
				<td>图片</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${zujis }" var="zuji" varStatus="s">
				<tr align="center">
					<td>${s.index+1 }</td>
					<td>${zuji.title }</td>
					<td>${zuji.jianjie }</td>
					<td>${zuji.date }</td>
					<td><img alt="" src="${zuji.url }"
						style="width: 50px;height: 50px"></td>
					<td><a class="test" href="DeleteServlet?id=${zuji.id }"> 删除</a> 修改</td>
				</tr>
			</c:forEach>
		</table>


	</div>
	</section>
	<div style="text-align:center;"></div>
</body>
</html>

