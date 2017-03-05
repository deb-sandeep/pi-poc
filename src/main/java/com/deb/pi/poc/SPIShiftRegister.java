package com.deb.pi.poc;

import java.nio.ByteBuffer;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;

public class SPIShiftRegister {

	private SpiDevice shiftRegister = null ; 
			
	public SPIShiftRegister() throws Exception {
		shiftRegister = SpiFactory.getInstance( SpiChannel.CS0 ) ;
	}
	
	public void runTest() throws Exception {
		clear();
		for( int i=0; i<2048; i++ ) {
			System.out.println( "Writing " + i ) ;
			write( i ) ;
			Thread.sleep( 20 ) ;
		}
		clear() ;
	}
	
	private void clear() throws Exception {
		write( 0 ) ;
	}
	
	private void write( int i ) throws Exception {
		byte[] bytes = ByteBuffer.allocate( 4 ).putInt( i ).array();
		shiftRegister.write( bytes ) ;
	}

	public static void main(String[] args) throws Exception {

		SPIShiftRegister driver = new SPIShiftRegister() ;
		driver.runTest() ;
	}
}
