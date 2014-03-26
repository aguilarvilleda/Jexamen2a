package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pelotitamala extends Image implements Funciones{
	
	Sound sonido;
	int termina = 0;
	int mh = ((int)(Math.random()*4%21));
	
	Pelotitamala(int x, int y)
	{
		super(new Texture("data/Pelotitamala.png"));
		addListener(new Milistenermala(this));
		setX(x);
		setY(y);
		// TODO Auto-generated constructor stub
	}
	
	public void act(float delta){
	
		setX(getX()+mh);
		setY(getY()+1);
		
		if(getX()>500)
			remove();	
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		sonido = Gdx.audio.newSound(Gdx.files.internal("data//sonidos/game over.mp3"));
		sonido.play();
	}
	
	public void setTermina(int termina){
		this.termina=termina;
	}
	
	public int getTermina(){
		return termina;
	}
}
