package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_APPLYDao;
import com.linkivr.model.ROMS_SZ_APPLY;
import com.linkivr.service.ROMS_SZ_APPLYService;

@Component("romsszapplyService")
@Transactional
public class ROMS_SZ_APPLYServiceImpl implements ROMS_SZ_APPLYService {

	private ROMS_SZ_APPLYDao applyDao;
	
	public ROMS_SZ_APPLYDao getApplyDao() {
		return applyDao;
	}
	
	@Resource
	public void setApplyDao(ROMS_SZ_APPLYDao applyDao) {
		this.applyDao = applyDao;
	}

	public void add(ROMS_SZ_APPLY apply) {
		applyDao.add(apply);

	}

	public int delete(String where) {
		return applyDao.delete(where);
	}

	public ROMS_SZ_APPLY query(String id) {
		return applyDao.query(id);
	}

	public List<ROMS_SZ_APPLY> queryAll() {
		return applyDao.queryAll();
	}

	public int queryCount(String where) {
		return applyDao.queryCount(where);
	}

	public ROMS_SZ_APPLY queryWhere(String where) {
		return applyDao.queryWhere(where);
	}

	public List<ROMS_SZ_APPLY> queryWhereList(String where) {
		return applyDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_APPLY apply) {
		applyDao.update(apply);

	}

}
