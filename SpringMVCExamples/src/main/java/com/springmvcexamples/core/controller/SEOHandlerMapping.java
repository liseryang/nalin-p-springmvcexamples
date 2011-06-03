package com.springmvcexamples.core.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;

import com.springmvcexamples.core.controller.handler.SEOController;
import com.springmvcexamples.core.controller.util.SEOUtil;

public class SEOHandlerMapping extends AbstractHandlerMapping {

    private final static List<SEOController> controllers = new ArrayList<SEOController>();

    @Override
    protected void initApplicationContext() throws BeansException {
        super.initApplicationContext();
        init();
    }

    private void init() {
        final Map<String, SEOController> map = new HashMap<String, SEOController>();
        map.putAll(getApplicationContext().getBeansOfType(SEOController.class));

        controllers.addAll(map.values());
    }

    @Override
    protected Object getHandlerInternal(HttpServletRequest request) throws Exception {
        final String path = SEOUtil.getCleanedUpPath(request);
        final List<String> params = SEOUtil.parse(request);

        // if none of them can handle it, try internal
        for (final SEOController<String> controller : controllers) {
            if (controller.canHandle(request, path, params)) {
                return controller;
            }
        }

        return null;
    }
}