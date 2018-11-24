package com.linkivr.util;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
//封装四舍六入的计算方法类
public class CalculateUtil {
  private static String dot_marker= "\\.";//小数点符号
    //计算平均值
    //isRA2判断是否选择的是RAM-II型环境级X、γ辐射剂量率仪测量
    //若选用RAM-II型环境级X、γ辐射剂量率仪测量，平均值为3个测量值的算数平均值除以1.14；
    // 若选用其他设备测量，平均值为3个测量值的算术平均值
    public static String[] getResult(String[] list,String factor,boolean isRA2){ //返回的数组分别对应平均值，报告值，标准差
        int dot=0;//判断输入的数有几位小数
        int dot1=0;
        int dot2=0;
        if(list.length==0){
            return new String[]{"","",""};
        }
        if(!ConfirmDataType.isNumber(factor)) factor="1";
        int len=0;
        float ff=0;
        for(int i=0;i<list.length;i++){
            if(ConfirmDataType.isNumber(list[i])) {
                ff += Float.parseFloat(list[i]);
                if(list[i].contains(".")){
                    if(dot<=list[i].substring(list[i].indexOf(".")+1).length()){
                        dot=list[i].substring(list[i].indexOf(".")+1).length();
                    }

                }
                len++;
            }

        }
        if(len==0) return new String[]{"","",""};
        //根据输入的数值计算平均值,在输入的数值基础上多保留一位有效数字
        StringBuffer formatType=new StringBuffer("#.0");
        for (int i=0;i<dot;i++){
            formatType.append("0");
        }
        java.text.DecimalFormat df = new java.text.DecimalFormat(formatType.toString());
        //        df.format()
        String avg=ff/(len+0.0f)+"";
        if(isRA2){ //如果选择了RAM-II型环境级X、γ辐射剂量率仪测量
            avg=(ff/(len+0.0f))/1.14+"";
        }
        String reportValue="";//报告值
        String correct="";
        //四舍六入五考虑规则

        if(avg.contains(".")){ //计算的平均值有小数
                      int len1=avg.substring(avg.indexOf(".")+1).length();
            if(len1<dot){
//                StringBuilder builder=new StringBuilder(avg);  //使用过程中发现偶尔会抛出内存溢出异常，所以改为字符串拼接方式
                for (int i=0;i<dot-len1+1;i++){
//                    builder.append("0");
                   avg= avg+"0";
                }
//                avg=builder.toString();
            }else if(len1==dot){
                avg=avg+"0";
            }else if(len1>dot){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
                if(dot+1<len1){
                    //四舍六入五考虑
                    String s=avg.substring(avg.indexOf(".")+dot+2,avg.indexOf(".")+dot+3);
                     int c=Integer.parseInt(s);
                    if(c<=4){ //四舍
                     avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                        if(avg.substring(avg.length()-1).equals(".")) avg=avg.replace(".","");
                    }else if(c==5){ //五考虑
                       if(len1-dot-1==1){//5后皆0视奇偶

                           int i = Integer.parseInt(avg.substring(avg.indexOf(".") + dot+1, avg.indexOf(".") + dot + 2));
                           if(i%2==0){ //5前为偶则舍去
                               avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                               if(avg.substring(avg.length()-1).equals(".")) avg=avg.replace(".","");
                           }else { //5前为奇则进一
                               avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                               avg=avg.replace(".","");
                               String[] item=new String[avg.length()];
                               for (int w=0;w<item.length;w++){
                                   item[w]=avg.substring(w,w+1);
                               }
                               if(item.length>0){
                                   if(Long.parseLong(item[item.length-1])<9){
                                       item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                   }else {
                                       if(avg.substring(0,1).equals("0")){ //首位为0
                                           avg="1"+avg;
                                           avg=Long.parseLong(avg)+1+"";
                                           avg=avg.substring(1);
                                       }else {
                                           avg=Long.parseLong(avg)+1+"";
                                       }
                                       for (int w=0;w<item.length;w++){
                                           item[w]=avg.substring(w,w+1);
                                       }
                                   }

                               }

                               StringBuilder b=new StringBuilder();
                               for (int w=0;w<item.length;w++){
                                   if(item.length-(dot+1)==w){
                                       b.append(".");
                                       b.append(item[w]);
                                   }else {
                                       b.append(item[w]);
                                   }


                               }
                               avg=b.toString();
                           }
                          ////////////////////////
                       }else {  //5后非零进一
                           avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                           avg=avg.replace(".","");
                           String[] item=new String[avg.length()];
                           for (int i=0;i<item.length;i++){
                               item[i]=avg.substring(i,i+1);
                           }
                           if(item.length>0){
                               if(Long.parseLong(item[item.length-1])<9){
                                   item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                               }else {
                                   if(avg.substring(0,1).equals("0")){ //首位为0
                                       avg="1"+avg;
                                       avg=Long.parseLong(avg)+1+"";
                                       avg=avg.substring(1);
                                   }else {
                                       avg=Long.parseLong(avg)+1+"";
                                   }
                                   for (int i=0;i<item.length;i++){
                                       item[i]=avg.substring(i,i+1);
                                   }
                               }

                           }

                           StringBuilder b=new StringBuilder();
                           for (int i=0;i<item.length;i++){
                               if(item.length-(dot+1)==i){
                                   b.append(".");
                                   b.append(item[i]);
                               }else {
                                   b.append(item[i]);
                               }


                           }
                           avg=b.toString();
                       }
                    }else if(c>5){ //六入
                        avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                        avg=avg.replace(".","");
                        String[] item=new String[avg.length()];
                        for (int i=0;i<item.length;i++){
                            item[i]=avg.substring(i,i+1);
                        }
                        if(item.length>0){
                                if(Long.parseLong(item[item.length-1])<9){
                                    item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                }else {
                                    if(avg.substring(0,1).equals("0")){ //首位为0
                                        avg="1"+avg;
                                        avg=Long.parseLong(avg)+1+"";
                                        avg=avg.substring(1);
                                    }else {
                                        avg=Long.parseLong(avg)+1+"";
                                    }

                                    for (int i=0;i<item.length;i++){
                                        item[i]=avg.substring(i,i+1);
                                    }
                                }

                        }

                        StringBuilder b=new StringBuilder();
                       for (int i=0;i<item.length;i++){
                           if(item.length-(dot+1)==i){
                               b.append(".");
                               b.append(item[i]);
                           }else {
                               b.append(item[i]);
                           }


                       }
                       avg=b.toString();
                    }

                }else if(dot+1==len1){
                  avg=avg;
                }
            }
        }else { //计算的平均值没有小数
//            StringBuilder builder=new StringBuilder(avg);
           for (int i=0;i<dot;i++){
                if(i==0){
//                    builder.append(".0");
                    avg=avg+".0";
                }else {
//                    builder.append("0");
                    avg=avg+"0";
                }
           }
//           avg=builder.toString();
        }
///////////////////////////////////////////////////////////////////////
        if(ConfirmDataType.isNumber(avg)){ //如果平均值是数字
            //计算报告值，即校准值
             reportValue=Float.parseFloat(avg)*Float.parseFloat(factor)+"";
            ////////////////////////////////
            //报告值也按四舍六入五考虑的规则
            if(reportValue.contains(".")){ //计算的报告值有小数
                 dot1=dot-1;
                int len1=reportValue.substring(reportValue.indexOf(".")+1).length();
                if(len1<dot1){
//                    StringBuilder builder=new StringBuilder(reportValue);
                    for (int i=0;i<dot1-len1+1;i++){
//                        builder.append("0");
                        reportValue=reportValue+"0";
                    }
//                    reportValue=builder.toString();
                }else if(len1==dot1){
                    reportValue=reportValue;
                }else if(len1>dot1){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
                    if(dot1+1<len1){
                        //四舍六入五考虑
                        String s=reportValue.substring(reportValue.indexOf(".")+dot1+2,reportValue.indexOf(".")+dot1+3);
                        int c=Integer.parseInt(s);
                        if(c<=4){ //四舍
                            reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                            if(reportValue.substring(reportValue.length()-1).equals(".")) reportValue=reportValue.replace(".","");
                        }else if(c==5){ //五考虑
                            if(len1-dot1-1==1){//5后皆0视奇偶

                                if(ConfirmDataType.isNumber(reportValue.substring(reportValue.indexOf(".") + dot1+1, reportValue.indexOf(".") + dot1 + 2))){
                                int  i=  Integer.parseInt(reportValue.substring(reportValue.indexOf(".") + dot1+1, reportValue.indexOf(".") + dot1 + 2));
                                    if(i%2==0){ //5前为偶则舍去
                                        reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                                        if(reportValue.substring(reportValue.length()-1).equals(".")) reportValue=reportValue.replace(".","");
                                    }else { //5前为奇则进一
                                        reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                                        reportValue=reportValue.replace(".","");
                                        String[] item=new String[reportValue.length()];
                                        for (int w=0;w<item.length;w++){
                                            item[w]=reportValue.substring(w,w+1);
                                        }
                                        if(item.length>0){
                                            if(Long.parseLong(item[item.length-1])<9){
                                                item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                            }else {
                                                if(reportValue.substring(0,1).equals("0")){ //首位为0
                                                    reportValue="1"+reportValue;
                                                    reportValue=Long.parseLong(reportValue)+1+"";
                                                    reportValue=reportValue.substring(1);
                                                }else {
                                                    reportValue=Long.parseLong(reportValue)+1+"";
                                                }
                                                for (int w=0;w<item.length;w++){
                                                    item[w]=reportValue.substring(w,w+1);
                                                }
                                            }

                                        }

                                        StringBuilder b=new StringBuilder();
                                        for (int w=0;w<item.length;w++){
                                            if(item.length-(dot1+1)==w){
                                                b.append(".");
                                                b.append(item[w]);
                                            }else {
                                                b.append(item[w]);
                                            }


                                        }
                                        reportValue=b.toString();
                                    }
                                }else {//刚好算出的结果只有一位小数
                                    reportValue=reportValue.substring(0,reportValue.indexOf("."));
                                    if(ConfirmDataType.isNumber(reportValue.substring(reportValue.length()-1))){
                                                   if(Integer.parseInt(reportValue.substring(reportValue.length()-1))%2==0){
                                                      reportValue=reportValue;
                                                   }else { //5前为奇数则进一
                                                    reportValue=Long.parseLong(reportValue)+1+"";
                                                   }
                                    }
                                }

                                ////////////////////////
                            }else {  //5后非零进一
                                reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                                reportValue=reportValue.replace(".","");
                                String[] item=new String[reportValue.length()];
                                for (int i=0;i<item.length;i++){
                                    item[i]=reportValue.substring(i,i+1);
                                }
                                if(item.length>0){
                                    if(Long.parseLong(item[item.length-1])<9){
                                        item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                    }else {
                                        if(reportValue.substring(0,1).equals("0")){ //首位为0
                                            reportValue="1"+reportValue;
                                            reportValue=Long.parseLong(reportValue)+1+"";
                                            reportValue=reportValue.substring(1);
                                        }else {
                                            reportValue=Long.parseLong(reportValue)+1+"";
                                        }
                                        for (int i=0;i<item.length;i++){
                                            item[i]=reportValue.substring(i,i+1);
                                        }
                                    }

                                }

                                StringBuilder b=new StringBuilder();
                                for (int i=0;i<item.length;i++){
                                    if(item.length-(dot1+1)==i){
                                        b.append(".");
                                        b.append(item[i]);
                                    }else {
                                        b.append(item[i]);
                                    }


                                }
                                reportValue=b.toString();
                            }
                        }else if(c>5){ //六入
                            reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                            reportValue=reportValue.replace(".","");
                            String[] item=new String[reportValue.length()];
                            for (int i=0;i<item.length;i++){
                                item[i]=reportValue.substring(i,i+1);
                            }
                            if(item.length>0){
                                if(Long.parseLong(item[item.length-1])<9){
                                    item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                }else {
                                    if(reportValue.substring(0,1).equals("0")){ //首位为0
                                        reportValue="1"+reportValue;
                                        reportValue=Long.parseLong(reportValue)+1+"";
                                        reportValue=reportValue.substring(1);
                                    }else {
                                        reportValue=Long.parseLong(reportValue)+1+"";
                                    }
                                    for (int i=0;i<item.length;i++){
                                        item[i]=reportValue.substring(i,i+1);
                                    }
                                }

                            }

                            StringBuilder b=new StringBuilder();
                            for (int i=0;i<item.length;i++){
                                if(item.length-(dot1+1)==i){
                                    b.append(".");
                                    b.append(item[i]);
                                }else {
                                    b.append(item[i]);
                                }

                            }
                            reportValue=b.toString();
                        }

                    }else if(dot1+1==len1){
                        reportValue=reportValue;
                    }
                }
            }else { //计算的报告值没有小数
//                StringBuilder builder=new StringBuilder(reportValue);
                for (int i=0;i<dot1;i++){
                    if(i==0){
//                        builder.append(".0");
                        reportValue=reportValue+".0";
                    }else {
//                        builder.append("0");
                        reportValue=reportValue+"0";
                    }
                }
//                reportValue=builder.toString();
            }

            //////////////////////////////////
            //标准差
            if(len<3){
                correct="";
            }else {
                //////////////////计算标准差
                int count=0;
                float ff1=0;
                for(int i=0;i<list.length;i++){
                    if(ConfirmDataType.isNumber(list[i])){
                        count++;
                        ff1 += (Float.parseFloat(list[i])-Float.parseFloat(avg))*(Float.parseFloat(list[i])-Float.parseFloat(avg));
                    }

                }
                correct=(float) Math.sqrt(ff1/(count-1+0.0f))+"";
//              LogUtils.e("标准差计算          "+correct);
                if(correct.contains(".")){ //计算的标准差有小数
                    dot2=dot-1;
                    int len1=correct.substring(correct.indexOf(".")+1).length();
                    if(len1<dot2){
//                        StringBuilder builder=new StringBuilder(correct);
                        for (int i=0;i<dot2-len1+1;i++){
//                            builder.append("0");
                            correct=correct+"0";
                        }
//                        correct=builder.toString();
                    }else if(len1==dot2){
                        correct=correct;
                    }else if(len1>dot2){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
                        if(dot2+1<len1){
                            //四舍六入五考虑
                            String s=correct.substring(correct.indexOf(".")+dot2+2,correct.indexOf(".")+dot2+3);
                            int c=Integer.parseInt(s);
                            if(c<=4){ //四舍
                                correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                if(correct.substring(correct.length()-1).equals(".")) correct=correct.replace(".","");
                            }else if(c==5){ //五考虑
                                if(len1-dot2-1==1){//5后皆0视奇偶
                                    if(ConfirmDataType.isNumber(correct.substring(correct.indexOf(".") + dot2+1, correct.indexOf(".") + dot2 + 2))){
                                        int i = Integer.parseInt(correct.substring(correct.indexOf(".") + dot2+1, correct.indexOf(".") + dot2 + 2));
                                        if(i%2==0){ //5前为偶则舍去
                                            correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                            if(correct.substring(correct.length()-1).equals(".")) correct=correct.replace(".","");
                                        }else { //5前为奇则进一
                                            correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                            correct=correct.replace(".","");
                                            String[] item=new String[correct.length()];
                                            for (int w=0;w<item.length;w++){
                                                item[w]=correct.substring(w,w+1);
                                            }
                                            if(item.length>0){
                                                if(Long.parseLong(item[item.length-1])<9){
                                                    item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                                }else {
                                                    if(correct.substring(0,1).equals("0")){ //首位为0
                                                        correct="1"+correct;
                                                        correct=Long.parseLong(correct)+1+"";
                                                        correct=correct.substring(1);
                                                    }else {
                                                        correct=Long.parseLong(correct)+1+"";
                                                    }
                                                    for (int w=0;w<item.length;w++){
                                                        item[w]=correct.substring(w,w+1);
                                                    }
                                                }

                                            }

                                            StringBuilder b=new StringBuilder();
                                            for (int w=0;w<item.length;w++){
                                                if(item.length-(dot2+1)==w){
                                                    b.append(".");
                                                    b.append(item[w]);
                                                }else {
                                                    b.append(item[w]);
                                                }


                                            }
                                            correct=b.toString();
                                        }
                                    }else {
                                        correct=correct.substring(0,correct.indexOf("."));
                                        if(ConfirmDataType.isNumber(correct.substring(correct.length()-1))){
                                            if(Integer.parseInt(correct.substring(correct.length()-1))%2==0){
                                                correct=correct;
                                            }else { //5前为奇数则进一
                                                correct=Long.parseLong(correct)+1+"";
                                            }
                                        }
                                    }

                                    ////////////////////////
                                }else {  //5后非零进一
                                    correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                    correct=correct.replace(".","");
                                    String[] item=new String[correct.length()];
                                    for (int i=0;i<item.length;i++){
                                        item[i]=correct.substring(i,i+1);
                                    }
                                    if(item.length>0){
                                        if(Long.parseLong(item[item.length-1])<9){
                                            item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                        }else {
                                            if(correct.substring(0,1).equals("0")){ //首位为0
                                                correct="1"+correct;
                                                correct=Long.parseLong(correct)+1+"";
                                                correct=correct.substring(1);
                                            }else {
                                                correct=Long.parseLong(correct)+1+"";
                                            }
                                            for (int i=0;i<item.length;i++){
                                                item[i]=correct.substring(i,i+1);
                                            }
                                        }

                                    }

                                    StringBuilder b=new StringBuilder();
                                    for (int i=0;i<item.length;i++){
                                        if(item.length-(dot2+1)==i){
                                            b.append(".");
                                            b.append(item[i]);
                                        }else {
                                            b.append(item[i]);
                                        }


                                    }
                                    correct=b.toString();
                                }
                            }else if(c>5){ //六入
                                correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                correct=correct.replace(".","");
                                String[] item=new String[correct.length()];
                                for (int i=0;i<item.length;i++){
                                    item[i]=correct.substring(i,i+1);
                                }
                                if(item.length>0){
                                    if(Long.parseLong(item[item.length-1])<9){
                                        item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                    }else {
                                        if(correct.substring(0,1).equals("0")){ //首位为0
                                            correct="1"+correct;
                                            correct=Long.parseLong(correct)+1+"";
                                            correct=correct.substring(1);
                                        }else {
                                            correct=Long.parseLong(correct)+1+"";
                                        }
                                        for (int i=0;i<item.length;i++){
                                            item[i]=correct.substring(i,i+1);
                                        }
                                    }

                                }

                                StringBuilder b=new StringBuilder();
                                for (int i=0;i<item.length;i++){
                                    if(item.length-(dot2+1)==i){
                                        b.append(".");
                                        b.append(item[i]);
                                    }else {
                                        b.append(item[i]);
                                    }


                                }
                                correct=b.toString();
                            }

                        }else if(dot2+1==len1){
                            correct=correct;
                        }
                    }
                }else { //计算的平均值没有小数
//                    StringBuilder builder=new StringBuilder(correct);
                    for (int i=0;i<dot2;i++){
                        if(i==0){
//                            builder.append(".0");
                            correct=correct+".0";
                        }else {
//                            builder.append("0");
                            correct=correct+"0";
                        }
                    }
//                    correct=builder.toString();
                }
            }
        }else {
             reportValue="";
             correct="";
        }


            return new String[]{avg,reportValue,correct};
    }

