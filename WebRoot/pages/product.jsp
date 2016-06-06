<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>VR 商品展示</title>
    <base href="<%=basePath %>" />
    <link rel="icon" href="favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
<style>
.one {
	width: 30%;
	display: inline-block;
	margin-left: 2%;
}

.two {
	width: 30%;
	display: inline-block;
	margin-left: 2%;
}

.thumbnail {
	padding: 5px;
	border-style: groove;
	border-color: rgba(159, 137, 111, 0.4);
	background-color: white;
}

.thumbnail:hover {
	border-color: red;
	border-width: 4px;
}

.caption {
	padding: 9px;
	color: #333;
	border-color: black;
	border-width: 1px;
	border-style: inherit;
	margin-top: 10px;
}

.pic {
	width: 90%;
	margin-left: 5%;
}

h3 {
	margin-left: 5%;
}

.btn1 {
	margin-left: 35%;
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #fff;
	background-color: #337ab7;
	border-color: #2e6da4;
}

.btn1:hover {
	border-style: groove;
	border-width: 2px;
}

.first {
	margin-bottom: 2%;
	padding-top: 3%;
}

p {
	margin-left: 5%;
}

h1 {
	margin-left: 40%;
	color: white;
}

body {
	background-color: black;
	padding-top: 8%;
}
</style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
  
  <body>
    
    <jsp:include page="/navbar.jsp" />
 	<h1>VR商品展示</h1>
    
  
    <div class="first">
		<div class="one">
			<div class="thumbnail">
				<img class="pic" src="images/1.jpg" alt="图片无法加载">
				<div class="caption">
					<h3>remax vr眼镜 苹果3d虚拟现实头盔box</h3>
					<p><b>价格：￥1799</b></p>
					<p>
						<a  href="pages/product-detail2.jsp" role="button" class="btn1">查看详情</a>

					</p>
				</div>
			</div>
		</div>
		<div class="one">
			<div class="thumbnail">
				<img class="pic" src="images/2.jpg" alt="图片无法加载">
				<div class="caption">
					<h3>头戴式3D虚拟现实头盔魔镜机沉浸式vr</h3>
					<p><b>价格：￥199</b></p>
					<p>
						<button type="button" class="btn1">查看详情</button>
					</p>
				</div>
			</div>
		</div>
		<div class="one">
			<div class="thumbnail">
				<img class="pic" src="images/3.jpg" alt="图片无法加载">
				<div class="caption">
					<h3>新款vr虚拟现实眼镜手机3d魔镜4代头</h3>
					<p><b>价格：￥280</b></p>
					<p>
						<button type="button" class="btn1">查看详情</button>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="second">
		<div class="two">
			<div class="thumbnail">
				<img class="pic" src="images/4.jpg" alt="图片无法加载">
				<div class="caption">
					<h3>
						vr虚拟现实3d眼镜头戴式头盔影院千幻</h3>
						<p><b>价格：￥2299</b></p>
						<p>
							<button type="button" class="btn1">查看详情</button>
						</p>
				</div>
			</div>
		</div>

		<div class="two">
			<div class="thumbnail">
				<img class="pic" src="images/5.jpg" alt="图片无法加载">
				<div class="caption">
					<h3>千幻魔镜升级版 虚拟现实3d眼镜游戏V</h3>
					<p><b>价格：￥100</b></p>
					<p>
						<button type="button" class="btn1">查看详情</button>
					</p>
				</div>
			</div>
		</div>
		<div class="two">
			<div class="thumbnail">
				<img class="pic" src="images/6.png" alt="图片无法加载">
				<div class="caption">
					<h3>新版暴风魔镜小D VR虚拟现实眼镜 3d</h3>
					<p><b>价格：￥99</b>价格：￥99</p>
					<p>
						<button type="button" class="btn1">查看详情</button>
					</p>
				</div>
			</div>
		</div>
	</div>
	
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
