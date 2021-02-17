<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib prefix="u" tagdir="/WEB-INF/tags"%> --%>

<!DOCTYPE html>
<html>
<head>
<script>
	var root = '${root}';
	var userno = '${authUser.no}';
</script>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- <script src="https://kit.fontawesome.com/a076d05399.js"></script> -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript"
	src="${root }/resources/js/restaurant/LikeDislike.js"></script>

<script>
	$(document).ready(
			function() {

				var message = '${message}';
				var message2 = '${message2}';
				checkModal(message2);
				checkModal2(message);

				history.replaceState({}, null, null);
				history.pushState(null, document.title, location.href);  // push 
				window.addEventListener('popstate', function(event) {    //  뒤로가기 이벤트 등록
				    // 특정 페이지로 가고싶다면 location.href = '';
				   history.pushState(null, document.title, location.href);  // 다시 push함으로 뒤로가기 Block
				   location.href = root + '/restaurant/list';
				});

				function checkModal2(message) {
					if (message && history.state == null) {
						swal(message, "","success");
					}
				}
				function checkModal(message2) {
					if (message2 && history.state == null) {
						swal(message2, "","warning");
					}
				}
				var actionForm = $("#actionForm");
				$(".pagination a").click(
						function(e) {
							e.preventDefault();

							actionForm.find("[name='pageNo']").val(
									$(this).attr('href'));

							actionForm.submit();

						});
				
				var removeForm = $("#removeForm");

				$("#removeBtn").on('click', function(e) {
				    e.preventDefault();
					var resno = $(this).attr("data-resNo");
					console.log(resno);
					swal({
						  title: "삭제 하시겠습니까?",
						  icon: "warning",
						  buttons: {
							  confirm : {
								  text : '확인',
								  value : true,
								  className : 'btn btn-danger'
							  },
							  cancle : {
								  text : '취소',
								  value : false,
								  className : 'btn btn-secondary'
							  }
						  }
						}).then((result) => {
							console.log(result);
							if(result) {
								swal({
									  title: resno + "번 게시물이 삭제되었습니다",
									  icon: "success",
									  buttons: {
										  confirm : {
											  text : '확인',
											  value : true,
											  className : 'btn btn-info'
										  }
									  }
								
								}).then((result) => {
									console.log(result);
									if(result) {
										removeForm.submit();
									}
								});

							} else {
								swal.close();
							}
							
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
.swal-footer {
	text-align: center;
}
.swal {
    position : top-start;
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
								class="btn btn-outline-info my-2 my-sm-0" type="button"><i class="far fa-list"></i>목록</button></a>
								<c:if test="${authUser.manager == 1 }">
						<a href="${root }/restaurant/register"><button
								class="btn btn-outline-info my-2 my-sm-0" type="button">등록</button></a>
								</c:if>
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
				<c:if test="${empty list}">

				<span style="font-size: 2em; color: darkgray; text-align: center">
				<i class="fas fa-exclamation-triangle"></i>검색한 결과가 없습니다.
				</span></c:if>
				<c:forEach items="${list }" var="res" varStatus="status">


					<div class="card mb-3">
						<div class="row no-gutters">
							<div class="col-sm-4">
								<img src="" class="card-img" alt="..."
									style="width: 250px; height: 225px;">
							</div>
							<div class="col-sm-8">
								<div class="card-body">
									<h5 class="card-title">${res.rname }</h5>
									<p class="card-text">
										<input type="hidden" name="resno" value="${res.no }"
											id="resno" /><c:out value="${res.mname }"/> <br> <c:out value="${res.rloc }"/><br>
									</p>
									<p class="card-text">
										<small class="text-muted"><c:out value="${res.description }"/><br><c:out value="${res.contact }"/></small><br>
									</p>
									<div class="d-flex justify-content-end align-items-center mb-1 likeDislike">
										<!-- 								 $(this).attr("data-resNo"); -->

										<img data-resNo="${res.no }" id="like-img${status.count }"
											src="${root }/resources/like_empty2.png" width="25px"
											height="25px"><span>&nbsp; ${res.likecnt }
											&nbsp;</span> <img data-resNo="${res.no }"
											id="dislike-img${status.count }"
											src="${root }/resources/dislike_empty.png" width="25px"
											height="25px"><span>&nbsp;${res.dislikecnt }</span>

									</div>
									<c:if test="${authUser.manager == 1}">
										<!--  ${authUser.manager == 1} -->
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
											<form action="${root }/restaurant/remove" method="post" id="removeForm">
												<input type="hidden" name="no" value="${res.no}">
												<button class="btn btn-outline-info my-2 my-sm-0"
													id="removeBtn" type="submit" data-resNo="${res.no }">삭제</button>
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