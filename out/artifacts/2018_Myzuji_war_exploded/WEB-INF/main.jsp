<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" /> 
	<title>我的成长足迹</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/book.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/book.js"></script>
	
	<style type="text/css">
/* 鼠标悬停状态 */
	.test:HOVER{
		color: red;
		text-decoration: underline;
	}
</style>
	
</head>
<body>

	<section id="knowledge" class="viewBlock">	
	
			<span style="color: white;font-size: 18px;position:absolute;right: 0px">欢迎【${user.username }】登陆
			<a href="EscServlet" style="color: red;" onclick="return confirm('确认退出吗？')">安全退出</a> 
			</span>
		
		<a href="add.jsp"> <img alt="添加" src="image/加号.png" width="50px" height="50px"></a>
		<%-- <a href="<%=basePath %>MainServlet"> <img alt="编辑" src="image/减号.png" width="50px" height="50px"></a>
	 --%>
		<div class="bookBox">
			<a class="lastBtn">&lt;</a>
			<a class="nextBtn">&gt;</a>
			
			<div class="bookPage frist">
				<img src="${zuji.url }"  width="300px" height="400px"/>
				
			</div>
			<input type="hidden" id="count" value="${fn:length(zujis)}" />
			<c:forEach items="${zujis }" var="zuji" varStatus="s">
			
				<div class="bookPage runPage">
					<div class="bookWord">
						<span>${zuji.title }</span> <br>
						${zuji.date }
						<label class="jianjie">${zuji.jianjie }</label><br>
						<%-- 
						<label class="delete_update"><a class="test" href="DeleteServlet?id=${zuji.id }" onclick="return confirm('确认删除吗？')"> 删除</a>  <a class="test" href="GetOneServlet?id=${zuji.id }">修改</a></label>
						 --%>
						<span class="pageNumber">${s.index+1 }</span>
					</div>
					<img src="${zujis[s.index+1].url }" style="transform: rotateY(180deg)" width="300px" height="400px"/>	
				</div>
			</c:forEach>
		</div>
	</section>
	<div style="text-align:center;">
</div>
</body>
</html>
