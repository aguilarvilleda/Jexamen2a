package com.me.mygdxgame;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture, fondo;
	private Sprite spritefondo;
	private Texture tinicio;//pantalla de inicio del juego
	private Sprite sinicio;//sprite de inicio
	Image botoni;
	Image imagenfondo,i;
	Stage stgpelotitas,s;
	Stage stgfondo,stginicio;
	
	Pelotita p, mipelotita;
	Pelotitamala pm, mipelotitamala;
	Inicio in;
	
	



	
	ArrayList<Pelotita>pelotitas = new ArrayList<Pelotita>();
	int frame = 0;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		int randomw = ((int)(Math.random()*1000%w));
		int randomh = ((int)(Math.random()*1000%h));
		
		
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		fondo = new Texture(Gdx.files.internal("data/Fondo2.png"));
		fondo.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		//spritefondo = new Sprite(fondo);
		//spritefondo.setSize(0f, 0f);
		//spritefondo.setOrigin(spritefondo.getWidth()/2, spritefondo.getHeight()/2);
		//spritefondo.setPosition(-spritefondo.getWidth()/2, -spritefondo.getHeight()/2);
		
		imagenfondo = new Image(fondo);
		stgfondo = new Stage();
		stgfondo.addActor(imagenfondo);
		

		
		mipelotita = new Pelotita (randomw, randomh);
		mipelotitamala = new Pelotitamala(randomw, randomh);
		s = new Stage();
		s.addActor(mipelotita);
		s.addActor(mipelotitamala);

		
		
		stgpelotitas = new Stage();
		
		
		for (int i = 0; i < 5; i++) {
			Pelotita p = new Pelotita(randomw, randomh);
			Pelotitamala pm = new Pelotitamala(randomw, randomh);
			stgpelotitas.addActor(p);
			stgpelotitas.addActor(pm);
		}
		

		
		/*tinicio = new Texture(Gdx.files.internal("data/Play.png"));
		sinicio = new Sprite(tinicio);
		sinicio.setSize(0.2f,0.2f);// * sinicio.getHeight() / sinicio.getWidth());
		sinicio.setOrigin(0,0);
		sinicio.setPosition(-200,500);*/
		in = new Inicio(0,0);
		stginicio = new Stage();
		//botoni = new Image(tinicio);
		
		stginicio.addActor(in);
		
		InputMultiplexer multi = new InputMultiplexer();
		multi.addProcessor(s);
		multi.addProcessor(stginicio);
		Gdx.input.setInputProcessor(multi);
		//Gdx.input.setInputProcessor(stginicio);
		

	}

	@Override
	public void dispose() {

		batch.dispose();
		fondo.dispose();
		stgpelotitas.dispose();
		
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		int randomw = (int)(Math.random()*1000%w);
		int randomh = (int)(Math.random()*1000%h);
		
		batch.setProjectionMatrix(camera.combined);
		//********************************************************************
		batch.begin();
		
		//spritefondo.draw(batch);
		stgfondo.draw();
		s.draw();
		s.act();
		//sinicio.draw(batch);
		
		
		stginicio.draw();
		batch.end();
		
		

		if(frame%30==0)
			s.addActor(new Pelotita(randomw, randomh));
			if(frame%40==0)
				s.addActor(new Pelotitamala(randomw, randomh));
			frame++;
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
