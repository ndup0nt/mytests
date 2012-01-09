package com.silverpeas.components.mytests.control;

import com.stratelia.silverpeas.peasCore.ComponentSessionController;

public abstract class ActionControllerSupport implements ActionController {
	private ComponentSessionController controller;
	
	protected ComponentSessionController getMainSessionController(){
		return controller;
	}

	public void setController(ComponentSessionController controller) {
		this.controller = controller;
	}
}
