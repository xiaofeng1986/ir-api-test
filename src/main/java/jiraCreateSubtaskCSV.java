import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class jiraCreateSubtaskCSV {

    public static void main(String[] args) {
        String csvFile = "D:\\001_Xiaofeng\\JiraRequest\\subtask.csv";
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

    }

    private static void sendJiraCreateAPI(String[] issue) throws IOException {
//      Generate URL and Header
        URL url = new URL("http://jira.shinho.net.cn/rest/api/2/issue");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        BASE64Encoder enc = new sun.misc.BASE64Encoder();
        String userpassword = "19070005" + ":" + "Utada.2019";
        String encodedAuthorization = enc.encode(userpassword.getBytes());
        con.setRequestProperty("Authorization", "Basic " +
                encodedAuthorization);

        con.setDoOutput(true);

        String project = "IR"; //IR,DAT4
        String fixVersion = "Sprint11";
//        String components = "开发";
        String parentKey = issue[0];
        String subTaskSummary = issue[2];
        String userId = issue[3];
        String storyPoint = issue[4];
        String descriptioin = issue[5];
        String label = issue[6];
//        String startDate = issue[6];
//        String endDate = issue[7];

        switch (userId) {
            case "刘":
                userId = "18040068";
                break;
            case "志刚":
                userId = "19060002";
                break;
            case "殷建军":
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
            default:
                userId = "19070005";
        }

        final String requestBody = "{\"fields\": {\"project\":{\"key\": \"" + project + "\"},\n" +
                "\"fixVersions\": [{\"name\": \"" + fixVersion + "\"}],\n" +
//                "\"components\": [{\"name\": \"" + components + "\"}],\n" +
                "\"parent\":{\"key\": \"" + parentKey + "\"},\n" +
                "\"labels\": [\"" + label + "\"],\n" +
                "\"assignee\":{\"name\": \"" + userId + "\"},\n" +
                "\"summary\": \"" + subTaskSummary + "\",\"description\": \"" +descriptioin + "\",\"issuetype\":{\"id\": \"10302\",\"name\": \"子任务\"},\n" +
                "\"customfield_10006\": " + storyPoint + "\n" +
//                ",\"customfield_10607\": \"" + startDate + "\"\n" +
//                ",\"customfield_10609\": \"" + endDate + "\"\n" +
                "}}";

        String charset = "utf-8";
//      Send Request
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
            System.out.println(
                    "Response Code : " + con.getResponseCode() + "\n" +
                            "Response Body: " + response.toString() + "\n");
        } else {
            System.out.println(
                    "Response Code : " + con.getResponseCode() + "\n" +
                            "Response Body: " + response.toString() + "\n" +
                            "Request Body : " + requestBody);
        }

    }

}
