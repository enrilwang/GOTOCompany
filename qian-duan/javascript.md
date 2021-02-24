# javascript

IDE要设置支持ES6语法，ES6之后局部变量用let i = 1；写js代码第一行加上 ‘use strict‘ 严格检查模式，预防js的随意性产生问题

```text
json对象:轻量级数据交换格式
var user{
    name:"wang",
    age:22
}
var jsonuser = JSON.stringify(user)就可以把user对象转换为json格式
JSON.parse('{"name":"wang","age":22}')就可以把json转换为对象



```

## 面向对象编程

```text
var Student ={
    name:"wang",
    age:3,
    run:function(){
        console.log(this.name + "run...");
    }
};


var wang={
    name="wang"
};

wang.__proto__ = user;

可以让wang对象用到Student的所有东西，相当于wang的原型是Student




class继承
ES6之后可以用class
class Student{
    constructor(name){
        this.name = name;
    }
    
    hello(){
        alert("hello");
    }
    可以加不同的方法
}

class xiaoxueheng extends Student{
    constructor(name,grade){
        super(name);
        this.grade = grade;
    }
}

和java一样的
```

## 操作BOM对象

BOM：浏览器对象模型

```text
window：代表浏览器窗口
window.innerHeight
window.outerWidth

screen:屏幕对象
screen.width
screen.height

location:实现一些重定向，代表当前页面的URL信息
host
href
protocal
reload()：刷新
设置新地址
location.assign('http:www...')

docuemnt代表当前页面
document.cookie:可以获得登录信息

```

## 操作DOM

```text
DOM：文档对象模型
浏览器网页就是一个DOM树形结构
更新：更新DOM节点
遍历dom节点：得到Dom节点
删除：删除一个dom节点
添加：添加一个dom节点

<div id= "father">
  <h1>title1</h1>
  <p id = "p1">p1</p>
  <p class = "p2">p2</p>
</div>
<script>
  对应css选择器
  var h1 = documnet.getElementsByTagName('h1');
  var p1 = document.getElementById('p1');
  var p2 = document.getElementsByClassName('p2');
  var father = document.getElementById('father');
  var childrens = father.children;  获取父节点下的所有子节点
  
</script>

这是原生代码，之后我们尽量用jquery



更新DOM
id1.innerText = '456' 修改文本的值
id1.innerHTML = '<strong>123</strong>' 可以解析html标签
id1.style.color = "red";
id1.style.fontSize =  '200px';

删除节点
先获得父节点，再通过父节点删除自己
father.removeChild(p1) father是p1的父节点，要删除p1节点


插入节点：获得某个DOM节点，dom节点是空的，通过innerHTML可以增加一个元素，但是这个dom节点有东西，就会覆盖
要用追加操作
<p id='js'> js</p>
<div id='list'>
  <p id = 'se'> javase</p>
</div>

var js = document.getElementById('js');
var list = document.getElementById('list');
list.appendChild(js);
追加后效果
<div id='list'>
  <p id = 'se'> javase</p>
  <p id='js'> js</p>
</div>

var newp = document.createElement('p'); 创建p标签
newp.id = 'newp';
newp.innerText = 'hello';


```

## 操作表单

```text
文本框 text
下拉框 <select>
单选框 radio
多选框 checkbox
隐藏框 hidden
密码框 password
。。。。

表单的目的：提交信息
<form action ="post">
    <span>username:</span> <input type = "text" id = "username">
</form>

<script>
    var input = document.getElementById("username");
    input.value可以得到输入的内容
</script>
```

## 提交表单

```text
<form action ="post">
    <p>
        <span>username:</span> <input type = "text" id = "username" name = "username">
    </p> 
    
       
    <p>
        <span>gender:</span>
        <input type = "radio" name = "gender" value = "man" id = "boy"> man
        <input type = "radio" name = "gender" value = "woman" id = "girl"> woman
    </p>
    
     <input type = "submit">  
     <button type ="button" onclick = "aaa()"> submit</button>       
</form>

<script>
    funciton aaa(){
        var uname = document.getElementById("username");
    }
</script>

```

## jQuery\(里面存在大量的javascript函数\)

## 文档工具站：http://jquery.cuishifeng.cn/

```text
$(selector).action() 公示

<body>

<a href = "" id ="come"> click me </a>

<script>
    $(#come).click(function(){
        alert("hello");
        这样就绑定了一个函数
    })    

</script>


</body>
```

## jquery事件

```text
鼠标事件
$(selector).mousedown()
$(selector).mouse等等
键盘事件
$(selector).key等等

操作DOM



```

