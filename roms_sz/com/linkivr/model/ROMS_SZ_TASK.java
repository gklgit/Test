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
import org.hibernate.annotations.Type;
import org.w3c.dom.Text;

@Entity
@GenericGenerator(name="idGenerator", strategy="uuid")
public class ROMS_SZ_TASK {

	private String id;
	private Date createtime;
	private Date inserttime;
	private Date enterTime;//任务进入派发的时间  
	private String needTime;//任务需要完成时间
	private String expectTime;//任务期望完成时间
	private String reason;//原始记录表审核不通过原因
	private String measureDataUrl;//原始记录表路径
	private String measureDataPdfUrl;//原始记录表PDF存放路径
	private String pointUrl;//点位图路径
	private String recordUrl;//检测人签名照路径
	private String checkUrl;//复核人签名照路径
	private String unitUrl;//受检单位签名照路径
	private String photoUrl;//现场照片文件夹路径
	private String confirmUrl;//确认人签名照存放地址
	private String docUrl;//报告地址
	private Date docTime;//报告日期
	private String docNum;//报告编号
	private Float lng;//经度
	private Float lat;//纬度
	private String projectNum;//项目编号
	private int taskNum;//任务编号
	private String checkUnitName;//受检单位名称
	private String checkUnitAddress;//受检单位地址
	private String checkUnitPhone;//受检单位电话
	private String checkUnitContact;//受检单位联系人
	private String monitorType;//检测类型
	private String place;//检测场所
	private String testingWay;//检测方式
	private String testingProject;//检测项目
	private String carNum;//受检车牌号码
	private String address;//检测地点
	private Float deviceFactor;//检测仪器校准因子
	private Float deviceFactor1;//检测仪器校准因子1
	private String standard;//检测依据
	private String conditions;//检测条件
	private String conditions1;//检测条件1
	private String nominalCapacity;//额定容量
	private String nominalCapacity1;//额定容量1
	private String weather;//天气
	private Float factor;//137Cs校准因子
	private String checkDeviceName;//受检设备名称
	private String checkDeviceNum;//受检设备编号
	private String checkDeviceModel;//受检设备型号
	private String checkDeviceVender;//受检设备厂家
	private int checkDeviceProbe;//被检设备探头个数
	private String deviceType;//设备类型
	private Float pressure;//气压
	private Float temperature;//温度
	private Float humidity;//湿度
	private String wireHarness1;//有用线束朝向1
	private String wireHarness2;//有用线束朝向2
	private String wireHarness3;//有用线束朝向3
	private String irradiation;//照射野
	private String irradiation1;//照射野1
	private String upstairs;//楼上
	private String downstairs;//楼下
	private String data;//测点json
	private String taskData;//任务json
	private int unusable;//0是可用，1是不可用
	private int pass;//0是未审核，1是未通过，2是通过，3是未上传
	private int isDone;//0是平板任务还未开始做，1是平板任务开始做，任务无法删除
	private int isSend;//0是没有派发，1是已经派发,3是不能派发
	private int isDeviate;//0是没有偏离，1是偏离了
	private int docPass;//0是未审核，1是未通过，2是通过
	private int noPass;//不通过数量
	private String exposureDeviceModel;//辐照装置类型
	private String source;//贮源放射
	private String nuclideName;//核素名称
	private String nuclideVender;//核素生产厂家
	private String maxActivity;//最大装填活度
	private String currentActivity;//当前装填活度
	private String nuclideNum;//核素编号
	private Date nuclideTime;//核素日期
	private String note;//备注
	private String note1;//备注1
	private String voltageRange1;//常用电压范围1
	private String voltageRange2;//常用电压范围2
	private String current1;//常用电流1
	private String current2;//常用电流2
	private String exposureTimeRange1;//曝光时间范围1
	private String exposureTimeRange2;//曝光时间范围2
	private String weekWork;//每周工作天数
	private String shooting1;//每天拍片1
	private String shooting2;//每天拍片2
	private String computerRoom;//机房防护检测条件
	private String performer;//术者位检测条件
	private String activityResponse;//表面活度响应
	private String cargoName;//货物名称
	private String packageNum;//货包批号
	private String packageSize;//货包件数
	private String packageType;//货包类型
	private String packageActivity;//货包总放射性活度
	private String rayType;//射线类型
	private String physicalState;//物理状态
	private String exposureControl;//自照曝光控制
	private String radiometricControl;//自照射量控制
	private String brightnessControl;//有无自动亮度控制
	private String imageIntensifier;//有无影像增强器
	private String timeDeixis;//有无时间指示
	private String sidDeixis;//有无SID指示
	private String sourcesSpecies;//治疗源核数种类
	private String sourcesVender;//治疗源生产厂家
	private String sourcesActivity;//治疗源当前总活度
	private String sourcesLoading;//治疗源装源活度
	private String activityTime;//活度刻度时间
	private String sourcesNuclideNum;//治疗源核数编码
	private String probeCrystal;//探头晶体厚度
	private String checkComputerRoom;//受检机房名称
	private String employUnit;//用人单位
	private String soundCalibratorModel;//声校准器型号
	private Float calibrationValue;//校准值[dB(A)]
	private Float calibrationValue1;//校准值[dB(A)]1
	private String clientUnitName;//委托单位名称
	private String clientUnitAddress;//委托单位地址
	private String clientUnitPhone;//委托单位电话
	private String clientUnitContact;//委托单位联系人
	private String environmental;//声学环境
    private String samplingPurpose;//采样目的
    private String other;//其他
    private String other1;//其他1
    private String anemometerModel;//风速仪型号及编号
    private String carFlow;//车流量
    private String sampleNum;//样品编号
    private String reportNum;//相关联摄影机性能检测报告号
    private String distribution;//布点
    private String wavelength;//检测波长
    private String updateFactor;//修正系数
    private String ceneCondition;//现场情况
    private Float windSpeed;//风速
    private Float avg1;//平均值1
    private Float avg2;//平均值2
    private String noiseType;//噪声类型
    private String location;//监测地点
    private String windType;//送风口布置方式
    private String indoorPressure;//室内压力
    private String minConcentration;//最小检出浓度
    private String cleanVolume;//洁净室体积
    private String xRayNum;//x射线管编号
	private String xRayNum1;//x射线管编号1
    private String objectWork;//检测对象及工况
    private int detectorSize;//探测器数量 
    private int aceSize;//AEC电离室数量
    private String province;//省
    private String city;//市
    private String district;//区县
    private String docReason;//报告不通过原因
    
