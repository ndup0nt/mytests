package com.silverpeas.components.mytests.control;

import javax.servlet.http.HttpServletRequest;

import com.silverpeas.components.mytests.MyTestsService;

public class MyContactsController extends ActionControllerSupport implements
		ActionController {

	@Override
	public String handleRequest(HttpServletRequest request) {
        request.setAttribute("myContacts", MyTestsService.getInstance().getMyContacts());
        
		return "mycontacts.jsp";
	}


}
