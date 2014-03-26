package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class Milistenerinicio extends InputListener{
	
	Inicio i;

	@Override
public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
	
		i.remove();
		return false;
}
	Milistenerinicio(Inicio inicio)
	{
		super();
		i=inicio;
	}
	
}
