package com.deb.pi.poc;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;

public class SPIShiftRegisterPISO {

	private SpiDevice shiftRegister = null ; 
			
	public SPIShiftRegisterPISO() throws Exception {
		shiftRegister = SpiFactory.getInstance( SpiChannel.CS0 ) ;
	}
	
	public void runTest() throws Exception {
		for( int i=0; i<10; i++ ) {
			byte[] miso = read();
			System.out.println( "Read " + miso.length + " bytes" ) ;
			System.out.println( Integer.toBinaryString( miso[0] ) ) ;
			Thread.sleep( 3000 );
		}
	}
	
	private byte[] read() throws Exception {
		byte dummy = (byte)0xFF ;
		return shiftRegister.write( dummy ) ;
	}

	public static void main(String[] args) throws Exception {

		SPIShiftRegisterPISO driver = new SPIShiftRegisterPISO() ;
		driver.runTest() ;
	}
}
