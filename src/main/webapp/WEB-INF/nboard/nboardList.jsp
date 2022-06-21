<%@page import="com.ender.boardmodel.PageVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ender.usermodel.UserDTO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ender.boardmodel.BoardVO"%>
<%@page import="com.ender.boardmodel.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<%
	String userID = null;
if (session.getAttribute("userID") != null) {
	userID = (String) session.getAttribute("userID");
}
UserDTO dto = new UserDTO();
ArrayList<BoardVO> list =(ArrayList<BoardVO>)request.getAttribute("list");
PageVO pvo =(PageVO)request.getAttribute("pvo");

int listCount=pvo.getListCount();
int nowPage = pvo.getPage();
int maxPage = pvo.getMaxPage();
int startPage = pvo.getStartPage();
int endPage = pvo.getEndPage();

%>


<script type="text/javascript">
	function checkForm() {	
		if (${userID==null}) {
			alert("로그인 해주세요.");
			return false;
		}
		location.href='${path}/boardInsertForm.do'
	}
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList JSP</title>
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
		<table class='table table-striped'>
		
		
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			

			<c:forEach var="vo" items="${list}">
				<tr>
					<td align="center">${vo.bo_num}</td>
					<td align="center"><a href='${path}/boardDetail.do?bo_num=${vo.bo_num}'>${vo.bo_subject}</a></td>
					<td align="center">${vo.bo_id}</td>
					<td align="center">${vo.bo_date}</td>
					<td align="center">${vo.bo_readcount}</td>
				</tr>
			</c:forEach>
			

			<tr align="center">
				<td colspan="5">
					<form action="boardSearch.do" method="post">
						<select name="part">
							<option value="bo_subject">제목</option>
							<option value="bo_content">내용</option>
							<option value="bo_id">작성자</option>
						</select> <input type="text" name="searchData" required="required" /> <input
							type="submit" value="검색" class="btn btn-success" />

						<!--  <input type="button" value="글쓰기" class="btn btn-success"
							onclick="location.href='${path}/boardInsertForm.do'" />-->

						<input type="button" value="글쓰기" class="btn btn-success"
							onclick="checkForm(); return false;" />
					</form>
				</td>
			</tr>
			<section id="pageList">
			<%
		if(list !=null && listCount >0){
		%>
		<%if(nowPage<=1){ %>
		[이전]&nbsp;
		<%}else{ %>
		<a href="boardList.do?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="boardList.do?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		[다음]
		<%}else{ %>
		<a href="boardList.do?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
	</section>
	<%
    }
	else
	{
	%>
	<section id="emptyArea">등록된 글이 없습니다.</section>
	<%
	}
%>
		</table>
	</div>
	<c:import url="/WEB-INF/footer.jsp" />
</body>
</html>