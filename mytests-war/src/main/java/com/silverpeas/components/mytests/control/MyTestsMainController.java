package com.silverpeas.components.mytests.control;

import javax.servlet.http.HttpServletRequest;

import com.stratelia.webactiv.beans.admin.UserDetail;

public class MyTestsMainController extends ActionControllerSupport implements
		ActionController {

	@Override
	public String handleRequest(HttpServletRequest request) {
        UserDetail userDetail = getMainSessionController().getUserDetail();
        String[] userRoles = getMainSessionController().getUserRoles();
        request.setAttribute("userDetail", userDetail);
        request.setAttribute("userRoles", userRoles);

		return "welcome.jsp";
	}

}
