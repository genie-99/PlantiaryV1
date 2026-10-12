<%@page import="genie99.prj.board.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
List<Board> boards = (List<Board>)request.getAttribute("boards");
%>	

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
 	<h2>자유게시판</h2>
 	<form action="<%= request.getContextPath()%>/board">
 		<input type="hidden" name="act" value="writeForm"/>
 		<button>게시물 추가</button> 	
 	</form>
	<fieldset>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
		</tr>
		<% 
		for(Board board : boards) {
		%>
		<tr>
 			<th><%=board.getNo()%></th>
 			<th><a href="<%= request.getContextPath() %>/board?act=detail&no=<%=board.getNo()%>"><%=board.getTitle()%></a></th>
 			<th><%=board.getAuthor()%></th>
 			<th><%=board.getViewCnt()%></th>
 		</tr>
		<% } %>
	</table>
	</fieldset>
</body>
</html>