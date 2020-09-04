# IR-API-TEST

使用csv批量建jira sub task。<br>

前置条件：<br>
1.安装JDK1.8<br>
2.按照IDE（可以使用IDEA）,使用IDE运行jiraCreateSubtaskCSV.java<br>

如何使用csv批量建jira sub task（主要逻辑都在jiraCreateSubtaskCSV.java）<br>

1. 准备subtask.csv<br>
storyKey,parentStory,sub-taskSummary,userId,storyPoint,description,startDate,endDate<br>
IR-980,故事概要,子任务概要,人名或ID,3,子任务描述,开始日期，结束日期<br>
开始日期和结束日期是可选字段<br>
人名需要在代码中添加ID转换<br>

2. 放入合适的路径，目前路径，可以自行修改<br>
Win路径 WIN_CSV_FILE_PATH = "D:\\001_Xiaofeng\\JiraRequest\\subtask.csv";<br>
MacOSX路径 OSX_CSV_FILE_PATH = "/Users/19070005/Documents/gitRepo/ir-api-test/src/main/java/subtask.csv";<br>
    

3. 修改jiraCreateSubtaskCSV.java 初始值 后执行该java<br>
- Jira用户名，密码： String userpassword = "19070005" + ":" + "Utada.2019";  <br>
- Jira项目ID：String project = "IR"; //IR,DAT4 <br>
- Jira Sprint fixVersion：String fixVersion = "Sprint08";<br>

----
PS: 如有需要，自行添加用户名和userID 转换<br>
switch (userId) {<br>
            case "刘":<br>
                userId = "18040068";<br>
                break;<br>

PS2： 调试使用到的Jira API :<br>
获得 Jira信息,GET方法，http://jira.shinho.net.cn/rest/api/2/issue/IR-409<br>
创建jirar, POST方法，http://jira.shinho.net.cn/rest/api/2/issue<br>

{"fields": {"project":{"key": "IR"},<br>
"fixVersions": [{"name": "Sprint08"}],<br>
"parent":{"key": "IR-802"},<br>
"labels": ["后端"],<br>
"assignee":{"name": "18040165"},<br>
"summary": "关键指标","description": "图片接收数量-单日--数据权限修改-;图片接收数量-本月累计---数据权限修改-;AI识别数量-单日---数据权限修改-;AI识别数量-本月累计---数据权限修改-;审核完成数量-单日---数据权限修改+功能权限修改-;审核完成数量-本月累计---数据权限修改+功能权限修改-","issuetype":{"id": "10302","name": "子任务"},<br>
"customfield_10006": 2<br>
}}<br>

        
