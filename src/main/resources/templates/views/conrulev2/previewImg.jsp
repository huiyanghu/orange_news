<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${vo.article.title }</title>
    <style>
        *{
            margin:0;  padding:0;
            text-decoration: none;
        }
        img{
            width:769px;
            height: 499px;
        }
        .container{
            width:800px;
            height:540px;
            position:relative;
        }
        .banner-info{
            width:769px;
            height:30px;
            text-align: left;
            line-height: 30px;
            position: absolute;
            bottom:0;
            z-index: 2;
        }
        .banner-list a{
            position:absolute;
        }
        .container ul{
            position:absolute;
            bottom:40px;
            left:330px;
            z-index: 2;
        }
        .container ul li{
            list-style: none;
            float:left;
            width:20px;
            height:20px;
            text-align: center;
            margin:0 2px;
            border-radius: 50%;
            cursor:pointer;
        }
        .container ul li.on{
            background-color: red;
        }
        .leftright{
            display: none;
        }
        .leftright a{
            padding:5px 5px;
            font-size: 30px;
            font-weight: bold;
            color:#fff;
            background-color: rgba(0,0,0,0.5);
            position: absolute;
            top:230px;
            z-index: 2;
        }
        .left{
            left:5px;
        }
        .right{
            right:5px;
        }
    </style>
</head>
<body>
    <div class="container" id="container">
        <div class="banner-bg"></div>
        <div class="banner-info" id="banner_info"></div>
        <ul id="list">
            <li ></li>
        </ul>
        <div class="banner-list" id="banner_list">
            <a href="javascript:void(0);"><img src="${vo.content.content }" alt="${vo.article.title }    ${vo.article.abstracts }"/></a>
        </div>
    </div>

<script>
    var n = 0;
    var timer = null;
    window.onload = function(){
        //初始化第一张图片及内容
        var bannerInfo = getId("banner_info");      //内容区
        var count = getId("banner_list").getElementsByTagName("a"); //img父级
        bannerInfo.innerHTML = count[0].firstElementChild.alt;
        imgview(0);
        function imgview(num){
            for(var i=0;i<count.length; i++){
                if(!num){
                    count[i].style.opacity = 0;
                }
                count[num].style.opacity = 1;
            }
        }
    function getId(id){
        return document.getElementById(id);
    }
  }
</script>
</body>
</html>
