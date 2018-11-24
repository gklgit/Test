package com.linkivr.model;

import java.sql.Date;

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
public class ROMS_SZ_FACTOR {
//校准因子表
	
	private String id;
	private Date createtime;
	private Float deviceFactor;//检测仪器校准因子
	private Float factor;//137Cs校准因子
	private Float equivalentRate;//周围剂量当量率
	private Float vol;//电压值
	
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
	public Float getDeviceFactor() {
		return deviceFactor;
	}
	public void setDeviceFactor(Float deviceFactor) {
		this.deviceFactor = deviceFactor;
	}
	public Float getFactor() {
		return factor;
	}
	public void setFactor(Float factor) {
		this.factor = factor;
	}
	public Float getEquivalentRate() {
		return equivalentRate;
	}
	public void setEquivalentRate(Float equivalentRate) {
		this.equivalentRate = equivalentRate;
	}
	public Float getVol() {
		return vol;
	}
	public void setVol(Float vol) {
		this.vol = vol;
	}
	
	
}
