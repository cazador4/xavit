package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.me.mygdxgame.MyGestureListener.Orientation;

public class MyActor extends Actor {
    TextureRegion region;
    String name;
    String north,south,east,west;
    BitmapFont font;
    String lastKey="";
    MyGdxGame game;
    
    public String getName(){
    	return name;
    }
    
    public String getKey(Orientation orientation){
    	switch(orientation){
    		case NORTH:
    			return north;
    		case SOUTH:
    			return south;
    		case EAST:
    			return east;
    		case WEST:
    			return west;
    	}
		return "FAIL";
    }
    
    public void setText(String str){
    	game.setText(str);
    }
    
    public MyActor (String name, String n, String s, String e, String w, MyGdxGame game) {
    		font = new BitmapFont();
    		this.name = name;
    		north = n;
    		south = s;
    		east = e;
    		west = w;
            region = new TextureRegion(new Texture(Gdx.files.internal("actor.png")));
            setWidth(300);
            setHeight(300);
            setPosition(0, 0);
            this.game = game;
    }

    public void draw (SpriteBatch batch, float parentAlpha) {
            super.draw(batch, parentAlpha);
            batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
                    getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            font.setScale(3);
            font.draw(batch, north, getX()+135, getY()+290);
            if(!south.equals(" "))
            	font.draw(batch, south, getX()+135, getY()+50);
            else
            	font.draw(batch, "espacio", getX()+75, getY()+50);
            font.draw(batch, east, getX()+250, getY()+170);
            font.draw(batch, west, getX()+20, getY()+170);
            //font.draw(batch, lastKey, getX()+20, getY()+50);    
    }
}