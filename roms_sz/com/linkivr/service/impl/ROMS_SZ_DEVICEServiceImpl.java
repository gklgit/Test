package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_DEVICEDao;
import com.linkivr.model.ROMS_SZ_DEVICE;
import com.linkivr.service.ROMS_SZ_DEVICEService;

@Component("romsszdeviceService")
@Transactional
public class ROMS_SZ_DEVICEServiceImpl implements ROMS_SZ_DEVICEService {

	private ROMS_SZ_DEVICEDao romsszdeviceDao;
	
	public ROMS_SZ_DEVICEDao getRomsszdeviceDao() {
		return romsszdeviceDao;
	}
	@Resource
	public void setRomsszdeviceDao(ROMS_SZ_DEVICEDao romsszdeviceDao) {
		this.romsszdeviceDao = romsszdeviceDao;
	}

	public void add(ROMS_SZ_DEVICE device) {
		romsszdeviceDao.add(device);

	}

	public int delete(String where) {
		return romsszdeviceDao.delete(where);
	}

	public ROMS_SZ_DEVICE query(String id) {
		return romsszdeviceDao.query(id);
	}

	public List<ROMS_SZ_DEVICE> queryAll() {
		return romsszdeviceDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszdeviceDao.queryCount(where);
	}

	public ROMS_SZ_DEVICE queryWhere(String where) {
		return romsszdeviceDao.queryWhere(where);
	}

	public List<ROMS_SZ_DEVICE> queryWhereList(String where) {
		return romsszdeviceDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_DEVICE device) {
		romsszdeviceDao.update(device);

	}

}
