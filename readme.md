# Start Server
C:\zxu_seaWorkSpace\seata-server-1.3.0\seata\bin> seata-server.bat -p 8091 -h 127.0.0.1 -m file

# init database

# TEST URL
http://127.0.0.1:8083/account/test
http://127.0.0.1:8084/business/api/business/test
http://127.0.0.1:8082/order/api/order/test
http://127.0.0.1:8081/storage/api/storage/test

http://127.0.0.1:8084/business/api/business/purchase/commit
http://127.0.0.1:8084/business/api/business/purchase/rollback
