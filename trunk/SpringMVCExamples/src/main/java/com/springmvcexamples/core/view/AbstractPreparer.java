package com.springmvcexamples.core.view;

import org.apache.log4j.Logger;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;

public abstract class AbstractPreparer implements ViewPreparer {

    private final Logger log = Logger.getLogger(getClass());

    private TilesRequestContext tilesRequestContext;

    private AttributeContext attributeContext;

    protected abstract void prepareData() throws Exception;

    public final void execute(TilesRequestContext tilesRequestContext, AttributeContext attributeContext)
        throws PreparerException {

        this.tilesRequestContext = tilesRequestContext;
        this.attributeContext = attributeContext;
        try {
            prepareData();
        }
        catch (Exception e) {
            log.error("Preparer Error", e);
            throw new PreparerException(e);
        }
    }

    protected void addObject(final String name, final Object data) {
        tilesRequestContext.getRequestScope().put(name, data);
    }

    protected Object getAttribute(String name) {
        Attribute attribute = this.attributeContext.getAttribute(name);
        if (attribute != null) {
            return attribute.getValue();
        }
        return null;
    }
}