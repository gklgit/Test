package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_SUBCOMPANYDao;
import com.linkivr.model.ROMS_SZ_SUBCOMPANY;
import com.linkivr.service.ROMS_SZ_SUBCOMPANYService;

@Component("romsszsubcompanyService")
@Transactional
public class ROMS_SZ_SUBCOMPANYServiceImpl implements ROMS_SZ_SUBCOMPANYService {

	private ROMS_SZ_SUBCOMPANYDao romsszsubcompanyDao;
	
	public ROMS_SZ_SUBCOMPANYDao getRomsszsubcompanyDao() {
		return romsszsubcompanyDao;
	}
	@Resource
	public void setRomsszsubcompanyDao(ROMS_SZ_SUBCOMPANYDao romsszsubcompanyDao) {
		this.romsszsubcompanyDao = romsszsubcompanyDao;
	}

	public void add(ROMS_SZ_SUBCOMPANY subCompany) {
		romsszsubcompanyDao.add(subCompany);

	}

	public int delete(String where) {
		return romsszsubcompanyDao.delete(where);
	}

	public ROMS_SZ_SUBCOMPANY query(String id) {
		return romsszsubcompanyDao.query(id);
	}

	public List<ROMS_SZ_SUBCOMPANY> queryAll() {
		return romsszsubcompanyDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszsubcompanyDao.queryCount(where);
	}

	public ROMS_SZ_SUBCOMPANY queryWhere(String where) {
		return romsszsubcompanyDao.queryWhere(where);
	}

	public List<ROMS_SZ_SUBCOMPANY> queryWhereList(String where) {
		return romsszsubcompanyDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_SUBCOMPANY subCompany) {
		romsszsubcompanyDao.update(subCompany);

	}

}
