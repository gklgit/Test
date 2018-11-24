package com.linkivr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_TASKSTATEDao;
import com.linkivr.model.ROMS_SZ_TASKSTATE;
import com.linkivr.service.ROMS_SZ_TASKSTATEService;

@Component("romssztaskstateService")
@Transactional
public class ROMS_SZ_TASKSTATEServiceImpl implements ROMS_SZ_TASKSTATEService {

	private ROMS_SZ_TASKSTATEDao taskStateDao;
	
	public ROMS_SZ_TASKSTATEDao getTaskStateDao() {
		return taskStateDao;
	}

	@Resource
	public void setTaskStateDao(ROMS_SZ_TASKSTATEDao taskStateDao) {
		this.taskStateDao = taskStateDao;
	}

	public void add(ROMS_SZ_TASKSTATE taskState) {
		taskStateDao.add(taskState);

	}

	public int delete(String where) {
		return taskStateDao.delete(where);
	}

	public ROMS_SZ_TASKSTATE query(String id) {
		return taskStateDao.query(id);
	}

	public List<ROMS_SZ_TASKSTATE> queryAll() {
		return taskStateDao.queryAll();
	}

	public int queryCount(String where) {
		return taskStateDao.queryCount(where);
	}

	public ROMS_SZ_TASKSTATE queryWhere(String where) {
		return taskStateDao.queryWhere(where);
	}

	public List<ROMS_SZ_TASKSTATE> queryWhereList(String where) {
		return taskStateDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_TASKSTATE taskState) {
		taskStateDao.update(taskState);

	}

}
