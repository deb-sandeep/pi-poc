package com.deb.pi.poc;

import com.tomgibara.bits.BitVector ;

public class BitVectorPOC {

    public static void main( String[] args ) {
        BitVector bus = new BitVector( 8 ) ;
        BitVector b1  = bus.range( 0, 3 ) ;
        BitVector b2  = bus.range( 4, 7 ) ;
        
        b2.setBits( 0, 2, 4 ) ;
        b1.setBits( 0, 8, 4 ) ;
        
        System.out.println( bus ) ;
    }
}
