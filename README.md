# Shopping_system
1、数据库建立（web_shop）
首先，要实现这个系统有三个大类分别为商品、用户和订单，所以我设计的MySQL数据库中需要创建三个表：存储商品信息、存储用户信息、存储订单信息；并定义好它们字段和关系，例如：用户信息表中，需要定义id，用户名，密码，用户类型（顾客或管理员），余额。
2、	后端开发：
使用Java编写数据库访问层，存于utils包中，包中的DBUtil类通过使用JDBC（Java数据库连接）来实现与MySQL数据库的连接从而能进一步的进行交互。而Flag类用来构建标准格式的JSON响应数据，其中包含了成功/失败的状态标识和额外的自定义数据。
使用Java编写模型层，表示Shop、用户User、订单Record实体类，该类对应数据库中的各个表，并提供对应的属性和方法。
使用Java编写控制器层Servlet类中来处理处理用户请求并调用相关的服务，包括商品的添加、查询、删除等操作，用户的注册、登录、个人信息管理等功能，以及订单的生成、支付、查询等操作。
3、	前端开发：
使用HTML、CSS和JavaScript技术设计购物系统的以下页面网页界面：登录页面、注册页面、商品管理总页面、商品的添加和修改页面、顾客管理总页面、顾客添加和修改页面、顾客的商品购物页面、顾客个人信息页面、购物车页面，并发出用户注册登录、管理员管理商品和用户、购买流程和订单管理等功能的请求，最后在JSP页面中引入Servlet类，通过调用Servlet的方法来处理用户的请求，并展示相关数据。

最后，配置web.xml文件，将Servlet类和JSP页面映射到相应的URL路径上，使其能够被访问。在运行Tomcat服务器后，通过浏览器访问相应的URL路径，即可使用购物系统进行浏览商品、添加到购物车等操作。
