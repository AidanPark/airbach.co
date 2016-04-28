package com.airbach.m.chart.bean;

public class TwitterBean {

	/*
	 * 
		"completed_in":0.125
		,"max_id":168625599802384384
		,"max_id_str":"168625599802384384"
		,"next_page":"?page=2&max_id=168625599802384384&q=%EB%B9%84%EC%8A%A4%ED%8A%B8&lang=ko&rpp=10"
		,"page":1,"query":"%EB%B9%84%EC%8A%A4%ED%8A%B8"
		,"refresh_url":"?since_id=168625599802384384&q=%EB%B9%84%EC%8A%A4%ED%8A%B8&lang=ko"
		,"results":[

			"created_at":"Sun, 12 Feb 2012 09:20:50 +0000"
			,"from_user":"LYYYSJ"
			,"from_user_id":243614738
			,"from_user_id_str":"243614738"
			,"from_user_name":"\u266596\uC0C1\uD07C\uC774\uB07C\uC73C\uB2C8\u2665"
			,"geo":null
			,"id":168625599802384384
			,"id_str":"168625599802384384"
			,"iso_language_code":"ko"
			,"metadata":{"result_type":"recent"}
			,"profile_image_url":"http://a0.twimg.com/profile_images/1819536435/________normal.jpg"
			,"profile_image_url_https":"https://si0.twimg.com/profile_images/1819536435/________normal.jpg"
			,"source":"&lt;a href=&quot;http://twitter.com/download/android&quot; rel=&quot;nofollow&quot;&gt;Twitter for Android&lt;/a&gt;"
			,"text":"RT @B2uty_story: \uBE44\uC2A4\uD2B8 \uD32C=\uBDF0\uD2F0 full=\uAC00\uB4DD\uCC2C \uC1FC=show \uBDF0\uD2F0\uD480\uC1FC!!!!!!\uADF8\uB798\uC11C \uBDF0\uD2F0\uD480\uC1FC \uC600\uB124\uC694!!!!!!"
			,"to_user":null
			,"to_user_id":null
			,"to_user_id_str":null
			,"to_user_name":null
	 */
	public String created_at = "";
	public String from_user = "";
	public String from_user_id = "";
	public String from_user_name = "";
	public String id = "";
	public String profile_image_url = "";
	public String text = "";
	
	@Override
	public String toString() {
		StringBuffer returnThis = new StringBuffer();
		returnThis
			.append("\t\t\t\t<TwitterBean>\n")
			.append("\t\t\t\t\t<created_at><![CDATA[").append(created_at).append("]]></created_at>\n")
			.append("\t\t\t\t\t<from_user>").append(from_user).append("</from_user>\n")
			.append("\t\t\t\t\t<from_user_id>").append(from_user_id).append("</from_user_id>\n")
			.append("\t\t\t\t\t<from_user_name>").append(from_user_name).append("</from_user_name>\n")
			.append("\t\t\t\t\t<id><![CDATA[").append(id).append("]]></id>\n")
			.append("\t\t\t\t\t<profile_image_url>").append(profile_image_url).append("</profile_image_url>\n")
			.append("\t\t\t\t\t<text><![CDATA[").append(text).append("]]></text>\n")
			.append("\t\t\t\t</TwitterBean>\n");
		return returnThis.toString();
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getFrom_user() {
		return from_user;
	}

	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}

	public String getFrom_user_id() {
		return from_user_id;
	}

	public void setFrom_user_id(String from_user_id) {
		this.from_user_id = from_user_id;
	}

	public String getFrom_user_name() {
		return from_user_name;
	}

	public void setFrom_user_name(String from_user_name) {
		this.from_user_name = from_user_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
