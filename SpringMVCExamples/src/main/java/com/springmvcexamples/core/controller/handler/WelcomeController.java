package com.springmvcexamples.core.controller.handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * PT-05
 * url pattern:
 *  /welcome
 * @author nalin
 */
@Controller
public class WelcomeController extends AbstractSEOController<String> {

    private static final String URL_FORMAT = "/welcome";

    private static final Pattern URL_PATTERN = Pattern.compile("^/welcome$",
            Pattern.CASE_INSENSITIVE);

    @RequestMapping
    public ModelAndView handleRequest() throws ServletException, IOException {
        return new ModelAndView(PageConstants.PAGE_NAME_WELCOME)
                    .addObject("pagename", PageConstants.PAGE_NAME_WELCOME);
    }

    @Override
    public void prepareUrlData(HttpServletRequest request, String path, List<String> params) {
    }

    @Override
    public boolean canHandle(HttpServletRequest request, String path, List<String> args) {
        return  URL_PATTERN.matcher(path).matches();
    }

    public static String getUrl() {
        return URL_FORMAT;
    }

    @Override
    public List<String> getSupportedPages() {
        return Arrays.asList(PageConstants.PAGE_NAME_WELCOME);
    }
}