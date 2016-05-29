<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="cn">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>主页</title>
        <link rel="icon" href="favicon.ico">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.min.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        用户主页<br>
        userId: <s:property value="#session.userId" /><br>
        adminId: <s:property value="#session.adminId" /><br>
        sequence: <s:property value="#session.sequence" /><br>
        token: <s:property value="#session.token" /><br>
        #context['struts.actionMapping'].name: <s:property value="#context['struts.actionMapping'].name"/>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>
        
        <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>