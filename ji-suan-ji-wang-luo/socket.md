# Socket

## I/O模型

Unix有5种I/O模型

* 阻塞式IO
* 非阻塞式IO
* I/O复用（select 和poll）
* 信号驱动式（SIGIO）
* 异步I/O（AIO）

### 阻塞式I/O

应用进程被阻塞，知道数据从内核缓冲区复制到应用进程缓冲区中才返回

