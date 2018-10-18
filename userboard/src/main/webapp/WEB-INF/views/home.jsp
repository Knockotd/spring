<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<section class="content">
	<div class="box">
		<div class="box-header with-border">
		<c:if test="${user==null}">
			<a href="${pageContext.request.contextPath}/user/login"><h3 class="box-title">로그인</h3></a>
			<a href="${pageContext.request.contextPath}/user/register"><h3 class="box-title">회원가입</h3></a>
		</c:if>
		<c:if test="${user!=null}">
		<a href="${pageContext.request.contextPath}/user/logout"><h3 class="box-title">로그아웃</h3></a>
		</c:if>
		</div>
	</div>
</section>
<%@include file="include/footer.jsp"%>