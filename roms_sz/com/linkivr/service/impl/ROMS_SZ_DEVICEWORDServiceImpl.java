package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_DEVICEWORDDao;
import com.linkivr.model.ROMS_SZ_DEVICEWORD;
import com.linkivr.service.ROMS_SZ_DEVICEWORDService;

@Component("romsszdevicewordService")
@Transactional
public class ROMS_SZ_DEVICEWORDServiceImpl implements ROMS_SZ_DEVICEWORDService {

	private ROMS_SZ_DEVICEWORDDao deviceWordDao;
	
	public ROMS_SZ_DEVICEWORDDao getDeviceWordDao() {
		return deviceWordDao;
	}
	@Resource
	public void setDeviceWordDao(ROMS_SZ_DEVICEWORDDao deviceWordDao) {
		this.deviceWordDao = deviceWordDao;
	}

	public void add(ROMS_SZ_DEVICEWORD deviceWord) {
		deviceWordDao.add(deviceWord);

	}

	public int delete(String id) {
		return deviceWordDao.delete(id);
	}

	public ROMS_SZ_DEVICEWORD query(String id) {
		return deviceWordDao.query(id);
	}

	public List<ROMS_SZ_DEVICEWORD> queryAll() {
		return deviceWordDao.queryAll();
	}

	public int queryCount(String where) {
		return deviceWordDao.queryCount(where);
	}

	public ROMS_SZ_DEVICEWORD queryWhere(String where) {
		return deviceWordDao.queryWhere(where);
	}

	public List<ROMS_SZ_DEVICEWORD> queryWhereList(String where) {
		return deviceWordDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_DEVICEWORD deviceWord) {
		deviceWordDao.update(deviceWord);

	}

}
