package com.deb.pi.poc;

import com.pi4j.component.lcd.impl.I2CLcdDisplay ;
import com.pi4j.io.i2c.I2CBus ;

public class I2CLCDUsingPi4J {

    public static void main( String[] args ) throws Exception {
        I2CLcdDisplay lcd = new I2CLcdDisplay( 4, 20, I2CBus.BUS_1, 0x27, 
                                               3, 0, 1, 2, 7, 6, 5, 4 ) ;
        
        lcd.setCursorHome() ;
        lcd.clear() ;
        
        lcd.write( 0, " Please set board" ) ;
        lcd.write( 1, " and confirm." ) ;
        lcd.write( 3,"    [OK]  [CANCEL]   " ) ;
        Thread.sleep( 5000 ) ;
        lcd.clear() ;
        lcd.setCursorHome() ;
        for( int i=0; i<4; i++ ) {
            lcd.write( i, "This is row " + i ) ;
            Thread.sleep( 1000 ) ;
        }
        for( int i=0; i<4; i++ ) {
            lcd.clear( i ) ;
            Thread.sleep( 1000 ) ;
        }
        lcd.clear() ;
        lcd.write( 0, "01234567890123456789" );
        lcd.write( 1, "abcdefghijklmnopqrst" );
        lcd.write( 2, "uvwxyzABCDEFGHIJKLMN" );
        lcd.write( 3, "OPQRSTUVWXYZ"         );
        Thread.sleep( 2000 ) ;
        lcd.clear() ;
        
        lcd.write( 1, "      Thinking" );        
    }
}
