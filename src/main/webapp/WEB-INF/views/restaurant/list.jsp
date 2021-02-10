<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib prefix="u" tagdir="/WEB-INF/tags"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script>
	$(document).ready(
			function() {

				var result = '${result}';
				var message = '${message}';
				//checkModal(result);
				checkModal2(message);

				history.replaceState({}, null, null);

				function checkModal2(message) {
					if (message && history.state == null) {
						$("#myModal .modal-body p").html(message);
						$("#myModal").modal("show");
					}
				}

				function checkModal(result) {
					if (result === '' || history.state) {
						return;
					}

					if (parseInt(result) > 0) {
						$("#myModal .modal-body p").html(
								"게시글 " + result + "번이 등록되었습니다.");
					}
					$("#myModal").modal("show");
				}
				var actionForm = $("#actionForm");
				$(".pagination a").click(
						function(e) {
							e.preventDefault();

							actionForm.find("[name='pageNo']").val(
									$(this).attr('href'));

							actionForm.submit();
						});
				// 해야할 것
				// 새로고침으로 카운트 반영
				// 게시글 like 별로 클릭할 수 있게 변경
				// modify 확인
			
				$(".like-img").click(function() {
					var userno = 1;
					var resno = $(this).attr("data-resNo");
					console.log(resno);
					$(".like-img").prop("src", "${root}/resources/like_full.png");
					$(".dislike-img").prop("src", "${root}/resources/dislike_empty.png");
					$.ajax({
						url : '${root}/restaurant/like',
						type : 'post',
						data : {'userno' : userno, 'resno': resno, 'likeno' : 1, 'dislikeno' : 0},
						success : function(data) {
							console.log("성공");

// 						}, error : function() {
// 							console.log("실패");
// 							alert("회원만 이용 가능합니다.");
						}
					});
				});

				$(".dislike-img").click(function() {
					var userno = 1;
					var resno = $(this).attr("data-resNo");
					$(".dislike-img").prop("src", "${root}/resources/dislike_full.png");
					$(".like-img").prop("src", "${root}/resources/like_empty2.png");
					$.ajax({
						url : '${root}/restaurant/like',
						type : 'post',
						data : {'userno' : userno, 'resno': resno, 'likeno' : 0, 'dislikeno' : 1},
					});
				});
				
			});
</script>
<style type="text/css">
.card mb-3 div {
	max-width: auto;
	max-height: 250px;
	"
}

.col-md-4 {
	float: right;
}

