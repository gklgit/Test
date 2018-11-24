package com.linkivr.service;

import java.util.List;

import com.linkivr.model.ROMS_SZ_TASKSTAFF;

public interface ROMS_SZ_TASKSTAFFService {

	public List<ROMS_SZ_TASKSTAFF> queryAll();
	public int queryCount(String where);
	public void add(ROMS_SZ_TASKSTAFF taskStaff);
	public int delete(String where);
	public void update(ROMS_SZ_TASKSTAFF taskStaff);
	public ROMS_SZ_TASKSTAFF query(String id);
	public List<ROMS_SZ_TASKSTAFF> queryWhereList(String where);
	public ROMS_SZ_TASKSTAFF queryWhere(String where);
}
