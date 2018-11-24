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
public class ROMS_SZ_STAFF {

	private String id;
	private Date createtime;
	private String staffName;//工作人员名字
	private String staffPhone;//工作人员电话
	private String password;//密码
	private String photoUrl;//签名照路径
	private int unusable;//0是可用，1是不可用
	private String baseUrl;//原始图片Url
	private String area;//区域
	private String type;//类型
	private String permitUrl;//资格证图片路径
	
	private ROMS_SZ_SUBCOMPANY subCompany;//子公司
	private ROMS_SZ_ROLE role;//角色

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "subCompanyId")
	public ROMS_SZ_SUBCOMPANY getSubCompany() {
		return subCompany;
	}

	public void setSubCompany(ROMS_SZ_SUBCOMPANY subCompany) {
		this.subCompany = subCompany;
	}

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "roleId")
	public ROMS_SZ_ROLE getRole() {
		return role;
	}

	public void setRole(ROMS_SZ_ROLE role) {
		this.role = role;
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

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Column(nullable=false,columnDefinition="INT default 0")
	public int getUnusable() {
		return unusable;
	}

	public void setUnusable(int unusable) {
		this.unusable = unusable;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPermitUrl() {
		return permitUrl;
	}

	public void setPermitUrl(String permitUrl) {
		this.permitUrl = permitUrl;
	}

}
