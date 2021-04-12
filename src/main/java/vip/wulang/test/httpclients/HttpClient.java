package vip.wulang.test.httpclients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author CoolerWu
 * @version 1.0
 */
public class HttpClient {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient minimal = HttpClients.createMinimal();
        HttpRequestBase request = new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response = minimal.execute(request);
        byte[] bytes = EntityUtils.toByteArray(response.getEntity());
        System.out.println(new String(bytes));
    }
}
