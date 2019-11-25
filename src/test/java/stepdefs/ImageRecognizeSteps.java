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
        req.setImgUrl("https://s3.cn-north-1.amazonaws.com.cn/s3-035-shit-irservice-in-prd-bjs/pic/ir-ai-service/sfa/06e6f96d-78b3-414c-a0b8-bbb46a4e0ae4.jpeg?X-Amz-Security-Token=FwoDYXdzEEkaDAIYfA5O5qIbpt5m7SLuAmEKjvcvm5uuuThgsH45xR5e34ML7z5UjkWyq5%2FrPghp0ylgyKOPLOkxvnxEVsJDzRakLhyqfeYDHZkivayzkcZaK8CcwuHoyTn1C6ewAc%2FlQNWmbaosWCqLOs7FaxPJ0j%2FlNhIsoqNDBC3BfvifiuZgGjcNvMT4XKIRkSbyhktYaBu66pV9sFT8Q6SPLnQIw6u0v8NxYASSb3OhiXsFRG2N%2FsfXDPPsxPSVCblLPyxE%2FtaLyjDaJkRvkgJbGeBwmcPuLRg6lq2uKrY2qJswQXeZzpRQ8ssc%2BYk8LAJs4PUC01Kr2ICyPmSul%2F3AOKhHy6i0vmZ2kNboUAlNzSPj9i9xR%2FgjRZRh3w8xvdNuV%2F0kh9EN2KiZxjFhPgBzkLwnSCj4wHWD1ocmw0xaQpusBkK8DG%2BZ7z1OVeRFC05wOv14wDfKd%2F1wPV6wa9ROPayhT8YQUNin3wYqNUKlqW7utdWLY2HsInhukC%2FtZbpbeyjqt%2BzuBTKmAfle9K7%2FX4CMppTQ7L%2FTfFl0hLYk76NK2pnCVMTn73D4YELJ52Wog6Ikm8GqAdgVrvC4jmEBmeG9f1vyMUgIgSL4XCm8tAq32mhTej754sqlF35eesGdnzfD0HN5E6hCmCx3IGlMpwisM5HWeH6HMyr4AUphsAI3KBamnX9mh6bUHHMs7dN6m2BIVKFew5I%2Byf79ZDejj1IPscT2tLWuq17bdnBHzMg%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20191125T013912Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIAXLCZFYXSZC7CPQNK%2F20191125%2Fcn-north-1%2Fs3%2Faws4_request&X-Amz-Signature=ecaf1a0fde42f11c08291af50c13fcd505f1c5119a2cc2a693e4f9ada64c7c0f");
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
