package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class LabelActor extends Actor{

	String labelText;
	BitmapFont font;

	public LabelActor(){
		font = new BitmapFont();
		labelText="Su Texto: ";
		font.scale(2);
	}

	public void appendText(String text){
		labelText = labelText.concat(text);
	}

	public void draw (SpriteBatch batch, float parentAlpha) {
		//super.draw(batch, parentAlpha);
		font.drawMultiLine(batch, labelText, getX()+20, getY()+200);
	}

	public void delete(int i) {
		labelText = labelText.substring(0, labelText.length()-i);
	}

}
