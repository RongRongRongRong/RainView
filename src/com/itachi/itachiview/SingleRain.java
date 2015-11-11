package com.itachi.itachiview;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SingleRain {

	private Random rand ;
	private float startX ;
	private float startY ;
	private float DropXSize;
	private float DropYSize ;
	private float stopX ;
	private float stopY ;
	private float width;
	private float height;
	private Paint paint;

	public SingleRain(int width, int height) {

		this.height = height;
		this.width = width;
		init();
	}

	private void init() {
		rand = new Random();
		paint = new Paint();
		paint.setStrokeWidth(5);
		paint.setColor(Color.WHITE);
		startX = rand.nextInt((int)width);
		startY =  rand.nextInt((int)height);
		DropXSize = 1+rand.nextInt(50);
		DropYSize = DropXSize+rand.nextInt(20);
		stopX = startX + DropXSize;
		stopY = startY + DropYSize;
	}

	public void drawDrop(Canvas canvas) {
		canvas.drawLine(startX, startY, stopX, stopY, paint);
		
	}

	public void dropMove() {
		float opt = 0.5f;
		startX += DropXSize * opt;
		startY += DropYSize * opt;
		stopX += DropXSize * opt;
		stopY += DropYSize * opt;

		if (startX > width || startY > height) {
			init();
		}
	}
}
