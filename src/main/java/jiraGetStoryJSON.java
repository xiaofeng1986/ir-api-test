import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jiraGetStoryJSON {

    public static final String CSV_FILE_PATH = "D:\\001_Xiaofeng\\JiraRequest\\subtask.csv";
    public static final String JIRA_USER = "19070005";
    public static final String JIRA_PWD = "Utada.2019";
    public static final String PROJECT = "DAT4";  //IR-图像中台,DAT4-C4I,,SYJ-食与家
    public static final String FIX_VERSION = "Sprint27";
    public static String totalCardJSON = "[";
    public static String[] storyJiraList  =  new String[] {"DAT4-5150","DAT4-5001","DAT4-5000","DAT4-4999","DAT4-4998","DAT4-4997","DAT4-4996","DAT4-4995","DAT4-4994","DAT4-4992","DAT4-4989","DAT4-4988","DAT4-4985","DAT4-4967","DAT4-4966","DAT4-4965","DAT4-4964","DAT4-4939","DAT4-4912","DAT4-4911","DAT4-4909","DAT4-4908","DAT4-4907","DAT4-4906","DAT4-4903","DAT4-4902","DAT4-4885","DAT4-4883","DAT4-4882","DAT4-4881","DAT4-4879","DAT4-4861","DAT4-4785","DAT4-4541","DAT4-4529","DAT4-4009"
    };

    public static void main(String[] args) {
        for(String storyJira: storyJiraList){
            try {
                getJiraAPIJSON(storyJira);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        totalCardJSON = totalCardJSON.substring(0, totalCardJSON.length()-1) + "]";
        System.out.println(
                "CardJSON : " + totalCardJSON + "\n" );
    }

    private static void getJiraAPIJSON(String issue) throws IOException {
//      Generate URL and Header
        URL url = new URL("http://jira.shinho.net.cn/rest/api/2/issue/" + issue);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BASE64Encoder enc = new BASE64Encoder();
        String userpassword = JIRA_USER + ":" + JIRA_PWD;
        String encodedAuthorization = enc.encode(userpassword.getBytes());
        con.setRequestProperty("Authorization", "Basic " +
                encodedAuthorization);

        con.setDoOutput(true);

        InputStream is;
        if (con.getResponseCode() >= 400) {
            is = con.getErrorStream();
        } else {
            is = con.getInputStream();
        }

//      Parser Response
        String charset = "utf-8";
        String responseLine;
        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(is, charset))) {
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        if (con.getResponseCode() == 200) {


            String parentKey = issue;
            String subTaskKey = issue;
            String storyPoint = response.toString().substring(response.toString().indexOf("customfield_10006")+19
                    ,response.toString().indexOf("customfield_10800")-2);
            String storySummary = response.toString().substring(response.toString().lastIndexOf("\"summary\"")+10
                    ,response.toString().indexOf("customfield_10000")-2);
            String startDateJson = response.toString().substring(response.toString().indexOf("customfield_10607")+19
                    ,response.toString().indexOf("customfield_10608")-2);
            String endDateJson = response.toString().substring(response.toString().indexOf("customfield_10609")+19
                    ,response.toString().indexOf("creator")-2);
//            String userNameJson = response.toString().substring(response.toString().indexOf("assignee")+14
//                    ,response.toString().indexOf("status")-2);

//            storySummary = storySummary.replace("【","");
//            storySummary = storySummary.replace("】","");
            storyPoint = storyPoint.replace("null","");
            storySummary = storySummary.replace("\"","");
            startDateJson = startDateJson.replace("\"","");
            startDateJson = startDateJson.replace("null","");
            endDateJson = startDateJson.replace("null","");
            endDateJson = endDateJson.replace("\"","");

            if(startDateJson.length()>8) {
                startDateJson=startDateJson.substring(5);
            }
            if(endDateJson.length()>8) {
                endDateJson=endDateJson.substring(5);
            }

            String jsonConnection = "\", \"";
            String cardJsonLine = "[\"" + parentKey + jsonConnection + subTaskKey + jsonConnection
                    + storyPoint + jsonConnection
                    + storySummary + jsonConnection
                    + startDateJson + jsonConnection + endDateJson + jsonConnection
//                    + userNameJson
                    + "\"],";

            totalCardJSON += cardJsonLine;

            System.out.println(
//                    "Response Code : " + con.getResponseCode() + "\n" +
//                            "Response Body: " + response.toString() + "\n" +
//                            "SubTaskKey:  " + subTaskKey + "\n" +
                            "cardJsonLine: " +
                                    cardJsonLine
            );
        } else {
            System.out.println(
                    "Response Code : " + con.getResponseCode() + "\n" +
                            "Response Body: " + response.toString() + "\n" );
        }
    }
}