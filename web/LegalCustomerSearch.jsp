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
                    <li><a href="LegalCustomerRegistration.jsp">ثبت مشتری حقوقی</a></li>
                    <li><a href="RealCustomerSearch.jsp">جستجوی مشتری حقیقی</a></li>
                    <li class="current_page_item"><a href="LegalCustomerSearch.jsp">جستجوی مشتری حقوقی</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="content" style="width: 1300px; height: 100%">
        <div class="post" style="height: 100%;">

            <div class="entry" style="height: 100%;">

                <div class="sidebar" style="width: 100%; height: 100%; padding: 30px 0px 0px; border-radius: 7px;">
                    <h2>جستجوی مشتری حقوقی</h2>

                    <form id="LegalCustomerSearchForm" method="get">
                        <div class="inputRow" style="float: right; margin-right: 10px;">
                            <div class="label">شماره مشتری:</div>
                            <div class="input"><input class="input" type="text" name="CustomerId" size="20"></div>
                        </div>
                        <div class="inputRow" style="float: right;">
                            <div class="label">نام شرکت:</div>
                            <div class="input"><input class="input" type="text" name="CompanyName" size="20"></div>
                        </div>
                        <div class="inputRow" style="float: right;">
                            <div class="label">کد اقتصادی:</div>
                            <div class="input"><input class="input" type="text" name="EconomicCode" size="20"></div>
                        </div>
                        <div>
                            <div class="buttonDiv">
                                <input class="button" type="submit"
                                       onclick="document.getElementById('LegalCustomerSearchForm').action = 'LegalCustomerSearchServlet';form.submit();"
                                       value="جستجو">
                            </div>
                        </div>
                    </form>

                    <jsp:include page="LegalCustomerSearchResults.jsp" flush="true"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>