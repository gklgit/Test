package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_DEVICETYPE;

public interface ROMS_SZ_DEVICETYPEService {

	public List<ROMS_SZ_DEVICETYPE> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_DEVICETYPE deviceType);
	public int delete(String where);
	public void update(ROMS_SZ_DEVICETYPE deviceType);
	public ROMS_SZ_DEVICETYPE query(String id);
	public List<ROMS_SZ_DEVICETYPE> queryWhereList(String where);
	public ROMS_SZ_DEVICETYPE queryWhere(String where);
}
