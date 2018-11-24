package com.linkivr.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="idGenerator", strategy="uuid")
public class ROMS_SZ_TEMPLATETYPE {

	private String id;
	private Date createtime;
	private String standard;//检测依据
	
	private ROMS_SZ_DEVICETYPE deviceType;
	private ROMS_SZ_TEMPLATE template;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "deviceTypeId")
	public ROMS_SZ_DEVICETYPE getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(ROMS_SZ_DEVICETYPE deviceType) {
		this.deviceType = deviceType;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "templateId")
	public ROMS_SZ_TEMPLATE getTemplate() {
		return template;
	}
	public void setTemplate(ROMS_SZ_TEMPLATE template) {
		this.template = template;
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
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	
}
