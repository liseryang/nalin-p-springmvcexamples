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
 * PT-02
 * url pattern:
 *  i.  /helloworld
 *  ii. /aaa
 * @author nalin
 */
@Controller
public class HelloWorldController extends AbstractSEOController<String> {

    private static final String URL_FORMAT = "/helloworld";

    private static final Pattern URL_PATTERN = Pattern.compile("^/(helloworld|aaa)$",
            Pattern.CASE_INSENSITIVE);

    @RequestMapping
    public ModelAndView handleRequest() throws ServletException, IOException {
        return new ModelAndView(PageConstants.PAGE_NAME_HELLO_WORLD)
                    .addObject("pagename", PageConstants.PAGE_NAME_HELLO_WORLD);
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
        return Arrays.asList(PageConstants.PAGE_NAME_HELLO_WORLD);
    }
}