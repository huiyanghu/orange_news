<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>${vo.article.title }</title>
  <link rel="stylesheet" href="https://translate.googleapis.com/translate_static/css/translateelement.css">
    <link rel="stylesheet" href="http://static.coolook.org/assets/static/css/detail_ad.css?v=8">
      <link rel="stylesheet" href="http://static.coolook.org/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://static.coolook.org/static/css/font-awesome.min.css">
          <link rel="stylesheet" href="http://static.coolook.org/static/css/partner_ck.css">
</head>

<body>
  <div class="wrap">
    <article>
      <header class="article-title clearfix">
        <h2>${vo.article.title }</h2>
        <div class="media pull-left" style="width:80%;">
          <!-- media icon end -->
          <div class="media-body">
            <p class="text-light-grey"> <i class="glyphicon glyphicon-time"></i> Update at
              <time>${vo.article.createtime}</time>
            </p>
          </div>
        </div>
      </header>
      <section class="article-body">
       ${vo.content.content }
      </section>
    </article>
    <!-- statement -->
    
  </div>
  <script src="http://static.coolook.org/static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="http://static.coolook.org/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="http://static.coolook.org/static/js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
  <script src="http://static.coolook.org/static/js/partner_ck.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>