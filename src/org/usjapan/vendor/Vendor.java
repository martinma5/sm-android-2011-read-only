package org.usjapan.vender;

public class Vender {
	private String mName;
	private String mType;
	private String mDescription;

	public Vender(String mName, String mType, String mDescription) {
		super();
		this.mName = mName;
		this.mType = mType;
		this.mDescription = mDescription;
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

	

}
