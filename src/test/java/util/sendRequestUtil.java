package util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * @author 19070005
 * @date 2019/09/11
 */
public class sendRequestUtil {

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
        URL url = new URL("https://apimarket-test.shinho.net.cn/ir-ai-service/image/analysis");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);
        return con;
    }
}
