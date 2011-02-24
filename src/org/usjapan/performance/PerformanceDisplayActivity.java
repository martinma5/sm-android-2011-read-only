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
	        
	        
	        TextView test = (TextView) this.findViewById(R.id.TextView01);
	        TextView stage = (TextView) this.findViewById(R.id.DisplayStage);
	        TextView starttime = (TextView) this.findViewById(R.id.PerformanceStartTime2);
	        test.setText(mPerformance.getName());
	        stage.setText(mPerformance.getStage());
	        starttime.setText(mPerformance.getStarttime());
	        

	    }

}
