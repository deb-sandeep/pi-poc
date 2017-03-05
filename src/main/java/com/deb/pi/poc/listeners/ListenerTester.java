package com.deb.pi.poc.listeners;

import com.deb.pi.poc.listeners.ButtonEvent.ButtonType;

public class ListenerTester {

	public static void main(String[] args) {
		GameBoard gBoard = new GameBoard();
		gBoard.setbListener( new ButtonListener() {
			
			@Override
			public void onButtonClicked(ButtonEvent e) {
				System.out.println( "Clicked!" );
				System.out.println( "Button type = " + e.getButtonType().toString() );
			}
		} );
		
		gBoard.throwEvent( ButtonType.BUTTON_LEFT );
		gBoard.throwEvent( ButtonType.BUTTON_OK );
		gBoard.throwEvent( ButtonType.BUTTON_RIGHT );
	}

}
