package com.airbach.m.chart.bean;

public class FourSharedBean {

	public String name = "";
	public String downloadsCount = "";
	public String pageurl = "";
	public String previewurl = "";
	public String size = "";
	
	@Override
	public String toString() {
		StringBuffer returnThis = new StringBuffer();
		returnThis
			.append("\t\t\t\t<FourSharedBean>\n")
			.append("\t\t\t\t\t<name><![CDATA[").append(name).append("]]></name>\n")
			.append("\t\t\t\t\t<downloadsCount>").append(downloadsCount).append("</downloadsCount>\n")
			.append("\t\t\t\t\t<pageurl><![CDATA[").append(pageurl).append("]]></pageurl>\n")
			.append("\t\t\t\t\t<previewurl><![CDATA[").append(previewurl).append("]]></previewurl>\n")
			.append("\t\t\t\t\t<size>").append(size).append("</size>\n")
			.append("\t\t\t\t</FourSharedBean>\n");
		return returnThis.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDownloadsCount() {
		return downloadsCount;
	}

	public void setDownloadsCount(String downloadsCount) {
		this.downloadsCount = downloadsCount;
	}

	public String getPageurl() {
		return pageurl;
	}

	public void setPageurl(String pageurl) {
		this.pageurl = pageurl;
	}

	public String getPreviewurl() {
		return previewurl;
	}

	public void setPreviewurl(String previewurl) {
		this.previewurl = previewurl;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
	
}
