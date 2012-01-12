package com.silverpeas.components.mytests.control;

import com.silverpeas.components.mytests.service.MyTestsServicesLocator;

import javax.servlet.http.HttpServletRequest;

public class MyContactsController extends ActionControllerSupport implements
		ActionController {

	@Override
	public String resolveView(HttpServletRequest request) {
		request.setAttribute(
				"myContacts",
				MyTestsServicesLocator
						.getInstance()
						.getMyTestsService()
						.getMyContacts(
								getComponentSessionController()
										.getComponentId()));
		return "mycontacts.jsp";
	}

}
