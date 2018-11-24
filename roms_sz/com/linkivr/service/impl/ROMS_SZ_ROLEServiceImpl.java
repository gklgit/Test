package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_ROLEDao;
import com.linkivr.model.ROMS_SZ_ROLE;
import com.linkivr.service.ROMS_SZ_ROLEService;

@Component("romsszroleService")
@Transactional
public class ROMS_SZ_ROLEServiceImpl implements
		ROMS_SZ_ROLEService {

	private ROMS_SZ_ROLEDao romsszroleDao;
	
	public ROMS_SZ_ROLEDao getRomsszroleDao() {
		return romsszroleDao;
	}
	@Resource
	public void setRomsszroleDao(
			ROMS_SZ_ROLEDao romsszroleDao) {
		this.romsszroleDao = romsszroleDao;
	}

	public void add(ROMS_SZ_ROLE role) {
		romsszroleDao.add(role);

	}

	public int delete(String where) {
		return romsszroleDao.delete(where);
	}

	public ROMS_SZ_ROLE query(String id) {
		return romsszroleDao.query(id);
	}

	public List<ROMS_SZ_ROLE> queryAll() {
		return romsszroleDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszroleDao.queryCount(where);
	}

	public ROMS_SZ_ROLE queryWhere(String where) {
		return romsszroleDao.queryWhere(where);
	}

	public List<ROMS_SZ_ROLE> queryWhereList(String where) {
		return romsszroleDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_ROLE role) {
		romsszroleDao.update(role);

	}

}
