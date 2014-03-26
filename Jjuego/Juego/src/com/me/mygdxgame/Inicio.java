package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Inicio extends Image{
	
	Inicio(int x, int y)
	{
		super(new Texture("data/Start.png"));
		addListener(new Milistenerinicio(this));
		setX(x);
		setY(y);
	}

}
