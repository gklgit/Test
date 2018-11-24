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
public class ROMS_SZ_DEVICE {

	private String id;
	private Date createtime;//创建时间
	private String deviceNum;//检测仪器编号
	private String deviceName;//检测仪器名称
	private String deviceModel;//检测仪器型号
	private String deviceUnit;//检测仪器检定单位
    private String correctNum;//检定证书编号（防护：x射线，性能:管电压）
    private String correctTime;//证书有效日期至（防护：x射线，性能:管电压）
    private String correctNum1;//检定证书编号（防护：γ射线，性能:剂量）
    private String correctTime1;//证书有效日期至（防护：γ射线，性能:剂量）
    private String deviceLower;//检测仪器探测下限 
    private Date LowerTime;//探测下限 测定时间  
    private String LowerUnit;//探测下限单位
    private int state;//设备状态（0是正常，1是准用，2是停用）
    private int useState;//设备使用状态（0是空闲，1是占用）
    private String purpose;//用途（防护/性能）
    private int type;//0是451P校准（旧），1是451P校准（新），2是AT1123（防护）
    private String deviceFactor;//检测仪器校准因子数组    -------（purpose=防护）x射线场校准因子，（purpose=性能）剂量检定校准因子
    private String deviceFactor_gdy;//管电压检测仪器校准因子数组
    private Float deviceFactor1;//检测仪器校准因子1
    private Float deviceFactor2;//检测仪器校准因子2
    private Float deviceFactor3;//检测仪器校准因子3
    private Float deviceFactor4;//检测仪器校准因子4
    private Float deviceFactor5;//检测仪器校准因子5
    private String factor;//137Cs校准因子----γ射线场检定校准因子，
    private Float factor1;//137Cs校准因子1
    private Float factor2;//137Cs校准因子2
    private Float factor3;//137Cs校准因子3
    private Float factor4;//137Cs校准因子4
    private Float equivalentRate1;//周围剂量当量率1
    private Float equivalentRate2;//周围剂量当量率2
    private Float equivalentRate3;//周围剂量当量率3
    private Float equivalentRate4;//周围剂量当量率4
    private Float alpha;//α值
    private Float beta;//β值
    private String vol;//电压值
    private Float vol1;//电压值1
    private Float vol2;//电压值2
    private Float vol3;//电压值3
    private Float vol4;//电压值4
    private Float vol5;//电压值5
    
