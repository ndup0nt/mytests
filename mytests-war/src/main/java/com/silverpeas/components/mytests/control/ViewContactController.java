package com.silverpeas.components.mytests.control;

import javax.servlet.http.HttpServletRequest;

import com.silverpeas.components.mytests.MyTestsRuntimeException;
import com.silverpeas.components.mytests.model.Contact;
import com.silverpeas.components.mytests.service.MyTestsServicesLocator;
import com.stratelia.webactiv.util.exception.SilverpeasRuntimeException;

public class ViewContactController extends ActionControllerSupport {
	private static final String CONTACT_ID_PARAM = "contactId";
	
	@Override
	public String resolveView(HttpServletRequest request) {
		String contactId = request.getParameter(CONTACT_ID_PARAM);
		if(contactId == null){
        	//FIXME gestion de l'i18n du message d'erreur
        	throw new MyTestsRuntimeException(this.getClass().getSimpleName()+".handleRequest()",
        			SilverpeasRuntimeException.ERROR,CONTACT_ID_PARAM+" parameter is missing");
		}
		int id = Integer.parseInt(contactId);
		Contact c = MyTestsServicesLocator.getInstance().getMyTestsService().findContact(id);
		if(c == null){
        	//FIXME gestion de l'i18n du message d'erreur
        	throw new MyTestsRuntimeException(this.getClass().getSimpleName()+".handleRequest()",
        			SilverpeasRuntimeException.ERROR,"cannot find a contact with id "+id);
		}
		request.setAttribute("contact", c);
		return "viewContact.jsp";
	}
}
