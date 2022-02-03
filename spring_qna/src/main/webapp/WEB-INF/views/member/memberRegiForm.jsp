<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/index.css">
<title>회원가입</title>
</head>
<body>
	<header>
        Mj_guri 
    </header>

    <section>
		<form:form commandName="memberRegiVO">
				<p>
					<label>아이디:
						<form:input path="memberId"/>
					</label>		
				</p>
				<p>
					<label>비밀번호:
						<form:password path="memberPassword"/>
					</label>		
				</p>
				<p>
					<label>비밀번호확인:
						<form:password path="memberConfirmPassword"/>
					</label>		
				</p>
				<p>
					<label>이름:
						<form:input path="memberName"/>
					</label>		
				</p>
				<p>
					<label>이메일:
						<form:input path="memberEmail"/>
					</label>		
				</p>
				<p>
					<label>전화번호:
						<form:input path="memberPhone"/>
					</label>		
				</p>
				<input type="submit" value="회원가입"><br>
				<form:errors />
		</form:form>
	    
    </section>

    <footer>
       Copyright (c) 2022 Mj_guri All right Reserved
    </footer>
</body>
</html>