package com.linkivr.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import util.JsonUtil;
import util.ToJson;

import com.linkivr.model.ROMS_SZ_DEVICE;
import com.linkivr.model.ROMS_SZ_DEVICEAUTH;
import com.linkivr.model.ROMS_SZ_TASK;
import com.linkivr.model.ROMS_SZ_TASKAUTH;
import com.linkivr.model.ROMS_SZ_TASKDEVICE;
import com.linkivr.model.ROMS_SZ_TEMPLATE;
import com.linkivr.service.ROMS_SZ_DEVICEAUTHService;
import com.linkivr.service.ROMS_SZ_DEVICEService;
import com.linkivr.service.ROMS_SZ_DEVICETYPEService;
import com.linkivr.service.ROMS_SZ_TASKAUTHService;
import com.linkivr.service.ROMS_SZ_TASKDEVICEService;
import com.linkivr.service.ROMS_SZ_TASKService;
import com.linkivr.service.ROMS_SZ_TEMPLATEService;
import com.linkivr.service.ROMS_SZ_TEMPLATETYPEService;
import com.opensymphony.xwork2.ActionSupport;

@Component("romsszdeviceAction")
public class ROMS_SZ_DEVICEAction extends ActionSupport {

	 private static final long serialVersionUID = 5255480732540713187L;
	 private String jsonString;
	 
