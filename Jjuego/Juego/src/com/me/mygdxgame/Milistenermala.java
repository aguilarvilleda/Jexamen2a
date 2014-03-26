package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Milistenermala extends InputListener {

	Pelotitamala pm;	
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		
		System.out.println("Probando");
		pm.remove();
	
		pm.play();
		System.out.println(Math.random());
		System.exit(0);
		return false;
	}
	
	Milistenermala(Pelotitamala param) 
	{
		super();
		pm=param;
	}
		

}
