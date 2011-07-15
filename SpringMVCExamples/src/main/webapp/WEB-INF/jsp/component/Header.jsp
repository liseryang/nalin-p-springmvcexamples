<%@ include file="/WEB-INF/jsp/Include.jsp" %>
<div class="gHd">
	<div class="bd">
		<ul class="hList">
		<c:forEach items="${menuItems}" var="menuItem" varStatus="index">
			<li <c:if test="${index.first}">class="first"</c:if>><a href="${menuItem.url}">${menuItem.label}</a></li>
		</c:forEach>
		</ul>
	</div>
</div>