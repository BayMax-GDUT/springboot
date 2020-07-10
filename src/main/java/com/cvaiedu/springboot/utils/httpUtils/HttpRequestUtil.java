package com.cvaiedu.springboot.utils.httpUtils;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

@Component
public class HttpRequestUtil {

    /**
     * 发送http请求工具类
     *
     * @param url
     * @param httpMethod
     * @return
     */
    public String httpRequest(String url, HttpMethod httpMethod) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = null;
        int i = 0;
        do {
            try {
                response = restTemplate.exchange(url, httpMethod, entity, String.class);
            } catch (HttpClientErrorException e) {
                entity = new HttpEntity<>(headers);
                i++;
            }
        } while (0 < i && i < 4);
        if (response == null) {
            throw new Exception("请求出错");
        }
        return response.getBody();
    }


    /**
     * 发送http请求工具类,带body
     *
     * @param url
     * @param httpMethod
     * @return
     */
    public String httpRequest(String url, HttpMethod httpMethod, String jsonData) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<>(jsonData, headers);
        ResponseEntity<String> response = null;
        int i = 0;
        do {
            try {
                response = restTemplate.exchange(url, httpMethod, entity, String.class);
            } catch (HttpClientErrorException e) {
                entity = new HttpEntity<>(headers);
                i++;
            }
        } while (0 < i && i < 4);
        if (response == null) {
            throw new Exception("请求出错");
        }
        return response.getBody();
    }

    /*
     * 处理https GET/POST请求
     * 请求地址、请求方法、参数
     * */
    public static String httpsRequest(String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
            //创建SSLContext
            SSLContext sslContext= SSLContext.getInstance("SSL");
            TrustManager[] tm={new MyX509TrustManager()};
            //初始化
            sslContext.init(null, tm, new java.security.SecureRandom());;
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url=new URL(requestUrl);
            HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            //往服务器端写内容
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
