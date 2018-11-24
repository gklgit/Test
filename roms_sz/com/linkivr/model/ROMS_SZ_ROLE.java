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
public class ROMS_SZ_ROLE {

	private String id;
	private Date createtime;
	private String roleName;//角色名
//	private String modList;//权限（数组）1是检测员，2是报告审核员，3是报告签发员，4是质控人员，5是设备管理员，6是项目派发员，7是任务派发员,8是设备管理员
	
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

//	@Column(columnDefinition="TEXT", nullable=true)
//	public String getModList() {
//		return modList;
//	}
//
//	public void setModList(String modList) {
//		this.modList = modList;
//	}
	
}
