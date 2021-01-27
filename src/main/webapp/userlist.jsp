<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        function del(url) {
            if(confirm('确定要删除吗?')){
                var form = $('#del')[0];
                form.action = url;
                form.submit();
            }
        }
    </script>
    <title>userlist</title>
</head>
<body>
<form id="del" method="post">
    <input type="hidden" name="_method" value="delete">
</form>
<div class="container">
    <div class="row row-center">
        <div class="col-center">
            <div class="table-responsive">
                <table class="table">
                    <caption>userlist</caption>
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>age</th>
                        <th>option</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userlist}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td><a href="/upd1?id=${user.id}">update</a>||<a href="javascript:del('/del/${user.id}')">delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row row-center">
        <div class="col-center">
            <form role="form" action="/add" method="post">
                <div class="form-group">
                    <label>name</label>
                    <input type="text" class="form-control" placeholder="name" name="name">
                    <label>age</label>
                    <input type="text" class="form-control" placeholder="age" name="age">
                </div>
                <button type="submit">addUser</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
