<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>添加足迹</title>

<link rel="stylesheet" href="<%=path %>/css/style.css" />
<link rel="stylesheet" href="<%=path %>/css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/book.css">
<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>

<script src="js/Ecalendar.jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#ECalendar_case2").ECalendar({
			type : "date", //模式，time: 带时间选择; date: 不带时间选择;
			stamp : false, //是否转成时间戳，默认true;
			offset : [ 0, 2 ], //弹框手动偏移量;
			format : "yyyy-mm-dd", //时间格式 默认 yyyy-mm-dd hh:ii;
			skin : 3, //皮肤颜色，默认随机，可选值：0-8,或者直接标注颜色值;
			step : 10, //选择时间分钟的精确度;
			callback : function(v, e) {
			} //回调函数
		});
	});
</script>


<style media="screen">
.ECalendar {
	width: 400px;
	height: 30px;
}
pre {
	background: #eee;
	border: 1px solid #ddd;
	border-left: 4px solid #f60;
	padding: 15px;
	margin-top: 15px;
}
</style>


<script type="text/javascript">
	//实现预览功能			
	function preview() {
		//获取文件框的第一个文件,因为文件有可能上传多个文件,咱这里是一个文件				
		var file = document.getElementById("fileload").files[0];
		var file1 = document.getElementById("image");
		file1.style.width = "100px";
		file1.style.height = "100px";
		//可以进行一下文件类型的判断				
		var fileType = file.type.split("/")[0];
		if (fileType != "image") {
			alert("请上传图片");
			return;
		}
		//获取img对象		
		var img = document.getElementById("image");
		//建一条文件流来读取图片			
		var reader = new FileReader();
		//根据url将文件添加的流中			
		reader.readAsDataURL(file);
		//实现onload接口			
		reader.onload = function(e) {
			//获取文件在流中url			
			url = reader.result;
			//将url赋值给img的src属性		
			img.src = url;
		};
	}
	
	
	
	
	function fun(){
		var username = document.getElementById("username").value;
		var jianjie = document.getElementById("jianjie").value;
		var ECalendar_case2 = document.getElementById("ECalendar_case2").value;
		var fileload = document.getElementById("fileload").value;
		//alert(username+"~"+jianjie+"~"+ECalendar_case2+"~"+fileload)
		if(username!=""&&jianjie!=""&&ECalendar_case2!=""&&fileload!=""){
			return true;
		}else{
			alert("请填写完整信息！！");
			return false;
		}
	}
	
	
	
	
	
	
</script>



</head>
<body>

<!--将jsp页面数据发送给后台 
方法一： form表单提交
方法二： ajax提交

form表单提交时，如果其中有图片，那么提交方式必须使用post
  enctype="multipart/form-data"
 -->
	<section id="knowledge" class="viewBlock">
		<span style="color: white;font-size: 18px;position:absolute;right: 0px">欢迎【${user.username }】登陆
			<a href="EscServlet" style="color: red;" onclick="return confirm('确认退出吗？')">安全退出</a> 
			</span>
		<a href="MainServlet"> <img style="width: 50px;height: 50px" alt="" src="image/返回.png"></a>
		<div class="reg_div">
			
			<form action="AddServlet" method="post" enctype="multipart/form-data">
			<ul class="reg_ul" style="list-style: none">
				<li><span class="span">标题</span> <input type="text" name="title" value=""
					placeholder="请输入成长概要" class="reg_user" id="username">
				</li>
				<li><span class="span">简介</span> <textarea placeholder="请输入成长简介"
						class="reg_user" rows="10" cols="30" name="jianjie" id="jianjie"></textarea></li>

				<li><span class="span">时间</span>
					<div class="" style="width:395px">
						<div  class="calendarWarp" style="">
							<input type="text" name="date" class='ECalendar'
								id="ECalendar_case2" value="" />
						</div>
					</div>
				</li>
				
				<li><span class="span">图片</span> 
					<input id="fileload" type="file" name="file" onchange="preview()">
					<img id="image"  src="" />
				</li>
				<li>
					<button style="align:center;" type="submit" name="button" class="red_button" onclick="return fun()">添加</button>
				</li>
			</ul>
			</form>
		</div>
	</section>
	<div style="text-align:center;"></div>
</body>
</html>

