<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆</title>
    <link rel="icon" href="favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  
    <jsp:include page="navbar.jsp" />
  
    <div class="container">

      <form class="form-signin enter-center-vertical" action="login" method="post">
        <h2 class="form-signin-heading">登陆</h2>
        <label for="userId" class="sr-only">用户 ID</label>
        <input type="text" id="userId" name="userId" class="form-control" placeholder="用户 ID" required autofocus />
        <label for="userPassword" class="sr-only">密码</label>
        <input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="密码" required />
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" /> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->

    <style type="text/css">
    .enter-center-vertical {
      position: relative;
      transform: translateY(40%);
    }
    </style>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>