<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String message=session.getAttribute("message").toString();%>

<html lang="fa-IR">
<head>
    <meta charset="UTF-8">
    <title>مدیریت اطلاعات مشتریان</title>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body dir="rtl">
<div id="wrapper">
    <div id="header-wrapper">
        <div id="header" class="container">
            <div id="logo">
                <h1><a href="#">سامانه مدیریت اطلاعات مشتریان</a></h1>
            </div>
            <div id="menu" dir="rtl">
                <ul>
                    <li><a href="index.jsp">خانه</a></li>
                    <li><a href="RealCustomerRegistration.jsp">ثبت مشتری حقیقی</a></li>
                    <li><a href="LegalCustomerRegistration.jsp">ثبت مشتری حقوقی</a></li>
                    <li><a href="RealCustomerSearch.jsp">جستجوی مشتری حقیقی</a></li>
                    <li><a href="LegalCustomerSearch.jsp">جستجوی مشتری حقوقی</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="content">
        <div class="post">

            <div class="entry">

                <div class="sidebar">
                    <div style="margin: 0 auto">
                        <p class="textCenter"><%=message%>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

