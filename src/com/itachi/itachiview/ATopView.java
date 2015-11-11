package com.itachi.itachiview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public abstract class ATopView extends View {

	public ATopView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ATopView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ATopView(Context context) {
		super(context);
	}

	private ThreadU mThread;
	
	public abstract void drawCanvas(Canvas canvas);
	
	public abstract void runView();
	
	public abstract void  init();
	

	@Override
	protected void onDraw(Canvas canvas) {
		
		if (mThread == null) {
			mThread = new ThreadU();
			mThread.start();
		}else{
			drawCanvas(canvas);
			
		}
	}
@Override
protected void onDetachedFromWindow() {

	isRun=false;
	super.onDetachedFromWindow();
}
	private boolean isRun=true;
	class ThreadU extends Thread {

		@Override
		public void run() {
			init();
			while (isRun) {
				runView();
				postInvalidate();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		
	}

}
