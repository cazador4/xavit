package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame implements ApplicationListener {
	Texture dropImage;
	Texture bucketImage;
	Texture imgBackground;
	SpriteBatch batch;
	OrthographicCamera camera;
	long lastDropTime;
	MyActor actor1,actor2, actor3, actor4, actor5, actor6, actor7;
	Stage stage;
	Texture texture;
	Sprite sprite;
	String text;
	public void setText(String str){
		text = text + str;
	}
	
	@Override
	public void create() {
		text = "";
		LabelActor label = new LabelActor();
		actor1 = new MyActor("1", "A","C","B","D");
		actor1.addListener(new MyGestureListener(actor1, label));
		actor2 = new MyActor("2", "E","G","F","H");
		actor2.addListener(new MyGestureListener(actor2, label));
		actor3 = new MyActor("3", "I","K","J","L");
		actor3.addListener(new MyGestureListener(actor3, label));
		actor4 = new MyActor("4", "M", "O", "N","P");
		actor4.addListener(new MyGestureListener(actor4, label));
		actor5 = new MyActor("5", "Q","S","R","T");
		actor5.addListener(new MyGestureListener(actor5, label));
		actor6 = new MyActor("6", "U","W","V","X");
		actor6.addListener(new MyGestureListener(actor6, label));
		actor7 = new MyActor("7", "Y"," ","Z","@");
		actor7.addListener(new MyGestureListener(actor7, label));
		stage = new Stage();
		stage.setViewport(1024, 1024, true);
		actor1.setPosition(0, 800);
		actor2.setPosition(320, 800);
		actor3.setPosition(640, 800);
		actor4.setPosition(0, 480);
		actor5.setPosition(320, 480);
		actor6.setPosition(640, 480);
		actor7.setPosition(320, 160);
		stage.addActor(actor1);
		stage.addActor(actor2);
		stage.addActor(actor3);
		stage.addActor(actor4);
		stage.addActor(actor5);
		stage.addActor(actor6);
		stage.addActor(actor7);
		stage.addActor(label);
		Gdx.input.setInputProcessor(stage);
		imgBackground = new Texture(Gdx.files.internal("fondo.png"));
		// create the camera and the SpriteBatch
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1024, 1024);
		batch = new SpriteBatch();
	}

	@Override
	public void dispose() {
		imgBackground.dispose();
		stage.dispose();
		batch.dispose();
		
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();		
		batch.end();
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
