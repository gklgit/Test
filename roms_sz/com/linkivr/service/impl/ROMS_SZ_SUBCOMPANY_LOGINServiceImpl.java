package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_SUBCOMPANY_LOGINDao;
import com.linkivr.model.ROMS_SZ_SUBCOMPANY_LOGIN;
import com.linkivr.service.ROMS_SZ_SUBCOMPANY_LOGINService;

@Component("romsszsubcompanyloginService")
@Transactional
public class ROMS_SZ_SUBCOMPANY_LOGINServiceImpl implements
		ROMS_SZ_SUBCOMPANY_LOGINService {

	private ROMS_SZ_SUBCOMPANY_LOGINDao romsszsubcompanyloginDao;
	
	public ROMS_SZ_SUBCOMPANY_LOGINDao getRomsszsubcompanyloginDao() {
		return romsszsubcompanyloginDao;
	}
	@Resource
	public void setRomsszsubcompanyloginDao(
			ROMS_SZ_SUBCOMPANY_LOGINDao romsszsubcompanyloginDao) {
		this.romsszsubcompanyloginDao = romsszsubcompanyloginDao;
	}

	public void add(ROMS_SZ_SUBCOMPANY_LOGIN login) {
		romsszsubcompanyloginDao.add(login);

	}

	public int delete(String where) {
		return romsszsubcompanyloginDao.delete(where);
	}

	public ROMS_SZ_SUBCOMPANY_LOGIN query(String id) {
		return romsszsubcompanyloginDao.query(id);
	}

	public List<ROMS_SZ_SUBCOMPANY_LOGIN> queryAll() {
		return romsszsubcompanyloginDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszsubcompanyloginDao.queryCount(where);
	}

	public ROMS_SZ_SUBCOMPANY_LOGIN queryWhere(String where) {
		return romsszsubcompanyloginDao.queryWhere(where);
	}

	public List<ROMS_SZ_SUBCOMPANY_LOGIN> queryWhereList(String where) {
		return romsszsubcompanyloginDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_SUBCOMPANY_LOGIN login) {
		romsszsubcompanyloginDao.update(login);

	}

}