.col-md-8 {
	float: left;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container-sm mt-3">
		<div class="row">
			<div class="col-1 col-sm-2"></div>
			<div class="col-10 col-sm-8 mt-3">

				<form action="${root }/restaurant/list" id="searchForm"
					class="form-inline my-2 my-lg-0 d-flex bd-highlight mb-3">
					<div class="mr-auto p-2 bd-highlight">
						<a href="${root }/restaurant/list"><button
								class="btn btn-outline-info my-2 my-sm-0" type="button">목록</button></a>
						<a href="${root }/restaurant/register"><button
								class="btn btn-outline-info my-2 my-sm-0" type="button">등록</button></a>
					</div>
					<select name="type" class="custom-select my-1 mr-sm-2 bd-highlight"
						id="inlineFormCustomSelectPref">
						<option value="M" ${page.cri.type eq 'M' ? 'selected' : ''}>산</option>
						<option value="L" ${page.cri.type eq 'L' ? 'selected' : ''}>지역</option>
						<option value="ML" ${page.cri.type eq 'ML' ? 'selected' : ''}>산
							+ 지역</option>
						<option value="N" ${page.cri.type eq 'N' ? 'selected' : ''}>상호</option>
						<option value="F" ${pager.cri.type eq 'F' ? 'selected' : ''}>메뉴</option>
					</select> <input class="form-control mr-sm-2 p-2 bd-highlight" type="search"
						name="keyword" value="${page.cri.keyword }" placeholder="Search"
						aria-label="Search" required="required"> <input
						type="hidden" name="pageNo" value="1" /> <input type="hidden"
						name="amount" value="${page.cri.amount }" />

					<button class="btn btn-outline-info my-2 my-sm-0 p-2 bd-highlight"
						type="submit">Search</button>
				</form>
				<c:forEach items="${list }" var="res">
					<div class="card mb-3">
						<div class="row no-gutters">
							<div class="col-sm-4">
								<img src="${root }/${res.img }" class="card-img" alt="..."
									style="width: 250px; height: 225px;">
							</div>
							<div class="col-sm-8">
								<div class="card-body">
									<h5 class="card-title">${res.rname }</h5>
									<p class="card-text">
										<input type="hidden" name="resno" value="${res.no }"
											id="resno" /> ${res.mname }<br> ${res.rloc }<br>
									</p>
									<p class="card-text">
										<small class="text-muted">${res.description }<br>${res.contact }</small><br>
									</p>
									<div class="d-flex justify-content-end align-items-center mb-1">
<!-- 								 $(this).attr("data-resNo"); -->
							<img data-resNo="${res.no }" class="like-img" src="${root }/resources/like_empty2.png" width="25px" height="25px"><span>&nbsp; ${res.likecnt } &nbsp;</span>
		                    <img data-resNo="${res.no }" class="dislike-img" src="${root }/resources/dislike_empty.png" width="25px" height="25px"><span>&nbsp;${res.dislikecnt }</span>

									</div>
									<c:if test="${true }"> <!--  ${authUser.manager == 1} -->
										<div class="d-flex justify-content-end">
											<c:url value="/restaurant/modify" var="modifyLink">
												<c:param name="no" value="${res.no }"></c:param>
												<c:param name="pageNo" value="${cri.pageNo }"></c:param>
												<c:param name="amount" value="${cri.amount }"></c:param>
												<c:param name="type" value="${cri.type }"></c:param>
												<c:param name="keyword" value="${cri.keyword }"></c:param>
											</c:url>
											<a href="${modifyLink }">
												<button class="btn btn-outline-info my-2 my-sm-0"
													type="submit">수정</button>
											</a>
											<form action="${root }/restaurant/remove" method="post">
												<input type="hidden" name="no" value="${res.no}">
												<button class="btn btn-outline-info my-2 my-sm-0"
													id="removeBtn" type="submit">삭제</button>
											</form>
										</div>
									</c:if>
								</div>

							</div>

						</div>
					</div>
				</c:forEach>
			</div>
			<div class="container-sm mt-3">
				<div class="row justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">

							<c:if test="${page.prev }">
								<c:url value="/restaurant/list" var="prevLink">
									<c:param value="${page.startPage -1 }" name="pageNo" />
									<c:param value="${page.cri.amount }" name="amount" />
									<c:param name="type" value="${page.cri.type }" />
									<c:param name="keyword" value="${page.cri.keyword }" />
								</c:url>
								<li class="page-item">
									<%-- <a class="page-link" href="${prevLink }">Previous</a> --%>
									<a class="page-link" href="${page.startPage -1 }">Previous</a>
								</li>
							</c:if>

							<c:forEach var="num" begin="${page.startPage }"
								end="${page.endPage }">
								<c:url value="/restaurant/list" var="pageLink">
									<c:param name="pageNo" value="${num }" />
									<c:param name="amount" value="${page.cri.amount }" />
									<c:param name="type" value="${page.cri.type }" />
									<c:param name="keyword" value="${page.cri.keyword }" />
								</c:url>
								<li class="page-item ${page.cri.pageNo eq num ? 'active' : '' }">
									<%-- <a class="page-link" href="${pageLink }">${num }</a> --%>
									<a class="page-link" href="${num }">${num }</a>
								</li>
							</c:forEach>

							<c:if test="${page.next }">
								<c:url value="/restaurant/list" var="nextLink">
									<c:param name="pageNo" value="${page.endPage +1 }" />
									<c:param name="amount" value="${page.cri.amount }" />
									<c:param name="type" value="${page.cri.type }" />
									<c:param name="keyword" value="${page.cri.keyword }" />
								</c:url>
								<li class="page-item">
									<%-- <a class="page-link" href="${nextLink }">Next</a> --%> <a
									class="page-link" href="${page.endPage +1 }">Next</a>
								</li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-1 col-sm-2"></div>
		</div>
	</div>
	<div class="modal" id="myModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">알림</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>처리가 완료 되었습니다.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<div class="d-none">
		<form id="actionForm" action="${root }/restaurant/list">
			<input name="pageNo" value="${page.cri.pageNo }" /> <input
				name="amount" value="${page.cri.amount }" /> <input name="type"
				value="${page.cri.type }" /> <input name="keyword"
				value="${page.cri.keyword }" /> <input type="submit" />
		</form>
	</div>
	</div>
</body>
</html>