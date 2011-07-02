<%@ include file="/WEB-INF/jsp/Include.jsp" %>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:og="http://opengraphprotocol.org/schema/"
	  xmlns:fb="http://developers.facebook.com/schema/">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<link rel="stylesheet" type="text/css" href="css/elements.css"/>
	<link rel="stylesheet" type="text/css" href="css/grids.css"/>
	<link rel="stylesheet" type="text/css" href="css/containers.css"/>
	<link rel="stylesheet" type="text/css" href="css/global.css"/>
	<link rel="stylesheet" type="text/css" href="css/modules.css"/>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="TSW">
		<div class="TR">
			<tiles:insertAttribute name="template" />
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>