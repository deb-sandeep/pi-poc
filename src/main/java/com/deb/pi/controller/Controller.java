package com.deb.pi.controller;

import com.deb.pi.controller.command.*;
import java.util.Scanner;

import com.pi4j.io.gpio.*;

public class Controller {
    
    public static final GpioController gpio = GpioFactory.getInstance();
    
    public static final GpioPinDigitalOutput pin0  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_00, "pin0", PinState.LOW );
    public static final GpioPinDigitalOutput pin1  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_01, "pin1", PinState.LOW );
    public static final GpioPinDigitalOutput pin2  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_02, "pin2", PinState.LOW );
    public static final GpioPinDigitalOutput pin3  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_03, "pin3", PinState.LOW );
    public static final GpioPinDigitalOutput pin4  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_04, "pin4", PinState.LOW );
    public static final GpioPinDigitalOutput pin5  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_05, "pin5", PinState.LOW );
    public static final GpioPinDigitalOutput pin6  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_06, "pin6", PinState.LOW );
    public static final GpioPinDigitalOutput pin7  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_07, "pin7", PinState.LOW  );
    public static final GpioPinDigitalOutput pin8  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_08, "pin8", PinState.LOW  );
    public static final GpioPinDigitalOutput pin9  = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_09, "pin9", PinState.LOW  );
    public static final GpioPinDigitalOutput pin10 = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_10, "pin10", PinState.LOW );
    public static final GpioPinDigitalOutput pin11 = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_11, "pin11", PinState.LOW );
    public static final GpioPinDigitalOutput pin12 = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_12, "pin12", PinState.LOW );
    public static final GpioPinDigitalOutput pin13 = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_13, "pin13", PinState.LOW );
    public static final GpioPinDigitalOutput pin14 = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_14, "pin14", PinState.LOW );
    public static final GpioPinDigitalOutput pin15 = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_15, "pin15", PinState.LOW );
    public static final GpioPinDigitalOutput pin16 = gpio.provisionDigitalOutputPin( RaspiPin.GPIO_16, "pin16", PinState.LOW );
    
    public static final GpioPinDigitalOutput[] pins = new GpioPinDigitalOutput[]{
                                             pin0, 
                                             pin1, 
                                             pin2,
                                             pin3,
                                             pin4,
                                             pin5,
                                             pin6,
                                             pin7,
                                             pin8,
                                             pin9,
                                             pin10,
                                             pin11,
                                             pin12,
                                             pin13,
                                             pin14,
                                             pin15,
                                             pin16
                                         } ;                                                                                         
    
    public static void main( String args[] ) throws Exception{
        
        final Scanner sc = new Scanner( System.in );

        while( true ) {
            
            System.out.print( "> " );
            String input = sc.nextLine();

            if( input.equals( "quit" ) ) {
                for( GpioPinDigitalOutput pin : pins ) {
                    pin.low();
                    gpio.unprovisionPin( pin );
                }
                gpio.shutdown();
                System.exit( 1 );
            }
                
            String command = Parser.getCommand( input );
            Parameter[] parameters = Parser.getParameters( input );
                        
            for( Command c : Commands.commands ) {
                if( c.getName().equals( command ) ) {
                    c.execute( parameters );
                }
            }
        }            
    }
}
