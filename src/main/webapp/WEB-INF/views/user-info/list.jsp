<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
I'm List

<table border = "1">
	<tr>
		<th>Num</th>
		<th>Name</th>
		<th>ID</th>
		<th>PWD</th>
		<th>Brith</th>
	</tr>
	<tbody id="tBody">
		
	</tbody>
</table>
<script type="text/javascript">
	function loadFunc() {
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/user-info/list');
		xhr.onreadystatechange = function (){
			if(xhr.readyState===4){
				if(xhr.status===200){
					const obj = JSON.parse(xhr.responseText);
					let html = '';
					for(let list of obj){
						html += '<tr>';
						html += '<td>' + list.uiNum + '</td>';
						html += '<td><a href="/views/user-info/view?uiNum=' + list.uiNum + '">' + list.uiName + '</td>';
						html += '<td>' + list.uiId + '</td>';
						html += '<td>' + list.uiPwd + '</td>';
						html += '<td>' + list.uiBirth + '</td>';
						html += '</tr>';
					}
					document.querySelector('#tBody').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load', loadFunc);
</script>
</body>
</html>