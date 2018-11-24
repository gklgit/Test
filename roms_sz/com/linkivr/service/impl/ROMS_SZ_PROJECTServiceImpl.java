package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_PROJECTDao;
import com.linkivr.model.ROMS_SZ_PROJECT;
import com.linkivr.service.ROMS_SZ_PROJECTService;

@Component("romsszprojectService")
@Transactional
public class ROMS_SZ_PROJECTServiceImpl implements ROMS_SZ_PROJECTService {

	private ROMS_SZ_PROJECTDao romsszprojectDao;
	
	public ROMS_SZ_PROJECTDao getRomsszprojectDao() {
		return romsszprojectDao;
	}
	@Resource
	public void setRomsszprojectDao(ROMS_SZ_PROJECTDao romsszprojectDao) {
		this.romsszprojectDao = romsszprojectDao;
	}

	public void add(ROMS_SZ_PROJECT project) {
		romsszprojectDao.add(project);

	}

	public int delete(String where) {
		return romsszprojectDao.delete(where);
	}

	public ROMS_SZ_PROJECT query(String id) {
		return romsszprojectDao.query(id);
	}

	public List<ROMS_SZ_PROJECT> queryAll() {
		return romsszprojectDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszprojectDao.queryCount(where);
	}

	public ROMS_SZ_PROJECT queryWhere(String where) {
		return romsszprojectDao.queryWhere(where);
	}

	public List<ROMS_SZ_PROJECT> queryWhereList(String where) {
		return romsszprojectDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_PROJECT project) {
		romsszprojectDao.update(project);

	}

}
