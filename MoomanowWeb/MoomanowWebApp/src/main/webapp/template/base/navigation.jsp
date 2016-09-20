<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<s:include value="/template/base/childMenu.jsp">
					<s:param name="menu">
					#session.SESSION_MENU_BEAN_KEY
					</s:param>
				</s:include>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>