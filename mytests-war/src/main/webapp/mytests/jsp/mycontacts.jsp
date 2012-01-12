<%--

    Copyright (C) 2000 - 2011 Silverpeas

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    As a special exception to the terms and conditions of version 3.0 of
    the GPL, you may redistribute this Program in connection with Free/Libre
    Open Source Software ("FLOSS") applications as described in Silverpeas's
    FLOSS exception.  You should have received a copy of the text describing
    the FLOSS exception, and it is also available here:
    "http://www.silverpeas.com/legal/licensing"

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

--%>
<%@ include file="include/check.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.silverpeas.com/tld/viewGenerator" prefix="view"%>
<html>
<head>
<view:looknfeel />
</head>
<c:set var="componentId" value="${requestScope.componentId}" />
<view:setBundle bundle="${requestScope.resources.multilangBundle}" />
<view:setBundle bundle="${requestScope.resources.iconsBundle}"
	var="icons" />
<body bgcolor="#ffffff" leftmargin="5" topmargin="5" marginwidth="5"
	marginheight="5">
	<c:set var="browseBarTitle">
	    <fmt:message key="mytests.browseBar.mycontacts"/>
	</c:set>
	<view:browseBar path="${browseBarTitle}"/>
	<c:set var="createContactIcon"><fmt:message key="mytests.createContact" bundle="${icons}"/></c:set>
	<c:set var="createContactText"><fmt:message key="mytests.createContact.altText"/></c:set>
	<view:operationPane>
		<view:operation
			action="CreateContact" 
			icon="${createContactIcon}"
			altText="${createContactText}" />
	</view:operationPane>

	<view:window>
		<%@ include file="include/tabs.jsp"%>
		<view:frame>
			icône : ${createContactIcon}
			<view:arrayPane title="Liste des contacts personnels"
				var="myContactsTable">
				<view:arrayColumn title="Nom" />
				<view:arrayColumn title="Prénom" />
				<view:arrayColumn title="Service" />
				<c:forEach items="${requestScope.myContacts}" var="myContact">
					<c:url var="viewContactURL" value="ViewContact">
						<c:param name="contactId" value="${myContact.id}"/>
					</c:url>
					<c:set var="col1"><a href="${viewContactURL}">${myContact.lastName}</a></c:set>
					<view:arrayLine>
						<view:arrayCellText text="${col1}" />
						<view:arrayCellText text="${myContact.firstName}" />
						<view:arrayCellText text="${myContact.department}" />
					</view:arrayLine>
				</c:forEach>
			</view:arrayPane>
		</view:frame>
	</view:window>
</body>
</html>
