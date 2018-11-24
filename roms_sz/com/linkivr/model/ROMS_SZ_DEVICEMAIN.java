package com.linkivr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="idGenerator", strategy="uuid")
public class ROMS_SZ_DEVICEMAIN {

	private String id;
	private Date createtime;
	private String name;
	private int type;//1是医用放射(防护)，2是工业放射，3是环境卫生，4是公共卫生,5是医用放射(性能)
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
