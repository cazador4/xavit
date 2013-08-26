package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

public class MyGestureListener extends ActorGestureListener {
	
	BitmapFont font;
	MyActor actor;
	LabelActor label;
	
	public MyGestureListener(MyActor actor, LabelActor label){
		this.actor = actor;
		this.label = label;
	}
	
	public void fling (InputEvent event, float velocityX, float velocityY, int button) {
		Orientation orientation = getRightMove(velocityX, velocityY);
		//actor.lastKey = actor.getKey(orientation);
		String key = actor.getKey(orientation);
		if(key.equals("ENTER"))
			label.appendText("\n");
		else{
			if(key.equals("<---"))
				label.delete(1);
			else
				label.appendText(key);
		}
			
		
		//System.out.println("Letter: " + actor.getKey(orientation));
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
