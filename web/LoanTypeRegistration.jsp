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
                    <li><a href="LegalCustomerSearch.jsp">جستجوی مشتری حقوقی</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="content">
        <div class="post">

            <div class="entry">

                <div class="sidebar">
                    <h2>ثبت نوع تسهیلات</h2>

                    <form id="LoanTypeRegistration" method="get" action="GrantConditionsDefinition.jsp"
                          onsubmit="return loanTypeRegistrationValidate();">
                        <div class="inputRow">
                            <div class="label">نام نوع:</div>
                            <div class="input">
                                <input id="TypeName" class="input" type="text" name="TypeName" size="20">
                            </div>
                            <label id="TypeNameRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow">
                            <div class="label">نرخ سود:</div>
                            <div class="input">
                                <input id="InterestRate" class="input" type="text" name="InterestRate" size="20">
                            </div>
                            <label id="InterestRateRequired" class="error" style="display: none">*</label>
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