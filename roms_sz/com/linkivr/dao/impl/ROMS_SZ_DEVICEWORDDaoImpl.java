package com.linkivr.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.linkivr.dao.ROMS_SZ_DEVICEWORDDao;
import com.linkivr.model.ROMS_SZ_DEVICEWORD;

@Component("romsszdevicewordDao")
public class ROMS_SZ_DEVICEWORDDaoImpl implements ROMS_SZ_DEVICEWORDDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(ROMS_SZ_DEVICEWORD deviceWord) {
		this.sessionFactory.getCurrentSession().merge(deviceWord);

	}

	public int delete(String id) {
		return  sessionFactory.getCurrentSession()
		.createQuery("delete ROMS_SZ_DEVICEWORD  where id=:id ")
		.setString("id", id)
		.executeUpdate();
	}

	public ROMS_SZ_DEVICEWORD query(String id) {
		String hql = "from ROMS_SZ_DEVICEWORD where  id=:id";
	    System.out.println(hql);
	    System.out.println("id=" + id);
	    return (ROMS_SZ_DEVICEWORD)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .setString("id", id)
	      .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ROMS_SZ_DEVICEWORD> queryAll() {
		String hql = "from ROMS_SZ_DEVICEWORD order by id";
	    System.out.println(hql);
	    return sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .list();
	}

	public int queryCount(String where) {
		String hql = "select count(*) from ROMS_SZ_DEVICEWORD where 1=1 " + where;
	    System.out.println(hql);
	    Integer count = Integer.valueOf(0);
	    Long lo = (Long)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .uniqueResult();
	    count = new Integer(String.valueOf(lo));
	    System.out.println("queryCount=" + count);
	    return count.intValue();
	}

	public ROMS_SZ_DEVICEWORD queryWhere(String where) {
		String hql = "from ROMS_SZ_DEVICEWORD where 1=1 " + where;
	    System.out.println(hql);
	    return (ROMS_SZ_DEVICEWORD)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ROMS_SZ_DEVICEWORD> queryWhereList(String where) {
		String hql = "from ROMS_SZ_DEVICEWORD where 1=1 " + where;
	    System.out.println(hql);
	    return sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .list();
	}

	public void update(ROMS_SZ_DEVICEWORD deviceWord) {
		sessionFactory.getCurrentSession().merge(deviceWord);

	}

}
