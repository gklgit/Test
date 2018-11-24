package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_DOCDao;
import com.linkivr.model.ROMS_SZ_DOC;
import com.linkivr.service.ROMS_SZ_DOCService;

@Component("romsszdocService")
@Transactional
public class ROMS_SZ_DOCServiceImpl implements ROMS_SZ_DOCService {

	private ROMS_SZ_DOCDao docDao;
	
	public ROMS_SZ_DOCDao getDocDao() {
		return docDao;
	}
	@Resource
	public void setDocDao(ROMS_SZ_DOCDao docDao) {
		this.docDao = docDao;
	}

	public void add(ROMS_SZ_DOC doc) {
		docDao.add(doc);

	}

	public int delete(String where) {
		return docDao.delete(where);
	}

	public ROMS_SZ_DOC query(String id) {
		return docDao.query(id);
	}

	public List<ROMS_SZ_DOC> queryAll() {
		return docDao.queryAll();
	}

	public int queryCount(String where) {
		return docDao.queryCount(where);
	}

	public ROMS_SZ_DOC queryWhere(String where) {
		return docDao.queryWhere(where);
	}

	public List<ROMS_SZ_DOC> queryWhereList(String where) {
		return docDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_DOC doc) {
		docDao.update(doc);

	}

}
