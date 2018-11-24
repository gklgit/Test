package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_TEMPLATETYPEDao;
import com.linkivr.model.ROMS_SZ_TEMPLATETYPE;
import com.linkivr.service.ROMS_SZ_TEMPLATETYPEService;

@Component("romssztemplatetypeService")
@Transactional
public class ROMS_SZ_TEMPLATETYPEServiceImpl implements
		ROMS_SZ_TEMPLATETYPEService {

	private ROMS_SZ_TEMPLATETYPEDao romssztemplatetypeDao;
	
	public ROMS_SZ_TEMPLATETYPEDao getRomssztemplatetypeDao() {
		return romssztemplatetypeDao;
	}
	@Resource
	public void setRomssztemplatetypeDao(
			ROMS_SZ_TEMPLATETYPEDao romssztemplatetypeDao) {
		this.romssztemplatetypeDao = romssztemplatetypeDao;
	}

	public void add(ROMS_SZ_TEMPLATETYPE templateType) {
		romssztemplatetypeDao.add(templateType);

	}

	public int delete(String where) {
		return romssztemplatetypeDao.delete(where);
	}

	public ROMS_SZ_TEMPLATETYPE query(String id) {
		return romssztemplatetypeDao.query(id);
	}

	public List<ROMS_SZ_TEMPLATETYPE> queryAll() {
		return romssztemplatetypeDao.queryAll();
	}

	public int queryCount(String where) {
		return romssztemplatetypeDao.queryCount(where);
	}

	public ROMS_SZ_TEMPLATETYPE queryWhere(String where) {
		return romssztemplatetypeDao.queryWhere(where);
	}

	public List<ROMS_SZ_TEMPLATETYPE> queryWhereList(String where) {
		return romssztemplatetypeDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_TEMPLATETYPE templateType) {
		romssztemplatetypeDao.update(templateType);

	}

}
