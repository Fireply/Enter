<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
            <span class="sr-only">折叠导航栏</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand navbar-brand-padding" href="index.jsp"><img alt="Brand" src="favicon.ico"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">首页 <span class="sr-only">(current)</span></a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">产品 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">VR</li>
                <li><a href="pages/product.jsp">Oculus Rift</a></li>
                <li class="dropdown-header">AR</li>
                <li><a href="#">Microsoft HoloLens</a></li>
                <li class="dropdown-header">MR</li>
                <li><a href="#">Magic leap</a></li>
              </ul>
            </li>
            <li><a href="news">动态</a></li>
            <li><a href="#">加入我们</a></li>
            <li><a href="intro.jsp">关于我们</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="login">登录</a></li>
            <li><a href="signup.jsp">注册</a></li>
          </ul>
          <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
          </form>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>

    <style>
    .navbar-brand-padding {
        padding-top: 10px;
    }
    
    body {
        padding-top: 70px;
    }
    </style>
