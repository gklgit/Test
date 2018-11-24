package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_ROLE;

public interface ROMS_SZ_ROLEService {

	public List<ROMS_SZ_ROLE> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_ROLE role);
	public int delete(String where);
	public void update(ROMS_SZ_ROLE role);
	public ROMS_SZ_ROLE query(String id);
	public List<ROMS_SZ_ROLE> queryWhereList(String where);
	public ROMS_SZ_ROLE queryWhere(String where);
}
