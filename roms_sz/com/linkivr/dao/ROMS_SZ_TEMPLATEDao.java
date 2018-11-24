package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_TEMPLATE;

public interface ROMS_SZ_TEMPLATEDao {

	public List<ROMS_SZ_TEMPLATE> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_TEMPLATE template);
	public int delete(String where);
	public void update(ROMS_SZ_TEMPLATE template);
	public ROMS_SZ_TEMPLATE query(String id);
	public List<ROMS_SZ_TEMPLATE> queryWhereList(String where);
	public ROMS_SZ_TEMPLATE queryWhere(String where);
}
