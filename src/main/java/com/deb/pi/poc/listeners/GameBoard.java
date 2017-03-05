package com.deb.pi.poc.listeners;

import com.deb.pi.poc.listeners.ButtonEvent.ButtonType;

public class GameBoard {
	
	private ButtonListener bListener = null;
	
	public void setbListener(ButtonListener bListener) {
		this.bListener = bListener;
	}
	
	public void throwEvent( ButtonType bType ) {
		// called when a button on the board is pressed!
		if( bListener != null ) {
			bListener.onButtonClicked( new ButtonEvent( bType ) );
		}
	}

}
