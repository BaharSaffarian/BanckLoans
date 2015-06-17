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

                <div class="sidebar" style="width: 100%; height: 100%; padding: 30px 0px 0px; border-radius: 7px;">
                    <h2>تعریف شروط اعطا</h2>
                        <div class="inputRow" style="float: right; margin-right: 10px; width: 250px;">
                            <div class="label" style="width: 60px;">نام:</div>
                            <div class="input"><input class="input" type="text" id="ConditionName"
                                                      size="20"></div>
                            <label id="ConditionNameRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow" style="float: right; width: 250px;">
                            <div class="label">حداقل مدت:</div>
                            <div class="input"><input class="input" type="text" id="MinDuration"
                                                      size="20"></div>
                            <label id="MinDurationRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow" style="float: right; width: 250px;">
                            <div class="label">حداکثر مدت:</div>
                            <div class="input"><input class="input" type="text" id="MaxDuration"
                                                      size="20"></div>
                            <label id="MaxDurationRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow" style="float: right; width: 250px;">
                            <div class="label">حداقل مبلغ:</div>
                            <div class="input"><input class="input" type="text" id="MinAmount"
                                                      size="20"></div>
                            <label id="MinAmountRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow" style="float: right; width: 250px;">
                            <div class="label">حداکثر مبلغ:</div>
                            <div class="input"><input class="input" type="text" id="MaxAmount"
                                                      size="20"></div>
                            <label id="MaxAmountRequired" class="error" style="display: none">*</label>
                        </div>
                        <div>

                            <div class="buttonDiv">
                                <input class="button" type="submit" onclick="if(GrantConditionDefinitionValidation()){createTableOfGrantConditions();}" value="افزودن">
                            </div>
                        </div>

                    <input id="counter" value="1" style="display: none">
                    <form id="grantConditionsForm" action="/LoanTypeRegistrationServlet">

                        <input name="LoanTypeName" value="<%=request.getParameter("TypeName")%>" style="display: none">
                        <input name="InterestRate" value="<%=request.getParameter("InterestRate")%>" style="display: none">

                        <div id="resultTable" class="table" style="width: 565; display: none; margin-bottom: 10px;">
                            <div class="htr" style="width: 555;">
                                <div class="idtd">ردیف</div>

                                <div class="htd" style="width: 95px">نام</div>
                                <div class="htd" style="width: 95px">حداقل مدت</div>
                                <div class="htd"
                                     style="width: 95px; margin-left: 5px; color: #B50D0D; float: right; padding: 10px 0 0;font-size: small;">
                                    حداکثر مدت
                                </div>
                                <div class="htd" style="width: 95px">حداقل مبلغ</div>
                                <div class="htd" style="width: 95px">حداکثر مبلغ</div>
                            </div>
                        </div>
                        <div class="buttonDiv">
                            <input id="registerButton" class="button" type="submit" style="display: none" value="ثبت">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
