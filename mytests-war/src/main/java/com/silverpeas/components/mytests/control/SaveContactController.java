package com.silverpeas.components.mytests.control;

import javax.servlet.http.HttpServletRequest;

import com.silverpeas.components.mytests.Contact;
import com.silverpeas.components.mytests.MyTestsService;

public class SaveContactController extends ActionControllerSupport implements
		ActionController {

	private static final String NAME_PARAM = "lastName";
	private static final String FIRSTNAME_PARAM = "firstName";
	private static final String SERVICE_PARAM = "service";
	
	@Override
	public String handleRequest(HttpServletRequest request) {
		Contact newC = new Contact();
		newC.setFirstName(request.getParameter(FIRSTNAME_PARAM));
		newC.setLastName(request.getParameter(NAME_PARAM));
		newC.setService(request.getParameter(SERVICE_PARAM));
		MyTestsService.getInstance().addContact(newC);
		return "redirect:MyContacts";
	}

}
