package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_DEVICEWORD;

public interface ROMS_SZ_DEVICEWORDService {

	public List<ROMS_SZ_DEVICEWORD> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_DEVICEWORD deviceWord);
	public int delete(String id);
	public void update(ROMS_SZ_DEVICEWORD deviceWord);
	public ROMS_SZ_DEVICEWORD query(String id);
	public List<ROMS_SZ_DEVICEWORD> queryWhereList(String where);
	public ROMS_SZ_DEVICEWORD queryWhere(String where);
}
