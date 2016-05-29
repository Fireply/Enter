<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="icon" href="favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/carousel.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>

    <jsp:include page="navbar.jsp" />
    
    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="images/oculus_rift_blur.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Oculus Rift</h1>
              <p>虚拟现实，让你身临其境，让你体验梦里的世界。</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">购买 Oculus Rift</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="images/microsoft_hololens_me.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Hololens</h1>
              <p>现在起，曾经想象中一切的都在你身边。</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">购买 Hololens</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="images/magic_leap_solar.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Magic leap</h1>
              <p>和我互动的，不再只有隔壁的王尼玛了。</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">购买 Magic leap</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->

    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">CES Asia为VR提供宽阔的展示空间 <span class="text-muted">2016</span></h2>
          <p class="lead">2016年已经被称之为是虚拟现实元年，而虚拟现实这一概念也在各种巨头的普遍看好下异常火爆，索尼HTC三星谷歌群雄角力，各家的VR产品也是纷纷亮相，并且活跃在各大展会中，成为最引人注目的焦点。而本次的CES Asia展会中，索尼的PS VR和HTC Vive为代表的虚拟现实无疑将会是人们关注的焦点。</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="images/CESA.jpg" alt="Generic placeholder image">
          <p><a class="btn btn-success btn-lg btn-detail" href="#" role="button">查看详情</a></p>
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">未来汽车技术：从增强现实玻璃到智能公路 </h2>
          <p class="lead">汽车平视显示器早在1988年的通用汽车上便已实现，可以带给驾驶者更直观的信息显示，防止交通意外发生。而现在，真正的AR（增强现实）挡风玻璃则成为汽车厂商们的下一个目标。目前，增强现实技术已经得到长足发展，汽车挡风玻璃便是一个非常具有前景的应用形式。驾驶者可以通过挡风玻璃直接看到叠加的信息，如仪表盘等内容，甚至还有望集成红外扫描、智能预测等功能，将汽车传感器收集的数据实时反馈在挡风玻璃上。</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="images/car.jpg" alt="Generic placeholder image">
          <p><a class="btn btn-success btn-lg btn-detail" href="#" role="button">查看详情</a></p>
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">MR（混合现实）智能头戴显示设备全球巡展启动 </h2>
          <p class="lead">今天上午，北京微视国人恒宇科技在珠海德瀚国际会议中心酒店的海天一色厅举办的一场《中国首家MR(混合现实)智能头戴显示设备全球巡展启动仪式》，给众多的投资界和广大的消费行业以及各个领域的专家带来了一场别开生面的汇报及发布会，这家专门从事VR(虚拟现实)、AR(增强现实)、MR(混合现实)(以下简称3R) 等专业的人机数字交互领域的科技公司，从航天、教育、军事、体育、工业、旅游、娱乐等六大领域向我们展示了这些高科技技术对于未来的无限可能。</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="images/mr_global.jpg" alt="Generic placeholder image">
          <p><a class="btn btn-success btn-lg btn-detail" href="#" role="button">查看详情</a></p>
        </div>
      </div>

      <hr class="featurette-divider">

      <!-- /END THE FEATURETTES -->

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
          <h2>刘袁梦</h2>
          <p>CEO</p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
          <h2>黄惠娥</h2>
          <p>CFO</p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
          <h2>李思彤</h2>
          <p>PM</p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->

      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">返回顶部</a></p>
        <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->

    <style type="text/css">
    .btn-detail {
      width: 60%;
      margin-top: 20%;
      margin-left: 20%
    }
    </style>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>