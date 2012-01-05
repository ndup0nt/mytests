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
<%@ include file="check.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.silverpeas.com/tld/viewGenerator" prefix="view"%>
<html>
  <head>
    <view:looknfeel />
  </head>
  <c:set var="componentId" value="${requestScope.componentId}" />
  <c:set var="sessionController">Silverpeas_MyTests_<c:out value="${componentId}" /></c:set>
  <fmt:setLocale value="${sessionScope[sessionController].language}" />
  <view:setBundle bundle="${requestScope.resources.multilangBundle}" />
  <view:setBundle bundle="${requestScope.resources.iconsBundle}" var="icons" />
  <c:set var="browseContext" value="${requestScope.browseContext}" />
  <body bgcolor="#ffffff" leftmargin="5" topmargin="5" marginwidth="5" marginheight="5">
    <view:window>
      <view:frame>
      	${requestScope.userDetail.firstName}, bienvenue sur le composant mytests.
        <fmt:message key="mytests.welcome" />
        Vous avez les droits suivants :
        <c:forEach var="role" items="${requestScope.userRoles}">${role},</c:forEach>
      </view:frame>
      <view:frame>
        <view:board>
          Cette instance s'appele <b><c:out value="${browseContext[1]}" /></b>.<br/>
          Elle se situe dans l'espace <b><c:out value="${browseContext[0]}" /></b>.
        </view:board>
      </view:frame>
    </view:window>
  </body>
</html>