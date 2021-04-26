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

### RPC调用（remote procedure call 远程过程调用）

和Ajax的共同点：都是两个计算机之间的网络通信，需要双方约定一个数据格式

和Ajax的不同点：不一定使用DNS作为寻址服务，应用层一般不使用HTTP（会使用二进制协议，有性能优势），但是基于TCP或UDP协议

```text
不同点一：
寻址/负载均衡
    Ajax：使用DNS进行寻址，先给DNS去寻址，然后在把拿到的IP地址  
          发起真正的请求
    RPC： 使用特有服务进行寻址，使用特有的id去发送请求给
          寻址服务器（内网ID）去获取ip地址，得到IP后去往另外一个
          服务器拿数据
 不同点二：
 TCP通信方式：
       单工通信
       半双工通信（同一个时间只有一端可以向一端发数据）
       全双工通信
 不同点三：Ajax是http 文本协议包括html，json
 二进制协议：RPC是使用二进制协议
       更小的数据包体积   【0001 0000 1111 0001】数据流
       更快的编解码速率
                
  
    
      
nodejs net搭建多路复用的RPC通道 require（‘net‘）          
```



|  |  |
| :--- | :--- |
|  |  |

