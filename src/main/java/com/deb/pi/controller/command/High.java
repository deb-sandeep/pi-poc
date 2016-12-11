package com.deb.pi.controller.command;

import com.pi4j.io.gpio.*;

public class High extends Command {
    
    public High() {
        super( "high" );
    }
    
    @Override
    public void execute( Parameter[] parameters ) throws Exception{
        super.parameters = parameters;
        GpioPinDigitalOutput pin = null;
        int timeDelay = -1;
        
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
        }
        
        if( timeDelay > -1 ) {
            pin.high();
            Thread.sleep( timeDelay );
            pin.low();
            System.out.println( "Done" );
        }
        else {
            pin.high();
        }
    }    
}
