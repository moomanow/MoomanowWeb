<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<jsp:include page="/template/projectInclude.jsp"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><tiles:getAsString name="title"/></title>

    <!-- Bootstrap Core CSS -->
    <link href="${requestScope.cssBase}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${requestScope.cssBase}/landing-page.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${requestScope.cssBase}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
 	<tiles:insertAttribute name="navigation"/> 
	<tiles:insertAttribute name="header"/>
	<div class="container">
  		<tiles:insertAttribute name="body"/> 
  	</div>
 	<tiles:insertAttribute name="banner"/> 
 	<tiles:insertAttribute name="footer"/> 
 	
    <!-- jQuery -->
    <script src="${requestScope.jsBase}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${requestScope.jsBase}/bootstrap.min.js"></script>

</body>

</html>

  
  
  
  
  