package com.springmvcexamples.core.controller.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEOUrlFactory {

    private Map<String, SEOController<String>> controllerMap = new HashMap<String, SEOController<String>>();

    protected void register(List<String> pageNames, SEOController controller) {
        for (final String pageName : pageNames) {
            controllerMap.put(pageName, controller);
        }
    }
}