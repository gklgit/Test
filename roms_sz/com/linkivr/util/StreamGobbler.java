/*
 * �������� 2010-10-20
 *
 * TODO Ҫ��Ĵ���ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package com.linkivr.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;



public  class StreamGobbler extends Thread  {
    InputStream is;   
    String type;  
    String outStr;
    int flag;
       
    public StreamGobbler(InputStream is, String type)   
    {   
        this.is = is;   
        this.type = type;         
    }   
       
    public void run()   
    {   
    	 
    	flag=0;
    	StringBuffer strBuffer=new StringBuffer();        //��Ҫ�����ҳ����ַ�
        try   
        {   
        	Date start = new Date();
            InputStreamReader isr = new InputStreamReader(is);   
            BufferedReader br = new BufferedReader(isr);   
            String line=null;   
           // strBuffer.append(line+"\\n");
            strBuffer.append(line+"<br/>");
            while ( (line = br.readLine()) != null)   
            {   
            	//strBuffer.append(line+"\\n");
            	strBuffer.append(line+"<br/>");
            	//strBuffer.append(line+"<html><p>");
            
              //  System.out.println(type + ">" + line);                  
               // System.out.flush();   
            	try {
					sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            	
            	Date now = new Date();
            	long ss = now.getTime()-start.getTime();
            	
            	
            	if(ss>5000)
            	{
            		break;
            	}
            } 
            flag=1;
            outStr=strBuffer.toString();
           
         } catch (IOException ioe)   
              {   
                ioe.printStackTrace();     
              } 
            
    }

	public String getOutStr() {
		return outStr;
	}

	public void setOutStr(String outStr) {
		this.outStr = outStr;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}     
}
