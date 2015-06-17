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
    <div id="content" style="width: 1300px; height: 100%">
        <div class="post" style="height: 100%;">

            <div class="entry" style="height: 100%;">

                <div class="sidebar"
                     style="width: 100%; height: 100%; padding: 30px 0px 0px; border-radius: 7px; margin: 0 auto;">
                    <h2>تشکیل پرونده تسهیلاتی</h2>
                    <script>
                        function loanFileCustomerIdSearchFormValidation(){
                            var status = true;
                            if (document.getElementById("CustomerId").value.length == 0) {
                                document.getElementById("CustomerIdRequired").style.display = "";
                                status = false;
                            }
                            return status;
                        }
                    </script>

                    <form id="customerSearchByIdForm" method="get" action="LoanFileSearchCustomerByIdServlet" onsubmit="return loanFileCustomerIdSearchFormValidation();">
                        <div style="margin: 10 auto 10px; width: 650px;">
                            <div class="inputRow" style="float: right; margin-right: 10px;">
                                <div class="label">شماره مشتری:</div>
                                <div class="input">
                                    <input class="input" type="text" name="CustomerId" id="CustomerId" size="20">
                                    <label id="CustomerIdRequired" class="error" style="display: none; float: right;">*</label>
                                </div>
                            </div>

                            <div class="inputRow" style="float: right">
                                <input class="button" style="margin: 10px 0px 5px;" type="submit"
                                       value="بازیابی">
                            </div>

                        </div>
                    </form>

                    <jsp:include page="loanFileCustomerSeachByIdResult.jsp" flush="true"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>