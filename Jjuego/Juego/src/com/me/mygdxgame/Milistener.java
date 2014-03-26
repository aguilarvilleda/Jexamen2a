package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Milistener extends InputListener {
	
	Pelotita p;
	
	
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		
		System.out.println("Probando");
		p.remove();
		p.play();
		System.out.println(x+" "+y);
		System.out.println(Math.random());
		return false;
	}

	
	Milistener(Pelotita param)
	{
		super();
		p = param;
	}	
}
