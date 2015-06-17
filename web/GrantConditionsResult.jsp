<%@ page session="true" contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*, model.RealCustomer" %>
<%@ page import="model.GrantCondition" %>
<%
    List<GrantCondition> grantConditions = (List<GrantCondition>) session.getAttribute("grantConditions");
    if (grantConditions != null && (!grantConditions.isEmpty())) {
%>
<div class="table" style="width: 565;">
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

    <form method="get" id="myForm">
        <%
            int counter = 0;
            Iterator<GrantCondition> iterator = grantConditions.iterator();
            GrantCondition grantCondition = null;
            while (iterator.hasNext()) {
                grantCondition = iterator.next();
                counter++;
        %>
        <div class="tr" style="width: 555;">
            <div class="idtd"><p style="padding: 0; text-align: center"><%=counter%>
            </p></div>
            <div class="td" style="width: 95px">
                <p style="padding: 0; text-align: center"><%=grantCondition.getName()%>
                </p>
            </div>
            <div class="td" style="width: 95px">
                <p style="padding: 0; text-align: center"><%=grantCondition.getMinDuration()%>
                </p>
            </div>
            <div class="td" style="width: 95px">
                <p style="padding: 0; text-align: center"><%=grantCondition.getMaxDuration()%>
                </p>
            </div>
            <div class="td" style="width: 95px">
                <p style="padding: 0; text-align: center"><%=grantCondition.getMinAmount() %>
                </p>
            </div>
            <div class="td" style="width: 95px">
                <p style="padding: 0; text-align: center"><%=grantCondition.getMaxAmount()%>
                </p>
            </div>
        </div>
        <% }%>
        <div class="tr" style="width: 555;">
            <div style="margin:0 auto;">
                <div class="buttonDiv">
                    <input class="button" type="submit"
                           onclick="document.getElementById('myForm').action = 'LoanRegistrationServlet';" value="ثبت">
                </div>
            </div>
        </div>
    </form>
</div>
<%}%>