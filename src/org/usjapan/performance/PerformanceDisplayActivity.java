package org.usjapan.performance;

import org.usjapan.sm.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PerformanceDisplayActivity extends Activity {
	
	   private Performance mPerformance = null;
	
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.performance_display);
	        
	        mPerformance = PerformanceListActivity.performancetoshare;
	        
	        
	        TextView meh = (TextView) findViewById(R.id.PerformanceStartTime);
	        meh.setText(mPerformance.getStarttime());

	    }

}
