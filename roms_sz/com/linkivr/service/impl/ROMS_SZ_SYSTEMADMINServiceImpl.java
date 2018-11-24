package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_SYSTEMADMINDao;
import com.linkivr.model.ROMS_SZ_SYSTEMADMIN;
import com.linkivr.service.ROMS_SZ_SYSTEMADMINService;

@Component("romsszdsystemadminService")
@Transactional
public class ROMS_SZ_SYSTEMADMINServiceImpl implements
		ROMS_SZ_SYSTEMADMINService {

	private ROMS_SZ_SYSTEMADMINDao systemAdminDao;
	
	public ROMS_SZ_SYSTEMADMINDao getSystemAdminDao() {
		return systemAdminDao;
	}
	@Resource
	public void setSystemAdminDao(ROMS_SZ_SYSTEMADMINDao systemAdminDao) {
		this.systemAdminDao = systemAdminDao;
	}

	public void add(ROMS_SZ_SYSTEMADMIN systemAdmin) {
		systemAdminDao.add(systemAdmin);

	}

	public int delete(String id) {
		return systemAdminDao.delete(id);
	}

	public ROMS_SZ_SYSTEMADMIN query(String id) {
		return systemAdminDao.query(id);
	}

	public List<ROMS_SZ_SYSTEMADMIN> queryAll() {
		return systemAdminDao.queryAll();
	}

	public int queryCount(String where) {
		return systemAdminDao.queryCount(where);
	}

	public ROMS_SZ_SYSTEMADMIN queryWhere(String where) {
		return systemAdminDao.queryWhere(where);
	}

	public List<ROMS_SZ_SYSTEMADMIN> queryWhereList(String where) {
		return systemAdminDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_SYSTEMADMIN systemAdmin) {
		systemAdminDao.update(systemAdmin);

	}

}
