package com.airbach.m.chart.bean;

public class YouTubeMediaBean {

	public String ytTitle = "";
	public long ytFCount = 0;
	public long ytVCount = 0;
	public long ytDuration = 0;
	public String ytWPUrl = "";
	public String ytVId = "";
	public String ytThumbUrl = "";
	
	@Override
	public String toString() {
		StringBuffer returnThis = new StringBuffer();
		returnThis
			.append("\t\t\t\t<YouTubeMediaBean>\n")
			.append("\t\t\t\t\t<ytTitle><![CDATA[").append(ytTitle).append("]]></ytTitle>\n")
			.append("\t\t\t\t\t<ytFCount>").append(ytFCount).append("</ytFCount>\n")
			.append("\t\t\t\t\t<ytVCount>").append(ytVCount).append("</ytVCount>\n")
			.append("\t\t\t\t\t<ytDuration>").append(ytDuration).append("</ytDuration>\n")
			.append("\t\t\t\t\t<ytWPUrl><![CDATA[").append(ytWPUrl).append("]]></ytWPUrl>\n")
			.append("\t\t\t\t\t<ytVId>").append(ytVId).append("</ytVId>\n")
			.append("\t\t\t\t\t<ytThumbUrl><![CDATA[").append(ytThumbUrl).append("]]></ytThumbUrl>\n")
			.append("\t\t\t\t</YouTubeMediaBean>\n");
		return returnThis.toString();
	}

	public String getYtTitle() {
		return ytTitle;
	}

	public void setYtTitle(String ytTitle) {
		this.ytTitle = ytTitle;
	}

	public long getYtFCount() {
		return ytFCount;
	}

	public void setYtFCount(long ytFCount) {
		this.ytFCount = ytFCount;
	}

	public long getYtVCount() {
		return ytVCount;
	}

	public void setYtVCount(long ytVCount) {
		this.ytVCount = ytVCount;
	}

	public long getYtDuration() {
		return ytDuration;
	}

	public void setYtDuration(long ytDuration) {
		this.ytDuration = ytDuration;
	}

	public String getYtWPUrl() {
		return ytWPUrl;
	}

	public void setYtWPUrl(String ytWPUrl) {
		this.ytWPUrl = ytWPUrl;
	}

	public String getYtVId() {
		return ytVId;
	}

	public void setYtVId(String ytVId) {
		this.ytVId = ytVId;
	}

	public String getYtThumbUrl() {
		return ytThumbUrl;
	}

	public void setYtThumbUrl(String ytThumbUrl) {
		this.ytThumbUrl = ytThumbUrl;
	}
	
	
	
}
