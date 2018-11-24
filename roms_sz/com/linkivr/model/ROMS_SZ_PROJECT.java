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
public class ROMS_SZ_PROJECT {

	private String id;
	private Date createtime;
	private String projectName;//项目名
	private int projectNum;//项目编号
	private Date docTime;//报告时间
	private String docNum;//报告编号
	private String docUrl;//报告地址
	private int audit;//0是项目下还有任务没有审核通过，1是项目下任务全部通过
	private String sendUrl;//任务派发单路径
	private String projectZip;//项目压缩包路径
	private String dataZip;//原始记录表压缩包路径
	private int globalType;//1是放射，2是卫生
	private String docDisplayUrl;//项目文档说明
	private String contact;//联系人
	private String phone;//联系电话
	private String checkUnitName;//受检单位名称
	
	private ROMS_SZ_SUBCOMPANY subCompany;//子公司
	private ROMS_SZ_STAFF staff;//项目创建人
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "subCompanyId")
	public ROMS_SZ_SUBCOMPANY getSubCompany() {
		return subCompany;
	}

	public void setSubCompany(ROMS_SZ_SUBCOMPANY subCompany) {
		this.subCompany = subCompany;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "staffId")
	public ROMS_SZ_STAFF getStaff() {
		return staff;
	}

	public void setStaff(ROMS_SZ_STAFF staff) {
		this.staff = staff;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getDocTime() {
		return docTime;
	}
	public void setDocTime(Date docTime) {
		this.docTime = docTime;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	public String getDocUrl() {
		return docUrl;
	}
	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getAudit() {
		return audit;
	}
	public void setAudit(int audit) {
		this.audit = audit;
	}
	public String getSendUrl() {
		return sendUrl;
	}
	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}
	public String getProjectZip() {
		return projectZip;
	}
	public void setProjectZip(String projectZip) {
		this.projectZip = projectZip;
	}
	public String getDataZip() {
		return dataZip;
	}
	public void setDataZip(String dataZip) {
		this.dataZip = dataZip;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getGlobalType() {
		return globalType;
	}
	public void setGlobalType(int globalType) {
		this.globalType = globalType;
	}
	public String getDocDisplayUrl() {
		return docDisplayUrl;
	}
	public void setDocDisplayUrl(String docDisplayUrl) {
		this.docDisplayUrl = docDisplayUrl;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}

	public String getCheckUnitName() {
		return checkUnitName;
	}

	public void setCheckUnitName(String checkUnitName) {
		this.checkUnitName = checkUnitName;
	}
	
	
}
