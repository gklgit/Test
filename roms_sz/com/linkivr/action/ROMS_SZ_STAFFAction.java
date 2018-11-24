package com.linkivr.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.linkivr.model.ROMS_SZ_STAFF;
import com.linkivr.model.ROMS_SZ_TASK;
import com.linkivr.model.ROMS_SZ_TASKAUTH;
import com.linkivr.model.ROMS_SZ_TASKSTAFF;
import com.linkivr.service.ROMS_SZ_PROJECTService;
import com.linkivr.service.ROMS_SZ_STAFFAUTHService;
import com.linkivr.service.ROMS_SZ_STAFFService;
import com.linkivr.service.ROMS_SZ_TASKAUTHService;
import com.linkivr.service.ROMS_SZ_TASKSTAFFService;
import com.linkivr.service.ROMS_SZ_TASKService;
import com.opensymphony.xwork2.ActionSupport;

@Component("romsszstaffAction")
public class ROMS_SZ_STAFFAction extends ActionSupport {

	private static final long serialVersionUID = 5255480732540713187L;
	private String jsonString;
	
	private ROMS_SZ_STAFFService romsszstaffService;
	private ROMS_SZ_TASKSTAFFService romssztaskstaffService;
	private ROMS_SZ_PROJECTService romsszprojectService;
	private ROMS_SZ_TASKService romssztaskService;
	private ROMS_SZ_STAFFAUTHService romsszstaffauthService;
	private ROMS_SZ_TASKAUTHService romssztaskauthService;
	
	public String getJsonString() {
		return jsonString;
	}
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	public ROMS_SZ_STAFFService getRomsszstaffService() {   
		return romsszstaffService;
	}
	@Resource
	public void setRomsszstaffService(ROMS_SZ_STAFFService romsszstaffService) {
		this.romsszstaffService = romsszstaffService;
	}
	public ROMS_SZ_TASKSTAFFService getRomssztaskstaffService() {
		return romssztaskstaffService;
	}
	@Resource
	public void setRomssztaskstaffService(
			ROMS_SZ_TASKSTAFFService romssztaskstaffService) {
		this.romssztaskstaffService = romssztaskstaffService;
	}
	public ROMS_SZ_PROJECTService getRomsszprojectService() {
		return romsszprojectService;
	}
	@Resource
	public void setRomsszprojectService(ROMS_SZ_PROJECTService romsszprojectService) {
		this.romsszprojectService = romsszprojectService;
	}
	public ROMS_SZ_TASKService getRomssztaskService() {
		return romssztaskService;
	}
	@Resource
	public void setRomssztaskService(ROMS_SZ_TASKService romssztaskService) {
		this.romssztaskService = romssztaskService;
	}
	public ROMS_SZ_STAFFAUTHService getRomsszstaffauthService() {
		return romsszstaffauthService;
	}
	@Resource
	public void setRomsszstaffauthService(
			ROMS_SZ_STAFFAUTHService romsszstaffauthService) {
		this.romsszstaffauthService = romsszstaffauthService;
	}
	public ROMS_SZ_TASKAUTHService getRomssztaskauthService() {
		return romssztaskauthService;
	}
	@Resource
	public void setRomssztaskauthService(
			ROMS_SZ_TASKAUTHService romssztaskauthService) {
		this.romssztaskauthService = romssztaskauthService;
	}
	
