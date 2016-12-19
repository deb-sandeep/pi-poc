package com.deb.pi.poc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class LCDI2COutput {

	public static void main(String[] args) throws Exception {
		
		GpioController gpio = GpioFactory.getInstance();
		
		GpioPinDigitalOutput out = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_00 );
		GpioPinDigitalInput in = gpio.provisionDigitalInputPin( RaspiPin.GPIO_14 );
		out.high();
	
		String output = executeCommand( "python /home/pi/temp/examples.py blablabla 1" );
		System.out.println( output );
		System.out.println( in.getState() );
		
		Thread.sleep( 500 );
		out.low();
	}
	
	private static String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader =
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
}
