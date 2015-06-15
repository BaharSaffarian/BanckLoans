<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <li class="current_page_item"><a href="index.jsp">خانه</a></li>
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
            <h3 class="title"><a href="#">به سامانه ی مدیریت اطلاعات مشتریان خوش آمدید </a></h3>

            <div class="entry">
                <p>لطفا عملیات مورد نظر را مشخص نمایید: </p>

                <div class="links">
                    <div class="icon">
                        <img src="images/Add_Person-128.png">
                        <br>

                        <div class="link">
                            <a href="RealCustomerRegistration.jsp">تعریف مشتری حقیقی</a>
                        </div>
                        <br>
                        <a href="LegalCustomerRegistration.jsp">تعریف مشتری حقوقی</a>
                    </div>
                    <div class="lastIcon">
                        <img src="images/Search_Group-128.png">
                        <br>

                        <div class="link">
                            <a href="RealCustomerSearch.jsp">جستجوی مشتری حقیقی</a>
                        </div>
                        <br>
                        <a href="LegalCustomerSearch.jsp">جستجوی مشتری حقوقی</a>
                    </div>
                    <div class="icon">
                        <img src="images/give-money-128.png">
                        <br>

                        <div class="link">
                            <a href="LoanTypeRegistration.jsp">تعریف نوع تسهیلات</a>
                        </div>
                        <div class="link">
                            <a href="loanFileRegistration.jsp">تشکیل پرونده تسهیلاتی</a>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

