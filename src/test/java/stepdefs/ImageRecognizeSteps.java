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
        req.setImgUrl("https://s3.cn-north-1.amazonaws.com.cn/s3-035-shit-irservice-in-prd-bjs/pic/ir-ai-service/f92bf4d2-0ce8-11ea-81ba-0242ac130003.jpg?X-Amz-Security-Token=FwoDYXdzEAgaDKCFHmI2o6gy8ru8ayLuAt3AbCbo1GKJQbuBu5VPNGEv%2FyLhyU%2Box0innfU3HGZBnL%2Bqu%2BigpO%2B02QOgr5xJJVJewXmBOKzDQCQ32Wvst1Wl9EtVySvwgrUOIKAlKbAJzxMqDN2OQLtrsgEU54iK579VetNe61UXIoQAPutLkm1wQy20sJUc0RwfU4Ca1anwvOAt50BbNk73kW73zHomCHdksclKxziHm9gUNpjNiCnToIcwPaPWsl3EG7hhNltYkugvKiMW%2Bskv6ZCUsCgqCSpYH8PFsJ0loPxzXcFIDYAt%2BDunr90QQ68ZIN43Z4rdYZ4g8E70DoFPwXPqG2TSsKJKan0hPCuUeVR5W78fS%2Fn2tt03XNvy3Ca3CUCJAsafeyI%2BMR%2BZSrVZ89wli7S1%2BjL2yXGuJrAlrY1Yq2874OtIq06SuzhWzU6Jry6Fb75EcGHl9m%2FcUgMJnp5xMzcUmuy2K4rp3UpGNnLL1PFbujWtgSqARVGja%2F97%2BXLt7iiAk97uBTKmARvfBPnJZxbHHeC8mXSX86DKa7tJVlEgu60t3NKNqHjg31%2B3Arx%2Fyqzwp488lO8vGrKIEdOnriLaPxVJ2FKAX0nsc%2FLko7w42YCMieHWa0UPA0RXn3ZtE5fTt8S2UuG0WksN8rlsIAALCx1UlxT0I%2B2H8oofDlcsIzyxvi%2FWnieZ7Ykzs19AT9oi%2BeH5%2BWAVuQUCLP58MLlYgT5CRYl%2B97%2Bx0BrC1wY%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20191122T072042Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIAXLCZFYXS4R3EJO4S%2F20191122%2Fcn-north-1%2Fs3%2Faws4_request&X-Amz-Signature=76cb215a22ccf393ee8ea4139520d5155437befd549545effbf2cb8b9271df69");
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