    ////////////////////////////////////
    //根据不同的仪器计算校准因子
    public static float getResultFactor(String vol,int type){//电压、仪器类型
        float volit=Float.parseFloat(vol);//电压值
        float k=1;//线性系数
        float common=0;//常量
        float factor=1f;//校准因子

        switch (type){
            case 0:   //451p---3590
               if(volit<=60){
                   factor= (float) 1.20;
               }else if(volit>=200){
                   factor= (float) 1.34;
               }else if(volit>=60&&volit<=80){
                   float r= (float) (1.29-volit*0.03/(20f));
                   factor=get(2,r+"");
               }else if(volit>=80&&volit<=100){
                   float r= (float) (0.53+volit*0.16/(20f));
                   factor=get(2,r+"");
               }else if(volit>=100&&volit<=150){
                   float r= (float) (1.35-volit*0.01/(50f));
                   factor=get(2,r+"");
               }else if(volit>=150&&volit<=200){
                   float r= (float) (1.26+volit*0.02/(50f));
                   factor=get(2,r+"");
               }
                break;
            case 1: //451p----5282
                if(volit<=60){
                    factor= (float) 1.29;
                }else if(volit>=200){
                    factor= (float) 1.28;
                }else if(volit>=60&&volit<=80){
                    float r= (float) (1.71-volit*0.14/(20f));
                    factor=get(2,r+"");
                }else if(volit>=80&&volit<=100){
                    float r= (float) (0.55+volit*0.15/(20f));
                    factor=get(2,r+"");
                }else if(volit>=100&&volit<=150){
                    float r= (float) (1.34-volit*0.02/(50f));
                    factor=get(2,r+"");
                }else if(volit>=150&&volit<=200){
                    factor=1.28f;
                }
                break;
            case 2: //AT1123防护,即AT1123/53862核辐射检测仪
              if(volit<=60){
                  factor= (float) 0.75;
              }else if(volit>=60&&volit<=80){
                  float r= (float) (0.57+volit*0.06/(20f));
                  factor=get(2,r+"");
              }else if(volit>=80&&volit<=100){
                  float r= (float) (0.49+volit*0.08/(20f));
                  factor=get(2,r+"");
              }else if(volit>=100&&volit<=120){
                  float r= (float) (0.94-volit*0.01/(20f));
                  factor=get(2,r+"");
              }else if(volit>=120&&volit<=150){
                  float r= (float) (0.8+volit*0.02/(30f));
                  factor=get(2,r+"");
              }else if(volit>=150){
                  factor= (float) 0.90;
              }
                break;
            case  3://AT1123本底

                break;
            case 4://RAM本底

                break;
        }
        return factor;
    }
    //参数values是所有的原始数据
    public static float get(String[] values,String f){  //封装四舍五考虑六入,参数是保留的小数点位数
        int num=0;
        System.out.println("num="+num);
        for(int i=0;i<values.length;i++){
            if(ConfirmDataType.isNumber(values[i])) {

                if(values[i].contains(".")){
                    if(num<=values[i].substring(values[i].indexOf(".")+1).length()){
                        num=values[i].substring(values[i].indexOf(".")+1).length();
                    }

                }

            }

        }
        int  dot2=num-1;
        if(f.contains(".")){ //计算的有小数
            int len1=f.substring(f.indexOf(".")+1).length();
            System.out.println("len1="+len1);
            if(len1<dot2){
//                StringBuilder builder=new StringBuilder(f);
                for (int i=0;i<dot2-len1+1;i++){
//                    builder.append("0");
                    f=f+"0";
                }
//                f=builder.toString();
            }else if(len1==dot2){
                f=f;
            }else if(len1>dot2){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
                if(dot2+1<len1){
                    //四舍六入五考虑
                    String s=f.substring(f.indexOf(".")+dot2+2,f.indexOf(".")+dot2+3);
                    int c=Integer.parseInt(s);
                    if(c<=4){ //四舍
                        f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                        if(f.substring(f.length()-1).equals(".")) f=f.replace(".","");
                    }else if(c==5){ //五考虑
                        if(len1-dot2-1==1){//5后皆0视奇偶
                            if(ConfirmDataType.isNumber(f.substring(f.indexOf(".") + dot2+1, f.indexOf(".") + dot2 + 2))){
                                int i = Integer.parseInt(f.substring(f.indexOf(".") + dot2+1, f.indexOf(".") + dot2 + 2));
                                if(i%2==0){ //5前为偶则舍去
                                    f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                                    if(f.substring(f.length()-1).equals(".")) f=f.replace(".","");
                                }else { //5前为奇则进一
                                    f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                                    f=f.replace(".","");
                                    String[] item=new String[f.length()];
                                    for (int w=0;w<item.length;w++){
                                        item[w]=f.substring(w,w+1);
                                    }
                                    if(item.length>0){
                                        if(Long.parseLong(item[item.length-1])<9){
                                            item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                        }else {
                                            if(f.substring(0,1).equals("0")){ //首位为0
                                                f="1"+f;
                                                f=Long.parseLong(f)+1+"";
                                                f=f.substring(1);
                                            }else {
                                                f=Long.parseLong(f)+1+"";
                                            }
                                            for (int w=0;w<item.length;w++){
                                                item[w]=f.substring(w,w+1);
                                            }
                                        }

                                    }

                                    StringBuilder b=new StringBuilder();
                                    for (int w=0;w<item.length;w++){
                                        if(item.length-(dot2+1)==w){
                                            b.append(".");
                                            b.append(item[w]);
                                        }else {
                                            b.append(item[w]);
                                        }


                                    }
                                    f=b.toString();
                                }
                            }else {
                                f=f.substring(0,f.indexOf("."));
                                if(ConfirmDataType.isNumber(f.substring(f.length()-1))){
                                    if(Integer.parseInt(f.substring(f.length()-1))%2==0){
                                        f=f;
                                    }else { //5前为奇数则进一
                                        f=Long.parseLong(f)+1+"";
                                    }
                                }
                            }

                            ////////////////////////
                        }else {  //5后非零进一
                            f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                            f=f.replace(".","");
                            String[] item=new String[f.length()];
                            for (int i=0;i<item.length;i++){
                                item[i]=f.substring(i,i+1);
                            }
                            if(item.length>0){
                                if(Long.parseLong(item[item.length-1])<9){
                                    item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                }else {
                                    if(f.substring(0,1).equals("0")){ //首位为0
                                        f="1"+f;
                                        f=Long.parseLong(f)+1+"";
                                        f=f.substring(1);
                                    }else {
                                        f=Long.parseLong(f)+1+"";
                                    }
                                    for (int i=0;i<item.length;i++){
                                        item[i]=f.substring(i,i+1);
                                    }
                                }

                            }

                            StringBuilder b=new StringBuilder();
                            for (int i=0;i<item.length;i++){
                                if(item.length-(dot2+1)==i){
                                    b.append(".");
                                    b.append(item[i]);
                                }else {
                                    b.append(item[i]);
                                }


                            }
                            f=b.toString();
                        }
                    }else if(c>5){ //六入
                        f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                        f=f.replace(".","");
                        String[] item=new String[f.length()];
                        for (int i=0;i<item.length;i++){
                            item[i]=f.substring(i,i+1);
                        }
                        if(item.length>0){
                            if(Long.parseLong(item[item.length-1])<9){
                                item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                            }else {

                                if(f.substring(0,1).equals("0")){ //首位为0
                                    f="1"+f;
                                    f=Long.parseLong(f)+1+"";
                                    f=f.substring(1);
                                }else {
                                    f=Long.parseLong(f)+1+"";
                                }
                                for (int i=0;i<item.length;i++){
                                    item[i]=f.substring(i,i+1);
                                }
                            }

                        }

                        StringBuilder b=new StringBuilder();
                        for (int i=0;i<item.length;i++){
                            if(item.length-(dot2+1)==i){
                                b.append(".");
                                b.append(item[i]);
                            }else {
                                b.append(item[i]);
                            }


                        }
                        f=b.toString();
                    }

                }else if(dot2+1==len1){
                    f=f;
                }
            }
        }else { //计算的平均值没有小数
            for (int i=0;i<dot2;i++){
                if(i==0){
                    f=f+".0";
                }else {
                    f=f+"0";
                }
            }
        }
        if(ConfirmDataType.isNumber(f)){
            return Float.parseFloat(f);
        }else {
            return 1f;
        }
    }
    public static float get(int num,String f){  //封装四舍五考虑六入,参数是保留的小数点位数
      int  dot2=num-1;
        if(f.contains(".")){ //计算的标准差有小数
            int len1=f.substring(f.indexOf(".")+1).length();
            if(len1<dot2){
//                StringBuilder builder=new StringBuilder(f);
                for (int i=0;i<dot2-len1+1;i++){
//                    builder.append("0");
                    f=f+"0";
                }
//                f=builder.toString();
            }else if(len1==dot2){
                f=f;
            }else if(len1>dot2){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
                if(dot2+1<len1){
                    //四舍六入五考虑
                    String s=f.substring(f.indexOf(".")+dot2+2,f.indexOf(".")+dot2+3);
                    int c=Integer.parseInt(s);
                    if(c<=4){ //四舍
                        f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                        if(f.substring(f.length()-1).equals(".")) f=f.replace(".","");
                    }else if(c==5){ //五考虑
                        if(len1-dot2-1==1){//5后皆0视奇偶


                            if(ConfirmDataType.isNumber(f.substring(f.indexOf(".") + dot2+1, f.indexOf(".") + dot2 + 2))) {
                                int i = Integer.parseInt(f.substring(f.indexOf(".") + dot2+1, f.indexOf(".") + dot2 + 2));
                                if(i%2==0){ //5前为偶则舍去
                                    f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                                    if(f.substring(f.length()-1).equals(".")) f=f.replace(".","");
                                }else { //5前为奇则进一
                                    f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                                    f=f.replace(".","");
                                    String[] item=new String[f.length()];
                                    for (int w=0;w<item.length;w++){
                                        item[w]=f.substring(w,w+1);
                                    }
                                    if(item.length>0){
                                        if(Long.parseLong(item[item.length-1])<9){
                                            item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                        }else {
                                            if(f.substring(0,1).equals("0")){ //首位为0
                                                f="1"+f;
                                                f=Long.parseLong(f)+1+"";
                                                f=f.substring(1);
                                            }else {
                                                f=Long.parseLong(f)+1+"";
                                            }
                                            for (int w=0;w<item.length;w++){
                                                item[w]=f.substring(w,w+1);
                                            }
                                        }

                                    }

                                    StringBuilder b=new StringBuilder();
                                    for (int w=0;w<item.length;w++){
                                        if(item.length-(dot2+1)==w){
                                            b.append(".");
                                            b.append(item[w]);
                                        }else {
                                            b.append(item[w]);
                                        }


                                    }
                                    f=b.toString();
                                }

                            }else {
                                f=f.substring(0,f.indexOf("."));
                                if(ConfirmDataType.isNumber(f.substring(f.length()-1))){
                                    if(Integer.parseInt(f.substring(f.length()-1))%2==0){
                                        f=f;
                                    }else { //5前为奇数则进一
                                        f=Long.parseLong(f)+1+"";
                                    }
                                }
                            }
                            ////////////////////////
                        }else {  //5后非零进一
                            f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                            f=f.replace(".","");
                            String[] item=new String[f.length()];
                            for (int i=0;i<item.length;i++){
                                item[i]=f.substring(i,i+1);
                            }
                            if(item.length>0){
                                if(Long.parseLong(item[item.length-1])<9){
                                    item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                }else {
                                    if(f.substring(0,1).equals("0")){ //首位为0
                                        f="1"+f;
                                        f=Long.parseLong(f)+1+"";
                                        f=f.substring(1);
                                    }else {
                                        f=Long.parseLong(f)+1+"";
                                    }
                                    for (int i=0;i<item.length;i++){
                                        item[i]=f.substring(i,i+1);
                                    }
                                }

                            }

                            StringBuilder b=new StringBuilder();
                            for (int i=0;i<item.length;i++){
                                if(item.length-(dot2+1)==i){
                                    b.append(".");
                                    b.append(item[i]);
                                }else {
                                    b.append(item[i]);
                                }


                            }
                            f=b.toString();
                        }
                    }else if(c>5){ //六入
                        f=f.split(dot_marker)[0]+"."+f.substring(f.indexOf(".")+1,f.indexOf(".")+1+dot2+1);
                        f=f.replace(".","");
                        String[] item=new String[f.length()];
                        for (int i=0;i<item.length;i++){
                            item[i]=f.substring(i,i+1);
                        }
                        if(item.length>0){
                            if(Long.parseLong(item[item.length-1])<9){
                                item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                            }else {
                                f=Long.parseLong(f)+1+"";
                                for (int i=0;i<item.length;i++){
                                    item[i]=f.substring(i,i+1);
                                }
                            }

                        }

                        StringBuilder b=new StringBuilder();
                        for (int i=0;i<item.length;i++){
                            if(item.length-(dot2+1)==i){
                                b.append(".");
                                b.append(item[i]);
                            }else {
                                b.append(item[i]);
                            }


                        }
                        f=b.toString();
                    }

                }else if(dot2+1==len1){
                    f=f;
                }
            }
        }else { //计算的平均值没有小数
//            StringBuilder builder=new StringBuilder(f);
            for (int i=0;i<dot2;i++){
                if(i==0){
//                    builder.append(".0");
                    f=f+".0";
                }else {
//                    builder.append("0");
                    f=f+"0";
                }
            }
//            f=builder.toString();
        }
        if(ConfirmDataType.isNumber(f)){
            return Float.parseFloat(f);
        }else {
            return 1f;
        }
    }

