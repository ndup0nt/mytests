package com.silverpeas.components.mytests.control;

import javax.servlet.http.HttpServletRequest;

public class CreateContactController extends ActionControllerSupport implements
		ActionController {

	@Override
	public String resolveView(HttpServletRequest request) {
		return "newContact.jsp";
	}

}
