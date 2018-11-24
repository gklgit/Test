package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_APPLY;

public interface ROMS_SZ_APPLYDao {

	public List<ROMS_SZ_APPLY> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_APPLY apply);
	public int delete(String where);
	public void update(ROMS_SZ_APPLY apply);
	public ROMS_SZ_APPLY query(String id);
	public List<ROMS_SZ_APPLY> queryWhereList(String where);
	public ROMS_SZ_APPLY queryWhere(String where);
}
