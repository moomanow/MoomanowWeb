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
	request.setAttribute("resourceBase", appBase + "/resource" );
	request.setAttribute("imageBase", appBase + "/resource/common/images");
	request.setAttribute("jsBase", appBase + "/resource/common/js");
	request.setAttribute("cssBase", appBase + "/resource/common/css");
	request.setAttribute("iconBase", appBase + "/resource/common/icon");
	
	request.setAttribute("imageThemes", appBase + "/resource/themes/"+themesBase+"/images");
	request.setAttribute("jsThemes", appBase + "/resource/themes/"+themesBase+"/js");
	request.setAttribute("cssThemes", appBase + "/resource/themes/"+themesBase+"/css");
	request.setAttribute("iconThemes", appBase + "/resource/themes/"+themesBase+"/icon");
	request.setAttribute("nasBase", "/resources");
	request.setAttribute("profileBase", "/resources/profile/image");
	request.setAttribute("noImagePath", "/profile/image/noimage.png");
	request.setAttribute("defaultImage", "/profile/image/default_image.png");

%>