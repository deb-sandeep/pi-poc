package com.deb.pi.poc;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;

public class SPIShiftRegister {

	public static void main(String[] args) throws Exception {
		
		SpiDevice shiftRegister = SpiFactory.getInstance(SpiChannel.CS0);
		
		shiftRegister.write( (byte)0b10101010 );
		Thread.sleep( 10000 );
	}
}
