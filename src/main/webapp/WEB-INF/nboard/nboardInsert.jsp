<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
	String userID = null;
if (session.getAttribute("userID") != null) {
	userID = (String) session.getAttribute("userID");
}

if (userID == null) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('로그인을 하세요.')");
	script.println("location.href='${path}/boardList.do'");
	script.println("</script>");
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Insert Form</title>
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<!-- custom css file link  -->
<link rel="stylesheet" href="${path}/css/ender.css?ver=1">
<script type="text/javascript">
	function fnSubmit() {
		if (confirm("작성하신 글을 등록하시겠습니까?")) {
			return true;
		}
		return false;
	}

	function fnReset() {
		if (confirm("입력하신 내용을 삭제하시겠습니까?")) {
			fnLoad();
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
			<h3>[게시판 글쓰기]</h3>
			<form id="board-Form" name="Insert" action="${path}/boardInsert.do"
				method="post" onsubmit="return fnSubmit()"
				onreset="return fnReset()">
				<table border="1">
					<input type="hidden" name="bo_id" value="${userName}" />
					<tr>
						<th>제목</th>
						<td><input type="text" id="bo_subject" name="bo_subject"
							maxlength="50" required="required" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="10" cols="50" id="bo_content"
								name="bo_content" required="required"></textarea>
					</tr>




					<tr>
						<td colspan="2">
							<!-- 						<input type="submit" value="등록" class="btn btn-success" /> -->
							<button class="btn btn-success" id="boardSubmit">등록</button> <input
							type="reset" value="내용 삭제" class="btn btn-danger" /> <input
							type="button" value="글목록"
							onclick="location.href='${path}/boardList.do'" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<c:import url="/WEB-INF/footer.jsp" />

	<script type="text/javascript">
		$(function() {
			$('#boardSubmit').on('click', insert);
			$('#board-Form').on('submit', function() {
				return false;
			});
		})

		function insert() {

			if (bo_subject.value != "") {
				if (bo_content.value != "") {

					const form = document.getElementById('board-Form');
					form.submit();

				}
			}
		}
	</script>
	
	<script type="text/javascript">
	function checkForm() {	
		if (${vo.bo_id==null}) {
			alert("로그인 해주세요.");
			return false;
		}

	}
</script>

</body>
</html>