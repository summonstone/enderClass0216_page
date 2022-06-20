<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ender.boardmodel.BoardVO"%>
<%@page import="com.ender.boardmodel.BoardDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
	String userID = null;
if (session.getAttribute("userID") != null) {
	userID = (String) session.getAttribute("userID");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nboardUpdate</title>
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<!-- custom css file link  -->
<link rel="stylesheet" href="${path}/css/ender.css?ver=1">
<script type="text/javascript">
	function fnSubmit() {
		if (confirm("정말 수정 하시겠습니까?")) {
			return true;
		}
		return false;
	}

	function fnReset() {
		if (confirm("정말 초기화 하시겠습니까?")) {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<c:import url="/WEB-INF/header.jsp" />
	<section>
		<div align="center">
			<h3>[게시판 글 수정하기]</h3>
			<form id="UpdateForm" name="Update" action="${path}/boardUpdate.do"
				method="post" onsubmit="return fnSubmit()"
				onreset="return fnReset()">
				<input type="hidden" name="bo_num" value="${vo.bo_num}" /> 
				<input
					type="hidden" name="bo_id" value="${userName}" />

				<table border="1" style="width: 80%;">

					<tr>
						<th>제목</th>
						<td><input type="text" id="bo_subject" name="bo_subject"
							value="${vo.bo_subject}" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="10" cols="50" id="bo_content"
								name="bo_content">${vo.bo_content}</textarea></td>
					</tr>
					<tr align="center">
						<td align="center">
							<!--  <input type="submit" value="수정 완료" /> -->
							<button class="btn btn-success" id="updateSubmit">수정완료</button> 
							<input type="button" class="btn btn-success" value="글 목록" onclick="location.href='${path}/boardList.do'" />
							</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<c:import url="/WEB-INF/footer.jsp" />

	<script type="text/javascript">
		$(function() {
			$('#updateSubmit').on('click', insert);
			$('#UpdateForm').on('submit', function() {
				return false;
			});
		})

		function insert() {
				if (bo_subject.value != "") {
					if (bo_content.value != "") {
						const form = document.getElementById('UpdateForm');
						form.submit();
				}
			}
		}
	</script>
	
</body>

</html>