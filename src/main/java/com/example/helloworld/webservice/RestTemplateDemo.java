package com.example.helloworld.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate方式调用
 *
 * @author cph
 * @date 2019/6/4
 */
public class RestTemplateDemo {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateDemo.class);

    public static void main(String[] args) {

//        String param = "key=71b40e20f66b457fb10c251b8b380b4a&location=北京";
//        String url = "https://api.heweather.net/s6/weather";
//        int connectionTimeout = 10000;
//        int socketTimeout = 5000;

        String param = "";
        String url = "https://www.qq.com";
        int connectionTimeout = 10000;
        int socketTimeout = 5000;

        System.out.println(restPost(url, param, connectionTimeout, socketTimeout));

    }


    /**
     * RestTemplate Post Demo
     *
     * @param url
     * @param reqStr
     * @param connectionTimeout
     * @param socketTimeout
     * @return
     */
    public static String restPost(String url, String reqStr, int connectionTimeout, int socketTimeout) {

        //设置HttpComponentsClientHttpRequestFactory
        ResponseEntity<String> responseEntity = null;
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectionRequestTimeout(connectionTimeout);
        requestFactory.setReadTimeout(socketTimeout);

        //实例化RestTemplate
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/plain;charset=UTF-8");
        headers.set("Accept", "*/*;charset=UTF-8");
        String body = null;

        //调用
        try {
//            //Post
//            responseEntity = restTemplate.postForEntity(url, new HttpEntity<>(reqStr, headers), String.class);
            //Get
            responseEntity = restTemplate.getForEntity(url, String.class);
            logger.info("响应头：responseEntity.getHeaders() " + responseEntity.getHeaders());
            body = new String(responseEntity.getBody().getBytes("ISO-8859-1"), "utf-8");
            logger.info("响应体：responseEntity.getBody() " + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }
}
