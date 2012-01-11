package com.silverpeas.components.mytests.control;

import com.silverpeas.components.mytests.service.MyTestsServicesLocator;

import javax.servlet.http.HttpServletRequest;

public class MyContactsController extends ActionControllerSupport implements
        ActionController {

    @Override
    public String handleRequest(HttpServletRequest request) {
        request.setAttribute("myContacts", MyTestsServicesLocator.getInstance().getMyTestsService().getMyContacts());

        return "mycontacts.jsp";
    }


}
