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
public class ROMS_SZ_STAFFAUTH {

	private String id;
	private Date createtime;
	private int num;//编号
	private String photoUrl;//资格证图片路径
	private int roleType;//区分权限人员（1是检测员，2是报告审核员，3是报告签发员）
	
	
	private ROMS_SZ_STAFF staff;
	private ROMS_SZ_DEVICETYPE deviceType;
//	private ROMS_SZ_ROLE role;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "staffId")
	public ROMS_SZ_STAFF getStaff() {
		return staff;
	}
	public void setStaff(ROMS_SZ_STAFF staff) {
		this.staff = staff;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "deviceTypeId")
	public ROMS_SZ_DEVICETYPE getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(ROMS_SZ_DEVICETYPE deviceType) {
		this.deviceType = deviceType;
	}
	
//	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinColumn(name = "roleId")
//	public ROMS_SZ_ROLE getRole() {
//		return role;
//	}
//	public void setRole(ROMS_SZ_ROLE role) {
//		this.role = role;
//	}
	
	
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	
}
