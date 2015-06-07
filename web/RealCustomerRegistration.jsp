<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa-IR">
<head>
    <meta charset="UTF-8">
    <title>مدیریت اطلاعات مشتریان</title>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body dir="rtl">
<div id="wrapper">
    <div id="header-wrapper">
        <div id="header" class="container" >
            <div id="logo">
                <h1><a href="#">سامانه مدیریت اطلاعات مشتریان</a></h1>
            </div>
            <div id="menu" dir="rtl">
                <ul>
                    <li><a href="index.html">خانه</a></li>
                    <li class="current_page_item"><a href="RealCustomerRegistration.jsp">ثبت مشتری حقیقی</a></li>
                    <li><a href="LegalCustomerRegistration.html">ثبت مشتری حقوقی</a></li>
                    <li><a href="RealCustomerSearch.html">جستجوی مشتری حقیقی</a></li>
                    <li><a href="LegalCustomerSearch.html">جستجوی مشتری حقوقی</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="content">
        <div class="post">

            <div class="entry">

                <div class="sidebar">

                    <h2>ثبت مشتری حقیقی</h2>
                    <script >
                        function validateRealCustomerRegistrationForm() {
                            var status=true;
                            if(document.getElementById("FirstName").value.length==0){
                                document.getElementById("NameRequired").style.display="inline";
                                status=false;
                            }
                            if(document.getElementById("LastName").value.length==0){
                                document.getElementById("LastNameRequired").style.display="inline";
                                status=false;
                            }
                            if(document.getElementById("FatherName").value.length==0){
                                document.getElementById("FatherNameRequired").style.display="inline";
                                status=false;
                            }
                            if(document.getElementById("DateOfBirth").value.length==0){
                                document.getElementById("DateOfBirthRequired").style.display="inline";
                                status=false;
                            }
                            if(document.getElementById("NationalCode").value.length==0){
                                document.getElementById("NationalCodeRequired").style.display="inline";
                                status=false;
                            }else if(isNaN(document.getElementById("NationalCode").value)){
                                document.getElementById("NationalCodeNotValid").style.display="inline";
                                status=false;
                            }else{
                                var nationalCode=document.getElementById("NationalCode").value;
                                var sum=0;
                                for(var i=0;i<(nationalCode.length-1);i++){
                                    sum+=nationalCode[i]*(10-i);
                                }
                                if(!((sum%11)==nationalCode[9] || (sum%11)==(11-nationalCode[9]))) {
                                    document.getElementById("NationalCodeNotValid").style.display = "inline";
                                    status = false;
                                }
                            }

                            return status;
                        }
                    </script>
                    <form id="realCustomerRegistrationForm" method="get"action="RealCustomerRegistrarServlet" onsubmit="return validateRealCustomerRegistrationForm();">
                        <div class="inputRow" >
                            <div class="label" >نام:</div>
                            <div class="input">
                                <input class="input" id="FirstName" type="text" name="FirstName" size="20">
                            </div>
                            <label id="NameRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow" >
                            <div class="label" >نام خانوادگی:</div>
                            <div class="input">
                                <input class="input" type="text" name="LastName" id="LastName" size="20">
                            </div>
                            <label id="LastNameRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow" >
                            <div class="label">نام پدر:</div>
                            <div class="input">
                                <input class="input" type="text" name="FatherName" id="FatherName" size="20">
                            </div>
                            <label id="FatherNameRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="inputRow" >
                            <div class="label">تاریخ تولد:</div>
                            <div class="input">
                                <input class="input" type="text" name="DateOfBirth" id="DateOfBirth" size="20">
                            </div>
                            <label id="DateOfBirthRequired" class="error" style="display: none">*</label>
                        </div>
                        <div class="LastInputRow" >
                            <div class="label">کد ملی:</div>
                            <div class="input">
                                <input class="input" id="NationalCode" type="text" name="NationalCode" size="20">
                            </div>
                            <%if(request.getAttribute("CustomerId")!=null &&
                                 Integer.parseInt(request.getAttribute("CustomerId").toString())==-1){%>
                            <label class="error">*کد ملی تکراری است</label>
                            <%}%>
                            <label id="NationalCodeNotValid" class="error"style="display: none">کد ملی نامعتبر است</label>
                            <label id="NationalCodeRequired" class="error" style="display: none">*</label>
                        </div>
                        <div>
                            <div class="buttonDiv">
                                <input class="button" type="submit" value="ثبت" >
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

