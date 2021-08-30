# 全排列

## 题干

给定一个不包含重复数字的数组，例子：[1，2，3]. 输出该数组的所有排列组合方式。


## 解题思路

这道题是典型的要用到回溯算法的问题。回溯算法的本质其实就是在深度优先遍历一整棵决策树的时候，从当前节点往下遍历到下一个节点时做出选择，从下一个节点回到当前节点时再撤销原来操作的算法。

## 框架

```
public void dfs()
{
    if 满足终止条件：
        加入终止的逻辑
    
    for 选择 in 选择列表：
        做出当前选择
        dfs（）//递归调用，进入下一层决策树
        撤销当前选择
}

```

## 题解
```C#
using Systems.Collections.Generic;

public class Solution
{
    List<List<int>> rslt = new List<IList<int>>();
    List<int> permutation = new List<int>();
    bool[] used;

    public List<List<int>> AllPermutations(int[] nums)
    {
        used = new bool[nums.Length];
        dfs(0, nums);
        return rslt;
    }

    public void dfs(int index, int[] nums)
    {
        if(index == nums.Length)
        {
            rslt.Add(new List<int>(permutation));
            return;
        }

        for(int i = 0; i < nums.Length; i++)
        {
            if(!used[i])
            {
                permutation.Add(nums[i]);
                used[i] = true;
                dfs(index + 1, nums);
                used[i] = false;
                permutation.RemoveLast();
            }
        }
    }
}
```