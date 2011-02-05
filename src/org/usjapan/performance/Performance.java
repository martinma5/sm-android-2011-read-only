package org.usjapan.performance;

public class Performance {
	private String mName;
	private String mStarttime;
	private String mEndtime;
	private String mDescription;

	public Performance(String performancename, String startime, String endtime,
			String descstring) {
		mName = performancename;
		mStarttime = startime;
		mEndtime = endtime;
		mDescription = descstring;
	}

	public String getName() {return mName;}
	public String getStarttime() {return mStarttime;}
	public String getEndtime() {return mEndtime;}
	public String getDescription() {return mDescription;}

	public void setEndtime(String endtime) {this.mEndtime = endtime;}
	public void setStarttime(String starttime) {this.mStarttime = starttime;}
	public void setName(String name) {this.mName = name;}
	public void setDescription(String description) {this.mDescription = description;}


	@Override
	public String toString() {
		return mStarttime + "-" + mEndtime + ":" + mName;
	}
	
}
