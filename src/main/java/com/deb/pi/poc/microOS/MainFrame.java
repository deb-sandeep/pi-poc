package com.deb.pi.poc.microOS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame implements KeyListener {

	JFrame frame = null;
	JPanel panel = null;
	JTextArea area = null;
	
	public MainFrame() {
		setUpUI();
	}
	
	private void setUpUI() {
		setUpFrame();
		setUpPanel();
		addPanelToFrame();
	}
	
	public void show() {
		frame.setVisible( true );
	}

	private void setUpFrame() {
		frame = new JFrame();		
		frame.setSize( 370, 175 );
		frame.setResizable( false );
		frame.setLocationRelativeTo( null );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	private void setUpPanel() {
		panel = new JPanel();
		panel.setBackground( new Color( 220, 255, 120 ) );
		setUpTextArea();
		addTextAreaToPanel();
	}

	private void setUpTextArea() {
		area = new JTextArea( 4, 20 );
		area.setLineWrap( true );
		area.setWrapStyleWord( false );
		area.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 30 ) );
		area.setBackground( new Color( 220, 255, 120 ) );
		area.setCaretColor( new Color( 220, 255, 120 ) );
	}

	private void addTextAreaToPanel() {
		panel.add( area );
	}
	
	private void addPanelToFrame() {
		frame.setContentPane( panel );
	}
	
	public static void main( String[] args ) {
		MainFrame frame = new MainFrame();
		frame.show();
	}

	public void keyTyped( KeyEvent e ) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed( KeyEvent e ) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased( KeyEvent e ) {
		// TODO Auto-generated method stub
		
	}

}
