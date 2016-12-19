package com.deb.pi.poc;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public class LCDI2COutput {

	public static void main(String[] args) throws UnsupportedBusNumberException, IOException, InterruptedException {
		I2CBus bus = I2CFactory.getInstance( I2CBus.BUS_1 );
		I2CDevice device = bus.getDevice( 0x27 );
		
		device.write( (byte)1 );
	}
}
