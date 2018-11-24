package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_DEVICE;


public interface ROMS_SZ_DEVICEDao {

	public List<ROMS_SZ_DEVICE> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_DEVICE device);
	public int delete(String where);
	public void update(ROMS_SZ_DEVICE device);
	public ROMS_SZ_DEVICE query(String id);
	public List<ROMS_SZ_DEVICE> queryWhereList(String where);
	public ROMS_SZ_DEVICE queryWhere(String where);
}
