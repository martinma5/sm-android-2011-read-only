package org.usjapan.mapview;

import org.usjapan.sm.R;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


public class MyMapActivity extends MapActivity {
	private MapView mapView = null;
	
	private MapController mapController;
	
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
