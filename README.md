
# 学海小初高在线教育平台

## 一、动机

利用这个项目，再次复习整合**SSM框架**相关知识

模拟企业开发，熟练全程采用**HTML+AJAX+JSON**的前后端数据交互形式

再次熟悉**IDEA+Maven**的使用
    
## 二、项目结构
###  **前台**
### - 课程搜索
使用 **solr**搜索引擎进行搜索

| URL | 描述 |
|--------|------------------|
| https://www.solr.cc/blog/ | solr搜素引擎开发文档 |
| [https://www.getpostman.com/](https://www.getpostman.com/) | 测试模拟发送post请求的http客户端 |
| [https://download.csdn.net/download/u010510107/10558538](https://download.csdn.net/download/u010510107/10558538) | IKAnalyzer中文分词器 |
**特别注意：**
- IK 分词器原理是用字典,与字典中的字符相匹配，匹配上一个就分为一个词
- 过程提交与返回的都是XML
### -  订单付款
使用 阿里沙箱支付进行支付

| URL | 描述 |
|--------|------------------|
| https://docs.open.alipay.com/200/105311 | 阿里沙箱支付开发文档 |
| https://openapi.alipaydev.com/gateway.do | 调用支付接口网关 |

### -  用户评论
使用过滤器+数据字典进行匹配，如果敏感词汇则用**代替
### -  权限控制
使用拦截器对未登录及未付款用户进行权限控制
### - 分类显示
使用二级分类表，实现分类显示

###  **后台** 
### - 对各大对象进行管理操作
对用户、课程、分类、订单、评论、图片上传等进行管理
### - 管理员权限管理
对管理员的权限进行管理


## 三、技术点

 - Solr搜索引擎
 - 支付宝沙箱支付
 - SSM框架
 - HTML+AJAX+JSON
 - 拦截器、过滤器、数据字典
 - C3P0、DPCP数据源
 - github模拟协同开发，版本控制
## 四、效果一览
![index](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/index.png)

![login](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/login.png)

![分类](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%88%86%E7%B1%BB.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%88%86%E7%B1%BB2.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E6%90%9C%E7%B4%A2.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E6%90%9C%E7%B4%A22.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E6%90%9C%E7%B4%A23.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E8%AF%A6%E6%83%85%E9%A1%B5.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E8%B4%AD%E7%89%A9%E8%BD%A6.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%90%8E%E5%8F%B01.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%90%8E%E5%8F%B02.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%90%8E%E5%8F%B03.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%90%8E%E5%8F%B04.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%90%8E%E5%8F%B05.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%90%8E%E5%8F%B06.png)

![enter image description here](https://github.com/zhuzi-01/XHEducation/blob/master/src/main/webapp/screenshot/%E5%90%8E%E5%8F%B07.png)
