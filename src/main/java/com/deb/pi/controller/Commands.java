package com.deb.pi.controller;

import com.deb.pi.controller.command.*;

public class Commands {
    
    public static final Command HIGH = new High();
    public static final Command LOW  = new Low();
    
    public static final Command[] commands = new Command[]{ HIGH, LOW };
    
}
