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
    public String handleRequest(HttpServletRequest request) {
        Contact newC = new Contact();
        newC.setFirstName(request.getParameter(FIRSTNAME_PARAM));
        newC.setLastName(request.getParameter(NAME_PARAM));
        newC.setDepartment(request.getParameter(SERVICE_PARAM));
        MyTestsServicesLocator.getInstance().getMyTestsService().addContact(newC);
        return "redirect:MyContacts";
    }

}
