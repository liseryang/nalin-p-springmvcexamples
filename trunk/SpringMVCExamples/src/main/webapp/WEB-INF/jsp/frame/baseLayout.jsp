<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:og="http://opengraphprotocol.org/schema/"
	  xmlns:fb="http://developers.facebook.com/schema/">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<link rel="stylesheet" type="text/css" href="css/elements.css"/>
	<link rel="stylesheet" type="text/css" href="css/grids.css"/>
</head>
<body>
	<div class="TSW1">
		<div class="TR THD">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="TR">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="TR">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>