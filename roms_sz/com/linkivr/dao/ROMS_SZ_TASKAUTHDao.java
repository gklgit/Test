package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_TASKAUTH;

public interface ROMS_SZ_TASKAUTHDao {

	public List<ROMS_SZ_TASKAUTH> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_TASKAUTH taskAuth);
	public int delete(String where);
	public void update(ROMS_SZ_TASKAUTH taskAuth);
	public ROMS_SZ_TASKAUTH query(String id);
	public List<ROMS_SZ_TASKAUTH> queryWhereList(String where);
	public ROMS_SZ_TASKAUTH queryWhere(String where);
}
