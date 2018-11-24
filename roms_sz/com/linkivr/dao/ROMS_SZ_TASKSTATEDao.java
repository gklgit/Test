package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_TASKSTATE;

public interface ROMS_SZ_TASKSTATEDao {

	public List<ROMS_SZ_TASKSTATE> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_TASKSTATE taskState);
	public int delete(String where);
	public void update(ROMS_SZ_TASKSTATE taskState);
	public ROMS_SZ_TASKSTATE query(String id);
	public List<ROMS_SZ_TASKSTATE> queryWhereList(String where);
	public ROMS_SZ_TASKSTATE queryWhere(String where);
}
