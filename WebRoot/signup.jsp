<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="cn">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <base href="<%=basePath %>" />
    <link rel="icon" href="favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <style type="text/css">
    	.input1 {
    		padding:6px;
    	}
      
    	.input2 {
    		padding-top: 10px;
    		padding-left:80px ;
    	}
      
    	.input3 {
    		pading-top:20px;
    	}
      
    	input {
    		height:30px;
    	}
    	
    	.div1 {
    		background-color: rgba(122, 176, 222, 0.44);
    		width:380px;
    	 	margin-left: 60%;
    	 	padding:30px;
    		border-style:outset
    	}
    		
    	.div2 {
    		height:500px; 
    	}
      
    	#biaoti {
    		height:80px;
    		color:white;
    		padding-left:65%;
    	}
      
    	body {
    		background-image:url(images/register-background.jpg);
    		background-position:center; 
    	}
    </style>
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    
</head>

  <body>
   <jsp:include page="navbar.jsp" />
  <h1 id="biaoti">注册</h1>
  <div class="div2">
	<div class="div1">
		<form action="register" method="post">
			<div class="input1">
				<b>　用户名：</b><input type="text" id="userId" name="userId" onblur="showHint();">*
                <label id="txtHint"></label>
			</div>
			<div class="input1">
				<b>　密　码：</b><input type="password" name="userPassword" />*
			</div>
			<div class="input1">
				<b>确认密码：</b><input type="password" />*
			</div>
			<div class="input1">
				<b>　性　别：男</b> <input type="radio" name="sex" value="male" /> 
					    <b> 女</b><input type="radio" name="sex" value="female" />
			</div>
			<div class="input1">
				<b>　籍　贯：</b><input type="text"><br />
			</div>
			<div class="input1">
				<b>　电　话：</b><input type="text"><br />
			</div>
			<div class="input1">
				<b>　邮　箱：</b><input type="text"><br />
			</div>
			<div class="input2">
			<input type="submit" value="立即注册" />
			</div>
		</form>
	</div>
	</div>
  
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
        function showHint() {
            var userName = document.getElementById("userId");
            
            if (userName.value.length == 0) {
                document.getElementById("txtHint").innerHTML = "";
                return;
            }
    
            var xmlhttp = getXhr();
    
            xmlhttp.onreadystatechange = function() {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET", "register?userId=" + userId.value, true);
            xmlhttp.send();
        }
        
        //创建XMLHttpRequest对象    
        function getXhr() {    
                var xhr;    
                try {    
                        //IE浏览器    
                        xhr = new ActiveXObject("Microsoft.XMLHTTP");    
                } catch (err) {    
                        try {    
                                // firefox opera 等其他浏览器    
                                xhr = new XMLHttpRequest();    
                        } catch (er) {    
                                alert("您的浏览器不支持ajax技术的操作,请您升级.....");    
                        }    
            
                }    
            
                return xhr;    
        }
    </script>
  </body>
</html>