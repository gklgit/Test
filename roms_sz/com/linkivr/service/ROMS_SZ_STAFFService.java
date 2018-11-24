package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_STAFF;

public interface ROMS_SZ_STAFFService {

	public List<ROMS_SZ_STAFF> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_STAFF staff);
	public int delete(String where);
	public void update(ROMS_SZ_STAFF staff);
	public ROMS_SZ_STAFF query(String id);
	public List<ROMS_SZ_STAFF> queryWhereList(String where);
	public ROMS_SZ_STAFF queryWhere(String where);
}
