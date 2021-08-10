<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/assets/css/mysite.css"
	rel="stylesheet" type="text/css"
>
<link href="${pageContext.request.contextPath }/assets/css/user.css"
	rel="stylesheet" type="text/css"
>

</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		<div id="container" class="clearfix">

			<c:import url="/WEB-INF/views/includes/asideBoard.jsp"></c:import>

			<div id="content">

				<div id="user">
					<div id="joinForm">
						<form action="${pageContext.request.contextPath }/user/join"
							method="get"
						>

							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label>
								<input type="text" id="input-uid" name="id" value=""
									placeholder="아이디를 입력하세요"
								>
								<button type="button" id="btnIdCheck">중복체크</button>
								<p id="idcheckMsg"></p>
							</div>

							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label>
								<input type="text" id="input-pass" name="password" value=""
									placeholder="비밀번호를 입력하세요"
								>
							</div>

							<!-- 이름 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label>
								<input type="text" id="input-name" name="name" value=""
									placeholder="이름을 입력하세요"
								>
							</div>

							<!-- //성별 -->
							<div class="form-group">
								<span class="form-text">성별</span> <label for="rdo-male">남</label>
								<input type="radio" id="rdo-male" name="gender" value="male">
								<label for="rdo-female">여</label>
								<input type="radio" id="rdo-female" name="gender" value="female">

							</div>

							<!-- 약관동의 -->
							<div class="form-group">
								<span class="form-text">약관동의</span>

								<input type="checkbox" id="chk-agree" value="" name="">
								<label for="chk-agree">서비스 약관에 동의합니다.</label>
							</div>

							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">회원가입</button>
							</div>

						</form>
					</div>
					<!-- //joinForm -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

<script type="text/javascript">
	//데이터를 json형식으로 보내기
	//form사용 x --> form 처럼 사용하기
	//parameter x --> json으로 데이터를 보낸다
	
	$("#btn-submit").on("click", function(){
		event.preventDefault();
		console.log("json방식으로 데이터를 보낸다.")
		
		//데이터 모으기
		var userVo = {
			id : $("#input-uid").val();
			password : $("#input-pass").val();
			name : $("#input-name").val();
			gender : $("[name=gender]").val();
		}:
			console.log(userVo);
		
		$.ajax({
    		//url : "${pageContext.request.contextPath }/api/guestbook/write?name="+userName+"&password="+password+"&content="+content,      
   			url : "${pageContext.request.contextPath }/user/join2",
	 		type : "get",
    		contentType : "application/json",
     
			data: JSON.stringify(userVo),


    		dataType : "json",
    		success : function(guestbookVo){
       		/*성공시 처리해야될 코드 작성*/
     
    		},
    		error : function(XHR, status, error) {
       		console.error(status + " : " + error);
			}
 
	 });
	});
	
	/*
	//form 전송버튼을 클릭했을때
	$("#joinForm").on("submit", function(){
		
		console.log("form 전송버튼 클릭했을때");
		
		//패스워드8글자 이상 체크
		var password = $("#input-pass").val();
		if(password.length < 8){
			alert("패스워드를 8슬자 이상 입력해주세요");
			return false;
		}
		
		//이름체크 
		var name = $("#input-name").val();
		if(name.lenth<1){
			alert("이름을 입력해 주세요")
			return false;
		}
		
		//약관동의
		var agree = $("#chk-agree").is();
		if(agree = false){
			alert("약관에 동의해 주세요");
			return false;
		}
		
		return true;
	});
	
*/
	$("#btnIdCheck").on("click", function(){
		console.log("아이디버튼 중복체크");
		
		var id = $("#input-uid").val();
		console.log(id);
		
		 //데이터 ajax방식으로 서버에 전송   
		   $.ajax({
		            
		      url : "${pageContext.request.contextPath }/user/idCheck",
		  		 type : "get",
//		       contentType : "application/json",
		       data : {id: id},
				
				
				
		      dataType : "json",
		      success : function(state){
		         /*성공시 처리해야될 코드 작성*/
		         console.log(state);
		         if(state == 'true'){
		      		 $("#idcheckMsg").html("사용가")
		         }else if(state == 'false'){
		        	 $("#idcheckMsg").html("사용중인 id") 
		         }else{
		        	 $("#idcheckMsg").html("관리자문의")
		         }
		         
		         
		         },
		      error : function(XHR, status, error) {
		         console.error(status + " : " + error);
		      }
		   });
	   });
	
	

</script>


</html>