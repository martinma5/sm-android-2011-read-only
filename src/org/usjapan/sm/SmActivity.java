package org.usjapan.sm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class SmActivity extends Activity {
	
	private AlertDialog mAlert = null;
	private static final String mMsg = "Thank you for downloading the 2011 Sakura Matsuri App. We are all saddened by the events of " +
			"the earthquake and tsunami in Japan.  We at JASW wish to encourage you to donate to the American Red Cross Japan Earthquake and Pacific Tsunami Fund." +
			"    Text the word REDCROSS to the number 90999 and confirm.  We thank you for your support";
	private final static String mTicketurl= "http://sakuramatsuri.eventbrite.com/?ref=ebtn";
	private final static String mFacebookurl= "http://www.facebook.com/event.php?eid=299149851418&ref=nf";
	private final static String mTwitterurl= "http://twitter.com/sakuramatsuri";
    private final static String mPerformance = "http://www.sakuramatsuri.org/Images/2011/PDF/Performance%20Script%20Schedule%202011.pdf";
    private final static String mMap = "http://www.sakuramatsuri.org/Images/2011/SeeandDo/MAP_Color.jpg";
    private final static String mSWJ = "http://youtu.be/1YohZFTYntI";
    
    
    private boolean ijustdontcare = true;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        ImageButton facebookbutton = (ImageButton) findViewById(R.id.facebook);
        facebookbutton.setOnClickListener(new OnClickListener() {
        	    public void onClick(View v) {
        	        // Perform action on clicks
        	    	Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(mFacebookurl));
        	    	startActivity(browserIntent);
        	    }
        	});

        final ImageButton twitterbutton = (ImageButton) findViewById(R.id.twitter);
        twitterbutton.setOnClickListener(new OnClickListener() {
        	    public void onClick(View v) {
        	        // Perform action on clicks
        	    	Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(mTwitterurl));
        	    	startActivity(browserIntent);

        	    }
        	});
        
        final ImageButton moviebutton = (ImageButton) findViewById(R.id.hope);
        moviebutton.setOnClickListener(new OnClickListener() {
        	    public void onClick(View v) {
        	        // Perform action on clicks
        	    	Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(mSWJ));
        	    	startActivity(browserIntent);

        	    }
        	});

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(mMsg)
        .setCancelable(false)
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	mAlert.hide();
            }
        });
		mAlert = builder.create();
		if (ijustdontcare){
		    mAlert.show();
		    ijustdontcare = false;
		};
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.sm_activity_menu, menu);
		return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()){
    	case R.id.showpicmap:
    		Intent mapshow = new Intent(Intent.ACTION_VIEW, Uri.parse(mMap));
    		this.startActivity(mapshow);
    		return true;
    	case R.id.tickets:
    		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(mTicketurl));
    		this.startActivity(launchBrowser);
    		return true;
    	case R.id.showschedule:
    		Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, Uri.parse(mPerformance));
    		this.startActivity(launchBrowser2);
    	    return true;
    	case R.id.showabout:
    	    Intent aboutactivity = new Intent(this,AboutActivity.class);
    		this.startActivity(aboutactivity);
    	    return true;
    	default:
    		 return super.onOptionsItemSelected(item);
    	}

    }
    
}