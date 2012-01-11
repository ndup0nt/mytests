package com.silverpeas.components.mytests.control;

import com.stratelia.silverpeas.peasCore.ComponentSessionController;

public abstract class ActionControllerSupport implements ActionController {
    private ComponentSessionController controller;

    protected ComponentSessionController getComponentSessionController() {
        return controller;
    }

    public void setSessionController(ComponentSessionController controller) {
        this.controller = controller;
    }
}
