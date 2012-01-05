<c:set var="identityTabLabel">
	<fmt:message key="mytests.tabs.identity" />
</c:set>
<c:set var="myContactsTabLabel">
	<fmt:message key="mytests.tabs.mycontacts" />
</c:set>
<view:tabs>
	<view:tab label="${identityTabLabel}" action="Main" selected="${requestScope.action eq 'Main'}" />
	<view:tab label="${myContactsTabLabel}" action="MyContacts" selected="${requestScope.action eq 'MyContacts'}" />
</view:tabs>
