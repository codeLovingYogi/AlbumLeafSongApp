package sprinkles.mysongapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SongMainActivity extends Activity {
	MediaPlayer mysong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e("Pickle", "inside onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
	}

	@Override
	protected void onResume() {
		Log.e("Pickle", "inside onResume");
		mysong = MediaPlayer.create(this, R.raw.leavingflorida);
		mysong.start();
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.e("Pickle", "inside onPause");
		mysong.stop();
		mysong.release();
		super.onPause();
	}

	// private MediaPlayer mysong;
	//
	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.main_activity);
	//
	// //MediaPlayer mysong = MediaPlayer.create(this, R.raw.leavingflorida);
	// mysong = MediaPlayer.create(this, R.raw.leavingflorida);
	// mysong.start();
	// }
	//
	public void stopSong(View v) {
		if (mysong.isPlaying()) {
			mysong.stop();
			//mysong.release();
		} else {
			mysong.start();
		}
	}

	//
	public void openWS(View v) {
		String url = "http://www.thealbumleaf.com";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}

}
