<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply test</title>
<script src="jquery/jquery-3.6.0.js"></script>
</head>
<body id="rbody">
<h2>게시물 제목</h2>
작성자 홍길동 | 댓글 달릴예정 | 조회수 1234 | 날짜 TODAY
<hr>
게시물 내용<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<hr>
<input type="button" id="toggleBtn" value="댓글창열기"><br>
<div id="toggle" style="display:none;">
	<form>
		작성자 : <input type="text" name="user" id="user"> 
		암호 : <input type="password" name="userPwd" id="userPwd">
		<input type="button" value="댓글등록" onclick="regiReple()"> <br>
		<textarea rows="5" cols="100" name="comment" id="comment"></textarea>
	</form>
</div>

<div id="replebox"></div>

<script>
    window.onload = function(){
        $.ajax({
            type:"GET",
            async:true,
            url:"RRS",
            dataType:"JSON",
	        success:function(wordList){
                makeReple(wordList);
            },
	        error:function(){
	            alert("에러가 발생했습니다.");
	        }
        });
        
        $(function (){
        	$('#toggleBtn').click(function(){
        		$('#toggle').toggle();
        	})
        })
        
    }

    function showUpdatePwd(code){
        console.log(code);

        $('#replely'+code).attr('readonly',false);

        $('#checkUpdatePwd'+code).toggle();
        $('#udtconfirm'+code).toggle();
    }

    function showDelPwd(code){
        console.log(code);
        $('#checkDelPwd'+code).toggle();
        $('#delconfirm'+code).toggle();
    }
    
    // 확인버튼(수정버튼 눌러서 나온) 눌렀을때
    function updateReple(code){
        let c_code = code;
        let updPwd = $('#checkUpdatePwd'+code).val();
        let comment = $('#replely'+code).val();

        let wordData = {
            "c_code":c_code,
            "updPwd":updPwd,
            "comment":comment
        }

        $.ajax({
            type:"POST",
            async:true,
            url:"URS",
            data:{
                "wordData":JSON.stringify(wordData)
            },
            dataType:"JSON",
	        success:function(wordList){
                if(wordList==0){
                    alert("비밀번호가틀렸습니다");
                }else{
                    makeReple(wordList);
                }
	        },
	        error:function(){
	            alert("에러가 발생했습니다.");
	        }
        });
    }

    function deleteReple(code){
        let c_code = code;
        let delPwd = $('#checkDelPwd'+code).val();
        
        console.log(c_code);
        console.log(delPwd);
        
        let wordData = {
            "c_code":c_code,
            "delPwd":delPwd
        }

        $.ajax({
            type:"POST",
            async:true,
            url:"DRS",
            data:{
                "wordData":JSON.stringify(wordData)
            },
            dataType:"JSON",
	        success:function(wordList){
                if(wordList==0){
                    alert("비밀번호가틀렸습니다");
                }else{
                    makeReple(wordList);
                }
	        },
	        error:function(){
	            alert("에러가 발생했습니다.");
	        }
        });
    }
    


	function regiReple(){
		let user = $('#user').val();
		let userPwd = $('#userPwd').val();
		let comment = $('#comment').val();
		
        let wordData = {
                "user":user,
                "userPwd":userPwd,
                "comment":comment
        }
        
        $.ajax({
            type:"POST",
            async:true,
            url:"RRS",
            data:{
                "wordData":JSON.stringify(wordData)
            },
	        dataType:"JSON",
	        success:function(wordList){
                makeReple(wordList);
            },
	        error:function(){
	            alert("에러가 발생했습니다.");
	        }
        });
        
        
	}

    function makeReple(wordList){
        
        //let body = document.getElementById('rbody');
        let rediv = document.getElementById('replebox');
        console.log(rediv);
        rediv.innerHTML = "";
        
        for(let i=0; i<wordList.length; i++){
            let div = document.createElement('div');

            let updatepwdtext = document.createElement('input');
            updatepwdtext.setAttribute('type','password');
            updatepwdtext.setAttribute('id','checkUpdatePwd'+wordList[i].c_code);
            updatepwdtext.setAttribute('name','checkUpdatePwd');
            updatepwdtext.setAttribute('style','display:none');

            let updateConfirmBtn = document.createElement('input');
            updateConfirmBtn.setAttribute('type','button');
            updateConfirmBtn.setAttribute('id', 'udtconfirm'+wordList[i].c_code);
            updateConfirmBtn.setAttribute('name',wordList[i].c_code);
            updateConfirmBtn.setAttribute('value','확인');
            updateConfirmBtn.setAttribute('style','display:none');
            updateConfirmBtn.setAttribute('onclick','updateReple(this.name)');

            let deletepwdtext = document.createElement('input');
            deletepwdtext.setAttribute('type','password');
            deletepwdtext.setAttribute('id','checkDelPwd'+wordList[i].c_code);
            deletepwdtext.setAttribute('name','checkDelPwd');
            deletepwdtext.setAttribute('style','display:none');

            let deleteConfirmBtn = document.createElement('input');
            deleteConfirmBtn.setAttribute('type','button');
            deleteConfirmBtn.setAttribute('id', 'delconfirm'+wordList[i].c_code);
            deleteConfirmBtn.setAttribute('name',wordList[i].c_code);
            deleteConfirmBtn.setAttribute('value','확인');
            deleteConfirmBtn.setAttribute('style','display:none');
            deleteConfirmBtn.setAttribute('onclick','deleteReple(this.name)');

            let updateBtn = document.createElement('input');
            updateBtn.setAttribute('type','button');
            updateBtn.setAttribute('id','update'+wordList[i].c_code);
            updateBtn.setAttribute('name',wordList[i].c_code);
            updateBtn.setAttribute('value','수정');
            updateBtn.setAttribute('onclick','showUpdatePwd(this.name)');
            
            let delBtn = document.createElement('input');
            delBtn.setAttribute('type','button');
            delBtn.setAttribute('id','del'+wordList[i].c_code);
            delBtn.setAttribute('name',wordList[i].c_code);
            delBtn.setAttribute('value','삭제');
            delBtn.setAttribute('onclick','showDelPwd(this.name)');
            
            let textarea = document.createElement('textarea');
            textarea.setAttribute('id','replely'+wordList[i].c_code);
            textarea.setAttribute('rows','3');
            textarea.setAttribute('cols','100');
            textarea.setAttribute('readonly','readonly');
            textarea.innerHTML = wordList[i].c_comment;

            div.innerHTML = wordList[i].c_user;
            div.appendChild(updatepwdtext);
            div.appendChild(updateConfirmBtn);
            div.appendChild(deletepwdtext);
            div.appendChild(deleteConfirmBtn);
            div.appendChild(updateBtn);
            div.appendChild(delBtn);
            div.innerHTML += wordList[i].c_regdate;
            div.innerHTML += "<br>";
            div.appendChild(textarea);
            
            rediv.appendChild(div);

            console.log(rediv);
            
        }
    }

</script>

</body>
</html>