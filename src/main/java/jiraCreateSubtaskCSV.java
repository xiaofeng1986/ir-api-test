import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class jiraCreateSubtaskCSV {
    
    public static final String CSV_FILE_PATH = "D:\\001_Xiaofeng\\JiraRequest\\subtask.csv";
    public static final String JIRA_USER = "19070005";
    public static final String JIRA_PWD = "Utada.2019";
    public static final String PROJECT = "DAT4";  //IR-图像中台,DAT4-C4I,,SYJ-食与家
    public static final String FIX_VERSION = "Sprint27";
    public static String totalCardJSON = "[";


    //中文字符逗号处理，

    public static void main(String[] args) {
        String csvFile = CSV_FILE_PATH;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                // use comma as separator
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
        String label = issue[5];
        String startDate = null;
        String endDate = null;
        Boolean includeDate = false;
        String startDateJson = null;
        String endDateJson = null;
        String userIdJson = userId;

        if (issue.length>6){
            includeDate = true;

            startDate=issue[6];
            endDate = issue[7];
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
                break;
            case "沈志刚":
                userId = "19060002";
                break;
            case "殷建军":
                userId = "15110003";
                break;
            case "建军":
                userId = "15110003";
                break;
            case "牛彪":
                userId = "18040165";
                break;
            case "任春宝":
                userId = "18020001";
                break;
            case "张明阳":
                userId = "18040108";
                break;
            case "严永洁":
                userId = "18120001";
                break;
            case "李智":
                userId = "18050027";
                break;
            case "孙孟杰":
                userId = "17060036";
                break;
            case "李务增":
                userId = "17080006";
                break;
            case "王秋丽":
                userId = "18120108";
                break;
            case "左琦":
                userId = "18010019";
                break;
            case "苗壮":
                userId = "17080013";
                break;
            case "徐海峰":
                userId = "17080010";
                break;
            case "张警国":
                userId = "19080088";
                break;
            case "王龙刚":
                userId = "18040185";
                break;
            case "张康鑫":
                userId = "17100021";
                break;
            case "傅为地":
                userId = "18040112";
                break;
            case "付为地":
                userId = "18040112";
                break;
            case "鲁万财":
                userId = "19040047";
                break;
            case "魏涛":
                userId = "18010080";
                break;
            case "郭虎":
                userId = "17080007";
                break;
            case "郝旭龙":
                userId = "18120003";
                break;
            case "魏源":
                userId = "17120031";
                break;
            case "陈侃麟":
                userId = "17120059";
                break;
            case "郑慧民":
                userId = "18120049";
                break;
            case "李磊":
                userId = "18120002";
                break;
            case "万军":
                userId = "17060085";
                break;
            case "蔡文彬":
                userId = "17110099";
                break;
            case "王修生":
                userId = "17050033";
                break;
            case "辛文丽":
                userId = "16010019";
                break;
            case "吴宗恩":
                userId = "18110018";
                break;
            case "尚康":
                userId = "19110089";
                break;
            case "杨丽辉":
                userId = "18040067";
                break;
            case "张婧雯":
                userId = "18040186";
                break;
            case "范军辉":
                userId = "17080005";
                break;
            case "周俊":
                userId = "20040071";
                break;
            case "朱炜敬":
                userId = "17090104";
                break;
            case "黄二明":
                userId = "18120004";
                break;
            case "徐晓赟":
                userId = "17080107";
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