<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	
	<!-- Font Awesome SVG with JavaScript -->
	<script src="https://use.fontawesome.com/releases/v5.9.0/js/all.js"></script>
	<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="/resources/javascript/jquery-ui.min.js"></script>
	<!-- Our Own Resources -->
	<script src="/resources/javascript/jquery.oLoader.min.js"></script>
	<!-- 날씨, 환율 정보를 위한 국가 도시 리스트 출력 -->
	<script src="/resources/javascript/getProfile.js"></script>
	<script src="/resources/javascript/index.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/index.css">
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    
	<style type="text/css">
	html {
		  scroll-behavior: smooth;
		}
		#callCountry {width: 100%; margin-top: 15px; color: #f2c029; border: 1px solid #f2c029;}
		#callCountry:hover {color: #fff; background-color: #f2c029;}
		#callCountry:focus {box-shadow: none; border-color: #f2c029; outline: 0;}
	</style>
</head>
<body>
		<nav class="navbar navbar-expand-md fixed-top navbar-light bg-light rounded">
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample10" aria-controls="navbarsExample10" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
		<a class="navbar-brand" href="#">
		    MyTravle
		  </a>
	    <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample10">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link" href="#"><strong>시차 정보</strong></a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#whatMoney"><strong>환율 정보</strong></a>
	        </li>	        
	      </ul>
	    </div>
	  </nav>
	  <br/><br/>
		<div class="timezone">
			<div class="time_data seoul">
				<span class="seoul"><span><img src="/resources/images/flag/KRW.svg"/></span> Seoul</span><br/>
				<div class="times">17:47:52</div>
			</div>
			<div class="time_data paris">
				<span class="paris"><span><img src="/resources/images/flag/FR.png"/></span> Paris</span><br/>
				<div class="times">7시간 시차</div>
			</div>
			<div class="time_data london">
				<span class="london"><span><img src="/resources/images/flag/GB.png"/></span> London</span><br/>
				<div class="times">8시간 시차</div>
			</div>
			<div class="time_data mockba">
				<span class="mockba"><span><img src="/resources/images/flag/russia.png"/></span> Mockba</span><br/>
				<div class="times">6시간 시차</div>
			</div>
			<div class="time_data newyork">
				<span class="newyork"><span><img src="/resources/images/flag/america.png"/></span> NewYork</span><br/>
				<div class="times">13시간 시차</div>
			</div>
			<div class="time_data paulo">
				<span class="paulo"><span><img src="/resources/images/flag/sanpa.png"/></span> São Paulo</span><br/>
				<div class="times">12시간 시차</div>
			</div>
			<div class="time_data sydney">
				<span class="sydney"><span><img src="/resources/images/flag/sydney.png"/></span> Sydney</span><br/>
				<div class="times">1시간 시차</div>
			</div>
		</div>
		<br/><br/><br/>
	<!-- 사이드바 추가(채팅, 관리자채팅) -->
	<div id="whatMoney" class="container">
			
			<!-- 환율 -->
			
				<div class="card" style="height: 335px;">
					<div class="card-body" id="exchange_container"></div>
				</div>
			
		
			<br><br>
	</div>
	
	
	
	
</body>
</html>