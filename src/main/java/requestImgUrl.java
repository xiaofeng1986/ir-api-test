import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class requestImgUrl {


    public static void main(String[] args) throws ClientProtocolException, IOException {
        // 文件sTestsetFile：solr_etl_agent35.json是存有JSON字符串的文件
        String sTestsetFile="D:\\001_Xiaofeng\\imgUrl.jpg";
        String sURL="https://apimarket-test.shinho.net.cn/ir-rec-service/file/upload";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(sURL);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);

        // 把文件加到HTTP的post请求中
        File f = new File(sTestsetFile);
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

        System.out.println("Post 返回结果"+sResponse);
        System.out.println("Img Url:"+sResponse.substring(beginIndex,endIndex));
    }
}
