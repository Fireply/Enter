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
    <link href="css/summernote.css" rel="stylesheet">
    
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
            
                <ol class="breadcrumb">
                    <li><a href="admin/">首页</a></li>
                    <li><a href="admin/newsManagement">新闻管理</a>
                    <li class="active">新闻发布</li>
                </ol>
                
                <form action="newsDeployment!deploy" id="newsForm" method="post">
                    <div class="form-group">
                        <label for="newsTitle">新闻标题</label>
                        <input type="text" class="form-control" id="newsTitle" name="newsTitle" placeholder="新闻标题" />
                    </div>
                    <div class="form-group">
                        <label for="summernote">新闻内容</label>
                        <div id="summernote" action="newsDeployment!saveFile"></div>
                    </div>
                    <div class="form-group">
                        <input type="hidden" class="form-control" id="newsContent" name="newsContent"/>
                        <input type="hidden" class="form-control" name="adminId" value="<s:property value='#session.adminId' />"/>
                    </div>
                    <a class="btn btn-default" href="javascript: deploy();" role="button">发布</a>
                </form>
                
            </div>
            
        </div><!-- /.row -->
        
    </div><!-- /.contain-fluid -->
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/summernote.min.js"></script>

    <script>

        $(document).ready(function() {
        	var url = $('#summernote').attr("action") || '';
        	
            $('#summernote').summernote({
                lang: 'zh-CN'
                /* callbacks: {
                    // onImageUpload的参数为files，summernote支持选择多张图片
                    onImageUpload : function(files) {
                        var $files = $(files);

                        // 通过each方法遍历每一个file
                        $files.each(function() {
                            var file = this;
                            var data = new FormData();

                            // 将文件加入到file中，后端可获得到参数名为“file”
                            data.append("file", file);

                            // ajax上传
                            $.ajax({
                                data : data,
                                type : "GET",
                                url : url,// div上的action
                                cache : false,
                                contentType : false,
                                processData : false,

                                // 成功时调用方法，后端返回json数据
                                success : function(response) {
                                	console.log("ajax succss");
                                	console.log(response);
                                     // 封装的eval方法
                                    var json = YUNM.jsonEval(response);

                                    // 控制台输出返回数据
                                    YUNM.debug(json);

                                    // 封装方法，主要是显示错误提示信息
                                    YUNM.ajaxDone(json);

                                    // 状态ok时
                                    if (json[YUNM.keys.statusCode] == YUNM.statusCode.ok) {
                                        // 文件不为空
                                        if (json[YUNM.keys.result]) {

                                            // 获取后台数据保存的图片完整路径
                                            var imageUrl = json[YUNM.keys.result].completeSavePath;

                                            // 插入到summernote
                                            $this.summernote('insertImage', imageUrl, function($image) {
                                                // todo，后续可以对image对象增加新的css式样等等，这里默认
                                            });
                                        }
                                    } 

                                },
                                // ajax请求失败时处理
                                error :  YUNM.ajaxError  console.log("ajax failed")
                            });
                        });
                    }
                } */
            });

            /*// summernote.image.upload
            $('#summernote').on('summernote.image.upload', function(we, files) {
            	var $files = $(files);

                // 通过each方法遍历每一个file
                $files.each(function() {
                    var file = this;
                    var data = new FormData();

                    // 将文件加入到file中，后端可获得到参数名为“file”
                    data.append("file", file);

                    // ajax上传
                    $.ajax({
                        data : data,
                        type : "POST",
                        url : url,// div上的action
                        cache : false,
                        contentType : false,
                        processData : false,

                        // 成功时调用方法，后端返回json数据
                        success : function(response) {
                        	alert("ajax succss");
                             // 封装的eval方法
                            var json = YUNM.jsonEval(response);

                            // 控制台输出返回数据
                            YUNM.debug(json);

                            // 封装方法，主要是显示错误提示信息
                            YUNM.ajaxDone(json);

                            // 状态ok时
                            if (json[YUNM.keys.statusCode] == YUNM.statusCode.ok) {
                                // 文件不为空
                                if (json[YUNM.keys.result]) {

                                    // 获取后台数据保存的图片完整路径
                                    var imageUrl = json[YUNM.keys.result].completeSavePath;

                                    // 插入到summernote
                                    $this.summernote('insertImage', imageUrl, function($image) {
                                        // todo，后续可以对image对象增加新的css式样等等，这里默认
                                    });
                                }
                            } 

                        },
                        // ajax请求失败时处理
                        error :  YUNM.ajaxError  alert("ajax failed")
                    });
                });
            }); */
            
        });
        
        function deploy() {
            var markupStr = $('#summernote').summernote('code');
            $('#newsContent').val(markupStr);
            $('#newsForm').submit();
        }

    </script>
</body>
</html>
