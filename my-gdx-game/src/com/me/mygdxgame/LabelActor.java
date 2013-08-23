package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class LabelActor extends Actor{

	String labelText;
	BitmapFont font;

	public LabelActor(){
		font = new BitmapFont();
	}

	public void appendText(String text){
		labelText = labelText.concat(text);
	}

	public void draw (SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		font.draw(batch, labelText, getX()+20, getY()+50);
	}

}
