package org.usjapan.performance;

public class Performance {
	private String mName;
	private String mStarttime;
	private String mEndtime;
	private String mDescription;
	private String mType;
	private String mStage;


	public Performance(String performancename, String startime, String endtime,
			String descstring, String typestring, String thestage) {
		mName = performancename;
		mStarttime = startime;
		mEndtime = endtime;
		mDescription = descstring;
        mType = typestring;
        mStage = thestage;
	}

	public String getName() {return mName;}
	public String getStarttime() {return mStarttime;}
	public String getEndtime() {return mEndtime;}
	public String getDescription() {return mDescription;}
	public String getType() {return mType;}
	public String getStage() {return mStage;}


	public void setEndtime(String endtime) {this.mEndtime = endtime;}
	public void setStarttime(String starttime) {this.mStarttime = starttime;}
	public void setName(String name) {this.mName = name;}
	public void setDescription(String description) {this.mDescription = description;}
	public void setType(String mType) {this.mType = mType;}
	public void setStage(String mStage) {this.mStage = mStage;}

	@Override
	public String toString() {
		return mStarttime + "-" + mEndtime + ":" + mName;
	}


	
}
