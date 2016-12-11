package com.deb.pi.controller.command;

import com.pi4j.io.gpio.*;

public class Strobe extends Command {
    
    public Strobe() {
        super( "strobe" );
    }
    
    @Override
    public void execute( Parameter[] parameters ) throws Exception{
        super.parameters = parameters;
        GpioPinDigitalOutput pin = null;
        int timeDelay = 100;
        int repeats = 10;
        
        for( Parameter p : parameters ) {
            if( p == null ) {
                continue;
            }
            else if( p.getIdentifier().equals( "pin" ) ) {
                pin = (GpioPinDigitalOutput)p.getObject();
            }
            else if( p.getIdentifier().equals( "-time" ) ) {
                timeDelay = Integer.parseInt( p.getObject().toString() );
            }
            else if( p.getIdentifier().equals( "-num" ) ) {
            	repeats = Integer.parseInt( p.getObject().toString() );
            }
        }
               	
    	for( int i=0; i<repeats; i++ ) {
            pin.high();
            Thread.sleep( timeDelay );
            pin.low();
            Thread.sleep( timeDelay );
    	}
    }    
}
