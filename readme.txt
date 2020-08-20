# Start Server
C:\zxu_seaWorkSpace\seata-server-1.3.0\seata\bin> seata-server.bat -p 8091 -h 127.0.0.1 -m file

# init database
执行all_in_one.sql,并修改spring.datasource相关数据库配置

# TEST URL

http://127.0.0.1:8084/business//businessProc/api/purchase/commit
http://127.0.0.1:8084/business/businessProc/api/purchase/rollback


#### 适用场景
常用场景一般使用AT模式
支付场景使用TCC模式

分布式事物理论基础:两阶段提交协议
分布式事物AT模式和TCC模式的防悬挂控制

seata分布式事务代理sqlSessionFactory导致mybatisplus分页插件失效的解决方法_qq_35721287的博客-CSDN博客_sqlsessionfactory配置分页 mybatisplus
https://blog.csdn.net/qq_35721287/article/details/103275830

