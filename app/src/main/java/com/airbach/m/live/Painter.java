package com.airbach.m.live;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.airbach.m.R;
import com.airbach.m.util.BitmapUtil;
import com.airbach.m.util.log.Log;
import com.airbach.m.util.log.LogTag;

public class Painter extends Thread {

	protected LogTag TAG = new LogTag(this.getClass().getName(), this.getClass().getSimpleName(), Thread.currentThread());
	
	/** Reference to the View and the context */
	SurfaceHolder surfaceHolder;
	Context context;

	/** State */
	boolean wait;
	boolean run;

	Bitmap albumArt;
	int bgOffset;

	public Painter(SurfaceHolder surfaceHolder, Context context) {

		this.surfaceHolder = surfaceHolder;
		this.context = context;

		// set default albumart.
		//	albumArt = loadBitmap("http://cfile87.uf.daum.net/image/157AAB384E2FD1D8265EC0");
//		albumArt = loadBitmap("http://cfile108.uf.daum.net/image/1462FF4A4E549A97061A9F");
		albumArt = BitmapUtil.getBitmapFromResource(context, R.drawable.icon);
		Log.d(TAG, "albumArt : "+albumArt);

		// don't animate until surface is created and displayed
		this.wait = true;
	}

	/**
	 * Pauses the livewallpaper animation
	 */
	public void pausePainting() {
		this.wait = true;
		synchronized(this) {
			this.notify();
		}
	}

	/**
	 * Resume the livewallpaper animation
	 */
	public void resumePainting() {
		this.wait = false;
		synchronized(this) {
			this.notify();
		}
	}

	/**
	 * Stop the livewallpaper animation
	 */
	public void stopPainting() {
		this.run = false;
		synchronized(this) {
			this.notify();
		}
	}

	@Override
	public void run() {
		this.run = true;
		while (run) {
			draw();
			// pause if no need to animate
			synchronized (this) {
				if (wait) {
					try {
						wait();
					} catch (Exception e) {}
				}
			}
		}
	}

	/**
	 * Invoke when the surface dimension change
	 *
	 * @param width
	 * @param height
	 */
	public void setSurfaceSize(int width, int height) {
		synchronized(this) {
			this.notify();
		}
	}

	/**
	 * Invoke while the screen is touched
	 *
	 * @param event
	 */
	public void doTouchEvent(MotionEvent event) {
		synchronized(this) {
//			Log.d(TAG, "event.getX() : "+event.getX()+", event.getY() : "+event.getY());
//			Intent i = new Intent(Intent.ACTION_VIEW); 
//			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			i.setData(Uri.parse("http://m.facebook.com/Coupang.korea")); 
//			context.startActivity(i);
		}
	}

	public void draw() {
		Canvas c = null;
		try {
			c = this.surfaceHolder.lockCanvas(null);
			synchronized (this.surfaceHolder) {
				c.drawColor(0xFF000000);
				c.drawBitmap(albumArt, -1*bgOffset*WallPaperService.xOffset, WallPaperService.statusBarHeight, new Paint());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				this.surfaceHolder.unlockCanvasAndPost(c);
			}
		}
	}
	/**
	 * Do the actual drawing stuff
	 *
	 * @param canvas
	 */
	public void doDraw(Canvas canvas) {
		Log.d(TAG, "######################################### draw !!!!!!!!!!!!!!!!!");

		canvas.drawColor(0xFF000000);

		canvas.drawBitmap(albumArt, 0, WallPaperService.statusBarHeight, new Paint());


//        RelativeLayout rl_screen = new RelativeLayout(context); 
//        rl_screen.setGravity(Gravity.CENTER);
//        rl_screen.setBackgroundColor(0xff000000);
//        rl_screen.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
//        
//        ImageView iv = new ImageView(context);
//        iv.setImageBitmap(b);
//        rl_screen.addView(iv);
//        
//        //Measure and layout the linear layout before drawing it
//        rl_screen.measure(MeasureSpec.getSize(rl_screen.getMeasuredWidth()), MeasureSpec.getSize(rl_screen.getMeasuredHeight())+LiveWallpaperService.statusBarHeight);
//        Log.d(TAG, "MeasureSpec.getSize(ll_screen.getMeasuredWidth()) : "+MeasureSpec.getSize(rl_screen.getMeasuredWidth()));
//        Log.d(TAG, "MeasureSpec.getSize(ll_screen.getMeasuredHeight()) : "+MeasureSpec.getSize(rl_screen.getMeasuredHeight())+LiveWallpaperService.statusBarHeight);
//        rl_screen.layout(0, LiveWallpaperService.statusBarHeight, width, height);
//        //Finally draw the linear layout on the canvas
//        rl_screen.draw(canvas);




//		LinearLayout ll_screen = new LinearLayout(context);
//        ll_screen.setGravity(Gravity.CENTER);
//        ll_screen.setBackgroundColor(0xff000000);
//        ll_screen.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
//        
//        bv = new BGView(context);
//        bv.setImageBitmap(b);
//        bv.set(130, 160);
//        ll_screen.addView(bv);
//        
//        //Measure and layout the linear layout before drawing it
//        ll_screen.measure(MeasureSpec.getSize(ll_screen.getMeasuredWidth()), MeasureSpec.getSize(ll_screen.getMeasuredHeight()));
//        Log.d(TAG, "MeasureSpec.getSize(ll_screen.getMeasuredWidth()) : "+MeasureSpec.getSize(ll_screen.getMeasuredWidth()));
//        Log.d(TAG, "MeasureSpec.getSize(ll_screen.getMeasuredHeight()) : "+MeasureSpec.getSize(ll_screen.getMeasuredHeight()));
//        ll_screen.layout(0, 0, width, height);
//        //Finally draw the linear layout on the canvas
//        ll_screen.draw(canvas);





//        LinearLayout ll_screen2 = new LinearLayout(context);
//        ll_screen2.setGravity(Gravity.CENTER);
//        ll_screen2.setBackgroundColor(0x77576757);
//        ll_screen2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
//        
//        //Measure and layout the linear layout before drawing it
//        ll_screen2.measure(MeasureSpec.getSize(ll_screen2.getMeasuredWidth()), MeasureSpec.getSize(ll_screen2.getMeasuredHeight()));
//        Log.d(TAG, "MeasureSpec.getSize(ll_screen2.getMeasuredWidth()) : "+MeasureSpec.getSize(ll_screen2.getMeasuredWidth()));
//        Log.d(TAG, "MeasureSpec.getSize(ll_screen2.getMeasuredHeight()) : "+MeasureSpec.getSize(ll_screen2.getMeasuredHeight()));
//        ll_screen2.layout(0, 0, width, height);
//        //Finally draw the linear layout on the canvas
//        ll_screen2.draw(canvas);

	}



