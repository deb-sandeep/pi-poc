package com.deb.pi.controller;

import com.deb.pi.controller.command.*;
import java.util.ArrayList;
import com.pi4j.io.gpio.*;

public class Parser {
    
    public static String getCommand( String input ) {
        
        String[] tokens = input.split( " " );
        return tokens[0];
    }
    
    public static Parameter[] getParameters( String input ) {
        String[] tokens = input.split( " " );
        ArrayList<Parameter> parameters = new ArrayList<Parameter>();
        
        for( int i=0; i<tokens.length; i++ ) {
            if( tokens[i].startsWith( "-" ) ) {
                parameters.add( new Parameter( tokens[i], tokens[i+1] ) );
                i++;
            }
            else if( tokens[i].startsWith( "pin" ) ) {
                parameters.add( new Parameter( "pin", findPin(tokens[i]) ) );
            }
        }
        
        return parameters.toArray( new Parameter[20] );
    }
    
    private static GpioPinDigitalOutput findPin( String pinName ) {
        
        for( GpioPinDigitalOutput pin : Controller.pins ) {
            if( pin.getName().equals( pinName ) ) {
                return pin;
            }
        }
        return null;                
    }
}
