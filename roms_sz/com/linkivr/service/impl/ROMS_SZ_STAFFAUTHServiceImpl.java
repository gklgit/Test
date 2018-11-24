package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_STAFFAUTHDao;
import com.linkivr.model.ROMS_SZ_STAFFAUTH;
import com.linkivr.service.ROMS_SZ_STAFFAUTHService;

@Component("romsszstaffauthService")
@Transactional
public class ROMS_SZ_STAFFAUTHServiceImpl implements ROMS_SZ_STAFFAUTHService {

	private ROMS_SZ_STAFFAUTHDao romsszstaffauthDao;
	
	public ROMS_SZ_STAFFAUTHDao getRomsszstaffauthDao() {
		return romsszstaffauthDao;
	}
	@Resource
	public void setRomsszstaffauthDao(ROMS_SZ_STAFFAUTHDao romsszstaffauthDao) {
		this.romsszstaffauthDao = romsszstaffauthDao;
	}

	public void add(ROMS_SZ_STAFFAUTH staffAuth) {
		romsszstaffauthDao.add(staffAuth);

	}

	public int delete(String where) {
		return romsszstaffauthDao.delete(where);
	}

	public ROMS_SZ_STAFFAUTH query(String id) {
		return romsszstaffauthDao.query(id);
	}

	public List<ROMS_SZ_STAFFAUTH> queryAll() {
		return romsszstaffauthDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszstaffauthDao.queryCount(where);
	}

	public ROMS_SZ_STAFFAUTH queryWhere(String where) {
		return romsszstaffauthDao.queryWhere(where);
	}

	public List<ROMS_SZ_STAFFAUTH> queryWhereList(String where) {
		return romsszstaffauthDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_STAFFAUTH staffAuth) {
		romsszstaffauthDao.update(staffAuth);

	}

}
