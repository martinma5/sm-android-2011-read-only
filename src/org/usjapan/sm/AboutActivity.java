package org.usjapan.sm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class AboutActivity extends Activity {
	private AlertDialog mAlert = null;
	private static String mMsg = "Sakura Matsuri App v0.1a\n\n" +
			"Stay tuned for more updates.  If you wish to contrubute " +
	        "please visit https://github.com/martinma5/sm-android.\n\n" +
			"Until then enjoy this neko burrito.";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(mMsg)
        .setCancelable(false)
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	mAlert.hide();
            }
        });
		mAlert = builder.create();
		mAlert.show();
    }
    
    @Override
    public void onStop() {
        super.onStop();
        this.finish();
    }
    
}
