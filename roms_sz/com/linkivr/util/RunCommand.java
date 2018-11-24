/*
 * �������� 2010-10-20
 *
 * TODO Ҫ��Ĵ���ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package com.linkivr.util;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class RunCommand {

	
    
    public static Map<String,String> run(String cmd) {  
    	Map<String,String> returnMap = new HashMap<String,String>();
    	int exitVal = -1;  
    	String errStr=null;  
    	String outputStr = null;  
        Runtime runtime = Runtime.getRuntime();  
        
        
        try {  
            Process proc = runtime.exec(cmd);  
        	Date start = new Date(); 
            // any error message? 
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR"); 
            // any output?
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT"); 
            errorGobbler.start();
            outputGobbler.start();    
            exitVal = proc.waitFor();  //���ִ����ȷ���򷵻�=0
            
            proc.getOutputStream().close(); //�ر�proc�����
            
            exitVal = proc.waitFor();  //���ִ����ȷ���ҽ����򷵻�=0
            //System.out.println("ExitValue: " + exitVal);  
            //System.out.println("String[] cmd--------->"+outputGobbler.getOutStr());
            
            while (outputGobbler.getFlag()==0){
 
            	
            	Date now = new Date();
            	long ss = now.getTime()-start.getTime();
            	
            	
            	if(ss>5000)
            	{
            		break;
            	}
            }
            while(errorGobbler.getFlag()==0){
            	
            	Date now = new Date();
            	long ss = now.getTime()-start.getTime();
            	
            	
            	if(ss>5000)
            	{
            		break;
            	}
            }
            outputStr = outputGobbler.getOutStr();
            errStr = errorGobbler.getOutStr();              
            System.out.println("outputStr----->"+outputStr);
           
        } catch (IOException e) {  
            System.out.println(e.getMessage()); 
            exitVal = -1;
           
        } catch (InterruptedException e) {  
        	System.out.println(e.getMessage()); 
        	exitVal = -2;        	 
        }  
        returnMap.put("exitVal",Integer.toString(exitVal));
        returnMap.put("errStr", errStr);
        returnMap.put("outputStr", outputStr);
        
       
        
        return returnMap ;
    } 
    
  
    public static Map<String,String> run(String[] cmd) {  
        
    	Map<String,String> returnMap = new HashMap<String,String>();
    	int exitVal = -1;  //���ؽ��    	
    	String errStr=null;  //����������
    	String outputStr = null;  //��ȷ������
        Runtime runtime = Runtime.getRuntime(); 
        
        try {  
            Process proc = runtime.exec(cmd);  
               
            // any error message? 
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR"); 
            // any output?
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT"); 
            errorGobbler.start();
            outputGobbler.start();              
           
            proc.getOutputStream().close(); //�ر�proc�����
            
          
            exitVal = proc.waitFor();  //���ִ����ȷ���ҽ����򷵻�=0
            
            	//System.out.println("ExitValue: " + exitVal);  
            //System.out.println("String[] cmd--------->"+outputGobbler.getOutStr());
          
        	Date start = new Date();
            
            while (outputGobbler.getFlag()==0){
 
            	
            	
            
            	Date now = new Date();
            	long ss = now.getTime()-start.getTime();
            	
            	
            	if(ss>5000)
            	{
            		break;
            	}
            	
            }
            while(errorGobbler.getFlag()==0){
            	
            	Date now = new Date();
            	long ss = now.getTime()-start.getTime();
            	
            	
            	if(ss>5000)
            	{
            		break;
            	}
            }
            outputStr = outputGobbler.getOutStr();
            errStr = errorGobbler.getOutStr();              
            
           
        } catch (IOException e) {  
            System.out.println(e.getMessage()); 
            exitVal = -1;
        }
        
        catch (InterruptedException e) {  
        	System.out.println(e.getMessage()); 
        	exitVal = -2;
        }  
        
        returnMap.put("exitVal",Integer.toString(exitVal));
        returnMap.put("errStr", errStr);
        returnMap.put("outputStr", outputStr);
        
        return returnMap ;
    }  
 public static Map<String,String> run5(String[] cmd) {  
        
    	Map<String,String> returnMap = new HashMap<String,String>();
    	int exitVal = -1;  //���ؽ��    	
    	String errStr=null;  //����������
    	String outputStr = null;  //��ȷ������
        Runtime runtime = Runtime.getRuntime(); 
        
        try {  
            Process proc = runtime.exec(cmd);  
               
            // any error message? 
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR"); 
            // any output?
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT"); 
            errorGobbler.start();
            outputGobbler.start();              
           
            proc.getOutputStream().close(); //�ر�proc�����
            
          
           // exitVal = proc.waitFor();  //���ִ����ȷ���ҽ����򷵻�=0
            
            	//System.out.println("ExitValue: " + exitVal);  
            //System.out.println("String[] cmd--------->"+outputGobbler.getOutStr());
          
        	Date start = new Date();
            
            while (outputGobbler.getFlag()==0){
 
            	
            	
            
            	Date now = new Date();
            	long ss = now.getTime()-start.getTime();
            	
            	
            	if(ss>5000)
            	{
            		break;
            	}
            	
            }
            while(errorGobbler.getFlag()==0){
            	
            	Date now = new Date();
            	long ss = now.getTime()-start.getTime();
            	
            	
            	if(ss>5000)
            	{
            		break;
            	}
            }
            outputStr = outputGobbler.getOutStr();
            errStr = errorGobbler.getOutStr();              
           
           
        } catch (IOException e) {  
            System.out.println(e.getMessage()); 
            exitVal = -1;
        }
       
        
        returnMap.put("exitVal",Integer.toString(exitVal));
        returnMap.put("errStr", errStr);
        returnMap.put("outputStr", outputStr);
       
        return returnMap ;
    }  
  
    //--------------------------------------------------------
	public static void main(String[] args) {
		
		Properties props = System.getProperties();
		System.out.println("os="+props.getProperty("os.name"));
		System.out.println("os="+props.getProperty("os.arch"));
		
	}


}
