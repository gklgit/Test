package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_STAFFAUTH;

public interface ROMS_SZ_STAFFAUTHDao {

	public List<ROMS_SZ_STAFFAUTH> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_STAFFAUTH staffAuth);
	public int delete(String where);
	public void update(ROMS_SZ_STAFFAUTH staffAuth);
	public ROMS_SZ_STAFFAUTH query(String id);
	public List<ROMS_SZ_STAFFAUTH> queryWhereList(String where);
	public ROMS_SZ_STAFFAUTH queryWhere(String where);
}
