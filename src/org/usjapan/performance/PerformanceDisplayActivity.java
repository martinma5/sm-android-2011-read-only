package org.usjapan.performance;

import org.usjapan.sm.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PerformanceDisplayActivity extends Activity {
	
	   private Performance mPerformance = null;
	   private String tweetabouturl = "http://twitter.com/intent/tweet?text=";
	
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.performance_display);

	        mPerformance = PerformanceListActivity.performancetoshare;
	        
	        
	        TextView test = (TextView) this.findViewById(R.id.TextView01);
	        TextView stage = (TextView) this.findViewById(R.id.Stage);
	        TextView starttime = (TextView) this.findViewById(R.id.PerformanceStartTime);
	        test.setText(mPerformance.getName());
	        stage.setText(mPerformance.getStage());
	        starttime.setText(mPerformance.getStarttime());
	        TextView desc = (TextView) this.findViewById(R.id.Description);
	        desc.setText(mPerformance.getDescription());
	        
	        TextView endtime = (TextView) this.findViewById(R.id.PerformanceEndTime);
	        endtime.setText(mPerformance.getEndtime());	        
	    }

}