	 private ROMS_SZ_TASKDEVICEService romssztaskdeviceService;
	 private ROMS_SZ_TASKService romssztaskService;
	 private ROMS_SZ_DEVICEService romsszdeviceService;
	 private ROMS_SZ_DEVICETYPEService romsszdevicetypeService;
	 private ROMS_SZ_DEVICEAUTHService romsszdeviceauthService;
	 private ROMS_SZ_TEMPLATEService romssztemplateService;
	 private ROMS_SZ_TEMPLATETYPEService romssztemplatetypeService;
	 private ROMS_SZ_TASKAUTHService romssztaskauthService;
	 
	 
	public String getJsonString() {
		return jsonString;
	}
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	public ROMS_SZ_TASKDEVICEService getRomssztaskdeviceService() {
		return romssztaskdeviceService;
	}
	@Resource
	public void setRomssztaskdeviceService(
			ROMS_SZ_TASKDEVICEService romssztaskdeviceService) {
		this.romssztaskdeviceService = romssztaskdeviceService;
	}
	public ROMS_SZ_TASKService getRomssztaskService() {
		return romssztaskService;
	}
	@Resource
	public void setRomssztaskService(ROMS_SZ_TASKService romssztaskService) {
		this.romssztaskService = romssztaskService;
	}
	public ROMS_SZ_DEVICEService getRomsszdeviceService() {
		return romsszdeviceService;
	}
	@Resource
	public void setRomsszdeviceService(ROMS_SZ_DEVICEService romsszdeviceService) {
		this.romsszdeviceService = romsszdeviceService;
	}
	public ROMS_SZ_DEVICETYPEService getRomsszdevicetypeService() {
		return romsszdevicetypeService;
	}
	@Resource
	public void setRomsszdevicetypeService(
			ROMS_SZ_DEVICETYPEService romsszdevicetypeService) {
		this.romsszdevicetypeService = romsszdevicetypeService;
	}
	public ROMS_SZ_DEVICEAUTHService getRomsszdeviceauthService() {
		return romsszdeviceauthService;
	}
	@Resource
	public void setRomsszdeviceauthService(
			ROMS_SZ_DEVICEAUTHService romsszdeviceauthService) {
		this.romsszdeviceauthService = romsszdeviceauthService;
	}
	public ROMS_SZ_TEMPLATEService getRomssztemplateService() {
		return romssztemplateService;
	}
	@Resource
	public void setRomssztemplateService(
			ROMS_SZ_TEMPLATEService romssztemplateService) {
		this.romssztemplateService = romssztemplateService;
	}
	public ROMS_SZ_TEMPLATETYPEService getRomssztemplatetypeService() {
		return romssztemplatetypeService;
	}
	@Resource
	public void setRomssztemplatetypeService(
			ROMS_SZ_TEMPLATETYPEService romssztemplatetypeService) {
		this.romssztemplatetypeService = romssztemplatetypeService;
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
	 * 平板任务仪器添加接口
	 * @return
	 * @throws Exception 
	 */
	public String app_add_taskdevice() throws Exception{
		org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(ROMS_SZ_DEVICEAction.class);
		logger.info("app_add_taskdevice()函数");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			String json = new String(request.getParameter("data").getBytes("ISO-8859-1"),"utf-8").replaceAll("[\\t\\n\\r]", "");
			logger.info("json="+json);
			String taskId = request.getParameter("taskId");
			logger.info("任务id="+taskId);
			if (json.equals("") || json.equals("[]")) {
				jsonString="{'success':false,'msg':'没有数据'}";
				out.write(jsonString);
				logger.info(jsonString);
				out.flush();
				out.close();
				return null;
			}
			JSONObject a = null;
			Object bean = null;
			JSONArray array = JSONArray.fromObject(json);
			Object[] objArray = array.toArray();
			System.out.println("array length--- "+objArray.length);
			
			ROMS_SZ_TASK task = this.romssztaskService.query(taskId);
			if (task == null) {
				jsonString="{'success':false,'msg':'没有该任务'}";
				out.write(jsonString);
				logger.info(jsonString);
				out.flush();
				out.close();
				return null;
			}
		      String where = " and taskId='" + taskId + "'";
		      List<ROMS_SZ_TASKDEVICE> taskDevices = this.romssztaskdeviceService.queryWhereList(where);
		      logger.info("任务绑定仪器数量=" + taskDevices.size());
		      for (int i = 0; i < taskDevices.size(); i++) {
		        romssztaskdeviceService.delete(taskDevices.get(i).getId());
		      }
		      for (int i = 0; i < objArray.length; i++)
		      {
		        a = JSONObject.fromObject(objArray[i]);
		        bean = JSONObject.toBean(a);
		        MorphDynaBean morphDynaBean = (MorphDynaBean)bean;
		        String deviceId = (String)morphDynaBean.get("deviceId");
		        logger.info("仪器id=" + deviceId);
		        
		        ROMS_SZ_DEVICE device = romsszdeviceService.query(deviceId);
		        if (device == null)
		        {
		          this.jsonString = "{'success':false,'msg':'没有该仪器'}";
		          out.write(this.jsonString);
		          logger.info(this.jsonString);
		          out.flush();
		          out.close();
		          return null;
		        }
		        
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date date = new Date();
		        String time = sdf.format(date);
		        Date datetime = sdf.parse(time);
		        logger.info("当前时间=" + datetime);
		        
		        //设备使用状态（0是空闲，1是占用）
		        //更新仪器状态
		        device.setUseState(0);
		        romsszdeviceService.update(device);
		        
		        //添加任务跟仪器绑定记录
		        ROMS_SZ_TASKDEVICE taskDevice = new ROMS_SZ_TASKDEVICE();
		        taskDevice.setCreatetime(datetime);
		        taskDevice.setTask(task);
		        taskDevice.setDevice(device);
		        this.romssztaskdeviceService.add(taskDevice);
		      }
		} catch (Exception e) {
			e.printStackTrace();
			jsonString="{'errcode':0,'success':false,'msg':'添加失败'}";
			out.write(jsonString);
			logger.info(jsonString);
			out.flush();
			out.close();
			return null;
		}
		jsonString="{'success':true,'msg':'添加成功'}";
		out.write(jsonString);
		logger.info(jsonString);
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 通过模板类型查询仪器
	 * @return
	 * @throws Exception
	 */
	public String app_queryListType() throws Exception{
		org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(ROMS_SZ_DEVICEAction.class);
		logger.info("app_queryListType()函数");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "";
		try {
//			int num = Integer.parseInt(request.getParameter("num"));
//		    logger.info("编号=" + num);
			String taskId = request.getParameter("taskId");
		    logger.info("任务id=" + taskId);
		    String subCompanyId = request.getParameter("subCompanyId");
		    logger.info("子公司id=" + subCompanyId);
		      
		    String where = " and taskId='"+taskId+"'";
		    ROMS_SZ_TASKAUTH taskauth = romssztaskauthService.queryWhere(where);
		    if (taskauth == null) {
		    	jsonString = "{'data':[]}";
			    out.write(this.jsonString);
			    logger.info(this.jsonString);
			    out.flush();
			    out.close();
			    return null;
			}else if (taskauth.getTemplate() == null) {
				jsonString = "{'data':[]}";
			    out.write(this.jsonString);
			    logger.info(this.jsonString);
			    out.flush();
			    out.close();
			    return null;
			}else if (taskauth.getDeviceType() == null) {
				jsonString = "{'data':[]}";
			    out.write(this.jsonString);
			    logger.info(this.jsonString);
			    out.flush();
			    out.close();
			    return null;
			}
		    String where1 = " and templateId='"+taskauth.getTemplate().getId()+"' and deviceTypeId='"+taskauth.getDeviceType().getId()+"' and deviceId is not null order by createtime desc ";
		    List<ROMS_SZ_DEVICEAUTH> deviceAuths = romsszdeviceauthService.queryWhereList(where1);
		    logger.info("模板绑定仪器数量=" + deviceAuths.size());
		    
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    SimpleDateFormat sdf_yMd = new SimpleDateFormat("yyyy-MM-dd");
		    
		    String lowerTime = "";
		    int as = 0;
		    String where2 = "";
		    ROMS_SZ_DEVICE device = null;
		    Date date = new Date();
		    Date dateTime = sdf_yMd.parse(sdf_yMd.format(date));
		    
		    for (int i = 0; i < deviceAuths.size(); i++) {
		    	where2 = " and id='"+deviceAuths.get(i).getDevice().getId()+"' and subCompanyId='"+subCompanyId+"'";
		    	device = romsszdeviceService.queryWhere(where2);
		    	
		    	if (device == null) {
					continue;
				}else{
					//state 设备状态（0是正常，1是准用，2是停用）
			        //useState 设备使用状态（0是空闲，1是占用）
					//correctTime 证书有效日期
					//判断是否过了检定日期
					if (device.getCorrectTime() != null && !device.getCorrectTime().equals("")) {
						Date parse = sdf_yMd.parse(device.getCorrectTime());
						
						if (dateTime.getTime() > parse.getTime()) {
							continue;
						}
					}
					
					//判断仪器是否停用或者占用
					if (device.getState() == 2 || device.getUseState() == 1) {
						continue;
					}
					
					if (as != 0) {
				       data = data + ",";
				    }
					
					if (device.getLowerTime() != null) {
			        	lowerTime = sdf.format(device.getLowerTime());
					}
			        String t = "{'deviceId':'"+device.getId()
			        	+"','deviceNum':'"+device.getDeviceNum()
			        	+"','deviceName':'"+device.getDeviceName()
			        	+"','deviceModel':'"+device.getDeviceModel()
			        	+"','deviceFactor1':'"+device.getDeviceFactor1()
			        	+"','deviceFactor2':'"+device.getDeviceFactor2()
			        	+"','deviceFactor3':'"+device.getDeviceFactor3()
			        	+"','deviceFactor4':'"+device.getDeviceFactor4()
			        	+"','deviceFactor5':'"+device.getDeviceFactor5()
			        	+"','factor1':'"+device.getFactor1()
			        	+"','factor2':'"+device.getFactor2()
			        	+"','factor3':'"+device.getFactor3()
			        	+"','factor4':'"+device.getFactor4()
			        	+"','equivalentRate1':'"+device.getEquivalentRate1()
			        	+"','equivalentRate2':'"+device.getEquivalentRate2()
			        	+"','equivalentRate3':'"+device.getEquivalentRate3()
			        	+"','equivalentRate4':'"+device.getEquivalentRate4()
			        	+"','alpha':'"+device.getAlpha()
			        	+"','beta':'"+device.getBeta()
			        	+"','vol1':'"+device.getVol1()
			        	+"','vol2':'"+device.getVol2()
			        	+"','vol3':'"+device.getVol3()
			        	+"','vol4':'"+device.getVol4()
			        	+"','vol5':'"+device.getVol5()
			        	+"','correctNum':'"+device.getCorrectNum()
			        	+"','correctTime':'"+device.getCorrectTime()
			        	+"','deviceLower':'"+device.getDeviceLower()
			        	+"','LowerTime':'"+lowerTime
			        	+"','state':'"+device.getState()
			        	+"','useState':'"+device.getUseState()
			        	+"','correctNum1':'"+device.getCorrectNum1()
			        	+"','correctTime1':'"+device.getCorrectTime1()
			        	+"','deviceFactor_gdy':'"+device.getDeviceFactor_gdy()
			        	+"','deviceFactor':'"+device.getDeviceFactor()
			        	+"','factor':'"+device.getFactor()
			        	+"'}";
			        
			        data += t;
			        as++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonString = "{'errcode':0,'data':[]}";
	        out.write(jsonString);
	        logger.info(jsonString);
	        out.flush();
	        out.close();
	        return null;
		}
		jsonString = "{'data':["+data+"]}";
        out.write(jsonString);
        logger.info(jsonString);
        out.flush();
        out.close();
		return null;
	}
	
	/**
	 * 更新仪器使用状态接口
	 * @return
	 * @throws Exception
	 */
	public String updateUseState() throws Exception{
		org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(ROMS_SZ_DEVICEAction.class);
		logger.info("updateUseState()函数");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			String deviceId = request.getParameter("deviceId");
			logger.info("仪器id"+deviceId);
			int useState = Integer.parseInt(request.getParameter("useState"));
			logger.info("0是空闲，1是占用"+useState);
			
			ROMS_SZ_DEVICE device = romsszdeviceService.query(deviceId);
			if (device == null) {
				jsonString = "{'success':false,'msg':'没有该仪器'}";
		        out.write(jsonString);
		        logger.info(jsonString);
		        out.flush();
		        out.close();
		        return null;
			}
			device.setUseState(useState);
			romsszdeviceService.update(device);
		} catch (Exception e) {
			e.printStackTrace();
			jsonString = "{'errcode':0,'success':false,'msg':'更新失败'}";
	        out.write(jsonString);
	        logger.info(jsonString);
	        out.flush();
	        out.close();
	        return null;
		}
		jsonString = "{'success':true,'msg':'更新成功'}";
        out.write(jsonString);
        logger.info(jsonString);
        out.flush();
        out.close();
        return null;
	}
}
