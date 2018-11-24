package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_TASKAUTHDao;
import com.linkivr.model.ROMS_SZ_TASKAUTH;
import com.linkivr.service.ROMS_SZ_TASKAUTHService;

@Component("romssztaskauthService")
@Transactional
public class ROMS_SZ_TASKAUTHServiceImpl implements ROMS_SZ_TASKAUTHService {

	private ROMS_SZ_TASKAUTHDao romssztaskauthDao;
	
	public ROMS_SZ_TASKAUTHDao getRomssztaskauthDao() {
		return romssztaskauthDao;
	}
	@Resource
	public void setRomssztaskauthDao(ROMS_SZ_TASKAUTHDao romssztaskauthDao) {
		this.romssztaskauthDao = romssztaskauthDao;
	}

	public void add(ROMS_SZ_TASKAUTH taskAuth) {
		romssztaskauthDao.add(taskAuth);

	}

	public int delete(String where) {
		return romssztaskauthDao.delete(where);
	}

	public ROMS_SZ_TASKAUTH query(String id) {
		return romssztaskauthDao.query(id);
	}

	public List<ROMS_SZ_TASKAUTH> queryAll() {
		return romssztaskauthDao.queryAll();
	}

	public int queryCount(String where) {
		return romssztaskauthDao.queryCount(where);
	}

	public ROMS_SZ_TASKAUTH queryWhere(String where) {
		return romssztaskauthDao.queryWhere(where);
	}

	public List<ROMS_SZ_TASKAUTH> queryWhereList(String where) {
		return romssztaskauthDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_TASKAUTH taskAuth) {
		romssztaskauthDao.update(taskAuth);

	}

}
