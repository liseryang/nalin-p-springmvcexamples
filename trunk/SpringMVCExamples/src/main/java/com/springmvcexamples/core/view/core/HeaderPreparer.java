package com.springmvcexamples.core.view.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springmvcexamples.core.controller.handler.AboutController;
import com.springmvcexamples.core.controller.handler.HomeController;
import com.springmvcexamples.core.controller.handler.WelcomeController;
import com.springmvcexamples.core.view.AbstractPreparer;

public class HeaderPreparer extends AbstractPreparer {

    protected void prepareData() throws Exception {
        addObject("menuItems", getMenuItems());
    }

    private List<Map<String,String>> getMenuItems() {
        final List<Map<String,String>> menuItems = new ArrayList<Map<String,String>>();
        final Map<String,String> homeMenu = new HashMap<String,String>();
        homeMenu.put("label", "Home");
        homeMenu.put("url", HomeController.getUrl());
        menuItems.add(homeMenu);

        final Map<String,String> aboutMenu = new HashMap<String,String>();
        aboutMenu.put("label", "About");
        aboutMenu.put("url", AboutController.getUrl());
        menuItems.add(aboutMenu);

        final Map<String,String> welcomeMenu = new HashMap<String,String>();
        welcomeMenu.put("label", "Welcome");
        welcomeMenu.put("url", WelcomeController.getUrl());
        menuItems.add(welcomeMenu);

        return menuItems;
    }
}