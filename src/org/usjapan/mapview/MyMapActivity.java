package org.usjapan.mapview;


import android.os.Bundle;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import org.usjapan.sm.R;

public class MyMapActivity extends MapActivity {
	private MapView mapView = null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        mapView = (MapView) findViewById(R.id.map_view);
        
        mapView.setStreetView(true);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
