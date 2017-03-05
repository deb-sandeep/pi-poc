package com.deb.pi.poc.listeners;

public class ButtonEvent {
	
	private ButtonType buttonType = null;
	
	public static enum ButtonType { 
		BUTTON_LEFT,
		BUTTON_OK,
		BUTTON_RIGHT 
	}
	
	public ButtonEvent( ButtonType buttonType ) {
		this.buttonType = buttonType;
	}
	
	public ButtonType getButtonType() {
		return buttonType;
	}

}
