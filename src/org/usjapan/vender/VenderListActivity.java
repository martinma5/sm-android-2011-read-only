package org.usjapan.vender;

import java.util.ArrayList;

import org.usjapan.sm.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class VenderListActivity extends ListActivity {
	private ArrayAdapter<Vender> aa;
	private ArrayList<Vender> mVenderList = new ArrayList<Vender>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vender_list);
        
        aa = new ArrayAdapter<Vender>(this, android.R.layout.simple_list_item_1, mVenderList);        
        setListAdapter(aa);

    }
}
