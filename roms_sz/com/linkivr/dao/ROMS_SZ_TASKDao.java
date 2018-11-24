package com.linkivr.dao;

import java.util.Date;
import java.util.List;

import com.linkivr.model.ROMS_SZ_TASK;

public interface ROMS_SZ_TASKDao {

	public List<ROMS_SZ_TASK> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_TASK task);
	public int delete(String id);
	public void update(ROMS_SZ_TASK task);
	public ROMS_SZ_TASK query(String id);
	public ROMS_SZ_TASK queryWhere(String where);
	public List<ROMS_SZ_TASK> queryPageSort(Date starttime,Date endtime,String where,int start,int pagesize,int sortflag);
	public List<ROMS_SZ_TASK> querySort(Date starttime,Date endtime,String where,int sortflag);
	public int queryCount(Date starttime,Date endtime,String where,int sortflag);
	public List<ROMS_SZ_TASK> queryWhereList(String where);
	public ROMS_SZ_TASK queryOtherTask(String where);
}
