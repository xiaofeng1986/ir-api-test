# IR-API-TEST

用途
1. csv批量建jira sub task。
2. cucubmber跑API case


如何使用csv批量建jira sub task.
1. 准备subtask.csv
storyKey,storySummary,sub-taskSummary,userId,storyPoint,description,label
IR-980,【人工+结果+异常列表页】根据数据权限列表筛选项+详情页的场景区分,测试用例：【人工+结果+异常列表页】根据数据权限列表筛选项+详情页的场景区分,王秋丽,3,测试用例：【人工+结果+异常列表页】根据数据权限列表筛选项+详情页的场景区分,测试

2. 放入合适的路径，目前路径，可以自行修改。
String csvFile = "D:\\001_Xiaofeng\\JiraRequest\\subtask.csv";

3. 修改jiraCreateSubtaskCSV.java 初始值 后执行
Jira用户名，密码
String userpassword = "19070005" + ":" + "Utada.2019";  

Jira项目ID
String project = "IR"; //IR,DAT4 

Jira Sprint fixVersion
String fixVersion = "Sprint08";


PS: 如有需要，自行添加用户名和userID 转换
switch (userId) {
            case "刘":
                userId = "18040068";
                break;


PS2： 调试使用到的Jira API :
获得 Jira信息,GET方法，http://jira.shinho.net.cn/rest/api/2/issue/IR-409
创建jirar, POST方法，http://jira.shinho.net.cn/rest/api/2/issue

{"fields": {"project":{"key": "IR"},
"fixVersions": [{"name": "Sprint08"}],
"parent":{"key": "IR-802"},
"labels": ["后端"],
"assignee":{"name": "18040165"},
"summary": "关键指标","description": "图片接收数量-单日--数据权限修改-;图片接收数量-本月累计---数据权限修改-;AI识别数量-单日---数据权限修改-;AI识别数量-本月累计---数据权限修改-;审核完成数量-单日---数据权限修改+功能权限修改-;审核完成数量-本月累计---数据权限修改+功能权限修改-","issuetype":{"id": "10302","name": "子任务"},
"customfield_10006": 2
}}

        