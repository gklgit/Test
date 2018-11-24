package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_DOC;

public interface ROMS_SZ_DOCService {

	public List<ROMS_SZ_DOC> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_DOC doc);
	public int delete(String where);
	public void update(ROMS_SZ_DOC doc);
	public ROMS_SZ_DOC query(String id);
	public List<ROMS_SZ_DOC> queryWhereList(String where);
	public ROMS_SZ_DOC queryWhere(String where);
}
