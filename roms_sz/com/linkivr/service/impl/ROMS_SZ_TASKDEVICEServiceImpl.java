package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_TASKDEVICEDao;
import com.linkivr.model.ROMS_SZ_TASKDEVICE;
import com.linkivr.service.ROMS_SZ_TASKDEVICEService;

@Component("romssztaskdeviceService")
@Transactional
public class ROMS_SZ_TASKDEVICEServiceImpl implements ROMS_SZ_TASKDEVICEService {

	private ROMS_SZ_TASKDEVICEDao romssztaskdeviceDao;
	
	public ROMS_SZ_TASKDEVICEDao getRomssztaskdeviceDao() {
		return romssztaskdeviceDao;
	}
	@Resource
	public void setRomssztaskdeviceDao(ROMS_SZ_TASKDEVICEDao romssztaskdeviceDao) {
		this.romssztaskdeviceDao = romssztaskdeviceDao;
	}

	public void add(ROMS_SZ_TASKDEVICE taskDevice) {
		romssztaskdeviceDao.add(taskDevice);

	}

	public int delete(String where) {
		return romssztaskdeviceDao.delete(where);
	}

	public ROMS_SZ_TASKDEVICE query(String id) {
		return romssztaskdeviceDao.query(id);
	}

	public List<ROMS_SZ_TASKDEVICE> queryAll() {
		return romssztaskdeviceDao.queryAll();
	}

	public int queryCount(String where) {
		return romssztaskdeviceDao.queryCount(where);
	}

	public ROMS_SZ_TASKDEVICE queryWhere(String where) {
		return romssztaskdeviceDao.queryWhere(where);
	}

	public List<ROMS_SZ_TASKDEVICE> queryWhereList(String where) {
		return romssztaskdeviceDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_TASKDEVICE taskDevice) {
		romssztaskdeviceDao.update(taskDevice);

	}

}
