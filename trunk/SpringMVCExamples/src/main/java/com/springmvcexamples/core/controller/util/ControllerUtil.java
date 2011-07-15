package com.springmvcexamples.core.controller.util;

public class ControllerUtil {

    public static final String HTTP = "http://";

    private static ThreadLocal<Boolean> BAD_ID_FLAG = new ThreadLocal<Boolean>();

    public static void init() {
        BAD_ID_FLAG.set(Boolean.FALSE);
    }
}