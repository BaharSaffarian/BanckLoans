<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa-IR">
<head>
    <meta charset="UTF-8">
    <title>مدیریت اطلاعات مشتریان</title>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
    <script src="Script.js" type="text/javascript"></script>
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
                    <li class="current_page_item"><a href="LegalCustomerRegistration.jsp">ثبت مشتری حقوقی</a></li>
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
                    <h2>ثبت مشتری حقوقی</h2>

                    <form id="LegalCustomerRegistrationForm" method="get" action="LegalCustomerRegistrationServlet"
                          onsubmit="return validateLegalCustomerRegistrationForm();">
                        <div class="inputRow">
                            <div class="label">نام شرکت:</div>
                            <div class="input">
                                <input id="CompanyName" class="input" type="text" name="CompanyName" size="20">
                            </div>
                            <label id="CompanyNameRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow">
                            <div class="label">تاریخ ثبت:</div>
                            <div class="input">
                                <input id="RegisterDate" class="input" type="text" name="RegisterDate" size="20">
                            </div>
                            <label id="RegisterDateRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="LastInputRow">
                            <div class="label">کد اقتصادی:</div>
                            <div class="input">
                                <input id="EconomicCode" class="input" type="text" name="EconomicCode" size="20">
                            </div>
                            <%
                                if (request.getAttribute("CustomerId") != null &&
                                        Integer.parseInt(request.getAttribute("CustomerId").toString()) == -1) {
                            %>
                            <label class="error">*کد اقتصادی تکراری است</label>
                            <%}%>
                            <label id="EconomicCodeRequired" class="error" style="display: none">*</label>
                        </div>
                        <div>
                            <div class="buttonDiv">
                                <input class="button" type="submit" value="ثبت">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
