package com.deb.pi.controller.command;

public class Parameter {

    private String identifier;
    private Object obj;
    
    public Parameter( String identifier, Object obj ) {
        this.identifier = identifier;
        this.obj = obj;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public Object getObject() {
        return obj;
    }
}
