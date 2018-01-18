<%--
  Created by IntelliJ IDEA.
  User: natay
  Date: 19.08.2017
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kayıt</title>


</head>
<body>
<div>
    <form name="kayıt" action="reg" method="get">
            İsim Giriniz :<input name="username" type="text"><br>
            Şifre Giriniz:<input name="password" type="password"><br>
            <input type="submit"><br>
    </form>

    <div id="pencerekodu"><label for="pencere" class="dugme">

        Pencereyi Aç

    </label><input type="checkbox" class="Pencereac" id="pencere" name="pencere"></input><label class="pencere">

        Pencere İçeriğini Bu Alana Yazabilirsiniz.


        <label for="pencere" class="dugme" name="kapat">Kapat</label></label></div>


    <style> .dugme{cursor:pointer;display:inline-block;padding:5px 10px;background:#eee;border:1px solid #d8d8d8;font-family:Helvetica, Arial, sans-serif;font-size:14px;color:#444; -webkit-border-radius: 3px; border-radius: 3px; } [name="kapat"]{position:absolute;bottom:20px;right:20px;} .pencere{ position:fixed;top:-50%;left:-50%; width:380px;height:280px;background:#fff;box-shadow:0 0 6px 2px rgba(0,0,0,0.4); opacity:0; transition:opacity 0.6s ease-out; z-index:-1; padding:10px; -webkit-border-radius: 3px; border-radius: 3px; margin:-150px 0 0 -200px; } .Pencereac{width:1px;height:1px;visibility:hidden;} .Pencereac:checked + .pencere{ top:50%;left:50%; display:block; z-index:9; opacity:1;}</style>
</div>
</body>
</html>