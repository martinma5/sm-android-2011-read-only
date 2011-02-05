package org.usjapan.schedule;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.usjapan.sm.R;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ScheduleListActivity extends ListActivity {
	
	private ArrayAdapter<Performace> aa;
	private ArrayList<Performace> mPerformacelist = new ArrayList<Performace>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        getPerformaces();

        aa = new ArrayAdapter<Performace>(this, android.R.layout.simple_list_item_1, mPerformacelist);        
        setListAdapter(aa);

    }
    
    void getPerformaces(){
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
					
					String performacename = name.getFirstChild().getNodeValue();
					String startime = start.getFirstChild().getNodeValue();
					String endtime = end.getFirstChild().getNodeValue();
					String descstring = desc.getFirstChild().getNodeValue(); 
					
					Performace performance = new Performace(performacename, startime, endtime, descstring);
					addPerformace(performance);
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

    
    private void addPerformace(Performace _aperformace)
    {
    	mPerformacelist.add(_aperformace);
    }

}
