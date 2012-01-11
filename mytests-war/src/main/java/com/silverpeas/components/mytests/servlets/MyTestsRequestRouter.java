/**
 * Copyright (C) 2000 - 2011 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection with Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception.  You should have received a copy of the text describing
 * the FLOSS exception, and it is also available here:
 * "http://www.silverpeas.com/legal/licensing"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.silverpeas.components.mytests.servlets;

import com.silverpeas.components.mytests.control.*;
import com.stratelia.silverpeas.peasCore.ComponentContext;
import com.stratelia.silverpeas.peasCore.ComponentSessionController;
import com.stratelia.silverpeas.peasCore.MainSessionController;
import com.stratelia.silverpeas.peasCore.servlets.ComponentRequestRouter;
import com.stratelia.silverpeas.silvertrace.SilverTrace;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class MyTestsRequestRouter extends ComponentRequestRouter {
    private static final long serialVersionUID = 2306409242623119934L;

    private final Map<String, ActionControllerSupport> viewMappings = new HashMap<String, ActionControllerSupport>();

    public MyTestsRequestRouter() {
        super();
        viewMappings.put("Main", new MyTestsMainController());
        viewMappings.put("MyContacts", new MyContactsController());
        viewMappings.put("CreateContact", new CreateContactController());
        viewMappings.put("SaveContact", new SaveContactController());
    }

    /**
     * This method has to be implemented in the component request rooter class.
     * returns the session control bean name to be put in the request object ex
     * : for almanach, returns "almanach"
     */
    @Override
    public String getSessionControlBeanName() {
        return "MyTests";
    }

    /**
     * Method declaration
     *
     * @param mainSessionCtrl
     * @param componentContext
     * @return
     * @see
     */
    @Override
    public ComponentSessionController createComponentSessionController(
            MainSessionController mainSessionCtrl,
            ComponentContext componentContext) {
        return new MyTestsSessionController(mainSessionCtrl, componentContext);
    }

    /**
     * This method has to be implemented by the component request rooter it has
     * to compute a destination page
     *
     * @param function    The entering request function (ex : "Main.jsp")
     * @param componentSC The component Session Control, build and initialised.
     * @return The complete destination URL for a forward (ex :
     *         "/almanach/jsp/almanach.jsp?flag=user")
     */
    @Override
    public String getDestination(String function,
                                 ComponentSessionController componentSC, HttpServletRequest request) {
        String destination;
        SilverTrace.info("mytests", "MyTestsRequestRouter.getDestination()",
                "root.MSG_GEN_PARAM_VALUE", "User=" + componentSC.getUserId()
                + " Function=" + function);
        try {
            if (viewMappings.containsKey(function)) {
                ActionControllerSupport actionController = viewMappings.get(function);
                actionController.setSessionController(componentSC);
                String view = actionController.handleRequest(request);
                if (view == null) {
                    destination = "/admin/jsp/errorpageMain.jsp";
                } else if (view.startsWith("redirect:")) {
                    //FIXME attention, risque de récursivité infinie non traité
                    return getDestination(view.substring("redirect:".length()), componentSC, request);
                } else {
                    destination = "/mytests/jsp/" + view;
                }
            } else {
                destination = "/admin/jsp/errorpageMain.jsp";
            }
        } catch (Exception e) {
            request.setAttribute("javax.servlet.jsp.jspException", e);
            destination = "/admin/jsp/errorpageMain.jsp";
        }

        request.setAttribute("action", function);

        SilverTrace.info("mytests", "MyTestsRequestRouter.getDestination()",
                "root.MSG_GEN_PARAM_VALUE", "Destination=" + destination);
        return destination;
    }

}
