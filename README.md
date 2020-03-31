# IR-API-TEST

用途
1. csv批量建jira sub task。<br>
2. cucubmber跑API case<br>


如何使用csv批量建jira sub task<br>
主要逻辑都在jiraCreateSubtaskCSV.java.

1. 准备subtask.csv<br>
storyKey,storySummary,sub-taskSummary,userId,storyPoint,description,label<br>
IR-980,故事概要,子任务概要,人名或ID,3,子任务描述,测试<br>
人名需要在代码中添加ID转换<br>

2. 放入合适的路径，目前路径，可以自行修改<br>
String csvFile = "D:\\001_Xiaofeng\\JiraRequest\\subtask.csv";<br>

3. 修改jiraCreateSubtaskCSV.java 初始值 后执行该java<br>
Jira用户名，密码<br>
String userpassword = "19070005" + ":" + "Utada.2019";  <br>

Jira项目ID<br>
String project = "IR"; //IR,DAT4 <br>

Jira Sprint fixVersion<br>
String fixVersion = "Sprint08";<br>

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

        
