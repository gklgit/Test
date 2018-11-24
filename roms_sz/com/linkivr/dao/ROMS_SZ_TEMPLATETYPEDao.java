package com.linkivr.dao;

import java.util.List;

import com.linkivr.model.ROMS_SZ_TEMPLATETYPE;

public interface ROMS_SZ_TEMPLATETYPEDao {

	public List<ROMS_SZ_TEMPLATETYPE> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_TEMPLATETYPE templateType);
	public int delete(String where);
	public void update(ROMS_SZ_TEMPLATETYPE templateType);
	public ROMS_SZ_TEMPLATETYPE query(String id);
	public List<ROMS_SZ_TEMPLATETYPE> queryWhereList(String where);
	public ROMS_SZ_TEMPLATETYPE queryWhere(String where);
}
