<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>${title}</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        var isCheckAll = false;
        function swapCheck() {
            if (isCheckAll) {
                $("input[type='checkbox']").each(function () {
                    this.checked = false;
                });
                isCheckAll = false;
            } else {
                $("input[type='checkbox']").each(function () {
                    this.checked = true;
                });
                isCheckAll = true;
            }
        }

        function submitForm() {
            var chk_value = [];
            $('input[name="userId"]:checked').each(function () {
                chk_value.push($(this).val());
            });
            if (chk_value.length == 0) {
                alert('你还没有选择任何内容！');
            } else {
                console.log(chk_value);
                $("#inputForm").attr("action", "${pageContext.request.contextPath}/dpt/export/" + chk_value.toString());
            }
            $('#inputForm').submit();
        }
        
        function downloadZip() {
            window.location.href = "${pageContext.request.contextPath}/dpt/toZip";
        }
    </script>
</head>
<body>
<center>${title}<c:if test="${!empty msg}"><input type="button" onclick="javascript:history.go(-1);" value="后退"></c:if></center>
<h4>${msg}</h4>
<form action="${pageContext.request.contextPath}/dpt/import" method="POST" enctype="multipart/form-data">
    文件：<input type="file" name="file"/>
    <input type="submit" value="提交"/>
    <input type="button" value="点击下载Zip压缩包" onclick="downloadZip()"/>
    <a href="${pageContext.request.contextPath}/dpt/template">点击下载导入模板</a>
</form>
<form id="inputForm" action="${pageContext.request.contextPath}/dpt/export/" method="get">
    <input type="button" value="导出" onclick="return submitForm()"/><fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm:ss"/>
    <table border="1">
        <thead>
        <tr>
            <th><input id="selectAll" type="checkbox" onchange="swapCheck()"/></th>
            <th>ID</th>
            <th>备注</th>
            <th>创建者</th>
            <th>创建日期</th>
            <th>更新者</th>
            <th>更新日期</th>
            <th>删除标记</th>
            <th>年龄</th>
            <th>工龄</th>
            <th>等级</th>
            <th>归属公司</th>
            <th>归属部门</th>
            <th>登录名</th>
            <th>密码</th>
            <th>工号</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>手机</th>
            <th>用户类型</th>
            <th>最后登陆IP</th>
            <th>最后登陆日期</th>
            <th>是否允许登陆</th>
            <th>头像</th>
            <th>原登录名</th>
            <th>新密码</th>
            <th>上次登陆IP</th>
            <th>上次登陆日期</th>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td><input name="userId" type="checkbox" value="${status.index}"/></td>
                <td>${user.id}</td>
                <td>${user.remarks}</td>
                <td>${user.createByName}</td>
                <td>${user.createDate}</td>
                <td>${user.updateByName}</td>
                <td>${user.updateDate}</td>
                <td>${user.delFlag}</td>
                <td>${user.age}</td>
                <td>${user.seniority}</td>
                <td>${user.gradePoint}</td>
                <td>${user.company}</td>
                <td>${user.office}</td>
                <td>${user.loginName}</td>
                <td>${user.password}</td>
                <td>${user.no}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.mobile}</td>
                <td>${user.userType}</td>
                <td>${user.loginIp}</td>
                <td>${user.loginDate}</td>
                <td>${user.loginFlag}</td>
                <td>${user.photo}</td>
                <td>${user.oldLoginName}</td>
                <td>${user.newPassword}</td>
                <td>${user.oldLoginIp}</td>
                <td>${user.oldLoginDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
