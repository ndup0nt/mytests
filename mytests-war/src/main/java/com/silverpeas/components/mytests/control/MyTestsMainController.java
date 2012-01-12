package com.silverpeas.components.mytests.control;

import com.stratelia.webactiv.beans.admin.UserDetail;

import javax.servlet.http.HttpServletRequest;

public class MyTestsMainController extends ActionControllerSupport implements
        ActionController {

    @Override
    public String resolveView(HttpServletRequest request) {
        UserDetail userDetail = getComponentSessionController().getUserDetail();
        String[] userRoles = getComponentSessionController().getUserRoles();
        request.setAttribute("userDetail", userDetail);
        request.setAttribute("userRoles", userRoles);

        return "welcome.jsp";
    }

}
