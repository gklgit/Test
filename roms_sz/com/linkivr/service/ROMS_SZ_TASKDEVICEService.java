package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_TASKDEVICE;

public interface ROMS_SZ_TASKDEVICEService {

	public List<ROMS_SZ_TASKDEVICE> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_TASKDEVICE taskDevice);
	public int delete(String where);
	public void update(ROMS_SZ_TASKDEVICE taskDevice);
	public ROMS_SZ_TASKDEVICE query(String id);
	public List<ROMS_SZ_TASKDEVICE> queryWhereList(String where);
	public ROMS_SZ_TASKDEVICE queryWhere(String where);
}
