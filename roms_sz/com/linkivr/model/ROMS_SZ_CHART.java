package com.linkivr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="idGenerator", strategy="uuid")
public class ROMS_SZ_CHART {
//图存储表
	
	private String id;
	private Date createtime;
	private String chartName;//图名字
	private String chartUrl;//图地址
	
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
	public String getChartName() {
		return chartName;
	}
	public void setChartName(String chartName) {
		this.chartName = chartName;
	}
	public String getChartUrl() {
		return chartUrl;
	}
	public void setChartUrl(String chartUrl) {
		this.chartUrl = chartUrl;
	}
	
	
}
