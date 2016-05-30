<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
    <title>Insert title here</title>
    <base href="<%=basePath %>" />
    <link rel="icon" href="favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
  
    <jsp:include page="/navbar.jsp" />
  
    <div class="container">
    
        <div class="page-header">
          <h1>新闻动态</h1>
        </div>
    
      <s:iterator value="newsList" var="news">
      
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3><a href="news!detail?newsId=${news.id }">${news.title }</a></h3>
          </div>
          <div class="panel-body enter-scrollable">
            <div><s:property value="#news.content" /></div>
          </div>
        </div>
      
      </s:iterator>
    
    </div><!-- /.container -->
    
    <style>
        .enter-scrollable {
            max-height: 200px;
            overflow-y: scroll;
        }
    </style>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>