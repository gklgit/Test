package com.linkivr.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="idGenerator", strategy="uuid")
public class ROMS_SZ_DEVICEWORD {
//仪器文档表
	
	private String id;
	private Date createtime;
	private String url;//文档路径
	private int type;//文档类型
	private String title;//文档标题
	
	private ROMS_SZ_DEVICE device;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "deviceId")
	public ROMS_SZ_DEVICE getDevice() {
		return device;
	}
	public void setDevice(ROMS_SZ_DEVICE device) {
		this.device = device;
	}
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
