package org.usjapan.vendor;

public class Vendor {
	private String mName;
	private String mType;
	private String mDescription;
	private String webpage;
	
	public Vendor(String mName, String mType, String mDescription, String mWebPage) {
		super();
		this.mName = mName;
		this.mType = mType;
		this.mDescription = mDescription;
		this.webpage = mWebPage;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmName() {
		return mName;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getmType() {
		return mType;
	}
	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}
	public String getmDescription() {
		return mDescription;
	}
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	public String getWebpage() {
		return webpage;
	}
}
