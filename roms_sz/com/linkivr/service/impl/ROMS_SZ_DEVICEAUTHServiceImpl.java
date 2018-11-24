package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_DEVICEAUTHDao;
import com.linkivr.model.ROMS_SZ_DEVICEAUTH;
import com.linkivr.service.ROMS_SZ_DEVICEAUTHService;

@Component("romsszdeviceauthService")
@Transactional
public class ROMS_SZ_DEVICEAUTHServiceImpl implements ROMS_SZ_DEVICEAUTHService {

	private ROMS_SZ_DEVICEAUTHDao romsszdeviceauthDao;
	
	public ROMS_SZ_DEVICEAUTHDao getRomsszdeviceauthDao() {
		return romsszdeviceauthDao;
	}
	@Resource
	public void setRomsszdeviceauthDao(ROMS_SZ_DEVICEAUTHDao romsszdeviceauthDao) {
		this.romsszdeviceauthDao = romsszdeviceauthDao;
	}

	public void add(ROMS_SZ_DEVICEAUTH deviceAuth) {
		romsszdeviceauthDao.add(deviceAuth);

	}

	public int delete(String where) {
		return romsszdeviceauthDao.delete(where);
	}

	public ROMS_SZ_DEVICEAUTH query(String id) {
		return romsszdeviceauthDao.query(id);
	}

	public List<ROMS_SZ_DEVICEAUTH> queryAll() {
		return romsszdeviceauthDao.queryAll();
	}

	public int queryCount(String where) {
		return romsszdeviceauthDao.queryCount(where);
	}

	public ROMS_SZ_DEVICEAUTH queryWhere(String where) {
		return romsszdeviceauthDao.queryWhere(where);
	}

	public List<ROMS_SZ_DEVICEAUTH> queryWhereList(String where) {
		return romsszdeviceauthDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_DEVICEAUTH deviceAuth) {
		romsszdeviceauthDao.update(deviceAuth);

	}

}
