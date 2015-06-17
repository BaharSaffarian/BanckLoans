<%@ page session="true" contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*, model.RealCustomer" %>
<%
    List<RealCustomer> realCustomers = (List<RealCustomer>) request.getAttribute("realCustomers");
    if (realCustomers != null && (!realCustomers.isEmpty())) {
%>
<script type="text/javascript">
    function validateRealCustomer(count) {
        var status = true;

        if (document.getElementById("firstName" + count).value.length == 0) {
            document.getElementById("firstNameRequired" + count).style.display = "inline";
            status = false;
        }
        if (document.getElementById("lastName" + count).value.length == 0) {
            document.getElementById("lastNameRequired" + count).style.display = "inline";
            status = false;
        }
        if (document.getElementById("fatherName" + count).value.length == 0) {
            document.getElementById("fatherNameRequired" + count).style.display = "inline";
            status = false;
        }
        if (document.getElementById("birthDate" + count).value.length == 0) {
            document.getElementById("birthDateRequired" + count).style.display = "inline";
            status = false;
        }
        if (document.getElementById("nationalCode" + count).value.length == 0) {
            document.getElementById("nationalCodeRequired" + count).style.display = "inline";
            status = false;
        } else if (isNaN(document.getElementById("nationalCode" + count).value)) {
            document.getElementById("nationalCodeNotValid" + count).style.display = "inline";
            status = false;
        } else {
            var nationalCode = document.getElementById("nationalCode" + count).value;
            var sum = 0;
            for (var i = 0; i < (nationalCode.length - 1); i++) {
                sum += nationalCode[i] * (10 - i);
            }
            if (!((sum % 11) == nationalCode[9] || (sum % 11) == (11 - nationalCode[9]))) {
                document.getElementById("nationalCodeNotValid" + count).style.display = "inline";
                status = false;
            }
        }

        return status;
    }
</script>
<div class="table">
    <div class="htr">
        <div class="idtd">ردیف</div>

        <div class="htd" style="width: 95px"><p>شناسه</p></div>
        <div class="htd" style="width: 95px"><p>نام</p></div>
        <div class="htd"
             style="width: 95px; margin-left: 5px; color: #B50D0D; float: right; padding: 10px 0 0;font-size: small;">
            نام خانوادگی
        </div>
        <div class="htd" style="width: 95px">نام پدر</div>
        <div class="htd" style="width: 95px">تاریخ تولد</div>
        <div class="htd" style="width: 95px">کد ملی</div>
        <div class="htd" style="width: 95px"></div>
    </div>

    <%
        int counter = 0;
        Iterator<RealCustomer> iterator = realCustomers.iterator();
        RealCustomer realCustomer = null;
        while (iterator.hasNext()) {
            realCustomer = iterator.next();
            counter++;
    %>
    <div class="tr">
        <form method="get" id="<%="myform" + counter%>" action="#"
              onsubmit="return validateRealCustomer(<%=counter%>);">
            <input style="display:none" type="text" name="oldNationalCode" size="8"
                   value="<%=realCustomer.getNationalCode()%>">

            <div class="idtd"><p style="padding: 0; text-align: center"><%=counter%>
            </p></div>
            <div class="td" style="width: 95px">
                <p id="<%="idLabel" + counter%>" style="padding: 0; text-align: center"><%=realCustomer.getId()%>
                </p>
                <input style="display:none" type="text" id="<%="id"+counter%>" name="id" size="8"
                       value="<%=realCustomer.getId()%>">
            </div>
            <div class="td" style="width: 95px">
                <p id="<%="firstNameLabel" + counter %>"
                   style="padding: 0; text-align: center"><%=realCustomer.getFirstName()%>
                </p>
                <input style="display:none" type="text" id="<%="firstName" + counter%>" name="firstName" size="8"
                       value="<%=realCustomer.getFirstName()%>">
                <label id="<%="firstNameRequired" + counter%>" class="error" style="display: none">*</label>
            </div>
            <div class="td" style="width: 95px">
                <p id="<%="lastNameLabel" + counter%>"
                   style="padding: 0; text-align: center"><%=realCustomer.getLastName()%>
                </p>
                <input style="display:none" type="text" id="<%="lastName" + counter%>" name="lastName" size="8"
                       value="<%=realCustomer.getLastName()%>">
                <label id="<%="lastNameRequired" + counter%>" class="error" style="display: none">*</label>
            </div>
            <div class="td" style="width: 95px">
                <p id="<%="fatherNameLabel" + counter%>"
                   style="padding: 0; text-align: center"><%=realCustomer.getFatherName() %>
                </p>
                <input style="display:none" type="text" id="<%="fatherName" + counter%>" name="fatherName" size="8"
                       value="<%=realCustomer.getFatherName()%>">
                <label id="<%="fatherNameRequired" + counter%>" class="error" style="display: none">*</label>
            </div>
            <div class="td" style="width: 95px">
                <p id="<%="birthDateLabel" + counter%>"
                   style="padding: 0; text-align: center"><%=realCustomer.getDateOfBirth().substring(0, 10)%>
                </p>
                <input style="display:none" type="text" id="<%="birthDate" + counter%>" name="birthDate" size="8"
                       value="<%=realCustomer.getDateOfBirth().substring(0, 10)%>">
                <label id="<%="birthDateRequired" + counter%>" class="error" style="display: none">*</label>
            </div>
            <div class="td" style="width: 95px">
                <p id="<%="nationalCodeLabel" + counter%>"
                   style="padding: 0; text-align: center"><%=realCustomer.getNationalCode()%>
                </p>
                <input style="display:none" type="text" id="<%="nationalCode" + counter%>" name="nationalCode" size="8"
                       value="<%=realCustomer.getNationalCode()%>">
                <label id="<%="nationalCodeRequired" + counter%>" class="error" style="display: none">*</label>
                <label id="<%="nationalCodeNotValid" + counter%>" class="error" style="display: none">کد ملی نامعتبر
                    است</label>
            </div>
            <div class="td" id="<%="choose" + counter%>" style="width: 95px">
                <a href="#" onclick="visible(<%=counter%>)"><img src="images/user_male_edit.png"
                                                                 style="margin-left: 5px;"></a>
                <a href="#"
                   onclick="<%="myform" + counter%>.action='RealCustomerDeleteServlet'; <%="myform" + counter%>.submit(); "><img
                        src="images/user_male_delete.png"></a>
            </div>
            <div class="td" style="display:none" id="<%="send" + counter%>">
                <div class="buttonDiv">
                    <input class="tinButton" type="submit" value="ثبت"
                           onclick="<%="myform" + counter%>.action='RealCustomerUpdateServlet'">
                </div>
            </div>
        </form>
    </div>
    <% }%>
</div>
<%} else if (session.getAttribute("realCustomers") != null && realCustomers != null && (realCustomers.isEmpty())) {%>
<div style="margin:0 auto;">
    <div style="margin: 40px auto; text-align: center">
        <p>موردی یافت نشد</p>
    </div>
</div>
<%}%>