	Bitmap loadBitmap(String url) {
		Bitmap bm = null;
		InputStream is = null;
		BufferedInputStream bis = null;
		try {
			URLConnection conn = new URL(url).openConnection();
			conn.connect();
			is = conn.getInputStream();
			bis = new BufferedInputStream(is, 8192);

			bm = BitmapFactory.decodeStream(bis);

			int width = WallPaperService.lcdWidth;
			int height = WallPaperService.lcdHeight - WallPaperService.statusBarHeight;
			Log.d(TAG, "width : "+width);
			Log.d(TAG, "height : "+height);

			int width_tmp = bm.getWidth();
			int height_tmp = bm.getHeight();
			Log.d(TAG, "width_tmp : "+width_tmp);
			Log.d(TAG, "height_tmp : "+height_tmp);

			float ratio = (float)height/(float)(width*2); //1.67xxx
			Log.d(TAG, "ratio : "+ratio);

			float ratio_tmp = (float)height_tmp/(float)width_tmp;
			Log.d(TAG, "ratio_tmp : "+ratio_tmp);



			if(width_tmp > width || height_tmp > height) {
				if(width_tmp > width && height_tmp > height) {
					if(ratio > ratio_tmp) {//가로기준
						width_tmp = width*2;
						float rtmp = (float)(width*2)/(float)width_tmp;
						height_tmp = (int)((float)width_tmp * rtmp * ratio_tmp);
					} else {//세로기준
						height_tmp = height;
						float rtmp = (float)height/(float)height_tmp;
						width_tmp = (int)((float)height_tmp * rtmp * ratio_tmp);
					}
				} else if(width_tmp > width) {
					width_tmp = 400;
					height_tmp = 400;
				} else if(height_tmp > height) {
					width_tmp = 400;
					height_tmp = 400;
				}
			}
//	        width_tmp = 400;
//	        height_tmp = 400;
			Log.d(TAG, ">>>> width_tmp : "+width_tmp);
			Log.d(TAG, ">>>> height_tmp : "+height_tmp);
			bgOffset = width_tmp - WallPaperService.lcdWidth;
			bm = Bitmap.createScaledBitmap(bm, width_tmp, height_tmp, true);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bm;
	}

	public Bitmap loadBitmap(String url, int scale) {
		Bitmap bm = null;
		InputStream is = null;
		BufferedInputStream bis = null;
		try {
			URLConnection conn = new URL(url).openConnection();
			conn.connect();
			is = conn.getInputStream();
			bis = new BufferedInputStream(is, 8192);
			bm = BitmapFactory.decodeStream(bis);
			return bm;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} catch(OutOfMemoryError oome) {
			scale = scale + 1;
			return loadBitmap(url, scale);
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}




}
