package com.silverpeas.components.mytests.service;

import javax.inject.Inject;

public class MyTestsServicesLocator {
    @Inject
    private MyTestsService myTestsService;

    private static class SingletonLoader {
        private static final MyTestsServicesLocator _instance = new MyTestsServicesLocator();
    }

    public static MyTestsServicesLocator getInstance() {
        return SingletonLoader._instance;
    }

    public MyTestsService getMyTestsService() {
        return myTestsService;
    }

}