    /////////////////////////////////////////
    //表面活度响应时计算平均值，报告值，标准差,报告值为平均值/表面活度响应
    public static String[] getRespnoceResult(String[] list,String responce,boolean isRA2){ //返回的数组分别对应平均值，报告值，标准差
        int dot=0;//判断输入的数有几位小数
        int dot1=0;
        int dot2=0;
        if(list.length==0){
            return new String[]{"","",""};
        }
        if(!ConfirmDataType.isNumber(responce)) responce="1";//表面活度响应
        int len=0;
        float ff=0;
        for(int i=0;i<list.length;i++){
            if(ConfirmDataType.isNumber(list[i])) {
                ff += Float.parseFloat(list[i]);
                if(list[i].contains(".")){
                    if(dot<=list[i].substring(list[i].indexOf(".")+1).length()){
                        dot=list[i].substring(list[i].indexOf(".")+1).length();
                    }

                }
                len++;
            }

        }
        if(len==0) return new String[]{"","",""};
        //根据输入的数值计算平均值,在输入的数值基础上多保留一位有效数字
        StringBuffer formatType=new StringBuffer("#.0");
        for (int i=0;i<dot;i++){
            formatType.append("0");
        }
        java.text.DecimalFormat df = new java.text.DecimalFormat(formatType.toString());
        //        df.format()
        String avg=ff/(len+0.0f)+"";
        if(isRA2){ //如果选择了RAM-II型环境级X、γ辐射剂量率仪测量
            avg=(ff/(len+0.0f))/1.14+"";
        }
        String reportValue="";//报告值
        String correct="";
        //四舍六入五考虑规则

        if(avg.contains(".")){ //计算的平均值有小数
            int len1=avg.substring(avg.indexOf(".")+1).length();
            if(len1<dot){
//                StringBuilder builder=new StringBuilder(avg);  //使用过程中发现偶尔会抛出内存溢出异常，所以改为字符串拼接方式
                for (int i=0;i<dot-len1+1;i++){
//                    builder.append("0");
                    avg= avg+"0";
                }
//                avg=builder.toString();
            }else if(len1==dot){
                avg=avg+"0";
            }else if(len1>dot){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
                if(dot+1<len1){
                    //四舍六入五考虑
                    String s=avg.substring(avg.indexOf(".")+dot+2,avg.indexOf(".")+dot+3);
                    int c=Integer.parseInt(s);
                    if(c<=4){ //四舍
                        avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                        if(avg.substring(avg.length()-1).equals(".")) avg=avg.replace(".","");
                    }else if(c==5){ //五考虑
                        if(len1-dot-1==1){//5后皆0视奇偶

                            int i = Integer.parseInt(avg.substring(avg.indexOf(".") + dot+1, avg.indexOf(".") + dot + 2));
                            if(i%2==0){ //5前为偶则舍去
                                avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                                if(avg.substring(avg.length()-1).equals(".")) avg=avg.replace(".","");
                            }else { //5前为奇则进一
                                avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                                avg=avg.replace(".","");
                                String[] item=new String[avg.length()];
                                for (int w=0;w<item.length;w++){
                                    item[w]=avg.substring(w,w+1);
                                }
                                if(item.length>0){
                                    if(Long.parseLong(item[item.length-1])<9){
                                        item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                    }else {
                                        if(avg.substring(0,1).equals("0")){ //首位为0
                                            avg="1"+avg;
                                            avg=Long.parseLong(avg)+1+"";
                                            avg=avg.substring(1);
                                        }else {
                                            avg=Long.parseLong(avg)+1+"";
                                        }
                                        for (int w=0;w<item.length;w++){
                                            item[w]=avg.substring(w,w+1);
                                        }
                                    }

                                }

                                StringBuilder b=new StringBuilder();
                                for (int w=0;w<item.length;w++){
                                    if(item.length-(dot+1)==w){
                                        b.append(".");
                                        b.append(item[w]);
                                    }else {
                                        b.append(item[w]);
                                    }


                                }
                                avg=b.toString();
                            }
                            ////////////////////////
                        }else {  //5后非零进一
                            avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                            avg=avg.replace(".","");
                            String[] item=new String[avg.length()];
                            for (int i=0;i<item.length;i++){
                                item[i]=avg.substring(i,i+1);
                            }
                            if(item.length>0){
                                if(Long.parseLong(item[item.length-1])<9){
                                    item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                }else {
                                    if(avg.substring(0,1).equals("0")){ //首位为0
                                        avg="1"+avg;
                                        avg=Long.parseLong(avg)+1+"";
                                        avg=avg.substring(1);
                                    }else {
                                        avg=Long.parseLong(avg)+1+"";
                                    }
                                    for (int i=0;i<item.length;i++){
                                        item[i]=avg.substring(i,i+1);
                                    }
                                }

                            }

                            StringBuilder b=new StringBuilder();
                            for (int i=0;i<item.length;i++){
                                if(item.length-(dot+1)==i){
                                    b.append(".");
                                    b.append(item[i]);
                                }else {
                                    b.append(item[i]);
                                }


                            }
                            avg=b.toString();
                        }
                    }else if(c>5){ //六入
                        avg=avg.split(dot_marker)[0]+"."+avg.substring(avg.indexOf(".")+1,avg.indexOf(".")+1+dot+1);
                        avg=avg.replace(".","");
                        String[] item=new String[avg.length()];
                        for (int i=0;i<item.length;i++){
                            item[i]=avg.substring(i,i+1);
                        }
                        if(item.length>0){
                            if(Long.parseLong(item[item.length-1])<9){
                                item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                            }else {
                                if(avg.substring(0,1).equals("0")){ //首位为0
                                    avg="1"+avg;
                                    avg=Long.parseLong(avg)+1+"";
                                    avg=avg.substring(1);
                                }else {
                                    avg=Long.parseLong(avg)+1+"";
                                }

                                for (int i=0;i<item.length;i++){
                                    item[i]=avg.substring(i,i+1);
                                }
                            }

                        }

                        StringBuilder b=new StringBuilder();
                        for (int i=0;i<item.length;i++){
                            if(item.length-(dot+1)==i){
                                b.append(".");
                                b.append(item[i]);
                            }else {
                                b.append(item[i]);
                            }


                        }
                        avg=b.toString();
                    }

                }else if(dot+1==len1){
                    avg=avg;
                }
            }
        }else { //计算的平均值没有小数
//            StringBuilder builder=new StringBuilder(avg);
            for (int i=0;i<dot;i++){
                if(i==0){
//                    builder.append(".0");
                    avg=avg+".0";
                }else {
//                    builder.append("0");
                    avg=avg+"0";
                }
            }
//           avg=builder.toString();
        }
///////////////////////////////////////////////////////////////////////
        if(ConfirmDataType.isNumber(avg)){ //如果平均值是数字
            //计算报告值，即校准值
            reportValue=Float.parseFloat(avg)/Float.parseFloat(responce)+"";
            ////////////////////////////////
            //报告值也按四舍六入五考虑的规则
            if(reportValue.contains(".")){ //计算的报告值有小数
                dot1=dot-1;
                int len1=reportValue.substring(reportValue.indexOf(".")+1).length();
                if(len1<dot1){
//                    StringBuilder builder=new StringBuilder(reportValue);
                    for (int i=0;i<dot1-len1+1;i++){
//                        builder.append("0");
                        reportValue=reportValue+"0";
                    }
//                    reportValue=builder.toString();
                }else if(len1==dot1){
                    reportValue=reportValue;
                }else if(len1>dot1){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
                    if(dot1+1<len1){
                        //四舍六入五考虑
                        String s=reportValue.substring(reportValue.indexOf(".")+dot1+2,reportValue.indexOf(".")+dot1+3);
                        int c=Integer.parseInt(s);
                        if(c<=4){ //四舍
                            reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                            if(reportValue.substring(reportValue.length()-1).equals(".")) reportValue=reportValue.replace(".","");
                        }else if(c==5){ //五考虑
                            if(len1-dot1-1==1){//5后皆0视奇偶

                                if(ConfirmDataType.isNumber(reportValue.substring(reportValue.indexOf(".") + dot1+1, reportValue.indexOf(".") + dot1 + 2))){
                                    int  i=  Integer.parseInt(reportValue.substring(reportValue.indexOf(".") + dot1+1, reportValue.indexOf(".") + dot1 + 2));
                                    if(i%2==0){ //5前为偶则舍去
                                        reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                                        if(reportValue.substring(reportValue.length()-1).equals(".")) reportValue=reportValue.replace(".","");
                                    }else { //5前为奇则进一
                                        reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                                        reportValue=reportValue.replace(".","");
                                        String[] item=new String[reportValue.length()];
                                        for (int w=0;w<item.length;w++){
                                            item[w]=reportValue.substring(w,w+1);
                                        }
                                        if(item.length>0){
                                            if(Long.parseLong(item[item.length-1])<9){
                                                item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                            }else {
                                                if(reportValue.substring(0,1).equals("0")){ //首位为0
                                                    reportValue="1"+reportValue;
                                                    reportValue=Long.parseLong(reportValue)+1+"";
                                                    reportValue=reportValue.substring(1);
                                                }else {
                                                    reportValue=Long.parseLong(reportValue)+1+"";
                                                }
                                                for (int w=0;w<item.length;w++){
                                                    item[w]=reportValue.substring(w,w+1);
                                                }
                                            }

                                        }

                                        StringBuilder b=new StringBuilder();
                                        for (int w=0;w<item.length;w++){
                                            if(item.length-(dot1+1)==w){
                                                b.append(".");
                                                b.append(item[w]);
                                            }else {
                                                b.append(item[w]);
                                            }


                                        }
                                        reportValue=b.toString();
                                    }
                                }else {//刚好算出的结果只有一位小数
                                    reportValue=reportValue.substring(0,reportValue.indexOf("."));
                                    if(ConfirmDataType.isNumber(reportValue.substring(reportValue.length()-1))){
                                        if(Integer.parseInt(reportValue.substring(reportValue.length()-1))%2==0){
                                            reportValue=reportValue;
                                        }else { //5前为奇数则进一
                                            reportValue=Long.parseLong(reportValue)+1+"";
                                        }
                                    }
                                }
                                ////////////////////////
                            }else {  //5后非零进一
                                reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                                reportValue=reportValue.replace(".","");
                                String[] item=new String[reportValue.length()];
                                for (int i=0;i<item.length;i++){
                                    item[i]=reportValue.substring(i,i+1);
                                }
                                if(item.length>0){
                                    if(Long.parseLong(item[item.length-1])<9){
                                        item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                    }else {
                                        if(reportValue.substring(0,1).equals("0")){ //首位为0
                                            reportValue="1"+reportValue;
                                            reportValue=Long.parseLong(reportValue)+1+"";
                                            reportValue=reportValue.substring(1);
                                        }else {
                                            reportValue=Long.parseLong(reportValue)+1+"";
                                        }
                                        for (int i=0;i<item.length;i++){
                                            item[i]=reportValue.substring(i,i+1);
                                        }
                                    }

                                }

                                StringBuilder b=new StringBuilder();
                                for (int i=0;i<item.length;i++){
                                    if(item.length-(dot1+1)==i){
                                        b.append(".");
                                        b.append(item[i]);
                                    }else {
                                        b.append(item[i]);
                                    }


                                }
                                reportValue=b.toString();
                            }
                        }else if(c>5){ //六入
                            reportValue=reportValue.split(dot_marker)[0]+"."+reportValue.substring(reportValue.indexOf(".")+1,reportValue.indexOf(".")+1+dot1+1);
                            reportValue=reportValue.replace(".","");
                            String[] item=new String[reportValue.length()];
                            for (int i=0;i<item.length;i++){
                                item[i]=reportValue.substring(i,i+1);
                            }
                            if(item.length>0){
                                if(Long.parseLong(item[item.length-1])<9){
                                    item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                }else {
                                    if(reportValue.substring(0,1).equals("0")){ //首位为0
                                        reportValue="1"+reportValue;
                                        reportValue=Long.parseLong(reportValue)+1+"";
                                        reportValue=reportValue.substring(1);
                                    }else {
                                        reportValue=Long.parseLong(reportValue)+1+"";
                                    }
                                    for (int i=0;i<item.length;i++){
                                        item[i]=reportValue.substring(i,i+1);
                                    }
                                }

                            }

                            StringBuilder b=new StringBuilder();
                            for (int i=0;i<item.length;i++){
                                if(item.length-(dot1+1)==i){
                                    b.append(".");
                                    b.append(item[i]);
                                }else {
                                    b.append(item[i]);
                                }

                            }
                            reportValue=b.toString();
                        }

                    }else if(dot1+1==len1){
                        reportValue=reportValue;
                    }
                }
            }else { //计算的平均值没有小数
//                StringBuilder builder=new StringBuilder(reportValue);
                for (int i=0;i<dot1;i++){
                    if(i==0){
//                        builder.append(".0");
                        reportValue=reportValue+".0";
                    }else {
//                        builder.append("0");
                        reportValue=reportValue+"0";
                    }
                }
//                reportValue=builder.toString();
            }

            //////////////////////////////////
            //标准差
            if(len<3){
                correct="";
            }else {
                //////////////////计算标准差
                int count=0;
                float ff1=0;
                for(int i=0;i<list.length;i++){
                    if(ConfirmDataType.isNumber(list[i])){
                        count++;
                        ff1 += (Float.parseFloat(list[i])-Float.parseFloat(avg))*(Float.parseFloat(list[i])-Float.parseFloat(avg));
                    }

                }
                correct=(float) Math.sqrt(ff1/(count-1+0.0f))+"";
//                LogUtils.e("标准差计算          "+correct);
                if(correct.contains(".")){ //计算的标准差有小数
                    dot2=dot-1;
                    int len1=correct.substring(correct.indexOf(".")+1).length();
                    if(len1<dot2){
//                        StringBuilder builder=new StringBuilder(correct);
                        for (int i=0;i<dot2-len1+1;i++){
//                            builder.append("0");
                            correct=correct+"0";
                        }
//                        correct=builder.toString();
                    }else if(len1==dot2){
                        correct=correct;
                    }else if(len1>dot2){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
                        if(dot2+1<len1){
                            //四舍六入五考虑
                            String s=correct.substring(correct.indexOf(".")+dot2+2,correct.indexOf(".")+dot2+3);
                            int c=Integer.parseInt(s);
                            if(c<=4){ //四舍
                                correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                if(correct.substring(correct.length()-1).equals(".")) correct=correct.replace(".","");
                            }else if(c==5){ //五考虑
                                if(len1-dot2-1==1){//5后皆0视奇偶
                                       if(ConfirmDataType.isNumber(correct.substring(correct.indexOf(".") + dot2+1, correct.indexOf(".") + dot2 + 2))){
                                           int i = Integer.parseInt(correct.substring(correct.indexOf(".") + dot2+1, correct.indexOf(".") + dot2 + 2));
                                           if(i%2==0){ //5前为偶则舍去
                                               correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                               if(correct.substring(correct.length()-1).equals(".")) correct=correct.replace(".","");
                                           }else { //5前为奇则进一
                                               correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                               correct=correct.replace(".","");
                                               String[] item=new String[correct.length()];
                                               for (int w=0;w<item.length;w++){
                                                   item[w]=correct.substring(w,w+1);
                                               }
                                               if(item.length>0){
                                                   if(Long.parseLong(item[item.length-1])<9){
                                                       item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                                   }else {
                                                       if(correct.substring(0,1).equals("0")){ //首位为0
                                                           correct="1"+correct;
                                                           correct=Long.parseLong(correct)+1+"";
                                                           correct=correct.substring(1);
                                                       }else {
                                                           correct=Long.parseLong(correct)+1+"";
                                                       }
                                                       for (int w=0;w<item.length;w++){
                                                           item[w]=correct.substring(w,w+1);
                                                       }
                                                   }

                                               }

                                               StringBuilder b=new StringBuilder();
                                               for (int w=0;w<item.length;w++){
                                                   if(item.length-(dot2+1)==w){
                                                       b.append(".");
                                                       b.append(item[w]);
                                                   }else {
                                                       b.append(item[w]);
                                                   }


                                               }
                                               correct=b.toString();
                                           }
                                       }else {
                                           correct=correct.substring(0,correct.indexOf("."));
                                           if(ConfirmDataType.isNumber(correct.substring(correct.length()-1))){
                                               if(Integer.parseInt(correct.substring(correct.length()-1))%2==0){
                                                   correct=correct;
                                               }else { //5前为奇数则进一
                                                   correct=Long.parseLong(correct)+1+"";
                                               }
                                           }
                                       }

                                    ////////////////////////
                                }else {  //5后非零进一
                                    correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                    correct=correct.replace(".","");
                                    String[] item=new String[correct.length()];
                                    for (int i=0;i<item.length;i++){
                                        item[i]=correct.substring(i,i+1);
                                    }
                                    if(item.length>0){
                                        if(Long.parseLong(item[item.length-1])<9){
                                            item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                        }else {
                                            if(correct.substring(0,1).equals("0")){ //首位为0
                                                correct="1"+correct;
                                                correct=Long.parseLong(correct)+1+"";
                                                correct=correct.substring(1);
                                            }else {
                                                correct=Long.parseLong(correct)+1+"";
                                            }
                                            for (int i=0;i<item.length;i++){
                                                item[i]=correct.substring(i,i+1);
                                            }
                                        }

                                    }

                                    StringBuilder b=new StringBuilder();
                                    for (int i=0;i<item.length;i++){
                                        if(item.length-(dot2+1)==i){
                                            b.append(".");
                                            b.append(item[i]);
                                        }else {
                                            b.append(item[i]);
                                        }


                                    }
                                    correct=b.toString();
                                }
                            }else if(c>5){ //六入
                                correct=correct.split(dot_marker)[0]+"."+correct.substring(correct.indexOf(".")+1,correct.indexOf(".")+1+dot2+1);
                                correct=correct.replace(".","");
                                String[] item=new String[correct.length()];
                                for (int i=0;i<item.length;i++){
                                    item[i]=correct.substring(i,i+1);
                                }
                                if(item.length>0){
                                    if(Long.parseLong(item[item.length-1])<9){
                                        item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
                                    }else {
                                        if(correct.substring(0,1).equals("0")){ //首位为0
                                            correct="1"+correct;
                                            correct=Long.parseLong(correct)+1+"";
                                            correct=correct.substring(1);
                                        }else {
                                            correct=Long.parseLong(correct)+1+"";
                                        }
                                        for (int i=0;i<item.length;i++){
                                            item[i]=correct.substring(i,i+1);
                                        }
                                    }

                                }

                                StringBuilder b=new StringBuilder();
                                for (int i=0;i<item.length;i++){
                                    if(item.length-(dot2+1)==i){
                                        b.append(".");
                                        b.append(item[i]);
                                    }else {
                                        b.append(item[i]);
                                    }


                                }
                                correct=b.toString();
                            }

                        }else if(dot2+1==len1){
                            correct=correct;
                        }
                    }
                }else { //计算的平均值没有小数
//                    StringBuilder builder=new StringBuilder(correct);
                    for (int i=0;i<dot2;i++){
                        if(i==0){
//                            builder.append(".0");
                            correct=correct+".0";
                        }else {
//                            builder.append("0");
                            correct=correct+"0";
                        }
                    }
//                    correct=builder.toString();
                }
            }
        }else {
            reportValue="";
            correct="";
        }


        return new String[]{avg,reportValue,correct};
    }
//    /////////////////////////////////////////////////////////////////////////
//    //根据仪器计算校准因子
//    // TODO: 2017/8/19 0019  vols电压集合，factors对应的刻度因子集合，currentVol当前电压
//    public static String getFactor(String[] vols,String[] factors,String currentVol){
//        if(currentVol==null)return "1";
//        if(!com.xt.sz.global.utils.ConfirmDataType.isNumber(currentVol)) return "1";
//        if(vols.length==1&&factors.length==1)return factors[0];
//        //计算出来的刻度因子与给出的保留一致的小数点位
//        int dotCount=0;//默认不保留小数
//        int dot2=0;
//        for (String f:factors
//             ) {
//            if(f.contains(".")){
//                int len=f.substring(f.indexOf(".")+1).length();
//                if(len>=dotCount){
//                    dotCount=len;
//                }
//            }
//        }
//        Double[] vs=new Double[vols.length];
//        for (int i=0;i<vs.length;i++){
//            vs[i]=Double.parseDouble(vols[i]);
//        }
//        Double[] fs=new Double[factors.length];
//        for (int i=0;i<fs.length;i++){
//            fs[i]=Double.parseDouble(factors[i]);
//        }
//        double current=Double.parseDouble(currentVol);
//        if(current<=vs[0]) return fs[0]+"";
//        if(current>=vs[vs.length-1]) return fs[fs.length-1]+"";
//        double k=1;//系数
//        double NORMAL=0;//常量
//        //判断当前电压在哪个区间
//        int indexStart=0;
//
//        double min1=Integer.MAX_VALUE;
//
//        for (int i=0;i<vs.length;i++){
//            if(current-vs[i]>=0){
//                if(min1>=current-vs[i]){
//                    min1=current-vs[i];
//                    indexStart=i;
//                }
//            }
//
//
//        }
//        k=(fs[indexStart+1]-fs[indexStart])/(vs[indexStart+1]-vs[indexStart]);
//        NORMAL=fs[indexStart]-k*vs[indexStart];
//        //计算校准因子
//        String factor=k*current+NORMAL+"";
//        if(factor.contains(".")){ //计算的校准因子有小数
//            dot2=dotCount-1;
//            int len1=factor.substring(factor.indexOf(".")+1).length();
//            if(len1<dot2){
//                for (int i=0;i<dot2-len1+1;i++){
//                    factor=factor+"0";
//                }
//            }else if(len1==dot2){
//                factor=factor;
//            }else if(len1>dot2){ //当计算结果位数大于应该保留的小数位数时，进行四舍六入判断
//                if(dot2+1<len1){
//                    //四舍六入五考虑
//                    String s=factor.substring(factor.indexOf(".")+dot2+2,factor.indexOf(".")+dot2+3);
//                    int c=Integer.parseInt(s);
//                    if(c<=4){ //四舍
//                        factor=factor.split(dot_marker)[0]+"."+factor.substring(factor.indexOf(".")+1,factor.indexOf(".")+1+dot2+1);
//                        if(factor.substring(factor.length()-1).equals(".")) factor=factor.replace(".","");
//                    }else if(c==5){ //五考虑
//                        if(len1-dot2-1==1){//5后皆0视奇偶
//                            if(ConfirmDataType.isNumber(factor.substring(factor.indexOf(".") + dot2+1, factor.indexOf(".") + dot2 + 2))){
//                                int i = Integer.parseInt(factor.substring(factor.indexOf(".") + dot2+1, factor.indexOf(".") + dot2 + 2));
//                                if(i%2==0){ //5前为偶则舍去
//                                    factor=factor.split(dot_marker)[0]+"."+factor.substring(factor.indexOf(".")+1,factor.indexOf(".")+1+dot2+1);
//                                    if(factor.substring(factor.length()-1).equals(".")) factor=factor.replace(".","");
//                                }else { //5前为奇则进一
//                                    factor=factor.split(dot_marker)[0]+"."+factor.substring(factor.indexOf(".")+1,factor.indexOf(".")+1+dot2+1);
//                                    factor=factor.replace(".","");
//                                    String[] item=new String[factor.length()];
//                                    for (int w=0;w<item.length;w++){
//                                        item[w]=factor.substring(w,w+1);
//                                    }
//                                    if(item.length>0){
//                                        if(Long.parseLong(item[item.length-1])<9){
//                                            item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
//                                        }else {
//                                            if(factor.substring(0,1).equals("0")){ //首位为0
//                                                factor="1"+factor;
//                                                factor=Long.parseLong(factor)+1+"";
//                                                factor=factor.substring(1);
//                                            }else {
//                                                factor=Long.parseLong(factor)+1+"";
//                                            }
//                                            for (int w=0;w<item.length;w++){
//                                                item[w]=factor.substring(w,w+1);
//                                            }
//                                        }
//
//                                    }
//
//                                    StringBuilder b=new StringBuilder();
//                                    for (int w=0;w<item.length;w++){
//                                        if(item.length-(dot2+1)==w){
//                                            b.append(".");
//                                            b.append(item[w]);
//                                        }else {
//                                            b.append(item[w]);
//                                        }
//
//
//                                    }
//                                    factor=b.toString();
//                                }
//                            }else {
//                                factor=factor.substring(0,factor.indexOf("."));
//                                if(ConfirmDataType.isNumber(factor.substring(factor.length()-1))){
//                                    if(Integer.parseInt(factor.substring(factor.length()-1))%2==0){
//                                        factor=factor;
//                                    }else { //5前为奇数则进一
//                                        factor=Long.parseLong(factor)+1+"";
//                                    }
//                                }
//                            }
//
//                            ////////////////////////
//                        }else {  //5后非零进一
//                            factor=factor.split(dot_marker)[0]+"."+factor.substring(factor.indexOf(".")+1,factor.indexOf(".")+1+dot2+1);
//                            factor=factor.replace(".","");
//                            String[] item=new String[factor.length()];
//                            for (int i=0;i<item.length;i++){
//                                item[i]=factor.substring(i,i+1);
//                            }
//                            if(item.length>0){
//                                if(Long.parseLong(item[item.length-1])<9){
//                                    item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
//                                }else {
//                                    if(factor.substring(0,1).equals("0")){ //首位为0
//                                        factor="1"+factor;
//                                        factor=Long.parseLong(factor)+1+"";
//                                        factor=factor.substring(1);
//                                    }else {
//                                        factor=Long.parseLong(factor)+1+"";
//                                    }
//                                    for (int i=0;i<item.length;i++){
//                                        item[i]=factor.substring(i,i+1);
//                                    }
//                                }
//
//                            }
//
//                            StringBuilder b=new StringBuilder();
//                            for (int i=0;i<item.length;i++){
//                                if(item.length-(dot2+1)==i){
//                                    b.append(".");
//                                    b.append(item[i]);
//                                }else {
//                                    b.append(item[i]);
//                                }
//
//
//                            }
//                            factor=b.toString();
//                        }
//                    }else if(c>5){ //六入
//                        factor=factor.split(dot_marker)[0]+"."+factor.substring(factor.indexOf(".")+1,factor.indexOf(".")+1+dot2+1);
//                        factor=factor.replace(".","");
//                        String[] item=new String[factor.length()];
//                        for (int i=0;i<item.length;i++){
//                            item[i]=factor.substring(i,i+1);
//                        }
//                        if(item.length>0){
//                            if(Long.parseLong(item[item.length-1])<9){
//                                item[item.length-1]=Long.parseLong(item[item.length-1])+1+"";
//                            }else {
//                                if(factor.substring(0,1).equals("0")){ //首位为0
//                                    factor="1"+factor;
//                                    factor=Long.parseLong(factor)+1+"";
//                                    factor=factor.substring(1);
//                                }else {
//                                    factor=Long.parseLong(factor)+1+"";
//                                }
//                                for (int i=0;i<item.length;i++){
//                                    item[i]=factor.substring(i,i+1);
//                                }
//                            }
//
//                        }
//
//                        StringBuilder b=new StringBuilder();
//                        for (int i=0;i<item.length;i++){
//                            if(item.length-(dot2+1)==i){
//                                b.append(".");
//                                b.append(item[i]);
//                            }else {
//                                b.append(item[i]);
//                            }
//
//
//                        }
//                        factor=b.toString();
//                    }
//
//                }else if(dot2+1==len1){
//                    factor=factor;
//                }
//            }
//        }else { //计算的没有小数
//            for (int i=0;i<dot2;i++){
//                if(i==0){
//                    factor=factor+".0";
//                }else {
//                    factor=factor+"0";
//                }
//            }
//        }
//        return factor;
//    }
//    //////////////////////////////////////////////
//    //封装一个计算照射量的计算方法,384模板会用到
//    public static  double getRepLightResult(String type,String value1,String value2){
//        double result=0;
//        switch (type){
//            case "锐珂(kodak)"://///E响应=10(EI-2000)/1000
//                result=Math.pow(10,(Double.parseDouble(value1)-2000)/1000);
//                //格式化计算结果
//                result = CalculateUtil.get(new String[]{value1}, result + "");
//                break;
//            case "AGFA"://///E响应=[(2276/S) ×10(logM-3.2768)]
//                result=(2276/Double.parseDouble(value1))*Math.pow(10,(Math.log(Double.parseDouble(value2))-3.2768));
//                //格式化计算结果
//                result=CalculateUtil.get(new String[]{value1,value2},result+"");
//                break;
//            case "FUJIFILM":  /////E响应=200/S
//            case "KONIKA":
//                result=200/Double.parseDouble(value1);
//                //格式化计算结果
//                result=CalculateUtil.get(new String[]{value1},result+"");
//                break;
//        }
//        return result;
//    }

}
