package js.tmpl.abcdef01;

import org.apache.cordova.DroidGap;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

public class MainActivity extends DroidGap {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final int manifestOrientation = getRequestedOrientation();
		setRequestedOrientation(getCurentOrientation());
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				setRequestedOrientation(manifestOrientation);
			}
		}, 3100);
		super.setIntegerProperty("splashscreen", R.drawable.splash);
		super.loadUrl("file:///android_asset/www/index.html", 3000);
	}
	private int getCurentOrientation() {
		Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
		boolean isWide = display.getWidth() >= display.getHeight();
		switch (display.getRotation()) {
		case Surface.ROTATION_0:
			return isWide ? ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE : ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
		case Surface.ROTATION_90:
			return isWide ? ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
					: ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
		case Surface.ROTATION_180:
			return isWide ? ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
					: ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
		case Surface.ROTATION_270:
			return isWide ? ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
					: ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
		}
		return -1;
	}
}
