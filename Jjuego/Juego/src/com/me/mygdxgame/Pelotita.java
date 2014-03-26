package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pelotita extends Image implements Funciones{
Sound sonido;
/*MoveByAction mover;
int mw = ((int)(Math.random()*1%32));
int mh = ((int)(Math.random()*1%21));
*/
	Pelotita(int x,int y)
	{
		super(new Texture("data/Pelotita1.png"));
		addListener(new Milistener(this));
		setX(x);
		setY(y);
	}
	
	public void act(float delta){
		
		setX(getX()+1.2f);
		if(getX()>500)
			remove();
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		sonido = Gdx.audio.newSound(Gdx.files.internal("data//sonidos/coin.mp3"));
		sonido.play();
	}
}
