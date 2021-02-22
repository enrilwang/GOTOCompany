# CSS选择器

```text
<body>
    <p>p1</p>
    <p>p2</p>
    <p>p3</p>
    <ul>
        <li>li1</li>
        <li>li2</li>
        <li>li3</li>
    </ul>
</body>
```

## css的选择器：选择页面的某一类或某一元素

```text

css的选择器：选择页面的某一类或某一元素
1 标签选择器:会选择所有h1的标签
    h1{
        color: red;    
    }

2 类选择器 class：把多个标签归为一类
    .classname{
        color:red;
    }

3 id选择器：选中单个标签
    #idname{
        color:red;
    }
优先级id>class>标签
```

## 层次选择器

```text
1 后代选择器：在某个元素的后面
     #body后面的所有p标签都变成了红色
     body p{ 
         background:red
     }
 
 2 子选择器：一代
     #body下面的一代p标签变红色而不是全部
     body>p{
         background:red;
     }
 
 3 相邻兄弟选择器:同辈
     要用class选择器or id选择器
     只有它旁边的下面的那个
     一个p class标签的下面变色
     .classname + p{
         background:red
     }
     
 
 4 通用选择器：
     p class周围全部变色（对下不对上）
     .classname~p{
         background:red！
```

## 结构伪类选择器

```text
选ul的第一个子元素
ul li:first-child{
    background:red;
}

选中第一个p元素
选中p：定位到父元素，选择当前的第一个元素,必须得第一个元素是p元素
p:nth-child(1){
    background:red;
}

选中p：定位到父元素，选择当前的第一个为p元素的元素变色
p:nth-of-type(1){
    background:red;
}
```

## 属性选择器（最常用）

```text
<p class="demo">
    <a herf = "http:www.baidu.com" class="links item">1</a>
    <a herf = "" class="links active">2</a>
    <a herf = "" class="links item" id ="first">3</a>
    <a herf = "" class="links item last">4</a>
</p>



=：绝对等于
^=:以什么什么开头
$=:以什么什么结尾
*=:包含

a[id]{
    代表选中a标签所有有id标签的
}


a[id = first]{
    代表选中a标签里id=first的那一个3
}

a[class*="links"]{
    代表选中了a标签里class含有links的标签1,2,3,4
}

a[class="links item"]{
    选中唯一标签3
}


a[href^=http]{
    找到a标签下以http开头的就是1
}



```

