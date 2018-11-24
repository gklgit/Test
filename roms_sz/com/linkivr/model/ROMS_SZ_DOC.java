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
public class ROMS_SZ_DOC {
//报告表
	private String id;
	private Date createtime;//报告创建日期
	private Date issueTime;//报告签发日期
	private Date auditorTime;//报告审核日期
	private Date issueExpectTime;//报告签发期望日期
	private Date auditorExpectTime;//报告审核期望日期
	private String docUrl;//报告地址
	private String docNum;//报告编号
	private String docPdfUrl;//报告pdf地址
	private String docHeadUrl;//报告封面地址
	private String docHeadPdfUrl;//报告封面PDF地址
	private int size;//打印数量
	private int docPassAuditor;//（审核）0是未审核，1是未通过，2是通过
	private int docPassIssue;//（签发）0是未审核，1是未通过，2是通过
	private int isG;//归档报告不通过数量（用于报告+G显示）
	private int isRepulse;//是否打回（0是没打回，1是打回了）---默认为0，如果为1了只有归档后才会更新为0
	private String reason;//报告审核不通过原因
	private String issueReason;//报告签发不通过原因
	private String fileReason;//报告归档打回原因
	private String docMakePdfUrl;//盖章过的PDF报告
	private String collarStaff;//领用人
	private Date collarTime;//领用时间
	
	private ROMS_SZ_STAFF staffMake;//报告编制人
	private ROMS_SZ_STAFF staffIssue;//报告签发人
	private ROMS_SZ_STAFF staffAuditor;//报告审核人
	private ROMS_SZ_PROJECT project;//项目表
	private ROMS_SZ_TASK task;//任务表
	private ROMS_SZ_SUBCOMPANY subCompany;//子公司
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "staffIssueId")
	public ROMS_SZ_STAFF getStaffIssue() { 
		return staffIssue;
	}
	public void setStaffIssue(ROMS_SZ_STAFF staffIssue) {
		this.staffIssue = staffIssue;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "staffAuditorId")
	public ROMS_SZ_STAFF getStaffAuditor() {
		return staffAuditor;
	}
	public void setStaffAuditor(ROMS_SZ_STAFF staffAuditor) {
		this.staffAuditor = staffAuditor;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "staffMakeId")
	public ROMS_SZ_STAFF getStaffMake() {
		return staffMake;
	}
	public void setStaffMake(ROMS_SZ_STAFF staffMake) {
		this.staffMake = staffMake;
	}
	
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
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getDocUrl() {
		return docUrl;
	}
	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getDocPdfUrl() {
		return docPdfUrl;
	}
	public void setDocPdfUrl(String docPdfUrl) {
		this.docPdfUrl = docPdfUrl;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getDocHeadUrl() {
		return docHeadUrl;
	}
	public void setDocHeadUrl(String docHeadUrl) {
		this.docHeadUrl = docHeadUrl;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getDocHeadPdfUrl() {
		return docHeadPdfUrl;
	}
	public void setDocHeadPdfUrl(String docHeadPdfUrl) {
		this.docHeadPdfUrl = docHeadPdfUrl;
	}
	public Date getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}
	public Date getAuditorTime() {
		return auditorTime;
	}
	public void setAuditorTime(Date auditorTime) {
		this.auditorTime = auditorTime;
	}
	
	@Column(nullable=false,columnDefinition="INT default 3")
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getDocMakePdfUrl() {
		return docMakePdfUrl;
	}
	public void setDocMakePdfUrl(String docMakePdfUrl) {
		this.docMakePdfUrl = docMakePdfUrl;
	}
	public Date getIssueExpectTime() {
		return issueExpectTime;
	}
	public void setIssueExpectTime(Date issueExpectTime) {
		this.issueExpectTime = issueExpectTime;
	}
	public Date getAuditorExpectTime() {
		return auditorExpectTime;
	}
	public void setAuditorExpectTime(Date auditorExpectTime) {
		this.auditorExpectTime = auditorExpectTime;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getDocPassAuditor() {
		return docPassAuditor;
	}
	public void setDocPassAuditor(int docPassAuditor) {
		this.docPassAuditor = docPassAuditor;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getDocPassIssue() {
		return docPassIssue;
	}
	public void setDocPassIssue(int docPassIssue) {
		this.docPassIssue = docPassIssue;
	}
	public String getIssueReason() {
		return issueReason;
	}
	public void setIssueReason(String issueReason) {
		this.issueReason = issueReason;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getIsG() {
		return isG;
	}
	public void setIsG(int isG) {
		this.isG = isG;
	}
	
	@Column(columnDefinition="TEXT", nullable=true)
	public String getFileReason() {
		return fileReason;
	}
	public void setFileReason(String fileReason) {
		this.fileReason = fileReason;
	}
	public String getCollarStaff() {
		return collarStaff;
	}
	public void setCollarStaff(String collarStaff) {
		this.collarStaff = collarStaff;
	}
	public Date getCollarTime() {
		return collarTime;
	}
	public void setCollarTime(Date collarTime) {
		this.collarTime = collarTime;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getIsRepulse() {
		return isRepulse;
	}
	public void setIsRepulse(int isRepulse) {
		this.isRepulse = isRepulse;
	}
	
	
}
