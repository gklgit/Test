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
public class ROMS_SZ_APPLY {
//申请表
	private String id;
	private Date createtime;
	private Date staffTime;//签名日期
	private String department;//申请部门
	private String applicant;//申请人
	private String staff;//签名
	private String reason;//原因
	private String measures;//措施
	private String opinion;//意见
	private String clientUnitName;//委托单位名称
	private String checkUnitName;//受检单位名称
	private String docNum;//报告编号
	private int type;//1是允许偏离管理体系或工作程序申请审批表，2是更正（或补发）检验报告申请表
	private int pass;//0是未审核，1是未通过，2是通过
	
	private ROMS_SZ_PROJECT project;//项目表
	private ROMS_SZ_TASK task;//任务表
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "projectId")
	public ROMS_SZ_PROJECT getProject() {
		return project;
	}
	public void setProject(ROMS_SZ_PROJECT project) {
		this.project = project;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "taskId")
	public ROMS_SZ_TASK getTask() {
		return task;
	}
	public void setTask(ROMS_SZ_TASK task) {
		this.task = task;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getMeasures() {
		return measures;
	}
	public void setMeasures(String measures) {
		this.measures = measures;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getClientUnitName() {
		return clientUnitName;
	}
	public void setClientUnitName(String clientUnitName) {
		this.clientUnitName = clientUnitName;
	}
	public String getCheckUnitName() {
		return checkUnitName;
	}
	public void setCheckUnitName(String checkUnitName) {
		this.checkUnitName = checkUnitName;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getStaffTime() {
		return staffTime;
	}
	public void setStaffTime(Date staffTime) {
		this.staffTime = staffTime;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	
	
}
