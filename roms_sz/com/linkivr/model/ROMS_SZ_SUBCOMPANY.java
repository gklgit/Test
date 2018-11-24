package com.linkivr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="idGenerator", strategy="uuid")
public class ROMS_SZ_SUBCOMPANY {

	private String id;
	private Date createtime;
	private String subCompanyName;//子公司名
	private String subCompanyAddress;//子公司地址
	private int subCompanyNum;//用于排序
	
	@Id
	@GeneratedValue(generator="idGenerator")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getSubCompanyName() {
		return subCompanyName;
	}
	public void setSubCompanyName(String subCompanyName) {
		this.subCompanyName = subCompanyName;
	}
	public String getSubCompanyAddress() {
		return subCompanyAddress;
	}
	public void setSubCompanyAddress(String subCompanyAddress) {
		this.subCompanyAddress = subCompanyAddress;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getSubCompanyNum() {
		return subCompanyNum;
	}
	public void setSubCompanyNum(int subCompanyNum) {
		this.subCompanyNum = subCompanyNum;
	}
	
	
}
