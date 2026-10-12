<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 추가</h2>
	<br>
	<form action="<%=request.getContextPath() %>/board">
		<input type="hidden" name="act" value="write" />
		<div>
			<label>author </label>
			<input type="text" name="author">
			
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
<!-- 
	private int no;
	private int viewCnt;
	private String title; 
	private String content;
	private String author;
 -->