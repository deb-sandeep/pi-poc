package com.deb.pi.poc;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class InputGpioExample {

	public static void main( String[] args ) throws InterruptedException{
		final GpioController gpio = GpioFactory.getInstance();
		
		GpioPinDigitalInput pin0 = gpio.provisionDigitalInputPin( 
										RaspiPin.GPIO_00, "pin0", 
										PinPullResistance.PULL_DOWN );

		pin0.addListener( new GpioPinListenerDigital() {
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent arg0) {
				System.out.println( arg0.getPin().getName() + " is now " 
				                  + arg0.getState().getName() );				
			}
		});
		
		while( true ) {
			Thread.sleep( 500 );
		}
	}
}
