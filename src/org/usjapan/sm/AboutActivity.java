package org.usjapan.sm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class AboutActivity extends Activity {
	private AlertDialog mAlert = null;
	private final static String mMsg = "Sakura Matsuri App v0.1\n\n" +
			"If you wish to contrubute " +
	        "please visit https://github.com/martinma5/sm-android.";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
