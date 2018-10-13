## 1.springboot的开始
* 1 创建springboot项目的方式很多种，最简单的依然是直接从新建项目 选择spring-initionzer开始。
* 2 新建一个controller，搞定一个requestMapping("/")就可以直接运行application类了
* 3 备注:其实controller类不是必要的，直接在application类增加对应的restController和requestMapping注解 也是可以的

## 2.全局配置文件
application.properties


## 3.redis的使用，
* 1 下载redis，并且启动 (切换到redis目录 启动 redis-server redis.conf  关闭 redis-cli shutdown）
* 2 在application类增加配置，在application.properties类增加配置
* 3 在controller使用


## 4.增加了定时任务，异步任务，拦截器


## 5.配置spring data
* 1 添加依赖 pom.xml
* 2 添加配置文件 application.properties
* 3 创建entity类，来自动生成数据库的表
* 4 创建JpaRepository的子接口，注入到Controller中就可以了


## 6.小技巧
* 1 通过 command+数字键，就可以快捷的显示或者隐藏view窗口 这个数字键
* 2 通过Database的配置(右边的Database窗口栏)，可以直观的在idea上看到数据库数据了 nice (在mac上配置ok）
* 3 编辑跳转


## 7.怎么导入已经存在的sql文件 测试Ok
* 1 将sql文件放置在resources目录下
* 2 新建BatchTaskDataSourceInitializer类，主要是为了初始化DataSourceInitializer


## 8.增加极光推送测试
* 1 测试了tag样式的推送，Android手机成功接收到了