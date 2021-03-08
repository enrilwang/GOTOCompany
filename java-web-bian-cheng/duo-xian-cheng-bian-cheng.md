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

## 自旋锁和互斥锁

自旋锁是线程如果拿不到锁会一直处于busy-waiting忙等待的一个过程，所以会一直处于用户态，性能更好了，因为不需要做太多的上下文切换，但是这个优势是当锁的持有时间不长的时候，如果锁的持有时间很长，就会浪费cpu的资源，反而得不偿失。

自旋锁可升级为可重入锁，可重入锁：当一个线程拿到这个锁时，在锁释放之前，再次拿到该锁，是可以拿到的。可重入锁的实现思想就是，有一个计数器count，每次lock，都++，unlock就--，所以是可以多次获取该锁的，当count再次=0，释放掉

可重入锁：支持超时的获取锁，用try lock，而synchronized关键字会卡死在这里。核心结构是AQS（AbstractQueueSynchronized）内部是queue队列，通过链表实现的队列。

reentrantLock通过两个构造函数来创建公平锁or非公平锁，默认是非公平锁，另外一个构造函数，传入的是一个boolean变量，true就代表是公平锁。





## synchronized详解

synchronized是基于monitor机制实现的，只支持非公平锁，但是reentrantLock同时支持公平锁和非公平锁，会阻塞其他线程。



 

