<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ender.boardmodel.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardSearchList</title>
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<!-- custom css file link  -->
<link rel="stylesheet" href="${path}/css/ender.css?ver=1">
</head>
<body>
<c:import url="/WEB-INF/header.jsp" />
	<div align="center">
		<table class='table table-hover'>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.bo_num}</td>
					<td><a href='${path}/boardDetail.do?bo_num=${vo.bo_num}'>${vo.bo_subject}</a></td>
					<td>${vo.bo_id}</td>
					<td>${vo.bo_date}</td>
					<td>${vo.bo_readcount}</td>
				</tr>
			</c:forEach>

			<tr align="center">
				<td colspan="5">
				<input type="button" value="글쓰기" onclick="location.href='${path}/boardInsertForm.do'" />
				<input type="button" value="글 목록" onclick="location.href='${path}/boardList.do'" />
				</td>
			</tr>
		</table>
	</div>
<c:import url="/WEB-INF/footer.jsp" />
</body>
</html>