package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_TEMPLATEDao;
import com.linkivr.model.ROMS_SZ_TEMPLATE;
import com.linkivr.service.ROMS_SZ_TEMPLATEService;

@Component("romssztemplateService")
@Transactional
public class ROMS_SZ_TEMPLATEServiceImpl implements ROMS_SZ_TEMPLATEService {

	private ROMS_SZ_TEMPLATEDao romssztemplateDao;
	
	public ROMS_SZ_TEMPLATEDao getRomssztemplateDao() {
		return romssztemplateDao;
	}
	@Resource
	public void setRomssztemplateDao(ROMS_SZ_TEMPLATEDao romssztemplateDao) {
		this.romssztemplateDao = romssztemplateDao;
	}

	public void add(ROMS_SZ_TEMPLATE template) {
		romssztemplateDao.add(template);

	}

	public int delete(String where) {
		return romssztemplateDao.delete(where);
	}

	public ROMS_SZ_TEMPLATE query(String id) {
		return romssztemplateDao.query(id);
	}

	public List<ROMS_SZ_TEMPLATE> queryAll() {
		return romssztemplateDao.queryAll();
	}

	public int queryCount(String where) {
		return romssztemplateDao.queryCount(where);
	}

	public ROMS_SZ_TEMPLATE queryWhere(String where) {
		return romssztemplateDao.queryWhere(where);
	}

	public List<ROMS_SZ_TEMPLATE> queryWhereList(String where) {
		return romssztemplateDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_TEMPLATE template) {
		romssztemplateDao.update(template);

	}

}
