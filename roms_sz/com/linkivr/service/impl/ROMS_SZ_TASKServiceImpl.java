package com.linkivr.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.linkivr.dao.ROMS_SZ_TASKDao;
import com.linkivr.model.ROMS_SZ_TASK;
import com.linkivr.service.ROMS_SZ_TASKService;

@Component("romssztaskService")
@Transactional
public class ROMS_SZ_TASKServiceImpl implements ROMS_SZ_TASKService {

	private ROMS_SZ_TASKDao romssztaskDao;
	
	public ROMS_SZ_TASKDao getRomssztaskDao() {
		return romssztaskDao;
	}
	@Resource
	public void setRomssztaskDao(ROMS_SZ_TASKDao romssztaskDao) {
		this.romssztaskDao = romssztaskDao;
	}

	public void add(ROMS_SZ_TASK task) {
		romssztaskDao.add(task);

	}

	public int delete(String id) {
		return romssztaskDao.delete(id);
	}

	public ROMS_SZ_TASK query(String id) {
		return romssztaskDao.query(id);
	}

	public List<ROMS_SZ_TASK> queryAll() {
		return romssztaskDao.queryAll();
	}

	public int queryCount(String where) {
		return romssztaskDao.queryCount(where);
	}

	public int queryCount(Date starttime, Date endtime, String where,
			int sortflag) {
		return romssztaskDao.queryCount(starttime, endtime, where, sortflag);
	}

	public List<ROMS_SZ_TASK> queryPageSort(Date starttime, Date endtime,
			String where, int start, int pagesize, int sortflag) {
		return romssztaskDao.queryPageSort(starttime, endtime, where, start, pagesize, sortflag);
	}

	public List<ROMS_SZ_TASK> querySort(Date starttime, Date endtime,
			String where, int sortflag) {
		return romssztaskDao.querySort(starttime, endtime, where, sortflag);
	}

	public ROMS_SZ_TASK queryWhere(String where) {
		return romssztaskDao.queryWhere(where);
	}

	public List<ROMS_SZ_TASK> queryWhereList(String where) {
		return romssztaskDao.queryWhereList(where);
	}

	public void update(ROMS_SZ_TASK task) {
		romssztaskDao.update(task);

	}
	public ROMS_SZ_TASK queryOtherTask(String where) {
		return romssztaskDao.queryOtherTask(where);
	}

}
