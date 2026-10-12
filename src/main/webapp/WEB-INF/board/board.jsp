<%@page import="genie99.prj.board.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Board board =(Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h2>자유게시판</h2>
 	 	<form action="<%= request.getContextPath()%>/board">
 		<input type="hidden" name="act" value="modifyForm"/>
 		<input type="hidden" name="no" value="<%=board.getNo()%>"/>
 		<button>게시물 수정</button> 	
 	</form>
	<fieldset>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>글쓴이</th>
			<th>조회수</th>
		</tr>			
		<tr>
 			<th><%=board.getNo()%></th>
 			<th><%=board.getTitle()%></th>
 			<th><%=board.getContent() %></th>
 			<th><%=board.getAuthor()%></th>
 			<th><%=board.getViewCnt()%></th>
 		</tr>
	</table>
	<a href="<%=request.getContextPath()%>/board?act=delete&title=<%=board.getTitle()%>">삭제</a>
	<a href="<%=request.getContextPath()%>/board?act=list">목록</a>
	</fieldset>
</body>
</html>