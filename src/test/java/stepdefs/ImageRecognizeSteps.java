package stepdefs;

import bean.ImageAnalysisRequestBodyBean;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.sendRequestUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.sql.Timestamp;
import java.util.Random;

public class ImageRecognizeSteps {
    private HttpURLConnection con;
    private ImageAnalysisRequestBodyBean req = new ImageAnalysisRequestBodyBean();
    private sendRequestUtil reqUtil = new sendRequestUtil();

    @Given("已准备的接口请求内容包含所有字段")
    public void prepareRequestContent() throws IOException {

        String imgPath = "/data/imgUrl.jpg";
//        imgPath = "D:\\001_Xiaofeng\\imgUrl.jpg"; //local_debug
        String imgUrl = reqUtil.generateImgUrlByUploadImg(imgPath);


        req.setBusinessId(String.valueOf(new Random().nextInt(10000)));
        req.setStoreName("上海农工商0293店-中兴店");
        req.setStoreNo("2000287815");
        req.setProvince("上海市");
        req.setCity("上海");
        req.setArea("长宁区");
        req.setAddress("中山国际广场B座2楼");
        req.setLat("31.525829");
        req.setLgt("121.757661");
        req.setSalesId("19070005");
        req.setSalesName("肖峰");
        req.setImgUrl(imgUrl);
        req.setStoreType("CTP-GT");
        req.setSceneCategoryOne("B");
        req.setSceneCategoryTwo("B1");
        req.setDataSource("1");
        req.setPhotoTime(new Timestamp(System.currentTimeMillis()).toString());
        req.setIsSplice("0");
        req.setIsAiQuality("1");
    }

    @When("调用图片接入接口")
    public void callImageAnalysisInputAPI() throws IOException {
        con = reqUtil.generateImageAnalysisConnection();
        reqUtil.sendPOSTRequest(con,req.toJSONObject());
    }

    @Then("调入接口成功，中台生成新记录")
    public void imageRecordsGeneratesInPlatform() throws IOException {
        //TO-DO 添加记录校验
    }
}
