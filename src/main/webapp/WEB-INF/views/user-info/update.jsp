<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
I'm update<br>
<input type="hidden" id="num">
<input type="text" id="name"  placeholder="name"><br>
<input type="text" id="id" placeholder="id" ><br>
<input type="text" id="pwd" placeholder="pwd"><br>
<input type="text" id="desc" placeholder="desc"><br>
<input type="text" id="birth" placeholder="birth"><br>
<button onclick="objSend()">OK</button>
<script type="text/javascript">
		function objSend(){
			
			const param = {
				uiNum : document.querySelector('#num').value,
				uiName : document.querySelector('#name').value,
				uiId : document.querySelector('#id').value,
				uiPwd : document.querySelector('#pwd').value,
				uiDesc : document.querySelector('#desc').value,
				uiBirth : document.querySelector('#birth').value
			}
			let json = JSON.stringify(param);
			const xhr = new XMLHttpRequest();
			xhr.open('POST','/user-info/update?uiNum=${param.uiNum}');
			xhr.setRequestHeader('Content-type', 'application/json');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						if(xhr.responseText === '1'){
							alert('Update Clear');
						}else if(xhr.responseText === '0'){
							alert('Update Denied');
						}
						location.href = "/views/user-info/list";
					}
				}
			}
			xhr.send(json);
		}
		function goPage(url){
			location.href= url;
		}
		function loadFunc() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/user-info/update?uiNum=${param.uiNum}');
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {
					if (xhr.status === 200) {
						const obj = JSON.parse(xhr.responseText);
						document.querySelector('#num').value = obj.uiNum;
						document.querySelector('#name').value = obj.uiName;
						document.querySelector('#id').value = obj.uiId;
						document.querySelector('#pwd').value = obj.uiPwd;
						document.querySelector('#birth').value = obj.uiBirth;
						document.querySelector('#desc').value = obj.uiDesc;
						document.querySelector('#credat').value = obj.credat;
						document.querySelector('#lmodat').value = obj.lmodat;
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load', loadFunc);
	</script>
</body>
</html>