package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_PROJECT;

public interface ROMS_SZ_PROJECTService {

	public List<ROMS_SZ_PROJECT> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_PROJECT project);
	public int delete(String where);
	public void update(ROMS_SZ_PROJECT project);
	public ROMS_SZ_PROJECT query(String id);
	public List<ROMS_SZ_PROJECT> queryWhereList(String where);
	public ROMS_SZ_PROJECT queryWhere(String where);
}
