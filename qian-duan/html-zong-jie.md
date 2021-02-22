# HTML总结

| 各类标签 | 标签基本用法 |
| :--- | :--- |
| 图像标签 | &lt;img src=" ../" alt = " "&gt;    src里可以装相对路径../resources |
| 链接标签 | &lt;a href="path"&gt;链接文本或图像&lt;/a&gt;     target="\_blank"表示在新标签中打开此页面 |

```text
<!--有序列表 -->
<ol>
    <li> </li>
    <li> </li>
</ol>

<hr/>

<!--无序列表 -->
<ul>
    <li>  </li>
</ul>
<!--自定义列表-->
<dl>
    <dt> </dt>
    <dd> </dd>
    <dd> </dd>
</dl>


表格标签
行<tr>
列<td>
<table border = "1px">
    <tr>
        <td>1-1</td>
    </tr>
</table>


视频元素 vedio
src:资源路径
controls: 控制条
autoplay: 自动播放
<vedio src="" controls></vedio>

音频元素 audio
<audio src=" " controls autoplay></audio>


页面结构分析（都放在body下面）
header：标题头部区域
footer：标记脚部区域的内容
section：Web页面中的一块独立区域
article：独立的文章内容
aside：相关内容或应用
nav：导航类辅助内容

iframe内联框架：网站里面放别的网站
src:引用页面地址
name:框架标识名
<iframe src="" name =""></iframe>

表单语法
必须有method是post，get
get方式提交，可以在url看到提交内容，不安全，但是效率高
post方式提交，比较安全，传输大文件，在network里的header可以看到post form
action是表示向何处发送表单数据
<form method= "post" action ="result.html">
    <p>name:<input type="text" name="username"> </p>
    <p>password:<input type="password" name="pwd"> </p>
</form>



```

