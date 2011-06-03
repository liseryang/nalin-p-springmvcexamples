package com.springmvcexamples.core.controller.util;

public class ControllerUtil {

    private static ThreadLocal<Boolean> BAD_ID_FLAG = new ThreadLocal<Boolean>();

    public static void init() {
        BAD_ID_FLAG.set(Boolean.FALSE);
    }
}