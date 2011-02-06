package org.usjapan.vendor;

import java.util.ArrayList;

import org.usjapan.sm.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class VendorListActivity extends ListActivity {
	private ArrayAdapter<Vendor> aa;
	private ArrayList<Vendor> mVendorList = new ArrayList<Vendor>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vender_list);
        
        aa = new ArrayAdapter<Vendor>(this, android.R.layout.simple_list_item_1, mVendorList);        
        setListAdapter(aa);

    }
}
