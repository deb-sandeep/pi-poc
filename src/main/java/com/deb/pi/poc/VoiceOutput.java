package com.deb.pi.poc;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.*;

public class VoiceOutput {

	public static void main(String[] args) throws Exception {
		
		Player player = new Player( 
							new FileInputStream( 
								new File( 
									"/home/pi/Avicii - The Days (Lyric Video).mp3" 
								) 
							) 
						);
		player.play();
		if( player.isComplete() ) {
			player.close();
		}
	}
}
