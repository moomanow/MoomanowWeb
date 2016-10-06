<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String menu = request.getParameter("menu");
// out.print(menu);
ValueStack stack = ActionContext.getContext().getValueStack();
Object o  = stack.findValue(menu);
stack.getContext().put("menuList", o);
stack.setValue("#attr['menuList']", o, false);
%>

<%-- <s:property value="%{#menuList}"/> --%>
<s:iterator value="#menuList" status="row">
<%-- <s:property/> --%>
	<s:if test='menuName=="<NEW-LINE>"'>
		</ul>
			<hr class="hr-topMenu hidden-sm hidden-xs">
		<ul class="nav nav-justified hidden-sm hidden-sx  ">
	</s:if>
	<s:else>
		<s:if test="%{level==0}">
			<li>
				<a href='<s:url value="%{url}" />'>
				<s:text name='%{"MENU_"+menuName}'></s:text>
<%-- 					<s:property value='%{label["MENU_"+menuName ]!=null?label["MENU_"+menuName ]:menuName}' /> --%>
				</a>
			</li>
			<s:if test='%{childMenu!=null}'>
					<s:include value="/template/base/childMenu.jsp">
					<s:param name="menu">${param.menu }[${row.index }].childMenu</s:param>
					</s:include>
			</s:if>
		</s:if>
		<s:else>
			<s:if test='%{childMenu!=null}'>
				<li class="dropdown">
					<a href='<s:url value="%{url}"/>' class="dropdown-toggle" data-toggle="dropdown" data-target="#"> 
					<s:property value='childMenu!=null&&childMenu.type=="T"'/>
					<s:text name='%{"MENU_"+menuName}'></s:text>
<%-- 						<s:property value='%{label["MENU_"+menuName ]!=null?label["MENU_"+menuName ]:menuName}' />  --%>
						<i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu">
						<s:include value="/template/base/childMenu.jsp">
							<s:param name="menu">${param.menu }[${row.index }].childMenu</s:param>
						</s:include>
					</ul>
				</li>
			</s:if>
			<s:else>
				<li ><a href='<s:url value="%{url}" />'><s:text name='%{"MENU_"+menuName}'></s:text></a></li>
			</s:else>
		</s:else>
	</s:else>
</s:iterator>
<script>
	$(".dropdown-menu").each( function(){
		if($(this).children('li').length == 0){
			$(this).prev().removeClass('dropdown-toggle').removeAttr('data-toggle').removeAttr('data-target').children().remove();
			$(this).remove();
		}
	});
</script>
