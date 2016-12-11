package com.deb.pi.poc;

import org.apache.log4j.Logger ;

public class HelloWorld {
    
    private static final Logger log = Logger.getLogger( HelloWorld.class ) ;

    public static void main( String[] args ) {
        log.debug( "Hello from Pi3" ) ;
    }
}
