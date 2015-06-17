<%@ page session="true" contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*, model.LegalCustomer" %>
<%
    List<LegalCustomer> legalCustomers = (List<LegalCustomer>) request.getAttribute("legalCustomers");
    if (legalCustomers != null && (!legalCustomers.isEmpty())) {
%>
<script type="text/javascript">
    function LegalEditVisible(count) {
        document.getElementById("companyName" + count).style.display = "inline";
        document.getElementById("registerDate" + count).style.display = "inline";
        document.getElementById("economicCode" + count).style.display = "inline";
        document.getElementById("send" + count).style.display = "inline";

        document.getElementById("companyNameLabel" + count).style.display = "none";
        document.getElementById("registerDateLabel" + count).style.display = "none";
        document.getElementById("economicCodeLabel" + count).style.display = "none";
        document.getElementById("choose" + count).style.display = "none";
    }

    function validateLegalCustomer(count) {
        var status = true;

        if (document.getElementById("companyName" + count).value.length == 0) {
            document.getElementById("companyNameRequired" + count).style.display = "inline";
            status = false;
        }
        if (document.getElementById("registerDate" + count).value.length == 0) {
            document.getElementById("registerDateRequired" + count).style.display = "inline";
            status = false;
        }
        if (document.getElementById("economicCode" + count).value.length == 0) {
            document.getElementById("economicCodeRequired" + count).style.display = "inline";
            status = false;
        }
        return status;
    }
</script>
<div class="table" style="width: 565px;">
    <div class="htr" style="width: 555px;">
        <div class="idtd">ردیف</div>

        <div class="htd" style="width: 95px">شناسه</div>
        <div class="htd" style="width: 95px">نام شرکت</div>
        <div class="htd" style="width: 95px">تاریخ ثبت</div>
        <div class="htd" style="width: 95px">کد اقتصادی</div>
        <div class="htd" style="width: 95px"></div>
    </div>

    <%
        int counter = 0;
        Iterator<LegalCustomer> iterator = legalCustomers.iterator();
        LegalCustomer legalCustomer = null;
        while (iterator.hasNext()) {
            legalCustomer = iterator.next();
            counter++;
    %>
    <div class="tr" style="width: 555px;">
        <form method="get" id="<%="myform" + counter%>" action="#"
              onsubmit="return validateLegalCustomer(<%=counter%>);">
            <input style="display:none" type="text" name="oldEconomicCode" size="8"
                   value="<%=legalCustomer.getEconomicCode()%>">

            <div class="idtd"><p style="padding: 0; text-align: center"><%=counter%>
            </p></div>
            <div class="td" style="width: 95px">
                <p id="<%="idLabel" + counter%>" style="padding: 0; text-align: center"><%=legalCustomer.getId()%>
                </p>
                <input style="display:none" type="text" id="<%="id"+counter%>" name="id" size="8"
                       value="<%=legalCustomer.getId()%>">
            </div>
            <div class="td" style="width: 95px">
                <p id="<%="companyNameLabel" + counter %>"
                   style="padding: 0; text-align: center"><%=legalCustomer.getCompanyName()%>
                </p>
                <input style="display:none" type="text" id="<%="companyName" + counter%>" name="companyName" size="8"
                       value="<%=legalCustomer.getCompanyName()%>">
                <label id="<%="companyNameRequired" + counter%>" class="error" style="display: none">*</label>
            </div>
            <div class="td" style="width: 95px">
                <p id="<%="registerDateLabel" + counter%>"
                   style="padding: 0; text-align: center"><%=legalCustomer.getRegisterDate().substring(0, 10)%>
                </p>
                <input style="display:none" type="text" id="<%="registerDate" + counter%>" name="registerDate" size="8"
                       value="<%=legalCustomer.getRegisterDate().substring(0, 10)%>">
                <label id="<%="registerDateRequired" + counter%>" class="error" style="display: none">*</label>
            </div>
            <div class="td" style="width: 95px">
                <p id="<%="economicCodeLabel" + counter%>"
                   style="padding: 0; text-align: center"><%=legalCustomer.getEconomicCode() %>
                </p>
                <input style="display:none" type="text" id="<%="economicCode" + counter%>" name="economicCode" size="8"
                       value="<%=legalCustomer.getEconomicCode()%>">
                <label id="<%="economicCodeRequired" + counter%>" class="error" style="display: none">*</label>
            </div>

            <div class="td" id="<%="choose" + counter%>" style="width: 95px">
                <a href="#" onclick="LegalEditVisible(<%=counter%>)"><img src="images/user_male_edit.png"
                                                                          style="margin-left: 5px;"></a>
                <a href="#"
                   onclick="<%="myform" + counter%>.action='LegalCustomerDeleteServlet'; <%="myform" + counter%>.submit(); "><img
                        src="images/user_male_delete.png"></a>
            </div>
            <div class="td" style="display:none" id="<%="send" + counter%>">
                <div class="buttonDiv">
                    <input class="tinButton" type="submit" value="ثبت"
                           onclick="<%="myform" + counter%>.action='LegalCustomerUpdateServlet'">
                </div>
            </div>
        </form>
    </div>
    <% }%>
</div>
<%} else if (session.getAttribute("legalCustomers") != null && legalCustomers != null && (legalCustomers.isEmpty())) {%>
<div style="margin:0 auto;">
    <div style="margin: 40px auto; text-align: center">
        <p>موردی یافت نشد</p>
    </div>
</div>
<%}%>