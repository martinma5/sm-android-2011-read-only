package org.usjapan.performance;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.usjapan.sm.R;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PerformanceListActivity extends ListActivity implements OnClickListener {
	
	private CustomPerformanceAdapter aa;
	private HashMap<String, ArrayList<Performance>> mPerforhash = new HashMap<String, ArrayList<Performance>>();
	private String mCurrentStage = null;
	public static Performance performancetoshare = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.performance_list);
        
		TextView Stage = (TextView) this.findViewById(R.id.ButtonJoin);
		
		
        Stage.setOnClickListener(this);

        getPerformaces();
        mCurrentStage = "Stage1";
        aa = new CustomPerformanceAdapter(this, android.R.layout.simple_list_item_1, R.layout.performance_row, mPerforhash.get(mCurrentStage));
        setListAdapter(aa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.performance_stage_menu, menu);
		return true;
    }

    //TODO: This might be going away
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()){
    	case R.id.Stage1:
    		switchStage("Stage1");
    	    return true;
    	case R.id.Stage2:
    		switchStage("Stage2");
    	    return true;
    	case R.id.Stage3:
    	    return true;
    	case R.id.Stage4:
    	    return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }

    
    private void switchStage(String items)
    {
    	if (!mCurrentStage.equalsIgnoreCase(items))
    	{
    		mCurrentStage = items;
    		aa.clear();
    		for (Performance aPerformance: mPerforhash.get(mCurrentStage))
    			aa.add(aPerformance);
    		aa.notifyDataSetChanged();
    	}
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	performancetoshare = mPerforhash.get(mCurrentStage).get(position);
	    Intent performancedetail = new Intent(this,PerformanceDisplayActivity.class);
		this.startActivity(performancedetail);
    	super.onListItemClick(l, v, position, id);
    }
    
    void getPerformaces(){
    	
       //TODO:  Need to redesign this more intelligently perhaps using a different method to parse xml
       //       Also need to combine the xml parser from the vendors and this to avoid repeated code.
       InputStream is = this.getResources().openRawResource(R.raw.performance_schedule);
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
			DocumentBuilder db = factory.newDocumentBuilder();
			Document dom = db.parse(is);
			Element docElement = dom.getDocumentElement();

			NodeList n1 = docElement.getElementsByTagName("performance");

			if (n1 != null && n1.getLength() > 0)
			{
				for (int i = 0; i < n1.getLength(); i++ )
				{      
					Element permformace = (Element)n1.item(i);
					Element name = (Element) permformace.getElementsByTagName("name").item(0);
					Element start = (Element) permformace.getElementsByTagName("starttime").item(0);
					Element end = (Element) permformace.getElementsByTagName("endtime").item(0);
					Element desc = (Element) permformace.getElementsByTagName("description").item(0);
					Element type = (Element) permformace.getElementsByTagName("type").item(0);
					Element stage = (Element) permformace.getElementsByTagName("stage").item(0);
					
					String performacename = name.getFirstChild().getNodeValue();
					String startime = start.getFirstChild().getNodeValue();
					String endtime = end.getFirstChild().getNodeValue();
					String descstring = desc.getFirstChild().getNodeValue(); 
					String typestring = type.getFirstChild().getNodeValue();
					String stagestring = stage.getFirstChild().getNodeValue();
					
					Performance performance = new Performance(performacename, startime, endtime, descstring, typestring, stagestring);
					addPerformace(performance, stagestring);
				}
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }; // end void getPerformaces

    
    private void addPerformace(Performance _aperformace, String stage)
    {
    	if (mPerforhash.get(stage) == null)
    	{
    		mPerforhash.put(stage, new ArrayList<Performance>());
    	}
    	mPerforhash.get(stage).add(_aperformace);
    }

    public class CustomPerformanceAdapter extends ArrayAdapter<Performance>{
    	
    	private ArrayList<Performance> mList;

		public CustomPerformanceAdapter(Context context, int resource,
				int textViewResourceId, ArrayList<Performance> PerformanceList) {
			super(context, resource, textViewResourceId, PerformanceList);
			mList = PerformanceList;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null )
			{
				LayoutInflater inflater=getLayoutInflater();
				convertView =  inflater.inflate(R.layout.performance_row, parent, false);
			}
			TextView PerStartTime = (TextView) convertView.findViewById(R.id.PerformanceStartTime);
			TextView PerEndTime = (TextView) convertView.findViewById(R.id.PerformanceEndTime);
			TextView PerName = (TextView) convertView.findViewById(R.id.PerformanceName);
			TextView PerType = (TextView) convertView.findViewById(R.id.PerformanceType);
			PerStartTime.setText(mList.get(position).getStarttime());
			PerEndTime.setText(mList.get(position).getEndtime());
			PerName.setText(mList.get(position).getName());
			PerType.setText(mList.get(position).getType());
			return convertView;
			
		}
    }

	@Override
	public void onClick(View v) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("Pick a Stage");
		//TODO:  This should not be hardcoded like this.
		final CharSequence[] items = {"Stage1", "Stage2", "Stage3"};

		alertDialog.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	switchStage((String) items[item]);
		    }
		});
		AlertDialog alert = alertDialog.create();
		alert.show();
		
	}
}
