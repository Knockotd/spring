<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다양한 뷰 출력</title>
<style>
h3:hover{
color:blue;
}
span{
	margin:10px;
	border:1px Solid pink;
	border-radius:15px;
	float:left;
	width:200px;
	height:80px;
	text-align:center;
}

span:hover{
	margin:10px;
	border:1px Solid blue;
	border-radius:15px;
	float:left;
	width:200px;
	height:80px;
	text-align:center;
}
</style>
</head>
<body>
	<form>
		<div id="msg"></div>
		아이디:<input type="text" id="id" /><br/>
		비밀번호:<input type="password" id="pw" /><br/>
	</form>
	<a href="excel.xls">엑셀로 출력</a><br/>
	<a href="data.pdf">PDF로 출력</a><br/>
	<a href="jsonview.json">jsonview를 이용한 출력</a><br/>
	<a href="data.csv">CSV 가져오기</a><br/>
	<a href="data.json">JSON 출력</a><br/>
	<a href="#" id="ajaxsend">AJAX로 JSON 가져오기</a><br/>
	<div id="disp"></div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script>
	//아이디에 대한 이벤트 핸들링
	document.getElementById("ajaxsend").addEventListener("click", function(){
		//ajax는 어려워서 이것만 jquery 도움을 받음
		$.ajax({
			url:"data.json",
			data:{}, //아이디 중복 검사에는 이 값을 id 값으로 주어야 함.
			dataType:"json",
			success:function(data){
				output = ""
				for(imsi in data){
					output += "<span><h3>";
					output += data[imsi].name + "</h3>";
					output += "<p>" + data[imsi].description;
					output += "</p></span>";
				}
				document.getElementById("disp").innerHTML = output;
			}
		});
	})
	
	var ids = document.getElementById("id");
	var msg = document.getElementById("msg");
	ids.addEventListener("blur", function(){
		$.ajax({
			url:"idcheck",
			data:{"id":ids.value},
			dataType:"json",
			success:function(data){
					if(data.result == "true"){
						
						msg.innerHTML="사용가능한 아이디입니다.";
						msg.style.color="blue";
					}else{
						msg.innerHTML="사용 불 가능한 아이디입니다.";
						msg.style.color="red";
					}
			}
		});
	});
</script>
</html>