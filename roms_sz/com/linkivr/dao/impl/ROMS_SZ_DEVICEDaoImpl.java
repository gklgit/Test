package com.linkivr.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.linkivr.dao.ROMS_SZ_DEVICEDao;
import com.linkivr.model.ROMS_SZ_DEVICE;

@Component("romsszdeviceDao")
public class ROMS_SZ_DEVICEDaoImpl implements ROMS_SZ_DEVICEDao {
	
	private SessionFactory sessionFactory;
	  
	  public SessionFactory getSessionFactory(){
	    return this.sessionFactory;
	  }
	  
	  @Resource
	  public void setSessionFactory(SessionFactory sessionFactory){
	    this.sessionFactory = sessionFactory;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<ROMS_SZ_DEVICE> queryAll()
	  {
	    String hql = "from ROMS_SZ_DEVICE order by id";
	    System.out.println(hql);
	    return sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .list();
	  }
	  
	  public int queryCount(String where)
	  {
	    String hql = "select count(*) from ROMS_SZ_DEVICE where 1=1 " + where;
	    System.out.println(hql);
	    Integer count = Integer.valueOf(0);
	    Long lo = (Long)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .uniqueResult();
	    count = new Integer(String.valueOf(lo));
	    System.out.println("queryCount=" + count);
	    return count.intValue();
	  }
	  
	  public void add(ROMS_SZ_DEVICE device)
	  {
	    this.sessionFactory.getCurrentSession().merge(device);
	  }
	  
	  public int delete(String id)  {
			
			return  sessionFactory.getCurrentSession()
			.createQuery("delete ROMS_SZ_DEVICE  where id=:id ")
			.setString("id", id)
			.executeUpdate();
		}
	  
	  public void update(ROMS_SZ_DEVICE device)
	  {
	    sessionFactory.getCurrentSession().merge(device);
	  }
	  
	  public ROMS_SZ_DEVICE query(String id)
	  {
	    String hql = "from ROMS_SZ_DEVICE where  id=:id";
	    System.out.println(hql);
	    System.out.println("id=" + id);
	    return (ROMS_SZ_DEVICE)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .setString("id", id)
	      .uniqueResult();
	  }
	  
	  public ROMS_SZ_DEVICE queryWhere(String where)
	  {
	    String hql = "from ROMS_SZ_DEVICE where 1=1 " + where;
	    System.out.println(hql);
	    return (ROMS_SZ_DEVICE)sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .uniqueResult();
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<ROMS_SZ_DEVICE> queryWhereList(String where)
	  {
	    String hql = "from ROMS_SZ_DEVICE where 1=1 " + where;
	    System.out.println(hql);
	    return sessionFactory.getCurrentSession()
	      .createQuery(hql)
	      .list();
	  }
	
}
