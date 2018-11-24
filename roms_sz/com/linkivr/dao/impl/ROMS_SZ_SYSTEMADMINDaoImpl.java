package com.linkivr.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.linkivr.dao.ROMS_SZ_SYSTEMADMINDao;
import com.linkivr.model.ROMS_SZ_SYSTEMADMIN;

@Component("romsszsystemadminDao")
public class ROMS_SZ_SYSTEMADMINDaoImpl implements ROMS_SZ_SYSTEMADMINDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(ROMS_SZ_SYSTEMADMIN systemAdmin) {
		this.sessionFactory.getCurrentSession().merge(systemAdmin);

	}

	public int delete(String id) {
		return  sessionFactory.getCurrentSession()
		.createQuery("delete ROMS_SZ_SYSTEMADMIN  where id=:id ")
		.setString("id", id)
		.executeUpdate();
	}

	public ROMS_SZ_SYSTEMADMIN query(String id) {
		String hql = "from ROMS_SZ_SYSTEMADMIN where  id=:id";
	    System.out.println(hql);
	    System.out.println("id=" + id);
	    return (ROMS_SZ_SYSTEMADMIN)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .setString("id", id)
	      .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ROMS_SZ_SYSTEMADMIN> queryAll() {
		String hql = "from ROMS_SZ_SYSTEMADMIN order by id";
	    System.out.println(hql);
	    return sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .list();
	}

	public int queryCount(String where) {
		String hql = "select count(*) from ROMS_SZ_SYSTEMADMIN where 1=1 " + where;
	    System.out.println(hql);
	    Integer count = Integer.valueOf(0);
	    Long lo = (Long)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .uniqueResult();
	    count = new Integer(String.valueOf(lo));
	    System.out.println("queryCount=" + count);
	    return count.intValue();
	}

	public ROMS_SZ_SYSTEMADMIN queryWhere(String where) {
		String hql = "from ROMS_SZ_SYSTEMADMIN where 1=1 " + where;
	    System.out.println(hql);
	    return (ROMS_SZ_SYSTEMADMIN)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ROMS_SZ_SYSTEMADMIN> queryWhereList(String where) {
		String hql = "from ROMS_SZ_SYSTEMADMIN where 1=1 " + where;
	    System.out.println(hql);
	    return sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .list();
	}

	public void update(ROMS_SZ_SYSTEMADMIN systemAdmin) {
		sessionFactory.getCurrentSession().merge(systemAdmin);

	}

}
