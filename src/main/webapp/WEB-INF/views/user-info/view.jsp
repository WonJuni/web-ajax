<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	I'm View ${param.uiNum}
	<table border="1">
		<tr>
			<th>Num</th>
			<td id="num"></td>
		</tr>
		<tr>
			<th>Name</th>
			<td id="name"></td>
		</tr>
		<tr>
			<th>ID</th>
			<td id="id"></td>
		</tr>
		<tr>
			<th>PWD</th>
			<td id="pwd"></td>
		</tr>
		<tr>
			<th>Birth</th>
			<td id="birth"></td>
		</tr>
		<tr>
			<th>DESC</th>
			<td id="desc"></td>
		</tr>
		<tr>
			<th>Credat</th>
			<td id="credat"></td>
		</tr>
		<tr>
			<th>Lmodat</th>
			<td id="lmodat"></td>
		</tr>
	</table>
	<br>
	<button onclick="goPage()">Update</button> <button>Delete</button>
	<script type="text/javascript">
		function goPage(){
			location.href="/views/user-info/update?uiNum=${param.uiNum}";
		}
		function loadFunc() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/user-info/view?uiNum=${param.uiNum}');
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {
					if (xhr.status === 200) {
						const obj = JSON.parse(xhr.responseText);
						document.querySelector('#num').innerHTML = obj.uiNum;
						document.querySelector('#name').innerHTML = obj.uiName;
						document.querySelector('#id').innerHTML = obj.uiId;
						document.querySelector('#pwd').innerHTML = obj.uiPwd;
						document.querySelector('#birth').innerHTML = obj.uiBirth;
						document.querySelector('#desc').innerHTML = obj.uiDesc;
						document.querySelector('#credat').innerHTML = obj.credat;
						document.querySelector('#lmodat').innerHTML = obj.lmodat;
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load', loadFunc);
	</script>
</body>
</html>