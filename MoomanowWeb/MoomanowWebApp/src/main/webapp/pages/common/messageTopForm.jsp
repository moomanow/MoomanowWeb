<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="message!=null">
<div class="alert ${message.messageTypeCss}"><strong>${message.messageCode} : </strong> ${message.displayText}</div>
</s:if>