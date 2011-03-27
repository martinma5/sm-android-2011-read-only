package org.usjapan.vendor;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

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

public class VendorListActivity extends ListActivity {
	private ArrayAdapter<Vendor> aa;
	private ArrayList<Vendor> mVendorList = new ArrayList<Vendor>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vender_list);
        
        getVendors();
        
        aa = new ArrayAdapter<Vendor>(this, android.R.layout.simple_list_item_1, mVendorList);        
        setListAdapter(aa);
    }

    void getVendors(){
        //TODO:  Need to redesign this more intelligently perhaps using a different method to parse xml
        //       Also need to combine the xml parser from the performance class to avoid repeated code.
        InputStream is = this.getResources().openRawResource(R.raw.vendorlist);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         try {
 			DocumentBuilder db = factory.newDocumentBuilder();
 			Document dom = db.parse(is);
 			Element docElement = dom.getDocumentElement();

 			NodeList n1 = docElement.getElementsByTagName("vendor");

 			if (n1 != null && n1.getLength() > 0)
 			{
 				for (int i = 0; i < n1.getLength(); i++ )
 				{      
 					Element vender = (Element)n1.item(i);
 					Element name = (Element) vender.getElementsByTagName("name").item(0);
 					Element desc = (Element) vender.getElementsByTagName("description").item(0);
 					Element type = (Element) vender.getElementsByTagName("type").item(0);
 					Element web = (Element) vender.getElementsByTagName("webpage").item(0);
 					
 					String vendorstring = name.getFirstChild().getNodeValue();
 					String descstring = desc.getFirstChild().getNodeValue();
 					String typestring = type.getFirstChild().getNodeValue();
 					String webstring = web.getFirstChild().getNodeValue();

 					Vendor performance = new Vendor(vendorstring, descstring, typestring, webstring);
 					addVendor(performance);
 				}
 			}
 			
 		} catch (ParserConfigurationException e) {
 			e.printStackTrace();
 		} catch (SAXException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
     }; // end void getPerformaces

     private void addVendor(Vendor _vendor)
     {
    	 mVendorList.add(_vendor);
     }
}
