package com.linkivr.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.linkivr.dao.ROMS_SZ_TASKDao;
import com.linkivr.model.ROMS_SZ_TASK;

@Component("romssztaskDao")
public class ROMS_SZ_TASKDaoImpl implements ROMS_SZ_TASKDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ROMS_SZ_TASK> queryAll() {
		
		String hql="from ROMS_SZ_TASK order by id";
		System.out.println(hql);
		return sessionFactory.getCurrentSession()
		.createQuery(hql)
		.list();
		
	}
	
	public int queryCount(String where)
	{
		String hql="select count(*) from ROMS_SZ_TASK where 1=1 " + where;
		System.out.println(hql);
		Integer count = 0;
		Long lo = (Long)sessionFactory.getCurrentSession()
		.createQuery(hql)
		.uniqueResult();   
		count = new Integer(String.valueOf(lo)); 
		System.out.println("queryCount="+count);
		return count;
	}
	public void add(ROMS_SZ_TASK task)  {
		
		sessionFactory.getCurrentSession().merge(task);
	}
	
	public int delete(String id)  {
		
		return  sessionFactory.getCurrentSession()
		.createQuery("delete ROMS_SZ_TASK  where id=:id ")
		.setString("id", id)
		.executeUpdate();
	}
	public void update(ROMS_SZ_TASK task)
	{
		sessionFactory.getCurrentSession().merge(task);
	}
	public ROMS_SZ_TASK query(String id)
	{
		String hql="from ROMS_SZ_TASK where  id=:id";
		System.out.println(hql);
		System.out.println("id="+id);
		return (ROMS_SZ_TASK)sessionFactory.getCurrentSession()
		.createQuery(hql)
		.setString("id", id)
		.uniqueResult(); 
		
	}
	
	public ROMS_SZ_TASK queryWhere(String where){
		String hql="from ROMS_SZ_TASK where 1=1 "+where;
		System.out.println(hql);
		return (ROMS_SZ_TASK) sessionFactory.getCurrentSession()
		.createQuery(hql)
		.uniqueResult(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<ROMS_SZ_TASK> queryWhereList(String where){
		String hql="from ROMS_SZ_TASK where 1=1 "+where;
		System.out.println(hql);
		return sessionFactory.getCurrentSession()
		.createQuery(hql)
		.list(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<ROMS_SZ_TASK> queryPageSort(Date starttime,Date endtime,String where,int start,int pagesize,int sortflag){
		String sql ="";
		if (sortflag == 0) {
			if(starttime!=null&&!starttime.equals(endtime))
			{	
				sql = "from  ROMS_SZ_TASK task where  createtime between :starttime and :endtime "+where+" order by createtime desc";
				System.out.println(sql);
				return   sessionFactory.getCurrentSession()
				.createQuery(sql)
				.setTimestamp("starttime", starttime)
				.setTimestamp("endtime",endtime)
				.setFirstResult(start)
				.setMaxResults(pagesize)
				.list();
			}
			else
			{
				sql = "from  ROMS_SZ_TASK task where 1=1 "+where +" order by createtime desc";
				System.out.println(sql);
				return   sessionFactory.getCurrentSession()
				.createQuery(sql)
				.setFirstResult(start)
				.setMaxResults(pagesize)
				.list();
			}
		}else{
			if(starttime!=null&&!starttime.equals(endtime))
			{	
				sql = "from  ROMS_SZ_TASK task where  createtime between :starttime and :endtime "+where+" order by createtime";
				System.out.println(sql);
				return   sessionFactory.getCurrentSession()
				.createQuery(sql)
				.setTimestamp("starttime", starttime)
				.setTimestamp("endtime",endtime)
				.setFirstResult(start)
				.setMaxResults(pagesize)
				.list();
			}
			else
			{
				sql = "from  ROMS_SZ_TASK task where 1=1 "+where +" order by createtime";
				System.out.println(sql);
				return   sessionFactory.getCurrentSession()
				.createQuery(sql)
				.setFirstResult(start)
				.setMaxResults(pagesize)
				.list();
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ROMS_SZ_TASK> querySort(Date starttime,Date endtime,String where,int sortflag){
		String sql ="";
		if (sortflag == 0) {
			if(starttime!=null&&!starttime.equals(endtime))
			{	
				sql = "from  ROMS_SZ_TASK where  createtime between :starttime and :endtime "+where+" order by createtime desc";
				System.out.println(sql);
				return   sessionFactory.getCurrentSession()
				.createQuery(sql)
				.setTimestamp("starttime", starttime)
				.setTimestamp("endtime",endtime)
				.list();
			}
			else
			{
				sql = "from  ROMS_SZ_TASK where 1=1 "+where +" order by createtime desc";
				System.out.println(sql);
				return   sessionFactory.getCurrentSession()
				.createQuery(sql)
				.list();
			}
		}else{
			if(starttime!=null&&!starttime.equals(endtime))
			{	
				sql = "from  ROMS_SZ_TASK where  createtime between :starttime and :endtime "+where+" order by createtime";
				System.out.println(sql);
				return   sessionFactory.getCurrentSession()
				.createQuery(sql)
				.setTimestamp("starttime", starttime)
				.setTimestamp("endtime",endtime)
				.list();
			}
			else
			{
				sql = "from  ROMS_SZ_TASK where 1=1 "+where +" order by createtime";
				System.out.println(sql);
				return   sessionFactory.getCurrentSession()
				.createQuery(sql)
				.list();
			}
		}
	}
	public int queryCount(Date starttime,Date endtime,String where,int sortflag){
		String hql ="";
		Integer count = 0;
		if (sortflag == 0) {
			if(starttime!=null&&!starttime.equals(endtime))
			{	
				hql = "select count(*) from  ROMS_SZ_TASK task where  createtime between :starttime and :endtime "+where+" order by createtime desc";
				System.out.println(hql);
				
				Long lo = (Long)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setTimestamp("starttime", starttime)
				.setTimestamp("endtime",endtime)
				.uniqueResult();   
				count = new Integer(String.valueOf(lo)); 
				System.out.println("queryCount="+count);
				return count;
			}
			else
			{
				hql = "select count(*) from  ROMS_SZ_TASK task where 1=1 "+where +" order by createtime desc";
				System.out.println(hql);
				Long lo = (Long)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.uniqueResult();   
				count = new Integer(String.valueOf(lo)); 
				System.out.println("queryCount="+count);
				return count;
			}
		}else{
			if(starttime!=null&&!starttime.equals(endtime))
			{	
				hql = "select count(*) from  ROMS_SZ_TASK task where  createtime between :starttime and :endtime "+where+" order by createtime";
				System.out.println(hql);
				Long lo = (Long)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setTimestamp("starttime", starttime)
				.setTimestamp("endtime",endtime)
				.uniqueResult();   
				count = new Integer(String.valueOf(lo)); 
				System.out.println("queryCount="+count);
				return count;
			}
			else
			{
				hql = "select count(*) from  ROMS_SZ_TASK task where 1=1 "+where +" order by createtime";
				System.out.println(hql);
				Long lo = (Long)sessionFactory.getCurrentSession()
				.createQuery(hql)
				.uniqueResult();   
				count = new Integer(String.valueOf(lo)); 
				System.out.println("queryCount="+count);
				return count;
			}
		}
	}
	
	
	//查询对应任务信息
	public ROMS_SZ_TASK queryOtherTask(String where){
		String hql="SELECT task FROM " +
				"ROMS_SZ_TASK task,ROMS_SZ_TASKAUTH taskAuth,ROMS_SZ_DEVICETYPE deviceType " +
				"WHERE task.id=taskAuth.task AND " +
				"taskAuth.deviceType=deviceType.id "+where;
		System.out.println(hql);
		return (ROMS_SZ_TASK) sessionFactory.getCurrentSession()
		.createQuery(hql)
		.uniqueResult(); 
	}

}
