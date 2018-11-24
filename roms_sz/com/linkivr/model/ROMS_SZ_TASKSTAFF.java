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
public class ROMS_SZ_TASKSTAFF {

	private String id;
	private Date createtime;
	private int type;//区分人员（0是检测人，1是审核人，2是创建人）
	
	private ROMS_SZ_STAFF staff;
	private ROMS_SZ_TASK task;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "staffId")
	public ROMS_SZ_STAFF getStaff() {
		return staff;
	}
	public void setStaff(ROMS_SZ_STAFF staff) {
		this.staff = staff;
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
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
