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
public class ROMS_SZ_SUBCOMPANY_LOGIN {

	private String id;
	private Date createtime;
	private String userName;//用户名
	private String pwd;//密码
	
//	private ROMS_SZ_SUBCOMPANY subCompany;
	private ROMS_SZ_ROLE role;
	
//	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinColumn(name = "subCompanyId")
//	public ROMS_SZ_SUBCOMPANY getSubCompany() {
//		return subCompany;
//	}
//	public void setSubCompany(ROMS_SZ_SUBCOMPANY subCompany) {
//		this.subCompany = subCompany;
//	}
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
