# 后端面经

LRU缓存，http协议，如何实现java网络通信，http网络协议

LRU缓存：哈希表+双向链表     双向链表靠近头部是最近使用的，靠近尾部是最久未使用的。哈希表通过缓存数据把键映射到双向链中的位置。Hashmap装的是&lt;Integer, LinkedNode&gt;



快排：核心思想是分治，选定第一个为基数后，i第二个index，j最后一位，i从左往右，j从右往左，i遇到第一个比基数大的数字，j找到第一个比基数小的数字，两个交换，继续循环直到i&gt;=j，break。此时，划分了三部分，小与基数，基数，大于基数。[https://zhuanlan.zhihu.com/p/68088475](https://zhuanlan.zhihu.com/p/68088475)

String被设计成不可变的原因：字符串常量池，多个引用可以指向同一个区域，如果string可以改变，将会有很多逻辑错误，2。string对象可以进行缓存，String类里面有int hash属性。3。安全性，比如网络连接的URL，如果String不固定，将会引起安全隐患。



StringBuffer和StringBuilder是可变类，但是shtringbuffer是线程安全的，而StringBuilder不是线程安全的，但是在单线程当中，性能更好。

线程池7大参数，核心线程数（核心线程是不会被回收的），最大线程数（允许的最大线程数，当线程数量达到核心线程数，且工作队列塞满了之后，才会继续创建线程），KeepAliveTime（超过核心线程数之后的临时线程的存活时间），工作队列（当前线程数量超过core pool size时，新的任务会处在等待状态，是用先进先出的阻塞式队列实现，底层涉及AQS机制。当队列已满，新来的任务会直接被新建的线程去执行），threadFactory（创建线程的工厂类，可以知道线程由哪个工厂类创建的，快速定位）handler（线程池执行拒绝策略，当线程数量达到maxmumPoolSize，并且工作队列塞满任务的情况下，线程池会调用handler拒绝策略来处理请求，有抛出异常，直接抛弃不执行）

[https://h5.qkduo.cn/live?liveId=ll\_44eeb70ed&termId=t\_b259d3f30&zjn1](https://h5.qkduo.cn/live?liveId=ll_44eeb70ed&termId=t_b259d3f30&zjn1) 转自线程池详解





偏向锁是不做cas操作，当一个线程持有这把锁的时候，没有别的线程拿这把锁，它下一次进入共享资源可以直接用这个锁。当有别的线程来抢锁的时候，偏向锁会升级为轻量级锁（自旋锁），如果更多线程来的话，才会升级为重量级锁。



java内存模型规定：所有变量都是存在主存当中，每个线程都有自己的工作内存（类似于前面的高速缓存），线程对变量的所有操作都必须在工作内存中进行，而不能直接对主存进行操作。并且每个线程不能访问其他线程的工作内存。当一个变量被volitile修饰，他会保证修改的值会立即被更新到主存（其他线程的工作内存中的这个缓存变量变成无效），当有其他线程需要读取时，它会去内存中读取新值。当然也可以通过synchronized和lock来保证可见性，synchronized和lock能保证同一时刻只有一个线程获取锁然后执行同步代码，并且在释放锁之前会将对变量的修改刷新到主存当中。因此可以保证可见行。volitile也可以保证有序性，当一个变量被volitile修饰，其前面的指令全部都会被运行完才会运行到volitile。volitile 禁止进行指令重排序，加入volatile会多一个一个lock前缀指令，实际上相当于一个内存屏障，提供三个功能：1确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，意思就是执行到内存屏障这句指令时，它前面的操作已经全部完成 2）会强制将缓存的修改操作立即写入主存 3）如果是写操作，他会导致其他cpu中对应的缓存行无效。



java四种引用类型：

1. 强引用：把对象赋给引用变量，当一个对象被强引用变量引用时，它处于可达状态，**不可能被垃圾回收的**，这是造成内存泄漏的主要原因之一（只有通过人为的把对象设置成null才能被回收）
2. 软引用：用softReference类来实现，当系统空间内存不够时才会被回收。（垃圾收集器可能会执行，但会作为最后的选择，回收完了软引用对象后发现空间还是不足才会报OOM。这种技术常常被用于实现缓存技术，图片缓存，网络缓存）
3. 弱引用：用WeakReference来实现，生存期更短，只要垃圾回收机制一运行，不管内存空间是够足够，都会被回收
4. 虚引用：用PhantomReference类来实现，不能单独使用，必须和队列联合使用，主要作用是跟踪对象被垃圾回收的状态

```text
java集合类有set，list，map接口，collection是list，set，queue最基本的接口
list里面有：ArrayList（线程不安全），Vector（线程安全，使用数组，效率低），LinkedList（线程不安全，使用双向循环链表）
set里面有：HashSet（hash表实现，内部是hashmap），treeset（二叉树实现），LinkedHashSet（hash表储存，双向链表记录插入顺序）
queue里面有：两端出入的list，可以链表也可以数组
```



Hashmap：通过键的hashCode值存储数据，如果想要线程安全可以使用ConcurrentHashMap，里面是数组，数组的每个元素是一个单向链表，数组容量始终保持2^n，当链表长度超过8个以后会将链表转换为红黑树（是因为需要顺着链表去查找，时间复杂度是On，为了降低开销，用红黑树，时间复杂度会降为OlogN），hashmap数组默认初始长度是16，当数组中数据个数超过0.75，就会自动扩容。源码的设计非常睿智，源码的hash算法是根据key计算哈希值，使结果尽量的离散，这样才能分布更均匀，扩容的putval方法里，数组的长度与哈希值的与运算（保留低位的值，去掉了高位的值）得到index，所以当hash值小于16时，扩容前和扩容后位置不变。当hash值大于16的时候，会有新的位置。这就保证了旧table已经散列好的良好的数据位置重新调换的频率。使数组改动最小。进行2倍扩容的原因是因为，更散列，元素更加均匀分布，减少hash碰。

concurrent hashmap 解决了HashMap 的线程不安全和 HashTable 的并发效率低，HashTable 之所以效率低是因为所有线程都必须竞争同一把锁，假如容器里有多把锁，每一把锁用于锁容器的部分数据，那么多线程访问容器不同数据段的数据时，线程间就不会存在锁竞争，从而有效提高并发效率，这就是 ConcurrentHashMap 的**锁分段技术，**首先将数据分成 Segment 数据段，然后给每一个数据段配一把锁，当一个线程占用锁访问其中一个段的数据时，其他段的数据也能被其他线程访问  
get 实现简单高效，先经过一次再散列，再用这个散列值通过散列运算定位到 Segment，最后通过散列[算法](/jump/super-jump/word?word=%E7%AE%97%E6%B3%95)定位到元素。get 的高效在于不需要加锁，除非读到空值才会加锁重读。get 方法中将共享变量定义为 volatile，在 get 操作里只需要读所以不用加锁。

put 必须加锁，首先定位到 Segment，然后进行插入操作，第一步判断是否需要对 Segment 里的 HashEntry 数组进行扩容，第二步定位添加元素的位置，然后将其放入数组。

size 操作用于统计元素的数量，必须统计每个 Segment 的大小然后求和，在统计结果累加的过程中，之前累加过的 count 变化几率很小，因此先尝试两次通过不加锁的方式统计结果，如果统计过程中容器大小发生了变化，再加锁统计所有 Segment 大小。判断容器是否发生变化根据 modCount 确定。

作者：大明宫巴菲特  
链接：[https://www.nowcoder.com/discuss/447742?type=all&order=time&pos=&page=4&channel=-1&source\_id=search\_all\_nctrack](https://www.nowcoder.com/discuss/447742?type=all&order=time&pos=&page=4&channel=-1&source_id=search_all_nctrack)  
来源：牛客网  
  


**JDK8 的 ConcurrentHashMap 原理？**

主要对 JDK7 做了三点改造：① 取消分段锁机制，进一步降低冲突概率。② 引入[红黑树](/jump/super-jump/word?word=%E7%BA%A2%E9%BB%91%E6%A0%91)结构，同一个哈希槽上的元素个数超过一定阈值后，单向[链表](/jump/super-jump/word?word=%E9%93%BE%E8%A1%A8)改为[红黑树](/jump/super-jump/word?word=%E7%BA%A2%E9%BB%91%E6%A0%91)结构。③ 使用了更加优化的方式统计集合内的元素数量。具体优化表现在：在 put、resize 和 size 方法中设计元素总数的更新和计算都避免了锁，使用 CAS 代替。

get 同样不需要同步，put 操作时如果没有出现哈希冲突，就使用 CAS 添加元素，否则使用 synchronized 加锁添加元素。

当某个槽内的元素个数达到 7 且 table 容量不小于 64 时，[链表](/jump/super-jump/word?word=%E9%93%BE%E8%A1%A8)转为[红黑树](/jump/super-jump/word?word=%E7%BA%A2%E9%BB%91%E6%A0%91)。当某个槽内的元素减少到 6 时，由[红黑树](/jump/super-jump/word?word=%E7%BA%A2%E9%BB%91%E6%A0%91)重新转为[链表](/jump/super-jump/word?word=%E9%93%BE%E8%A1%A8)。在转化过程中，使用同步块锁住当前槽的首元素，防止其他线程对当前槽进行增删改操作，转化完成后利用 CAS 替换原有[链表](/jump/super-jump/word?word=%E9%93%BE%E8%A1%A8)。由于 TreeNode 节点也存储了 next 引用，因此[红黑树](/jump/super-jump/word?word=%E7%BA%A2%E9%BB%91%E6%A0%91)转为[链表](/jump/super-jump/word?word=%E9%93%BE%E8%A1%A8)很简单，只需从 first 元素开始遍历所有节点，并把节点从 TreeNode 转为 Node 类型即可，当构造好新[链表](/jump/super-jump/word?word=%E9%93%BE%E8%A1%A8)后同样用 CAS 替换[红黑树](/jump/super-jump/word?word=%E7%BA%A2%E9%BB%91%E6%A0%91)。



单例模式：

```text

public final class Singleton {
    private static Singleton instance=new Singleton();// 自行创建实例
    private Singleton(){}// 构造函数
    public static Singleton getInstance(){// 通过该函数向整个系统提供实例
        return instance;
    }
}

饿汉模式在类加载的时候就对实例进行创建，实例在整个程序周期都存在。

它的好处是只在类加载的时候创建一次实例，避免了多线程同步的问题。
它的缺点，即使这个单例没有用到也会被创建，而且在类加载之后就被创建，内存就被浪费了。
这种实现方式适合单例占用内存比较小，在初始化时就会被用到的情况。但是，如果单例占用的内存比较大，或单例只是在某个特定场景下才会用到，使用饿汉模式就不合适了，这时候就需要用到懒汉模式进行延迟加载。



public final class Singleton {
    private static Singleton instance= null;// 不实例化
    private Singleton(){}// 构造函数
    public static Singleton getInstance(){// 通过该函数向整个系统提供实例
        if(null == instance){// 当 instance 为 null 时，则实例化对象，否则直接返回对象
            instance = new Singleton();// 实例化对象
        }
        return instance;// 返回已存在的对象
    }
}
好处：懒汉模式中单例是在需要的时候才去创建的，如果单例已经创建，而是直接返回之前创建的对象。
适用于：如果某个单例使用的次数少，并且创建单例消耗的资源较多，那么就需要实现单例的按需创建，这个时候使用懒汉模式就是一个不错的选择。
缺点：懒汉模式并没有考虑线程安全问题，在多个线程可能会并发调用它的getInstance()方法，导致创建多个实例，因此需要加锁解决线程同步问题，实现如下:

加锁还是会创建多个实例



以下是双重校验。
// 懒汉模式 + synchronized 同步锁 + double-check
public final class Singleton {
    private static Singleton instance= null;// 不实例化
    private Singleton(){}// 构造函数
    public static Singleton getInstance(){// 加同步锁，通过该函数向整个系统提供实例
        if(null == instance){// 第一次判断，当 instance 为 null 时，则实例化对象，否则直接返回对象
          synchronized (Singleton.class){// 同步锁
             if(null == instance){// 第二次判断
                instance = new Singleton();// 实例化对象
             }
          } 
        }
        return instance;// 返回已存在的对象
    }

}
```

怎么产生僵尸进程：一个进程调用exit 命令结束自己的时候，其实他并没有真正的被销毁，只是进程不能被调度并处于exit\_zombie状态。它占用的所有内存就是内核栈。此时进程存在的唯一目的就是向它的父进程提供信息，如果他的父进程没有调用wait或者waitpid等待子进程结束又没有显示地忽略该信号，那么它就会一直保持exit\_zombie状态。 __如何清理僵尸进程呢？：把父进程杀掉，此时僵尸进程成为“孤儿进程“，过继给init进程，init进程始终负责清理孤儿进程，它产生的所有僵尸进程也跟着消失。





Select: 时间复杂度On，具有On的无差别轮询复杂度，处理的流越多，无差别轮询时间就越长。

poll：本质上和select没有区别，将用户传入的数组拷贝到内核空间，然后查询么哥fd对应的设备状态。但是它没有最大连接数的限制，因为是基于链表来存储的

epoll：时间复杂度O1，不同于忙轮询和无差别轮询，epoll会把哪个流发生了怎样的I/O事件通知我们，所以我们说epoll实际上是事件驱动











