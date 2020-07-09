import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class jiraCreateSubtaskCSV {
//    subtask.csv template
//    storyKey,sub-taskSummary,userId,storyPoint,description,startDate,endDate
//    SYJ-2636,【测试】小程序食谱草稿测试用例编写,葛肖峰,0.5,-,2020/6/11,2020/6/11

    public static final String WIN_CSV_FILE_PATH = "D:\\001_Xiaofeng\\JiraRequest\\subtask.csv";
    public static final String OSX_CSV_FILE_PATH = "/Users/19070005/Documents/gitRepo/c4i/ir-api-test/src/main/javasubtask.csv";
    public static final String JIRA_USER = "19070005";
    public static final String JIRA_PWD = "Utada.2019";
    public static final String PROJECT = "IR";  //IR-图像中台,DAT4-C4I,,SYJ-食与家
    public static final String FIX_VERSION = "Sprint14";
    public static String totalCardJSON = "[";


    //中文字符逗号处理，

    public static void main(String[] args) {
        String csvFile = OSX_CSV_FILE_PATH;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                line = line.replace("（","-");
                line = line.replace("）","-");
                line = line.replace("、","-");
                line = line.replace("，","-");
                line = line.replace("\"","-");
                String[] issue = line.split(cvsSplitBy);
                sendJiraCreateAPI(issue);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        totalCardJSON = totalCardJSON.substring(0, totalCardJSON.length()-1) + "]";
        System.out.println(
                "CardJSON : " + totalCardJSON + "\n" );

    }

    private static void sendJiraCreateAPI(String[] issue) throws IOException {
//      Generate URL and Header
        URL url = new URL("http://jira.shinho.net.cn/rest/api/2/issue");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        BASE64Encoder enc = new sun.misc.BASE64Encoder();
        String userpassword = JIRA_USER + ":" + JIRA_PWD;
        String encodedAuthorization = enc.encode(userpassword.getBytes());
        con.setRequestProperty("Authorization", "Basic " +
                encodedAuthorization);

        con.setDoOutput(true);

        String project = PROJECT; //IR,DAT4
        String fixVersion = FIX_VERSION;
//        String components = "开发";
        String parentKey = issue[0];
        String subTaskSummary = issue[1];
        String userId = issue[2];
        String storyPoint = issue[3];
        String descriptioin = subTaskSummary+issue[4];
        String label = null;
        String startDate = null;
        String endDate = null;
        Boolean includeDate = false;
        String startDateJson = null;
        String endDateJson = null;
        String userIdJson = userId;

        if (issue.length>5){
            includeDate = true;

            startDate=issue[5];
            endDate = issue[6];
            startDateJson = startDate.substring(5);
            endDateJson = endDate.substring(5);

            if(startDate.contains("/") || endDate.contains("/") ) {
                startDate = startDate.replace("/","-");
                endDate = endDate.replace("/","-");
            }
        }

        switch (userId) {
            case "刘振宇":
                userId = "18040068";
                label = "后端";
                break;
            case "沈志刚":
                userId = "19060002";
                label = "后端";
                break;
            case "殷建军":
                userId = "15110003";
                label = "后端";
                break;
            case "建军":
                userId = "15110003";
                label = "后端";
                break;
            case "牛彪":
                userId = "18040165";
                label = "后端";
                break;
            case "任春宝":
                userId = "18020001";
                label = "后端";
                break;
            case "张明阳":
                userId = "18040108";
                label = "前端";
                break;
            case "严永洁":
                userId = "18120001";
                label = "前端";
                break;
            case "李智":
                userId = "18050027";
                label = "前端";
                break;
            case "孙孟杰":
                userId = "17060036";
                label = "前端";
                break;
            case "李务增":
                userId = "17080006";
                label = "前端";
                break;
            case "王秋丽":
                userId = "18120108";
                label = "测试";
                break;
            case "左琦":
                userId = "18010019";
                label = "测试";
                break;

            case "苗壮":
                userId = "17080013";
                label = "前端";
                break;
            case "徐海峰":
                userId = "17080010";
                label = "前端";
                break;
            case "张警国":
                userId = "19080088";
                label = "前端";
                break;
            case "王龙刚":
                userId = "18040185";
                label = "前端";
                break;
            case "张康鑫":
                userId = "17100021";
                label = "前端";
                break;
            case "傅为地":
                userId = "18040112";
                label = "后端";
                break;
            case "付为地":
                userId = "18040112";
                label = "后端";
                break;
            case "鲁万财":
                userId = "19040047";
                label = "后端";
                break;
            case "魏涛":
                userId = "18010080";
                label = "后端";
                break;
            case "郭虎":
                userId = "17080007";
                label = "后端";
                break;
            case "郝旭龙":
                userId = "18120003";
                label = "后端";
                break;
            case "魏源":
                userId = "17120031";
                label = "测试";
                break;
            case "陈侃麟":
                userId = "17120059";
                label = "测试";
                break;
            case "郑慧民":
                userId = "18120049";
                label = "测试";
                break;
            case "李磊":
                userId = "18120002";
                label = "后端";
                break;
            case "万军":
                userId = "17060085";
                label = "后端";
                break;
            case "蔡文彬":
                userId = "17110099";
                label = "前端";
                break;
            case "王修生":
                userId = "17050033";
                label = "后端";
                break;
            case "辛文丽":
                userId = "16010019";
                label = "后端";
                break;
            case "吴宗恩":
                userId = "18110018";
                label = "前端";
                break;
            case "尚康":
                userId = "19110089";
                label = "前端";
                break;
            case "杨丽辉":
                userId = "18040067";
                label = "测试";
                break;
            case "张婧雯":
                userId = "18040186";
                label = "后端";
                break;
            case "范军辉":
                userId = "17080005";
                label = "前端";
                break;
            case "周俊":
                userId = "20040071";
                label = "前端";
                break;
            case "朱炜敬":
                userId = "17090104";
                label = "前端";
                break;
            case "黄二明":
                userId = "18120004";
                label = "测试";
                break;
            case "徐晓赟":
                userId = "17080107";
                label = "测试";
                break;
            case "徐晓贇":
                userId = "17080107";
                label = "测试";
                break;
            case "吴雅韵":
                userId = "17110096";
                label = "产品";
                break;
            case "胡学文":
                userId = "19040004";
                label = "产品";
                break;
            case "陈霞":
                userId = "17120056";
                label = "产品";
                break;
            default:
                userId = "19070005";
        }

        String requestBody = "{\"fields\": {\"project\":{\"key\": \"" + project + "\"},\n" +
                "\"fixVersions\": [{\"name\": \"" + fixVersion + "\"}],\n" +
//                "\"components\": [{\"name\": \"" + components + "\"}],\n" +
                "\"parent\":{\"key\": \"" + parentKey + "\"},\n" +
                "\"labels\": [\"" + label + "\"],\n" +
                "\"assignee\":{\"name\": \"" + userId + "\"},\n" +
                "\"summary\": \"" + subTaskSummary + "\",\"description\": \"" +descriptioin + "\",\"issuetype\":{\"id\": \"10302\",\"name\": \"子任务\"},\n" +
                "\"customfield_10006\": " + storyPoint + "\n" ;

        if (includeDate) {
            requestBody += ",\"customfield_10607\": \"" + startDate + "\"\n" +
                    ",\"customfield_10609\": \"" + endDate + "\"\n" +
                    "}}";
        } else {
            requestBody += "}}";
        }


        String charset = "utf-8";
        try (OutputStream os = con.getOutputStream()) {
            os.write(requestBody.getBytes(charset));
        }

        InputStream is;
        if (con.getResponseCode() >= 400) {
            is = con.getErrorStream();
        } else {
            is = con.getInputStream();
        }

//      Parser Response
        String responseLine;
        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(is, charset))) {
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        if (con.getResponseCode() == 201) {
            int subTaskKeyStart = response.toString().indexOf("key")+6;
            int subTaskKeyEnd = response.toString().indexOf("self")-3;
            String subTaskKey= response.toString().substring(subTaskKeyStart,subTaskKeyEnd);

            String jsonConnection = "\", \"";
            String cardJsonLine = "[\"" + parentKey + jsonConnection + subTaskKey + jsonConnection
                    + storyPoint + jsonConnection +  subTaskSummary + jsonConnection
                    + startDateJson + jsonConnection + endDateJson + jsonConnection + userIdJson + "\"],";

            totalCardJSON += cardJsonLine;

            System.out.println(
//                    "Response Code : " + con.getResponseCode() + "\n" +
//                            "Response Body: " + response.toString() + "\n" +
//                            "SubTaskKey:  " + subTaskKey + "\n" +
//                            "cardJsonLine: " +
                                    cardJsonLine
            );
        } else {
            System.out.println(
                    "Response Code : " + con.getResponseCode() + "\n" +
                            "Response Body: " + response.toString() + "\n" +
                            "Request Body : " + requestBody);
        }
    }
}