package com.airbach.m.live;

import android.content.Context;
import android.service.wallpaper.WallpaperService;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowManager;

import com.airbach.m.c.C;
import com.airbach.m.util.log.Log;
import com.airbach.m.util.log.LogTag;

public class WallPaperService extends WallpaperService {

	protected LogTag TAG = new LogTag(this.getClass().getName(), this.getClass().getSimpleName(), Thread.currentThread());

	public static int statusBarHeight;

	public static int lcdWidth;
	public static int lcdHeight;

	public static int bgposX;
	public static float xOffset;

	@Override
	public Engine onCreateEngine() {
		return new MusicWallEngine();
	}

	void init() {
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		lcdWidth = display.getWidth();
		lcdHeight = display.getHeight();

		DisplayMetrics displayMetrics = new DisplayMetrics();
		display.getMetrics(displayMetrics);

		switch (displayMetrics.densityDpi) {
			case DisplayMetrics.DENSITY_HIGH:
				statusBarHeight = C.HIGH_DPI_STATUS_BAR_HEIGHT;
				break;
			case DisplayMetrics.DENSITY_MEDIUM:
				statusBarHeight = C.MEDIUM_DPI_STATUS_BAR_HEIGHT;
				break;
			case DisplayMetrics.DENSITY_LOW:
				statusBarHeight = C.LOW_DPI_STATUS_BAR_HEIGHT;
				break;
			default:
				statusBarHeight = C.MEDIUM_DPI_STATUS_BAR_HEIGHT;
				break;
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	public class MusicWallEngine extends Engine {

		Painter painter;

		MusicWallEngine() {
			SurfaceHolder holder = getSurfaceHolder();
			painter = new Painter(holder, getApplicationContext());
		}

		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			setTouchEventsEnabled(true);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
			painter.stopPainting();
		}

		@Override
		public void onVisibilityChanged(boolean visible) {
			if (visible) {
				painter.resumePainting();
			} else {
				painter.pausePainting();
			}
		}

		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			super.onSurfaceChanged(holder, format, width, height);
			Log.d(TAG, "=============== onSurfaceChanged : ");
			painter.setSurfaceSize(width, height);
		}

		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			super.onSurfaceCreated(holder);
			Log.d(TAG, "=============== onSurfaceCreated : ");
			painter.start();
		}

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
			boolean retry = true;
			painter.stopPainting();
			while (retry) {
				try {
					painter.join();
					retry = false;
				} catch (InterruptedException e) {}
			}
		}

		//스크린 갯수가 4개인 경우 xStep = 0.25
		@Override
		public void onOffsetsChanged(float xOffset, float yOffset, float xStep, float yStep, int xPixels, int yPixels) {
			Log.d(TAG, "xOffset : "+xOffset);
			Log.d(TAG, "yOffset : "+yOffset);
			Log.d(TAG, "xStep : "+xStep);
			Log.d(TAG, "yStep : "+yStep);
			Log.d(TAG, "xPixels : "+xPixels);
			Log.d(TAG, "yPixels : "+yPixels);
			bgposX = xPixels;
			WallPaperService.xOffset = xOffset;
			try {

				//	painting.bv.set(xPixels, yPixels);
				painter.draw();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onTouchEvent(MotionEvent event) {
			super.onTouchEvent(event);
			painter.doTouchEvent(event);
		}

	}
}