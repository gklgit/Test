package com.linkivr.util;

public class AlgorithmUtil {

	private static Double v50 = null;
	private static Double v60 = null;
	private static Double v70 = null;
	private static Double v80 = null;
	private static Double v90 = null;
	private static Double v100 = null;
	private static Double v110 = null;
	private static Double v120 = null;
	private static Double v125 = null;
	private static Double result = null;
	
	public static void main(String[] args) {
		Double result = ypj(55.0,90.0);
		System.out.println(result);
	}
	

	//牙片机
	public static Double ypj(Double value,Double nominalCpacity){
		//50~70
		if (nominalCpacity <= 70 && nominalCpacity >= 50) {
			v50 = 1.5;
			v60 = 1.5;
			v70 = 1.5;
			//50-60
			if (value <= 60 && value >= 50) {
				result = (v60-v50)*(value-50)/10+v50;
			}else{
				//60-70
				result = (v70-v60)*(value-60)/10+v60;
			}
			
		}else{
			//50~90
			v50 = 1.5;
			v60 = 1.8;
			v70 = 2.1;
			v80 = 2.3;
			v90 = 2.5;
			//50-60
			if (value <= 60 && value >= 50) {
				result = (v60-v50)*(value-50)/10+v50;
			}else if (value <= 70 && value > 60) {
				//60-70
				result = (v70-v60)*(value-60)/10+v60;
			}else if (value <= 80 && value > 70) {
				//70-80
				result = (v80-v70)*(value-70)/10+v70;
			}else if (value <= 90 && value > 80) {
				//80-90
				result = (v90-v80)*(value-80)/10+v80;
			}
		}
		
		return result;
	}
	
	
	
	//其他牙科应用
	public static Double OtherYk(Double value,Double nominalCpacity){
		//50~70
		if (nominalCpacity <= 70 && nominalCpacity >= 50) {
			v50 = 1.2;
			v60 = 1.3;
			v70 = 1.5;
			//50-60
			if (value <= 60 && value >= 50) {
				result = (v60-v50)*(value-50)/10+v50;
			}else{
				//60-70
				result = (v70-v60)*(value-60)/10+v60;
			}
			
		}else{
			//50~90
			v50 = 1.5;
			v60 = 1.8;
			v70 = 2.1;
			v80 = 2.3;
			v90 = 2.5;
			v100 = 2.7;
			v110 = 3.0;
			v120 = 3.2;
			v125 = 3.3;
			//50-60
			if (value <= 60 && value >= 50) {
				result = (v60-v50)*(value-50)/10+v50;
			}else if (value <= 70 && value > 60) {
				//60-70
				result = (v70-v60)*(value-60)/10+v60;
			}else if (value <= 80 && value > 70) {
				//70-80
				result = (v80-v70)*(value-70)/10+v70;
			}else if (value <= 90 && value > 80) {
				//80-90
				result = (v90-v80)*(value-80)/10+v80;
			}else if (value <= 100 && value > 90) {
				//90-100
				result = (v100-v90)*(value-90)/10+v90;
			}else if (value <= 110 && value > 100) {
				//100-110
				result = (v110-v100)*(value-100)/10+v100;
			}else if (value <= 120 && value > 110) {
				//110-120
				result = (v120-v110)*(value-110)/10+v110;
			}else if (value <= 125 && value > 120) {
				//120-125
				result = (v125-v120)*(value-120)/5+v120;
			}
		}
		return result;
	}
	
	
	//口内机机
	public static Double knj(Double value,Double nominalCpacity){
		//60~70
		if (nominalCpacity <= 70 && nominalCpacity >= 60) {
			v60 = 1.5;
			v70 = 1.5;
			//60-70
			if (value <= 70 && value >= 60) {
				result = (v70-v60)*(value-60)/10+v60;
			}
			
		}else{
			//60~90
			v60 = 1.8;
			v70 = 2.1;
			v80 = 2.3;
			v90 = 2.5;
			//60-70
			if (value <= 70 && value > 60) {
				result = (v70-v60)*(value-60)/10+v60;
			}else if (value <= 80 && value > 70) {
				//70-80
				result = (v80-v70)*(value-70)/10+v70;
			}else if (value <= 90 && value > 80) {
				//80-90
				result = (v90-v80)*(value-80)/10+v80;
			}
		}
		
		return result;
	}
	
	//口外机
	public static Double kwj(Double value,Double nominalCpacity){
		//60~70
		if (nominalCpacity <= 70 && nominalCpacity >= 60) {
			v60 = 1.3;
			v70 = 1.5;
			//60-70
			if (value <= 70 && value >= 60) {
				result = (v70-v60)*(value-60)/10+v60;
			}
			
		}else{
			//60~125
			v60 = 1.8;
			v70 = 2.1;
			v80 = 2.3;
			v90 = 2.5;
			v100 = 2.7;
			v110 = 3.0;
			v120 = 3.2;
			v125 = 3.3;
			//60-70
			if (value <= 70 && value > 60) {
				result = (v70-v60)*(value-60)/10+v60;
			}else if (value <= 80 && value > 70) {
				//70-80
				result = (v80-v70)*(value-70)/10+v70;
			}else if (value <= 90 && value > 80) {
				//80-90
				result = (v90-v80)*(value-80)/10+v80;
			}else if (value <= 100 && value > 90) {
				//90-100
				result = (v100-v90)*(value-90)/10+v90;
			}else if (value <= 110 && value > 100) {
				//100-110
				result = (v110-v100)*(value-100)/10+v100;
			}else if (value <= 120 && value > 110) {
				//110-120
				result = (v120-v110)*(value-110)/10+v110;
			}else if (value <= 125 && value > 120) {
				//120-125
				result = (v125-v120)*(value-120)/5+v120;
			}
		}
		return result;
	}
	
	
}