    //备注通用字段
    private int item1;
    private String item2;
    private String item3;
    private String item4;
    private String item5;
    private String item6;
    private String item7;
    private String item8;
    private String item9;
    private String item10;
    private String item11;
    
	
	private ROMS_SZ_PROJECT project;//项目
	private ROMS_SZ_SUBCOMPANY subCompany;//子公司
	private ROMS_SZ_CHART chart;//画图底图

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "projectId")
	public ROMS_SZ_PROJECT getProject() {
		return project;
	}

	public void setProject(ROMS_SZ_PROJECT project) {
		this.project = project;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "subCompanyId")
	public ROMS_SZ_SUBCOMPANY getSubCompany() {
		return subCompany;
	}

	public void setSubCompany(ROMS_SZ_SUBCOMPANY subCompany) {
		this.subCompany = subCompany;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "chartId")
	public ROMS_SZ_CHART getChart() {
		return chart;
	}

	public void setChart(ROMS_SZ_CHART chart) {
		this.chart = chart;
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

	public Date getInserttime() {
		return inserttime;
	}

	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	@Column(length=100)
	public String getMeasureDataUrl() {
		return measureDataUrl;
	}

	public void setMeasureDataUrl(String measureDataUrl) {
		this.measureDataUrl = measureDataUrl;
	}

	@Column(length=100)
	public String getPointUrl() {
		return pointUrl;
	}

	public void setPointUrl(String pointUrl) {
		this.pointUrl = pointUrl;
	}

	public String getRecordUrl() {
		return recordUrl;
	}

	public void setRecordUrl(String recordUrl) {
		this.recordUrl = recordUrl;
	}

	public String getCheckUrl() {
		return checkUrl;
	}

	public void setCheckUrl(String checkUrl) {
		this.checkUrl = checkUrl;
	}

	@Column(length=100)
	public String getUnitUrl() {
		return unitUrl;
	}

	public void setUnitUrl(String unitUrl) {
		this.unitUrl = unitUrl;
	}

	@Column(columnDefinition="TEXT", nullable=true)
	public String getDocUrl() {
		return docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}

	public Date getDocTime() {
		return docTime;
	}

	public void setDocTime(Date docTime) {
		this.docTime = docTime;
	}

	@Column(length=100)
	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	@Column(length=100)
	public String getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	@Column(length=100)
	public String getCheckUnitName() {
		return checkUnitName;
	}

	public void setCheckUnitName(String checkUnitName) {
		this.checkUnitName = checkUnitName;
	}

	@Column(length=100)
	public String getCheckUnitAddress() {
		return checkUnitAddress;
	}

	public void setCheckUnitAddress(String checkUnitAddress) {
		this.checkUnitAddress = checkUnitAddress;
	}

	@Column(length=50)
	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getCarNum() {
		return carNum;
	}
	
	@Column(length=50)
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	
	@Column(length=100)
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(length=100)
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	@Column(length=100)
	public String getCheckDeviceName() {
		return checkDeviceName;
	}

	public void setCheckDeviceName(String checkDeviceName) {
		this.checkDeviceName = checkDeviceName;
	}

	@Column(length=100)
	public String getCheckDeviceNum() {
		return checkDeviceNum;
	}

	public void setCheckDeviceNum(String checkDeviceNum) {
		this.checkDeviceNum = checkDeviceNum;
	}

	@Column(length=100)
	public String getCheckDeviceModel() {
		return checkDeviceModel;
	}

	public void setCheckDeviceModel(String checkDeviceModel) {
		this.checkDeviceModel = checkDeviceModel;
	}

	@Column(length=100)
	public String getCheckDeviceVender() {
		return checkDeviceVender;
	}

	public void setCheckDeviceVender(String checkDeviceVender) {
		this.checkDeviceVender = checkDeviceVender;
	}

	@Column(length=100)
	public String getNominalCapacity() {
		return nominalCapacity;
	}

	public void setNominalCapacity(String nominalCapacity) {
		this.nominalCapacity = nominalCapacity;
	}

	@Column(length=50)
	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Column(length=10)
	public String getWireHarness1() {
		return wireHarness1;
	}

	public void setWireHarness1(String wireHarness1) {
		this.wireHarness1 = wireHarness1;
	}

	@Column(length=10)
	public String getWireHarness2() {
		return wireHarness2;
	}

	public void setWireHarness2(String wireHarness2) {
		this.wireHarness2 = wireHarness2;
	}

	@Column(length=10)
	public String getWireHarness3() {
		return wireHarness3;
	}

	public void setWireHarness3(String wireHarness3) {
		this.wireHarness3 = wireHarness3;
	}

	@Column(length=100)
	public String getIrradiation() {
		return irradiation;
	}

	public void setIrradiation(String irradiation) {
		this.irradiation = irradiation;
	}

	@Column(length=100)
	public String getUpstairs() {
		return upstairs;
	}

	public void setUpstairs(String upstairs) {
		this.upstairs = upstairs;
	}

	@Column(length=100)
	public String getDownstairs() {
		return downstairs;
	}

	public void setDownstairs(String downstairs) {
		this.downstairs = downstairs;
	}

	@Column(columnDefinition="TEXT", nullable=true)
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getUnusable() {
		return unusable;
	}

	public void setUnusable(int unusable) {
		this.unusable = unusable;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getIsDone() {
		return isDone;
	}

	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}

	@Column(length=100)
	public String getExposureDeviceModel() {
		return exposureDeviceModel;
	}

	public void setExposureDeviceModel(String exposureDeviceModel) {
		this.exposureDeviceModel = exposureDeviceModel;
	}

	@Column(length=100)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(length=100)
	public String getNuclideName() {
		return nuclideName;
	}

	public void setNuclideName(String nuclideName) {
		this.nuclideName = nuclideName;
	}

	@Column(length=100)
	public String getNuclideVender() {
		return nuclideVender;
	}

	public void setNuclideVender(String nuclideVender) {
		this.nuclideVender = nuclideVender;
	}

	@Column(length=100)
	public String getMaxActivity() {
		return maxActivity;
	}

	public void setMaxActivity(String maxActivity) {
		this.maxActivity = maxActivity;
	}

	@Column(length=100)
	public String getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(String currentActivity) {
		this.currentActivity = currentActivity;
	}

	@Column(length=100)
	public String getNuclideNum() {
		return nuclideNum;
	}

	public void setNuclideNum(String nuclideNum) {
		this.nuclideNum = nuclideNum;
	}

	@Column(columnDefinition="TEXT", nullable=true)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(length=100)
	public String getVoltageRange1() {
		return voltageRange1;
	}

	public void setVoltageRange1(String voltageRange1) {
		this.voltageRange1 = voltageRange1;
	}

	@Column(length=100)
	public String getVoltageRange2() {
		return voltageRange2;
	}

	public void setVoltageRange2(String voltageRange2) {
		this.voltageRange2 = voltageRange2;
	}

	@Column(length=100)
	public String getCurrent1() {
		return current1;
	}

	public void setCurrent1(String current1) {
		this.current1 = current1;
	}

	@Column(length=100)
	public String getCurrent2() {
		return current2;
	}

	public void setCurrent2(String current2) {
		this.current2 = current2;
	}

	@Column(length=100)
	public String getExposureTimeRange1() {
		return exposureTimeRange1;
	}

	public void setExposureTimeRange1(String exposureTimeRange1) {
		this.exposureTimeRange1 = exposureTimeRange1;
	}

	@Column(length=100)
	public String getExposureTimeRange2() {
		return exposureTimeRange2;
	}

	public void setExposureTimeRange2(String exposureTimeRange2) {
		this.exposureTimeRange2 = exposureTimeRange2;
	}

	@Column(length=100)
	public String getWeekWork() {
		return weekWork;
	}

	public void setWeekWork(String weekWork) {
		this.weekWork = weekWork;
	}

	@Column(length=100)
	public String getShooting1() {
		return shooting1;
	}

	public void setShooting1(String shooting1) {
		this.shooting1 = shooting1;
	}

	@Column(length=100)
	public String getShooting2() {
		return shooting2;
	}

	public void setShooting2(String shooting2) {
		this.shooting2 = shooting2;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getIsSend() {
		return isSend;
	}

	public void setIsSend(int isSend) {
		this.isSend = isSend;
	}

	@Column(length=100)
	public String getMeasureDataPdfUrl() {
		return measureDataPdfUrl;
	}

	public void setMeasureDataPdfUrl(String measureDataPdfUrl) {
		this.measureDataPdfUrl = measureDataPdfUrl;
	}

	@Column(length=100)
	public String getConfirmUrl() {
		return confirmUrl;
	}

	public void setConfirmUrl(String confirmUrl) {
		this.confirmUrl = confirmUrl;
	}

	@Column(length=100)
	public String getComputerRoom() {
		return computerRoom;
	}

	public void setComputerRoom(String computerRoom) {
		this.computerRoom = computerRoom;
	}

	@Column(length=100)
	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	@Column(length=100)
	public String getActivityResponse() {
		return activityResponse;
	}

	public void setActivityResponse(String activityResponse) {
		this.activityResponse = activityResponse;
	}

	@Column(length=100)
	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	@Column(length=100)
	public String getPackageNum() {
		return packageNum;
	}

	public void setPackageNum(String packageNum) {
		this.packageNum = packageNum;
	}

	@Column(length=100)
	public String getPhysicalState() {
		return physicalState;
	}

	public void setPhysicalState(String physicalState) {
		this.physicalState = physicalState;
	}

	@Column(length=100)
	public String getPackageSize() {
		return packageSize;
	}

	public void setPackageSize(String packageSize) {
		this.packageSize = packageSize;
	}

	@Column(length=100)
	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	@Column(length=100)
	public String getPackageActivity() {
		return packageActivity;
	}

	public void setPackageActivity(String packageActivity) {
		this.packageActivity = packageActivity;
	}

	@Column(length=100)
	public String getRayType() {
		return rayType;
	}

	public void setRayType(String rayType) {
		this.rayType = rayType;
	}

	@Column(length=100)
	public String getExposureControl() {
		return exposureControl;
	}

	public void setExposureControl(String exposureControl) {
		this.exposureControl = exposureControl;
	}

	@Column(length=100)
	public String getImageIntensifier() {
		return imageIntensifier;
	}

	public void setImageIntensifier(String imageIntensifier) {
		this.imageIntensifier = imageIntensifier;
	}

	@Column(length=100)
	public String getBrightnessControl() {
		return brightnessControl;
	}

	public void setBrightnessControl(String brightnessControl) {
		this.brightnessControl = brightnessControl;
	}

	@Column(length=50)
	public String getTimeDeixis() {
		return timeDeixis;
	}

	public void setTimeDeixis(String timeDeixis) {
		this.timeDeixis = timeDeixis;
	}

	@Column(length=100)
	public String getRadiometricControl() {
		return radiometricControl;
	}

	public void setRadiometricControl(String radiometricControl) {
		this.radiometricControl = radiometricControl;
	}

	@Column(length=50)
	public String getSidDeixis() {
		return sidDeixis;
	}

	public void setSidDeixis(String sidDeixis) {
		this.sidDeixis = sidDeixis;
	}

	@Column(length=100)
	public String getSourcesSpecies() {
		return sourcesSpecies;
	}

	public void setSourcesSpecies(String sourcesSpecies) {
		this.sourcesSpecies = sourcesSpecies;
	}

	@Column(length=100)
	public String getSourcesVender() {
		return sourcesVender;
	}

	public void setSourcesVender(String sourcesVender) {
		this.sourcesVender = sourcesVender;
	}

	@Column(length=100)
	public String getIrradiation1() {
		return irradiation1;
	}

	public void setIrradiation1(String irradiation1) {
		this.irradiation1 = irradiation1;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getCheckDeviceProbe() {
		return checkDeviceProbe;
	}

	public void setCheckDeviceProbe(int checkDeviceProbe) {
		this.checkDeviceProbe = checkDeviceProbe;
	}

	@Column(length=100)
	public String getProbeCrystal() {
		return probeCrystal;
	}

	public void setProbeCrystal(String probeCrystal) {
		this.probeCrystal = probeCrystal;
	}

	@Column(length=100)
	public String getCheckComputerRoom() {
		return checkComputerRoom;
	}

	public void setCheckComputerRoom(String checkComputerRoom) {
		this.checkComputerRoom = checkComputerRoom;
	}

	@Column(length=100)
	public String getSourcesActivity() {
		return sourcesActivity;
	}

	public void setSourcesActivity(String sourcesActivity) {
		this.sourcesActivity = sourcesActivity;
	}

	@Column(length=100)
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Column(length=100)
	public String getTestingWay() {
		return testingWay;
	}

	public void setTestingWay(String testingWay) {
		this.testingWay = testingWay;
	}

	@Column(length=100)
	public String getTestingProject() {
		return testingProject;
	}

	public void setTestingProject(String testingProject) {
		this.testingProject = testingProject;
	}

	@Column(length=20)
	public String getCheckUnitPhone() {
		return checkUnitPhone;
	}

	public void setCheckUnitPhone(String checkUnitPhone) {
		this.checkUnitPhone = checkUnitPhone;
	}

	@Column(length=50)
	public String getConditions1() {
		return conditions1;
	}

	public void setConditions1(String conditions1) {
		this.conditions1 = conditions1;
	}

	@Column(length=50)
	public String getNominalCapacity1() {
		return nominalCapacity1;
	}

	public void setNominalCapacity1(String nominalCapacity1) {
		this.nominalCapacity1 = nominalCapacity1;
	}

	@Column(length=100)
	public String getSourcesLoading() {
		return sourcesLoading;
	}

	public void setSourcesLoading(String sourcesLoading) {
		this.sourcesLoading = sourcesLoading;
	}

	@Column(length=100)
	public String getSourcesNuclideNum() {
		return sourcesNuclideNum;
	}

	public void setSourcesNuclideNum(String sourcesNuclideNum) {
		this.sourcesNuclideNum = sourcesNuclideNum;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	@Column(length=50)
	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public Float getDeviceFactor() {
		return deviceFactor;
	}

	public void setDeviceFactor(Float deviceFactor) {
		this.deviceFactor = deviceFactor;
	}

	public Float getDeviceFactor1() {
		return deviceFactor1;
	}

	public void setDeviceFactor1(Float deviceFactor1) {
		this.deviceFactor1 = deviceFactor1;
	}

	public Float getFactor() {
		return factor;
	}

	public void setFactor(Float factor) {
		this.factor = factor;
	}

	public Float getPressure() {
		return pressure;
	}

	public void setPressure(Float pressure) {
		this.pressure = pressure;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getHumidity() {
		return humidity;
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public String getEmployUnit() {
		return employUnit;
	}

	public void setEmployUnit(String employUnit) {
		this.employUnit = employUnit;
	}

	@Column(length=100)
	public String getSoundCalibratorModel() {
		return soundCalibratorModel;
	}

	public void setSoundCalibratorModel(String soundCalibratorModel) {
		this.soundCalibratorModel = soundCalibratorModel;
	}

	public Float getCalibrationValue() {
		return calibrationValue;
	}

	public void setCalibrationValue(Float calibrationValue) {
		this.calibrationValue = calibrationValue;
	}

	@Column(length=100)
	public String getCheckUnitContact() {
		return checkUnitContact;
	}

	public void setCheckUnitContact(String checkUnitContact) {
		this.checkUnitContact = checkUnitContact;
	}

	public Float getCalibrationValue1() {
		return calibrationValue1;
	}

	public void setCalibrationValue1(Float calibrationValue1) {
		this.calibrationValue1 = calibrationValue1;
	}

	@Column(length=100)
	public String getClientUnitName() {
		return clientUnitName;
	}

	public void setClientUnitName(String clientUnitName) {
		this.clientUnitName = clientUnitName;
	}

	@Column(length=150)
	public String getClientUnitAddress() {
		return clientUnitAddress;
	}

	public void setClientUnitAddress(String clientUnitAddress) {
		this.clientUnitAddress = clientUnitAddress;
	}

	@Column(length=20)
	public String getClientUnitPhone() {
		return clientUnitPhone;
	}

	public void setClientUnitPhone(String clientUnitPhone) {
		this.clientUnitPhone = clientUnitPhone;
	}

	@Column(length=50)
	public String getClientUnitContact() {
		return clientUnitContact;
	}

	public void setClientUnitContact(String clientUnitContact) {
		this.clientUnitContact = clientUnitContact;
	}

	@Column(length=100)
	public String getEnvironmental() {
		return environmental;
	}

	public void setEnvironmental(String environmental) {
		this.environmental = environmental;
	}

	@Column(length=100)
	public String getSamplingPurpose() {
		return samplingPurpose;
	}

	public void setSamplingPurpose(String samplingPurpose) {
		this.samplingPurpose = samplingPurpose;
	}

	@Column(length=50)
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(length=100)
	public String getAnemometerModel() {
		return anemometerModel;
	}

	public void setAnemometerModel(String anemometerModel) {
		this.anemometerModel = anemometerModel;
	}

	@Column(length=50)
	public String getCarFlow() {
		return carFlow;
	}

	public void setCarFlow(String carFlow) {
		this.carFlow = carFlow;
	}

	@Column(length=50)
	public String getSampleNum() {
		return sampleNum;
	}

	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}

	@Column(length=50)
	public String getOther1() {
		return other1;
	}

	public void setOther1(String other1) {
		this.other1 = other1;
	}

	@Column(length=50)
	public String getReportNum() {
		return reportNum;
	}

	public void setReportNum(String reportNum) {
		this.reportNum = reportNum;
	}

	@Column(length=20)
	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	@Column(length=50)
	public String getWavelength() {
		return wavelength;
	}

	public void setWavelength(String wavelength) {
		this.wavelength = wavelength;
	}

	@Column(length=50)
	public String getUpdateFactor() {
		return updateFactor;
	}

	public void setUpdateFactor(String updateFactor) {
		this.updateFactor = updateFactor;
	}

	@Column(length=100)
	public String getCeneCondition() {
		return ceneCondition;
	}

	public void setCeneCondition(String ceneCondition) {
		this.ceneCondition = ceneCondition;
	}

	public Float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Float getAvg1() {
		return avg1;
	}

	public void setAvg1(Float avg1) {
		this.avg1 = avg1;
	}

	public Float getAvg2() {
		return avg2;
	}

	public void setAvg2(Float avg2) {
		this.avg2 = avg2;
	}

	@Column(length=100)
	public String getNoiseType() {
		return noiseType;
	}

	public void setNoiseType(String noiseType) {
		this.noiseType = noiseType;
	}

	@Column(length=100)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(length=100)
	public String getWindType() {
		return windType;
	}

	public void setWindType(String windType) {
		this.windType = windType;
	}

	@Column(length=100)
	public String getIndoorPressure() {
		return indoorPressure;
	}

	public void setIndoorPressure(String indoorPressure) {
		this.indoorPressure = indoorPressure;
	}

	@Column(length=100)
	public String getMinConcentration() {
		return minConcentration;
	}

	public void setMinConcentration(String minConcentration) {
		this.minConcentration = minConcentration;
	}

	@Column(length=100)
	public String getCleanVolume() {
		return cleanVolume;
	}

	public void setCleanVolume(String cleanVolume) {
		this.cleanVolume = cleanVolume;
	}

	@Column(length=50)
	public String getNeedTime() {
		return needTime;
	}

	public void setNeedTime(String needTime) {
		this.needTime = needTime;
	}

	@Column(length=50)
	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getIsDeviate() {
		return isDeviate;
	}

	public void setIsDeviate(int isDeviate) {
		this.isDeviate = isDeviate;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getDocPass() {
		return docPass;
	}

	public void setDocPass(int docPass) {
		this.docPass = docPass;
	}

	@Column(length=50)
	public String getxRayNum() {
		return xRayNum;
	}

	public void setxRayNum(String xRayNum) {
		this.xRayNum = xRayNum;
	}
	@Column(length=50)
	public String getxRayNum1() {
		return xRayNum1;
	}

	public void setxRayNum1(String xRayNum1) {
		this.xRayNum1 = xRayNum1;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getItem1() {
		return item1;
	}

	public void setItem1(int item1) {
		this.item1 = item1;
	}

	@Column(length=50)
	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	@Column(length=50)
	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	@Column(length=50)
	public String getItem4() {
		return item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	@Column(length=50)
	public String getItem5() {
		return item5;
	}

	public void setItem5(String item5) {
		this.item5 = item5;
	}

	@Column(length=50)
	public String getItem6() {
		return item6;
	}

	public void setItem6(String item6) {
		this.item6 = item6;
	}

	@Column(length=50)
	public String getItem7() {
		return item7;
	}

	public void setItem7(String item7) {
		this.item7 = item7;
	}

	@Column(length=50)
	public String getItem8() {
		return item8;
	}

	public void setItem8(String item8) {
		this.item8 = item8;
	}

	@Column(length=50)
	public String getItem9() {
		return item9;
	}

	public void setItem9(String item9) {
		this.item9 = item9;
	}

	@Column(length=50)
	public String getItem10() {
		return item10;
	}

	public void setItem10(String item10) {
		this.item10 = item10;
	}

	@Column(length=50)
	public String getItem11() {
		return item11;
	}

	public void setItem11(String item11) {
		this.item11 = item11;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(int taskNum) {
		this.taskNum = taskNum;
	}

	@Column(columnDefinition="TEXT", nullable=true)
	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	@Column(length=50)
	public String getObjectWork() {
		return objectWork;
	}

	public void setObjectWork(String objectWork) {
		this.objectWork = objectWork;
	}

	@Column(columnDefinition="TEXT", nullable=true)
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getDetectorSize() {
		return detectorSize;
	}

	public void setDetectorSize(int detectorSize) {
		this.detectorSize = detectorSize;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getAceSize() {
		return aceSize;
	}

	public void setAceSize(int aceSize) {
		this.aceSize = aceSize;
	}

	@Column(length=100)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(length=100)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(length=100)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Date getNuclideTime() {
		return nuclideTime;
	}

	public void setNuclideTime(Date nuclideTime) {
		this.nuclideTime = nuclideTime;
	}

	public Date getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getNoPass() {
		return noPass;
	}

	public void setNoPass(int noPass) {
		this.noPass = noPass;
	}

	@Column(columnDefinition="TEXT", nullable=true)
	public String getDocReason() {
		return docReason;
	}

	public void setDocReason(String docReason) {
		this.docReason = docReason;
	}

	@Column(columnDefinition="TEXT", nullable=true)
	public String getTaskData() {
		return taskData;
	}

	public void setTaskData(String taskData) {
		this.taskData = taskData;
	}
	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

}
