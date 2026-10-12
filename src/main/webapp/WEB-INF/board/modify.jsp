<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 수정</h2>
	<br>
	<form action="<%=request.getContextPath()%>/board">
		<input type="hidden" name="act" value="modify" />
		<input type="hidden" name="no" value="<%=no %>"/>
		<div>
			<h2><%=no%>번</h2>
		</div>
		<div>
			<label>title</label>
			<input type="text" name="title">
		</div>
		<div>
			<label>Content</label>
			<input type="text" name="content">
		</div>
		<div>	
			<button>제출</button>
		</div>
	</form>
</body>
</html>
