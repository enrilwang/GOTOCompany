# 多线程编程

```text
线程创建
继承Thread， 实现Runnable接口，实现Callable接口

1。Thread类 实现了Runnable接口
把一个类声明为Thread的子类，重写run方法，运行时，new出此对象，用start去执行


2。implement Runnable接口
override run方法，把此类作为参数传到new Thread（）里

3。实现Callable接口，重写call（）方法，返回值是Boolean
执行线程时是，ExecutorService 去newFixedThreadPool，然后提交执行，之后获取结果
最后关闭服务。



产生死锁的四个必要条件：
1 互斥条件：一个资源只能被一个进程使用
2 请求与保持条件：一个进程因请求资源而堵塞时，对已获得的资源保持不放
3 不剥夺条件：进程已获得的资源，在未使用完之前，不能强行剥夺
4 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源的关系
```

