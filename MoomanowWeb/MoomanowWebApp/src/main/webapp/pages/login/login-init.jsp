<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<h1 class="page-header">Login</h1>
<div class="row">
<s:if test="message!=null">
	<div class="alert ${message.messageTypeCss}">
		<strong>${message.messageCode} : </strong> ${message.displayText}
	</div>
</s:if>
<s:form action="login-login" namespace="/main">
	<s:textfield name="username"  />
	<s:password name="password" />
	<s:submit />
</s:form>
</div>