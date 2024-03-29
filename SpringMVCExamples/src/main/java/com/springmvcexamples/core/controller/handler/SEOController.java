package com.springmvcexamples.core.controller.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface SEOController<E> {

    public boolean canHandle(String path, List<E> args);

    public boolean canHandle(HttpServletRequest request, String path, List<E> args);

    public void prepareAllData(HttpServletRequest request, String path, List<E> params);

    public List<String> getSupportedPages();
}