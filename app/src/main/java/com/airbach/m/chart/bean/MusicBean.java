package com.airbach.m.chart.bean;

import java.util.ArrayList;

public class MusicBean {
	
	public String rank = "";
	public String title = "";
	public String artist = "";
	public String album = "";
	public String state = "";
	public String statemargin = "";
	public String imgname = "";
	public String imgurl = "";
	public String lastRank = "";
	
	public ArrayList<YouTubeMediaBean> ytBeans = new ArrayList<YouTubeMediaBean>();
	public ArrayList<YouTubeMediaBean> rBeans = new ArrayList<YouTubeMediaBean>();
	public ArrayList<FourSharedBean> fBeans = new ArrayList<FourSharedBean>();
	
	@Override
	public String toString() {
		StringBuffer returnThis = new StringBuffer();
		returnThis
			.append("\t\t<MusicBean>\n")
				.append("\t\t\t<rank>").append(rank).append("</rank>\n")
				.append("\t\t\t<title><![CDATA[").append(title).append("]]></title>\n")
				.append("\t\t\t<artist><![CDATA[").append(artist).append("]]></artist>\n")
				.append("\t\t\t<album><![CDATA[").append(album).append("]]></album>\n")
				.append("\t\t\t<state>").append(state).append("</state>\n")
				.append("\t\t\t<statemargin>").append(statemargin).append("</statemargin>\n")
				.append("\t\t\t<imgname><![CDATA[").append(imgname).append("]]></imgname>\n")
				.append("\t\t\t<imgurl><![CDATA[").append(imgurl).append("]]></imgurl>\n")
				.append("\t\t\t<lastRank><![CDATA[").append(lastRank).append("]]></lastRank>\n")
				.append("\t\t\t<ytBeans>\n");
					for(YouTubeMediaBean ytBean : ytBeans) 
						returnThis.append(ytBean);
				returnThis.append("\t\t\t</ytBeans>\n")
				.append("\t\t\t<rBeans>\n");
					for(YouTubeMediaBean ytBean : rBeans) 
						returnThis.append(ytBean);
				returnThis.append("\t\t\t</rBeans>\n")
				.append("\t\t\t<fBeans>\n");
					for(FourSharedBean fBean : fBeans) 
						returnThis.append(fBean);
				returnThis.append("\t\t\t</fBeans>\n")
			.append("\t\t</MusicBean>\n");
		return returnThis.toString();
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatemargin() {
		return statemargin;
	}

	public void setStatemargin(String statemargin) {
		this.statemargin = statemargin;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	public String getLastRank() {
		return lastRank;
	}

	public void setLastRank(String lastRank) {
		this.lastRank = lastRank;
	}

	public ArrayList<YouTubeMediaBean> getYtBeans() {
		return ytBeans;
	}

	public void setYtBeans(ArrayList<YouTubeMediaBean> ytBeans) {
		this.ytBeans = ytBeans;
	}

	public ArrayList<YouTubeMediaBean> getrBeans() {
		return rBeans;
	}

	public void setrBeans(ArrayList<YouTubeMediaBean> rBeans) {
		this.rBeans = rBeans;
	}

	public ArrayList<FourSharedBean> getfBeans() {
		return fBeans;
	}

	public void setfBeans(ArrayList<FourSharedBean> fBeans) {
		this.fBeans = fBeans;
	}
	
	
}
