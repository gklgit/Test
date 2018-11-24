package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_TASKSTAFFDao;
import com.linkivr.model.ROMS_SZ_TASKSTAFF;
import com.linkivr.service.ROMS_SZ_TASKSTAFFService;

@Component("romssztaskstaffService")
@Transactional
public class ROMS_SZ_TASKSTAFFServiceImpl implements ROMS_SZ_TASKSTAFFService {

	private ROMS_SZ_TASKSTAFFDao romssztaskstaffDao;
	
	public ROMS_SZ_TASKSTAFFDao getRomssztaskstaffDao() {
		return romssztaskstaffDao;
	}
	@Resource
	public void setRomssztaskstaffDao(ROMS_SZ_TASKSTAFFDao romssztaskstaffDao) {
		this.romssztaskstaffDao = romssztaskstaffDao;
	}

	public void add(ROMS_SZ_TASKSTAFF taskStaff) {
		romssztaskstaffDao.add(taskStaff);

	}

	public int delete(String where) {
		return romssztaskstaffDao.delete(where);
	}

	public ROMS_SZ_TASKSTAFF query(String id) {
		return romssztaskstaffDao.query(id);
	}

	public List<ROMS_SZ_TASKSTAFF> queryAll() {
		return romssztaskstaffDao.queryAll();
	}

	public int queryCount(String where) {
		return romssztaskstaffDao.queryCount(where);
	}

	public ROMS_SZ_TASKSTAFF queryWhere(String where) {
		return romssztaskstaffDao.queryWhere(where);
	}

	public List<ROMS_SZ_TASKSTAFF> queryWhereList(String where) {
		return romssztaskstaffDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_TASKSTAFF taskStaff) {
		romssztaskstaffDao.update(taskStaff);

	}

}
