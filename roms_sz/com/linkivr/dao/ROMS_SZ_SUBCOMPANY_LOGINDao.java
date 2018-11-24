package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_SUBCOMPANY_LOGIN;

public interface ROMS_SZ_SUBCOMPANY_LOGINDao {

	public List<ROMS_SZ_SUBCOMPANY_LOGIN> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_SUBCOMPANY_LOGIN login);
	public int delete(String where);
	public void update(ROMS_SZ_SUBCOMPANY_LOGIN login);
	public ROMS_SZ_SUBCOMPANY_LOGIN query(String id);
	public List<ROMS_SZ_SUBCOMPANY_LOGIN> queryWhereList(String where);
	public ROMS_SZ_SUBCOMPANY_LOGIN queryWhere(String where);
}
