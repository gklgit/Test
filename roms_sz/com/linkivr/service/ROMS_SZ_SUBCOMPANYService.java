package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_SUBCOMPANY;

public interface ROMS_SZ_SUBCOMPANYService {

	public List<ROMS_SZ_SUBCOMPANY> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_SUBCOMPANY subCompany);
	public int delete(String where);
	public void update(ROMS_SZ_SUBCOMPANY subCompany);
	public ROMS_SZ_SUBCOMPANY query(String id);
	public List<ROMS_SZ_SUBCOMPANY> queryWhereList(String where);
	public ROMS_SZ_SUBCOMPANY queryWhere(String where);
}
