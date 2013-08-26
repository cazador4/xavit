package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.me.mygdxgame.MyGestureListener.Orientation;

public class MyActor extends Actor {
    static TextureRegion region;
    String name;
    String north,south,east,west;
    BitmapFont font;
    String lastKey="";
    
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
    
    public MyActor (String name, String n, String s, String e, String w) {
    		font = new BitmapFont();
    		this.name = name;
    		north = n;
    		south = s;
    		east = e;
    		west = w;
            if(region==null)
            	region = new TextureRegion(new Texture(Gdx.files.internal("actor.png")));
            setWidth(200);
            setHeight(200);
            setPosition(0, 0);
    }

    public void draw (SpriteBatch batch, float parentAlpha) {
            //super.draw(batch, parentAlpha);
            batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
                    getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
            font.setScale(3);
            font.draw(batch, north, getX()+80, getY()+190);
            if(!south.equals(" "))
            	font.draw(batch, south, getX()+80, getY()+40);
            else
            	font.draw(batch, "espacio", getX()+10, getY()+40);
            font.draw(batch, east, getX()+150, getY()+110);
            font.draw(batch, west, getX()+10, getY()+110);
            //font.draw(batch, lastKey, getX()+20, getY()+50);    
    }
}