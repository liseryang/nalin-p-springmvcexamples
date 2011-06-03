package com.springmvcexamples.core.controller.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class SEOUtil {

    public static String getPath(HttpServletRequest request) {
        // remove the application name
        return request.getRequestURI().substring(request.getContextPath().length());
    }

    public static String getCleanedUpPath(HttpServletRequest request) {
        final String path = getPath(request);
        return path.replaceAll("/{2,}", "/");   //if there are 2 or more "/", then replace it with just '/'
    }

    public static List<String> parse(HttpServletRequest request) {
        return parse(getCleanedUpPath(request));
    }

    public static List<String> parse(String path) {
        // remove the extension
        if (path.indexOf('.') >= 0) {
            path = path.substring(0, path.lastIndexOf("."));
        }

        if (path.length() > 0) {
            return Arrays.asList(path.substring(1).split("[/-]"));
        }
        else {
            return new ArrayList<String>();
        }
    }
}