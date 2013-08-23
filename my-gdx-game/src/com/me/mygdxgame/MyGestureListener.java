package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

public class MyGestureListener extends ActorGestureListener {
	
	BitmapFont font;
	MyActor actor;
	
	public MyGestureListener(MyActor actor){
		this.actor = actor;
	}
	
	public void fling (InputEvent event, float velocityX, float velocityY, int button) {
		Orientation orientation = getRightMove(velocityX, velocityY);
		actor.lastKey = actor.getKey(orientation);
		actor.setText(actor.getKey(orientation));
		System.out.println("Letter: " + actor.getKey(orientation));
	}
	
	private Orientation getRightMove(float velocityX, float velocityY){
		if( Math.abs(velocityX) > Math.abs(velocityY) ){
			if(velocityX>0)
				return Orientation.EAST;
			else
				return Orientation.WEST;
		}
		else{
			if(velocityY>0)
				return Orientation.NORTH;
			else
				return Orientation.SOUTH;
		}
	}
	
	
	enum Orientation{
		NORTH, SOUTH, EAST, WEST
	}

}