    private ROMS_SZ_SUBCOMPANY subCompany;//子公司
    
    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "subCompanyId")
    public ROMS_SZ_SUBCOMPANY getSubCompany() {
		return subCompany;
	}
	public void setSubCompany(ROMS_SZ_SUBCOMPANY subCompany) {
		this.subCompany = subCompany;
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
	public String getDeviceNum() {
		return deviceNum;
	}
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceUnit() {
		return deviceUnit;
	}
	public void setDeviceUnit(String deviceUnit) {
		this.deviceUnit = deviceUnit;
	}
	public String getCorrectNum() {
		return correctNum;
	}
	public void setCorrectNum(String correctNum) {
		this.correctNum = correctNum;
	}
	public String getCorrectTime() {
		return correctTime;
	}
	public void setCorrectTime(String correctTime) {
		this.correctTime = correctTime;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Float getDeviceFactor1() {
		return deviceFactor1;
	}
	public void setDeviceFactor1(Float deviceFactor1) {
		this.deviceFactor1 = deviceFactor1;
	}
	public Float getDeviceFactor2() {
		return deviceFactor2;
	}
	public void setDeviceFactor2(Float deviceFactor2) {
		this.deviceFactor2 = deviceFactor2;
	}
	public Float getDeviceFactor3() {
		return deviceFactor3;
	}
	public void setDeviceFactor3(Float deviceFactor3) {
		this.deviceFactor3 = deviceFactor3;
	}
	public Float getDeviceFactor4() {
		return deviceFactor4;
	}
	public void setDeviceFactor4(Float deviceFactor4) {
		this.deviceFactor4 = deviceFactor4;
	}
	public Float getDeviceFactor5() {
		return deviceFactor5;
	}
	public void setDeviceFactor5(Float deviceFactor5) {
		this.deviceFactor5 = deviceFactor5;
	}
	public Float getFactor1() {
		return factor1;
	}
	public void setFactor1(Float factor1) {
		this.factor1 = factor1;
	}
	public Float getFactor2() {
		return factor2;
	}
	public void setFactor2(Float factor2) {
		this.factor2 = factor2;
	}
	public Float getFactor3() {
		return factor3;
	}
	public void setFactor3(Float factor3) {
		this.factor3 = factor3;
	}
	public Float getFactor4() {
		return factor4;
	}
	public void setFactor4(Float factor4) {
		this.factor4 = factor4;
	}
	public Float getEquivalentRate1() {
		return equivalentRate1;
	}
	public void setEquivalentRate1(Float equivalentRate1) {
		this.equivalentRate1 = equivalentRate1;
	}
	public Float getEquivalentRate2() {
		return equivalentRate2;
	}
	public void setEquivalentRate2(Float equivalentRate2) {
		this.equivalentRate2 = equivalentRate2;
	}
	public Float getEquivalentRate3() {
		return equivalentRate3;
	}
	public void setEquivalentRate3(Float equivalentRate3) {
		this.equivalentRate3 = equivalentRate3;
	}
	public Float getEquivalentRate4() {
		return equivalentRate4;
	}
	public void setEquivalentRate4(Float equivalentRate4) {
		this.equivalentRate4 = equivalentRate4;
	}
	public Float getAlpha() {
		return alpha;
	}
	public void setAlpha(Float alpha) {
		this.alpha = alpha;
	}
	public Float getBeta() {
		return beta;
	}
	public void setBeta(Float beta) {
		this.beta = beta;
	}
	public Float getVol1() {
		return vol1;
	}
	public void setVol1(Float vol1) {
		this.vol1 = vol1;
	}
	public Float getVol2() {
		return vol2;
	}
	public void setVol2(Float vol2) {
		this.vol2 = vol2;
	}
	public Float getVol3() {
		return vol3;
	}
	public void setVol3(Float vol3) {
		this.vol3 = vol3;
	}
	public Float getVol4() {
		return vol4;
	}
	public void setVol4(Float vol4) {
		this.vol4 = vol4;
	}
	public Float getVol5() {
		return vol5;
	}
	public void setVol5(Float vol5) {
		this.vol5 = vol5;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceLower() {
		return deviceLower;
	}
	public void setDeviceLower(String deviceLower) {
		this.deviceLower = deviceLower;
	}
	public Date getLowerTime() {
		return LowerTime;
	}
	public void setLowerTime(Date lowerTime) {
		LowerTime = lowerTime;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getUseState() {
		return useState;
	}
	public void setUseState(int useState) {
		this.useState = useState;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getDeviceFactor() {
		return deviceFactor;
	}
	public void setDeviceFactor(String deviceFactor) {
		this.deviceFactor = deviceFactor;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public String getVol() {
		return vol;
	}
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	public String getCorrectNum1() {
		return correctNum1;
	}
	public void setCorrectNum1(String correctNum1) {
		this.correctNum1 = correctNum1;
	}
	public String getCorrectTime1() {
		return correctTime1;
	}
	public void setCorrectTime1(String correctTime1) {
		this.correctTime1 = correctTime1;
	}
	public String getDeviceFactor_gdy() {
		return deviceFactor_gdy;
	}
	public void setDeviceFactor_gdy(String deviceFactorGdy) {
		deviceFactor_gdy = deviceFactorGdy;
	}
	public String getLowerUnit() {
		return LowerUnit;
	}
	public void setLowerUnit(String lowerUnit) {
		LowerUnit = lowerUnit;
	}
	
   
}
