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
public class ROMS_SZ_TASKSTATE {
//任务状态表
	private String id;
	private Date createtime;
	private String state;//状态
	private String docReason;//报告不通过原因
	
	private ROMS_SZ_TASK task;//任务表
	private ROMS_SZ_STAFF staff;//人员表
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "taskId")
	public ROMS_SZ_TASK getTask() {
		return task;
	}
	public void setTask(ROMS_SZ_TASK task) {
		this.task = task;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDocReason() {
		return docReason;
	}
	public void setDocReason(String docReason) {
		this.docReason = docReason;
	}
	
}
