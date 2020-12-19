# 算法汇总

## 算法\#

// 计算从起点 start 到终点 target 的最近距离 int BFS\(Node start, Node target\) { Queue q; // 核心数据结构 Set visited; // 避免走回头路

这是BFS的框架

```text
q.offer(start); // 将起点加入队列
visited.add(start);
int step = 0; // 记录扩散的步数

while (q not empty) {
    int sz = q.size();
    /* 将当前队列中的所有节点向四周扩散 */
    for (int i = 0; i < sz; i++) {
        Node cur = q.poll();
        /* 划重点：这里判断是否到达终点 */
        if (cur is target)
            return step;
        /* 将 cur 的相邻节点加入队列 */
        for (Node x : cur.adj())
            if (x not in visited) {
                q.offer(x);
                visited.add(x);
            }
    }
    /* 划重点：更新步数在这里 */
    step++;
}
```

}

## 

