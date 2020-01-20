package util;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * @author 19070005
 * @date 2019/09/11
 */
public class sendRequestUtil {

    public static final String HTTPS_APIMARKET_TEST_SHINHO_NET_CN_IR_AI_SERVICE_IMAGE_ANALYSIS = "https://apimarket-test.shinho.net.cn/ir-ai/image/analysis";

    public sendRequestUtil() {}

    /**
     * 发送POST的HTTP请求
     * @param con
     * @param requestBody
     * @throws IOException
     */
    public void sendPOSTRequest(HttpURLConnection con, String requestBody) throws IOException {
        String charset = "utf-8";
//      发出请求
        try(OutputStream os = con.getOutputStream()) {
            os.write(requestBody.getBytes(charset));
        }

//      获得错误响应信息
        InputStream is;
        if (con.getResponseCode() >= 400) {
            is = con.getErrorStream();
        } else {
            is = con.getInputStream();
        }

//      获得响应
        String responseLine;
        StringBuilder response = new StringBuilder();
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(is,charset))) {
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }
        assertTrue(
                "Response Code : " + con.getResponseCode() + "\n" +
                        "Response Message : " + con.getResponseMessage() + "\n" +
                        "Response Body: " + response.toString() + "\n" +
                        "Request Body : " + requestBody ,response.toString().contains("200"));

    }

    public HttpURLConnection generateImageAnalysisConnection() throws IOException {
        URL url = new URL(HTTPS_APIMARKET_TEST_SHINHO_NET_CN_IR_AI_SERVICE_IMAGE_ANALYSIS);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);
        return con;
    }

    public String generateImgUrlByUploadImg(String imgPath) throws IOException {
        String sURL="https://apimarket-test.shinho.net.cn/ir-rec-service/file/upload";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(sURL);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);

        // 把文件加到HTTP的post请求中
        File f = new File(imgPath);
        builder.addBinaryBody(
                "file",
                new FileInputStream(f),
                ContentType.APPLICATION_OCTET_STREAM,
                f.getName()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();
        String sResponse= EntityUtils.toString(responseEntity, "UTF-8");
        int beginIndex = sResponse.indexOf("\"data\":\"") + 8;
        int endIndex = sResponse.length()-2;

        return sResponse.substring(beginIndex,endIndex);
    }

}
