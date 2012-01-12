package com.silverpeas.components.mytests.control;

import com.silverpeas.components.mytests.model.Contact;
import com.silverpeas.components.mytests.service.MyTestsServicesLocator;

import javax.servlet.http.HttpServletRequest;

public class SaveContactController extends ActionControllerSupport implements
        ActionController {

    private static final String NAME_PARAM = "lastName";
    private static final String FIRSTNAME_PARAM = "firstName";
    private static final String SERVICE_PARAM = "department";

    @Override
    public String resolveView(HttpServletRequest request) {
        Contact newC = new Contact(
        		request.getParameter(FIRSTNAME_PARAM),
        		request.getParameter(NAME_PARAM),
        		request.getParameter(SERVICE_PARAM),
        		getComponentSessionController().getComponentId()
        );
        MyTestsServicesLocator.getInstance().getMyTestsService().addContact(newC);
        return "redirect:MyContacts";
    }

}
