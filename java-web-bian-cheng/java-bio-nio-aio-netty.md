# JAVA BIO NIO AIO Netty

BIO:同步并堵塞，客户端有连接请求时服务器端需要启动一个线程进行处理，没处理完之前此线程不能做其他操作。

NIO：同步非堵塞，客户端发送的连接请求都会到多路复用器上，服务器端当accept一个请求后，加入fds集合，每次轮询一遍fds集合去recv数据。底层也是用epoll。

AIO：异步非堵塞，客户端的I/O请求都是由操作系统先完成了再通知服务器应用去启动线程进行处理，



## IO多路复用（select，poll，epoll）

IO多路复用是一种同步IO模型，实现一个线程可以监视多个文件句柄；一旦某个文件句柄就绪，就能够通知应用程序进行相应的读写操作。没有文件句柄就绪时就会堵塞应用程序，交出cpu，多路是指网络连接，复用指的是同一个线程。

没有多路复用的时候，有BIO和NIO两种实现方式，但是有问题。

select: 运行到select会堵塞，把一组fd从用户态转换成内核态，由内核态去查找，找到了就讲bitmap置位，但是大小只有1024个fd

poll：思路和select一样但是取消了1024的限制，因为有自己的struct，置位置的是revent变量。

epoll：先是用epoll create创建epfd，然后需要epoll ctl函数进行配置。因为在epoll wait函数里面需要用到这个参数。好处就是不需要进行拷贝了，还是内核态来检查。epoll中的置位 是进行重排，把有数据的往前放。然后进行返回。

[https://www.cnblogs.com/flashsun/p/14591563.html](https://www.cnblogs.com/flashsun/p/14591563.html) 可参考

