
package com.siva.service;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlType(propOrder={"smid", "sm_name" , "sm_des", "sm_version","username" })
public class SoftwareModule {
	private int smid;
	private String username;
	private String sm_name;
	private String sm_des;
	private int sm_version;

	public int getSmid() {
		return smid;
	}

	public void setSmid(int smid) {
		this.smid = smid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSm_name() {
		return sm_name;
	}

	public void setSm_name(String sm_name) {
		this.sm_name = sm_name;
	}

	public String getSm_des() {
		return sm_des;
	}

	public void setSm_des(String sm_des) {
		this.sm_des = sm_des;
	}

	public int getSm_version() {
		return sm_version;
	}

	public void setSm_version(int sm_version) {
		this.sm_version = sm_version;
	}

}