	/**
	 * 工作人员登录接口
	 * @return
	 * @throws Exception
	 */
	public String app_staffLogin() throws Exception{
		org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(ROMS_SZ_STAFFAction.class);
		logger.info("app_staffLogin()函数");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		ROMS_SZ_STAFF staff = null;
	    String data = "";
	    try {
	    	String phone = request.getParameter("phone");
	        logger.info("工作人员电话=" + phone);
	        
	        if (phone == null) {
	        	jsonString = "{'success':false,'msg':'电话为空'}";
	        	out.write(jsonString);
	        	logger.info(jsonString);
	        	out.flush();
	        	out.close();
	        	return null;
			}
	       
	        String where = " and staffPhone='"+phone+"' and unusable=0";
	        staff = romsszstaffService.queryWhere(where);
	        if (staff == null) {
	        	jsonString = "{'success':false,'msg':'没有该人员'}";
	        	out.write(jsonString);
	        	logger.info(jsonString);
	        	out.flush();
	        	out.close();
	        	return null;
			}
	        String where1 = " and staffId='"+staff.getId()+"' and taskId is not null";
	        List<ROMS_SZ_TASKSTAFF> taskStaffs = romssztaskstaffService.queryWhereList(where1);
	        logger.info("任务绑定人员数量="+taskStaffs.size());
	        
	        int as = 0;
	        for (int i = 0; i < taskStaffs.size(); i++) {
	        	if (taskStaffs.get(i).getTask().getDocUrl() == null && taskStaffs.get(i).getTask().getProject().getDocUrl() == null) {
	        		if (as != 0) {
	  	              data += ",";
	  	            }
	        		logger.info("任务id="+taskStaffs.get(i).getTask().getId());
	  	            String where2 = " and taskId='" + taskStaffs.get(i).getTask().getId() + "'";
	  	            ROMS_SZ_TASKAUTH taskauth = romssztaskauthService.queryWhere(where2);
	  	            
	  	            String note = "";
	  	            if (taskStaffs.get(i).getTask().getNote() != null) {
						note = taskStaffs.get(i).getTask().getNote();
					}
	  	            
	  	            String t = "{'id':'"+taskStaffs.get(i).getTask().getId()
	  	            +"','createtime':'"+taskStaffs.get(i).getTask().getCreatetime()
	  	            +"','checkUnitName':'"+taskStaffs.get(i).getTask().getCheckUnitName()
	  	            +"','checkDeviceName':'"+taskStaffs.get(i).getTask().getCheckDeviceName()
	  	            +"','lng':'"+taskStaffs.get(i).getTask().getLng()
	  	            +"','lat':'"+taskStaffs.get(i).getTask().getLat()
	  	            +"','type':'"+taskauth.getDeviceType().getNum()
	  	            +"','subType':'"+taskauth.getTemplate().getNum()
	  	            +"','category':'"+taskauth.getDeviceType().getDeviceMain().getType()
	  	            +"','longTime':'"+taskStaffs.get(i).getTask().getCreatetime().getTime()
	  	            +"','note':'"+note
	  	            +"'}";
	  	            
	  	            data += t;
	  	            as++;
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
			jsonString = "{'errcode':0,'success':false,'msg':'登录失败'}";
        	out.write(jsonString);
        	logger.info(jsonString);
        	out.flush();
        	out.close();
        	return null;
		}
		jsonString = "{'success':true,'msg':'登录成功','staffId':'"+staff.getId()+"','data':["+data+"]}";
    	out.write(jsonString);
    	logger.info(jsonString);
    	out.flush();
    	out.close();
    	return null;
	}
	
	
	/**
	 * 工作人员登录接口
	 * @return
	 * @throws Exception
	 */
	public String app_staffLogin_x() throws Exception{
		org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(ROMS_SZ_STAFFAction.class);
		logger.info("app_staffLogin_x()函数");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		ROMS_SZ_STAFF staff = null;
	    String data = "";
	    try {
	    	String phone = request.getParameter("phone");
	        logger.info("工作人员电话=" + phone);
	        int type = Integer.parseInt(request.getParameter("type"));
	        logger.info("1是放射，2是卫生=" + type);
	        
	        if (phone == null) {
	        	jsonString = "{'success':false,'msg':'电话为空'}";
	        	out.write(jsonString);
	        	logger.info(jsonString);
	        	out.flush();
	        	out.close();
	        	return null;
			}
	        
	        
	        String where = " and staffPhone='"+phone+"' and unusable=0";
	        staff = romsszstaffService.queryWhere(where);
	        if (staff == null) {
	        	jsonString = "{'success':false,'msg':'没有该人员'}";
	        	out.write(jsonString);
	        	logger.info(jsonString);
	        	out.flush();
	        	out.close();
	        	return null;
			}
	        String where1 = " and staffId='"+staff.getId()+"' and taskId is not null and type=0";
	        List<ROMS_SZ_TASKSTAFF> taskStaffs = romssztaskstaffService.queryWhereList(where1);
	        logger.info("任务绑定人员数量="+taskStaffs.size());
	        
	        int as = 0;
	        String audit = "";
	        for (int i = 0; i < taskStaffs.size(); i++) {
	        	String taskId = taskStaffs.get(i).getTask().getId();
        		logger.info("任务id="+taskId);
        		ROMS_SZ_TASK task = romssztaskService.query(taskId);
        		
        		//返回除了通过了的所有任务
	        	if (task.getPass() != 2) {
	        		String where2 = " and taskId='" + taskId + "'";
	        		ROMS_SZ_TASKAUTH taskauth = romssztaskauthService.queryWhere(where2);
	  	            
	  	            String note = "";
	  	            if (taskStaffs.get(i).getTask().getNote1() != null) {
						note = taskStaffs.get(i).getTask().getNote1();
					}
	  	            //判断是否跟要查询的类型一样
	        		if (task.getProject().getGlobalType() == type) {
	        			if (as != 0) {
	  	  	              data += ",";
	  	  	            }
	        			
	        			int pass = task.getPass();
	        			
	        			if (pass == 0) {
	        				audit = "未审核";
	        			}else if (pass == 1) {
	        				audit = "未通过";
	        			}else if (pass == 2){ 
	        				audit = "通过";
	        			}else{
	        				audit = "未上传";
	        			}
	        			
	        			String t = "{'id':'"+task.getId()
		  	            +"','createtime':'"+task.getCreatetime()
		  	            +"','checkUnitName':'"+task.getCheckUnitName()
		  	            +"','checkDeviceName':'"+task.getCheckDeviceName()
		  	            +"','lng':'"+task.getLng()
		  	            +"','lat':'"+task.getLat()
		  	            +"','type':'"+taskauth.getDeviceType().getNum()
		  	            +"','subType':'"+taskauth.getTemplate().getNum()
		  	            +"','category':'"+taskauth.getDeviceType().getDeviceMain().getType()
		  	            +"','longTime':'"+task.getCreatetime().getTime()
		  	            +"','note':'"+note
		  	            +"','name':'"+taskauth.getDeviceType().getName()
		  	            +"','templateName':'"+taskauth.getTemplate().getName()
		  	            +"','address':'"+task.getAddress()
		  	            +"','projectNum':'"+task.getProjectNum()
		  	            +"','needTime':'"+task.getNeedTime()
		  	            +"','expectTime':'"+task.getExpectTime()
		  	            +"','monitorType':'"+task.getMonitorType()
		  	            +"','checkUnitPhone':'"+task.getCheckUnitPhone()
		  	            +"','checkUnitContact':'"+task.getCheckUnitContact()
		  	            +"','mainType':'"+taskauth.getDeviceType().getDeviceMain().getType()
		  	            +"','pass':'"+audit
		  	            +"','docReason':'"+task.getDocReason()
		  	            +"'}";
		  	            
		  	            data += t;
		  	            as++;
					}else{
						continue;
					}
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
			jsonString = "{'errcode':0,'success':false,'msg':'登录失败'}";
        	out.write(jsonString);
        	logger.info(jsonString);
        	out.flush();
        	out.close();
        	return null;
		}
		jsonString = "{'success':true,'msg':'登录成功','staffId':'"+staff.getId()+"','subCompanyId':'"+staff.getSubCompany().getId()+"','data':["+data+"]}";
    	out.write(jsonString);
    	logger.info(jsonString);
    	out.flush();
    	out.close();
    	return null;
	}
	
}
