package com.springmvcexamples.core.controller.handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * url pattern: /
 * @author nalin
 */
@Controller
public class HomeController extends AbstractSEOController<String> {

    private static final String URL_FORMAT = "/";

    @RequestMapping
    public ModelAndView handleRequest() throws ServletException, IOException {
        return new ModelAndView(PageConstants.PAGE_NAME_HOME)
                    .addObject("pagename", PageConstants.PAGE_NAME_HOME);
    }

    @Override
    public void prepareUrlData(HttpServletRequest request, String path, List<String> params) {
    }

    @Override
    public boolean canHandle(HttpServletRequest request, String path, List<String> args) {
        return URL_FORMAT.equalsIgnoreCase(path);
    }

    public static String getUrl() {
        return URL_FORMAT;
    }

    @Override
    public List<String> getSupportedPages() {
        return Arrays.asList(PageConstants.PAGE_NAME_HOME);
    }
}