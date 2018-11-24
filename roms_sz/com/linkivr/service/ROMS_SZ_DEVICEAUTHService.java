package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_DEVICEAUTH;

public interface ROMS_SZ_DEVICEAUTHService {

	public List<ROMS_SZ_DEVICEAUTH> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_DEVICEAUTH deviceAuth);
	public int delete(String where);
	public void update(ROMS_SZ_DEVICEAUTH deviceAuth);
	public ROMS_SZ_DEVICEAUTH query(String id);
	public List<ROMS_SZ_DEVICEAUTH> queryWhereList(String where);
	public ROMS_SZ_DEVICEAUTH queryWhere(String where);
}
