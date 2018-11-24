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
public class ROMS_SZ_DEVICETYPE {

	private String id;
	private Date createtime;
	private String name;//名字
	private int num;//1是本底，2是牙科机，3是DR，4是CR，5是透视机，6是体检车，7是手术室，8是乳腺机，9是CT，10是DSA，11是医用直线加速器，12是后装治疗机，13是粒子植入设备，14是模拟定位机，15是γ刀，16是SPECT，17是PET，18是X射线衍射仪和荧光分析仪，19是含密封源仪表，20是安检机，21是货包，22是γ射线工业探伤，23是X射线工业探伤，24是γ射线工业CT，25是γ射线和电子束辐照装置，26是豁免，27是交流输变电工程，28是移动通信基站，29是（环境卫生）噪声，30是洁净室，31是公共场所物理因素，32是（公共卫生）噪声，33是职业卫生物理因素
	private int isAvailable;//判断是否可以使用（0是可以，1是不可以）
	
	private ROMS_SZ_DEVICEMAIN deviceMain;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "deviceMainId")
	public ROMS_SZ_DEVICEMAIN getDeviceMain() {
		return deviceMain;
	}
	public void setDeviceMain(ROMS_SZ_DEVICEMAIN deviceMain) {
		this.deviceMain = deviceMain;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	
}
