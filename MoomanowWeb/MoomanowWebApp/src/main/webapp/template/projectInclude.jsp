<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%!
	String appBase    	= null;
	String imageBase  	= null;
	String jsBase 	= null;
	String cssBase  	= null;
	
	String agiImageBase = null;
	String agiJSBase = null;
	String agiCssBase = null;
	String themesBase = null;
%><%
	appBase    	= request.getContextPath();
	if(appBase.equals("/")){
		appBase = "";
	}
	themesBase = "Standard";
	request.setAttribute("themesBase", themesBase );
	request.setAttribute("appBase", appBase );
	request.setAttribute("resourceBase", appBase + "/resources" );
	request.setAttribute("imageBase", resourceBase + "/common/images");
	request.setAttribute("jsBase", resourceBase + "/common/js");
	request.setAttribute("cssBase", resourceBase + "/common/css");
	request.setAttribute("iconBase", resourceBase + "/common/icon");
	
	request.setAttribute("imageThemes", resourceBase + "/themes/"+themesBase+"/images");
	request.setAttribute("jsThemes", resourceBase + "/themes/"+themesBase+"/js");
	request.setAttribute("cssThemes", resourceBase + "/themes/"+themesBase+"/css");
	request.setAttribute("iconThemes", resourceBase + "/themes/"+themesBase+"/icon");

%>