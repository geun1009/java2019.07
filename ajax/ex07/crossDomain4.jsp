<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#searchResult {
		border: 1px solid red;
		width: 70%;
		height: 1000px;
	}
</style>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function() {
		
		$('#searchBtn').click(function() {
			
			$('#searchResult').empty();
			
			// 검색날짜 추출
			var date = $('#searchDate').val();
			console.log(date);
			
			// 2019-07-15 => 20190715 변경
			var searchDate = date.split('-').join('');
			/*
			var searchDate = '';
			date.split('-').forEach(function(d) {
				searchDate += d;
			});
			*/
			//console.log(searchDate);
			
			
			$.ajax({
				url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
				data : {
							key: "",
							targetDt: searchDate,
							itemPerPage: 5
				},
				datatype: "jsonp",
				success: callback,
				error: function() {
					alert('실패')
				}
			});
			
		});
		
	});
	
	async function callback(data) {
		
		var list = data.boxOfficeResult.dailyBoxOfficeList;
		
		for(var i = 0; i < list.length; i++) {
			var movie = list[i];
			var rank = movie.rank;
			var name = movie.movieNm;
			var audiCnt = movie.audiCnt;
			
			// 영화상세보기 조회
			var movieCd = movie.movieCd;
			var actorList = '';
			await $.ajax({
				url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
				data: {
					key: "c86186c935e6b0e5b5e98021db82ea3d",
					movieCd: movieCd
				},
				success : function(data) {
					var actors = data.movieInfoResult.movieInfo.actors;
					for(var i = 0; i < actors.length; i++) {
						if(actorList)
							actorList += ", ";
						actorList += actors[i].peopleNm
					}
					console.log(actorList)
				}
			});
			
			$('#searchResult').append("<h4>" + rank + "위</h4>");
			$('#searchResult').append("<strong>" + name 
								+ "</strong>(" + audiCnt + "명)<br>");
			$('#searchResult').append("배우정보 : " + actorList + '<br>');
			$('#searchResult').append("<hr>");
		}
	}
</script>
</head>
<body>
	<h2>일일 박스오피스 조회서비스</h2>
	검색일 : <input type="date" id="searchDate">
	<button id="searchBtn">검색</button>
	<br>
	
	<h4>검색결과</h4>
	<div id="searchResult"></div>
</body>
</html>