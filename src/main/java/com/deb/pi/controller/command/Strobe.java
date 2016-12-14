package com.deb.pi.controller.command;

import com.deb.pi.controller.Controller;
import com.pi4j.io.gpio.*;

public class Strobe extends Command {
    
	int timeDelay = 75;
	int repeats = 5;
	int waveLength = 0;
	GpioPinDigitalOutput pin = null;
	
    public Strobe() {
        super( "strobe" );
    }
    
    @Override
    public void execute( Parameter[] parameters ) throws Exception{
        super.parameters = parameters;

        injectValues();
        
        if( pin == null ) {
        	strobeContinuousWave();
        }
        else {
        	strobePin();
        }
    }

	private void injectValues() {
        for( Parameter p : super.parameters ) {
            if( p == null ) {
                continue;
            }
            else if( p.getIdentifier().equals( "pin" ) ) {
                pin = (GpioPinDigitalOutput)p.getObject();
            }
            else if( p.getIdentifier().equals( "-time" ) ) {
                timeDelay = Integer.parseInt( p.getObject().toString() );
            }
            else if( p.getIdentifier().equals( "-repeat" ) ) {
            	repeats = Integer.parseInt( p.getObject().toString() );
            }
            else if( p.getIdentifier().equals( "-wave" ) ) {
            	waveLength = Integer.parseInt( p.getObject().toString() );
            }

        }               			
	}
	
    private void strobeContinuousWave() throws InterruptedException{
    	for( int i=0; i<repeats; i++ ) {
        	for( int j=0; j<Controller.pins.length; j++ ) {
        		int trailingEdge = j;
        		int leadingEdge = 0;
        			        		
        		if( j+waveLength >= Controller.pins.length ) {
        			leadingEdge = (j+waveLength) - Controller.pins.length;
        		}
        		else {
        			leadingEdge = j+waveLength;
        		}
        		
        		GpioPinDigitalOutput leadingPin = Controller.pins[leadingEdge];
        		GpioPinDigitalOutput trailingPin = Controller.pins[trailingEdge];
        		
        		leadingPin.high();
        		trailingPin.high();
        		Thread.sleep( timeDelay );
        		leadingPin.low();
        		trailingPin.low();
        	}
    	}
    }
    
    private void strobePin() throws InterruptedException{
        for( int i=0; i<repeats; i++ ) {
        	pin.high();
        	Thread.sleep( timeDelay );
        	pin.low();
        	Thread.sleep( timeDelay );
        }
    }
}
