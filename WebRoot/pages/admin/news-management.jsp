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
    
    <jsp:include page="/pages/admin/admin-navbar.jsp" />
    
    <div class="contain-fluid">
        <div class="row">
        
            <jsp:include page="/pages/admin/admin-sidebar.jsp" />
            
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                 <div class="page-header">
                    <a class="btn btn-primary" href="pages/admin/news-deployment.jsp" role="button">发布新新闻</a>
                </div>
                
                <s:iterator value="newsList" var="news">
      
                  <div class="panel panel-default">
                    <div class="panel-heading">
                      <h3><a href="news!detail?newsId=${news.id }">${news.title }</a></h3>
                    </div>
                    <%-- <div class="panel-body enter-scrollable">
                      <div><s:property value="#news.content" /></div>
                    </div> --%>
                  </div>
                
                </s:iterator>
            </div>
        </div>
        
    </div>
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
