package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_DEVICETYPEDao;
import com.linkivr.model.ROMS_SZ_DEVICETYPE;
import com.linkivr.service.ROMS_SZ_DEVICETYPEService;

@Component("romsszdevicetypeService")
@Transactional
public class ROMS_SZ_DEVICETYPEServiceImpl implements ROMS_SZ_DEVICETYPEService {

	private ROMS_SZ_DEVICETYPEDao romsszdevicetypeDao;
	
	public ROMS_SZ_DEVICETYPEDao getRomsszdevicetypeDao() {
		return romsszdevicetypeDao;
	}
	@Resource
	public void setRomsszdevicetypeDao(ROMS_SZ_DEVICETYPEDao romsszdevicetypeDao) {
		this.romsszdevicetypeDao = romsszdevicetypeDao;
	}

	public void add(ROMS_SZ_DEVICETYPE deviceType) {
		romsszdevicetypeDao.add(deviceType);

	}

	public int delete(String where) {
		return romsszdevicetypeDao.delete(where);
	}

	public ROMS_SZ_DEVICETYPE query(String id) {
		return romsszdevicetypeDao.query(id);
	}

	public List<ROMS_SZ_DEVICETYPE> queryAll() {
		return romsszdevicetypeDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszdevicetypeDao.queryCount(where);
	}

	public ROMS_SZ_DEVICETYPE queryWhere(String where) {
		return romsszdevicetypeDao.queryWhere(where);
	}

	public List<ROMS_SZ_DEVICETYPE> queryWhereList(String where) {
		return romsszdevicetypeDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_DEVICETYPE deviceType) {
		romsszdevicetypeDao.update(deviceType);

	}

}
