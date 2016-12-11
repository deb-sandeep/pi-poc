package com.deb.pi.controller.command;

public class Command {
    
    protected String name;
    protected Parameter[] parameters;
    
    public Command( String name ) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public Parameter[] getParameters() {
        return parameters;
    }
    
    public void setParameters( Parameter[] parameters ) {
        this.parameters = parameters;
    }
    
    public void execute( Parameter[] parameters ) throws Exception{}
    
}
