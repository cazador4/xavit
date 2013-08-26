package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class QwertyApp implements ApplicationListener {
	Texture dropImage;
	Texture bucketImage;
	Texture imgBackground;
	SpriteBatch batch;
	OrthographicCamera camera;
	long lastDropTime;
	MyActor actor1,actor2, actor3, actor4, actor5, actor6, actor7, actor8, actor9, actor10, actor11, actor12;
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
		actor1 = new MyActor("1", "W","@","E","Q");
		actor1.addListener(new MyGestureListener(actor1, label));
		actor2 = new MyActor("2", "T","_","Y","R");
		actor2.addListener(new MyGestureListener(actor2, label));
		actor3 = new MyActor("3", "I","P","O","U");
		actor3.addListener(new MyGestureListener(actor3, label));
		actor11 = new MyActor("11", "<---","","","");
		actor11.addListener(new MyGestureListener(actor11, label));
		
		actor4 = new MyActor("4", "S", "?", "D","A");
		actor4.addListener(new MyGestureListener(actor4, label));
		actor5 = new MyActor("5", "G","!","H","F");
		actor5.addListener(new MyGestureListener(actor5, label));
		actor6 = new MyActor("6", "K","„","L","J");
		actor12 = new MyActor("12", "ENTER","","","");
		actor12.addListener(new MyGestureListener(actor12, label));
		
		actor6.addListener(new MyGestureListener(actor6, label));
		actor7 = new MyActor("7", "X",",","C","Z");
		actor7.addListener(new MyGestureListener(actor7, label));
		actor8 = new MyActor("8", "B",".","N","V");
		actor8.addListener(new MyGestureListener(actor8, label));
		actor9 = new MyActor("9", ";","'","M",":");
		actor9.addListener(new MyGestureListener(actor9, label));
		actor10 = new MyActor("10", "SHIFT","","","");
		actor10.addListener(new MyGestureListener(actor10, label));
		stage = new Stage();
		stage.setViewport(1024, 1024, true);
		int FIRST_LEVEL_Y = 1200;
		int SECOND_LEVEL_Y = 980;
		int THIRD_LEVEL_Y = 760;
		int FIRST_LEVEL_X = 0;
		int SECOND_LEVEL_X = 220;
		int THIRD_LEVEL_X = 440;
		int FORTH_LEVEL_X = 660;
		actor1.setPosition(FIRST_LEVEL_X, FIRST_LEVEL_Y);
		actor2.setPosition(SECOND_LEVEL_X, FIRST_LEVEL_Y);
		actor3.setPosition(THIRD_LEVEL_X, FIRST_LEVEL_Y);
		actor11.setPosition(FORTH_LEVEL_X, FIRST_LEVEL_Y);
		
		actor4.setPosition(FIRST_LEVEL_X, SECOND_LEVEL_Y);
		actor5.setPosition(SECOND_LEVEL_X, SECOND_LEVEL_Y);
		actor6.setPosition(THIRD_LEVEL_X, SECOND_LEVEL_Y);
		actor12.setPosition(FORTH_LEVEL_X, SECOND_LEVEL_Y);
		
		actor7.setPosition(FIRST_LEVEL_X, THIRD_LEVEL_Y);
		actor8.setPosition(SECOND_LEVEL_X, THIRD_LEVEL_Y);
		actor9.setPosition(THIRD_LEVEL_X, THIRD_LEVEL_Y);
		actor10.setPosition(FORTH_LEVEL_X, THIRD_LEVEL_Y);
		
		
		
		
		stage.addActor(actor1);
		stage.addActor(actor2);
		stage.addActor(actor3);
		stage.addActor(actor4);
		stage.addActor(actor5);
		stage.addActor(actor6);
		stage.addActor(actor7);
		stage.addActor(actor8);
		stage.addActor(actor9);
		stage.addActor(actor10);
		stage.addActor(actor11);
		stage.addActor(actor12);
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
