package org.usjapan.sm;

import org.usjapan.mapview.MyMapActivity;
import org.usjapan.performance.PerformanceListActivity;
import org.usjapan.vender.VenderListActivity;

import com.google.android.maps.MapView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class SmActivity extends Activity {
	

	private final static String mTicketurl= "http://sakuramatsuri.org/";
	private final static String mFacebookurl= "http://www.facebook.com/event.php?eid=299149851418&ref=nf";
	private final static String mTwitterurl= "http://twitter.com/sakuramatsuri";

	
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
		Toast.makeText(this, "hi", Toast.LENGTH_LONG);
    	switch(item.getItemId()){
    	case R.id.showpicmap:
    	    Intent startmap = new Intent(this,MyMapActivity.class);
    		this.startActivity(startmap);
    	    return true;
    	case R.id.showvenders:
    	    Intent startvender = new Intent(this,VenderListActivity.class);
    		this.startActivity(startvender);
    	    return true;
    	case R.id.tickets:
    		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(mTicketurl));
    		this.startActivity(launchBrowser);
    		return true;
    	case R.id.showschedule:
    	    Intent startschedule = new Intent(this,PerformanceListActivity.class);
    		this.startActivity(startschedule);
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