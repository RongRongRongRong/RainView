package com.itachi.itachiview;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;

public class RainView extends ATopView {

    private ArrayList<SingleRain> hardRain;
	private SingleRain rainDrop;
	int rainNum=80;
    
	public RainView(Context context) {
		super(context);
		
	}

	@Override
	public void drawCanvas(Canvas canvas) {
		for (SingleRain i : hardRain) {
			i.drawDrop(canvas);
		}
		
	}

	@Override
	public void runView() {
		for (SingleRain i : hardRain) {
			i.dropMove();
		}

	}

	@Override
	public void init() {
		hardRain=new ArrayList<SingleRain>();
		for (int i=0;i<rainNum ;i++) {
			rainDrop=new SingleRain(getWidth(), getHeight());
			hardRain.add(rainDrop);
		}
		
	}

}
