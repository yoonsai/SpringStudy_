<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <div id="slider" class="clear"> 
    <div class="flexslider basicslider">
      <ul class="slides">
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back1.jpg" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back2.jpg" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back3.jpg" style="width:978px;height:400px"></a></li>
      </ul>
    </div>
    </div>
</div>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <ul class="nospace group btmspace-80">
      <li class="one_third first">
        <article class="service"><i class="icon fa fa-ambulance"></i>
          <h6 class="heading"><a href="#">인기 추천 맛집</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
      <li class="one_third">
        <article class="service"><i class="icon fa fa-h-square"></i>
          <h6 class="heading"><a href="#">인기 추천 레시피</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
      <li class="one_third">
        <article class="service"><i class="icon fa fa-hospital-o"></i>
          <h6 class="heading"><a href="#">인기 추천 쉐프</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
    </ul>
    <h2 class="sectiontitle">인기 레시피</h2>
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <c:forEach var="vo" items="${recipeList }">
        <li>
          <figure><img class="radius-10 btmspace-10" src="${vo.poster }" style="width: 320px;height: 185px">
            <figcaption><a href="#">${vo.title }</a></figcaption>
          </figure>
        </li>
       </c:forEach>
      </ul>
    </div>
    <h2 class="sectiontitle">인기 쉐프</h2>
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <c:forEach var="vo" items="${chefList }">
        <li>
          <figure><img class="radius-10 btmspace-10" src="${vo.poster }" style="width: 320px;height: 185px">
            <figcaption><a href="#">${vo.chef }</a></figcaption>
          </figure>
        </li>
       </c:forEach>
      </ul>
    </div>
    <h2 class="sectiontitle">인기 맛집</h2>
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
       <c:forEach var="vo" items="${foodList }">
        <li>
          <figure><img class="radius-10 btmspace-10" src="http://www.menupan.com${vo.poster }" style="width: 320px;height: 185px">
            <figcaption><a href="#">${vo.name }</a></figcaption>
          </figure>
        </li>
       </c:forEach>
      </ul>
    </div>
    <h2 class="sectiontitle">최신 방문 레시피</h2>
    <ul class="nospace group">
      <li class="one_half first">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
      <li class="one_half">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
    </ul>
    <div class="clear"></div>
  </main>
</div>
</body>
</html>