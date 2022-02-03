<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/index.css">
<title>로그인 화면</title>
</head>
<body>
    <header>
        Mj_guri 
    </header>

    <section>
	    <form:form commandName="loginVO">
				<p>
					<label>아이디:<br>
						<form:input path="memberId"/>
					</label>		
				</p>
				<p>
					<label>비밀번호:<br>
						<form:password path="memberPassword"/>
					</label>		
				</p>
				<input type="submit" value="로그인"> <input type="button" id="joinBtn" name="joinBtn" value="회원가입" onclick="location.href='memberRegi'"><br>
				<form:errors />
		</form:form>
    </section>

    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>
</body>
</html>