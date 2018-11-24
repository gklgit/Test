package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_STAFFDao;
import com.linkivr.model.ROMS_SZ_STAFF;
import com.linkivr.service.ROMS_SZ_STAFFService;

@Component("romsszstaffService")
@Transactional
public class ROMS_SZ_STAFFServiceImpl implements ROMS_SZ_STAFFService {

	private ROMS_SZ_STAFFDao romsszstaffDao;
	
	public ROMS_SZ_STAFFDao getRomsszstaffDao() {
		return romsszstaffDao;
	}
	@Resource
	public void setRomsszstaffDao(ROMS_SZ_STAFFDao romsszstaffDao) {
		this.romsszstaffDao = romsszstaffDao;
	}

	public void add(ROMS_SZ_STAFF staff) {
		romsszstaffDao.add(staff);

	}

	public int delete(String where) {
		return romsszstaffDao.delete(where);
	}

	public ROMS_SZ_STAFF query(String id) {
		return romsszstaffDao.query(id);
	}

	public List<ROMS_SZ_STAFF> queryAll() {
		return romsszstaffDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszstaffDao.queryCount(where);
	}

	public ROMS_SZ_STAFF queryWhere(String where) {
		return romsszstaffDao.queryWhere(where);
	}

	public List<ROMS_SZ_STAFF> queryWhereList(String where) {
		return romsszstaffDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_STAFF staff) {
		romsszstaffDao.update(staff);

	}

}
