package com.springmvcexamples.core.controller.handler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvcexamples.core.controller.util.ControllerUtil;

public abstract class AbstractSEOController<E> implements SEOController<E> {

    @Autowired
    private SEOUrlFactory urlFactory;

    @Override
    public boolean canHandle(String path, List<E> args) {
        return canHandle(null, path, args);
    }

    @PostConstruct
    public void initBean() {
        urlFactory.register(this.getSupportedPages(), this);        
    }

    public final void prepareAllData(HttpServletRequest request, String path, List<E> params) {
        ControllerUtil.init();
        prepareUrlData(request, path, params);
    }

    public abstract void prepareUrlData(HttpServletRequest request, String path, List<E> params);

    protected static String getBaseUrl() {
        return "http://localhost";
    }
}