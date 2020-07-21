package com.example.toolkit.sample.webservice;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;

/**
 * 基于SOAP协议的webservice接口调用
 *
 * @author chenpenghui
 * @date 2020/7/17
 */
public class SOAPCallSample {

    public static void main(String[] args) {
        //第一种，Axis方式
        try {

            String endpoint = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);
            call.setOperationName("getSupportCity");
            Object obj = call.invoke(new Object[]{});
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //第二种，XFire方式

        //第三种，JAX-WS



    }
}
