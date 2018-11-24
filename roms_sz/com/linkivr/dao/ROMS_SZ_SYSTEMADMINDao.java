package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_SYSTEMADMIN;

public interface ROMS_SZ_SYSTEMADMINDao {

	public List<ROMS_SZ_SYSTEMADMIN> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_SYSTEMADMIN systemAdmin);
	public int delete(String id);
	public void update(ROMS_SZ_SYSTEMADMIN systemAdmin);
	public ROMS_SZ_SYSTEMADMIN query(String id);
	public List<ROMS_SZ_SYSTEMADMIN> queryWhereList(String where);
	public ROMS_SZ_SYSTEMADMIN queryWhere(String where);
}
