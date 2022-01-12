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
    <header class='headerFooter'> 강사목록 </header>
    <section>
        <div class='total'> 총 ${totalCnt } 개의 과목이 있습니다.</div>
        <div class='lecturerBtn'> <input type="button" value="교과목보기" onclick="location.href='CMS?command=curriculum_List'"> </div>
        
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>강사명</th>
                    <th>전공</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="cL" items="${lecList}">
					<tr>
						<td class="tdcenter">${cL.idx}</td>
						<td class="tdcenter"><a href="CMS?command=readCurri_List&id=${cL.idx}">${cL.name}</a></td>
						<td class="tdcenter">${cL.major}</td>
					</tr>
				</c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td>
                    	<input type="button" value="강사등록" onclick="go_curriculumInsert()">
                    </td>
                </tr>
            </tfoot>
        </table>

    </section>
    <footer class='headerFooter'>Copyright (c) 2022 MJguri All right Reserved</footer>

    <script>
        function go_curriculumInsert(){
            location.href="CMS?command=insertCurriculumForm";
        }
    
    </script>
</body>
</html>