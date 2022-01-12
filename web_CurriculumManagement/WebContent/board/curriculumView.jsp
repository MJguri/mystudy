<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href ="./CSS/main.css">
<title>Insert title here</title>
</head>
<body>
    <header class='headerFooter'>교과목 관리 사이트</header>
    
    <section>
        <div class='title'>교과목 상세보기</div>
        <table>
            <tr>
                <th>교과목 코드</th>
                <td><input type="text" id="id" name="id" value="${cVo.id}" readonly> </td>
            </tr>
            <tr>
                <th>과목 명</th>
                <td><input type="text" id="name" name="name" value=" ${cVo.name}"  readonly></td>
            </tr>
            <tr>
                <th>담당 강사</th>
                <td><input type="text" id="lecturer" name="lecturer" value="${cVo.lecturer}"  readonly> </td>
            </tr>
            <tr>
                <th>학점</th>
                <td><input type="text" id="credit" name="credit" value="${cVo.credit}"  readonly> </td>
            </tr>
            <tr>
                <th>요일</th>
                <td><input type="text" id="week" name="week" value="${cVo.week}"  readonly> </td>
            </tr>
            <tr>
                <th>시작</th>
                <td><input type="text" id="start_hour" name="start_hour" value="${cVo.starthour}"  readonly> </td>
            </tr>
            <tr>
                <th>종료</th>
                <td><input type="text" id="end_hour" name="end_hour" value="${cVo.endhour}"  readonly> </td>
            </tr>
        </table>
        <div class="btnBox">
            <input type="button" value="수정하기" onclick="location.href='CMS?command=updateCurriculumForm&id=${cVo.id}'">
            <input type="button" value="삭제하기" onclick="location.href='CMS?command=deleteCurriculum&id=${cVo.id}'">
            <input type="button" value="목록으로" onclick="location.href='CMS?command=curriculum_List'">
        </div>
    </section>

    <footer class='headerFooter'>Copyright (c) 2022 MJguri All right Reserved</footer>

</body>
</html>