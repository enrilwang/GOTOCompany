# web编程

```text
import java.net.InetAddress
import java.net.UnknownHostException


端口 -- 计算机的一个进程 PID

端口分类
    -公有端口 0～65535
        HTTP：80
        HTTPS：443
        FTP：21
        Telent：23
    -程序组册端口：1024～49151，分配用户或程序
        Tomcat：8080
        MySQL：3306
        Oracle：1521
    -动态，私有：49152～65535
        netstat -ano  #查看所有端口
        netstat -ano｜findstr “5900“ #查看指定的端口
        tasklist｜findstr “8696“ #查看指定端口的进程
        
        
Tomcat：java写的，可以充当一个服务器 8080端口号
```

