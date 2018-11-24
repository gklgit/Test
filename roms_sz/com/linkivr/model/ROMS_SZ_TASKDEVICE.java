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
public class ROMS_SZ_TASKDEVICE {

	private String id;
	private Date createtime;
	
	private ROMS_SZ_TASK task;
	private ROMS_SZ_DEVICE device;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "taskId")
	public ROMS_SZ_TASK getTask() {
		return task;
	}
	public void setTask(ROMS_SZ_TASK task) {
		this.task = task;
	}
	
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
	
	
}
