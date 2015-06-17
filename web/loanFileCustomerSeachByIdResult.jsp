<%@ page import="java.util.List" %>
<%@ page import="model.LoanType" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String firstName;
    String lastName;
    String id;
    List<LoanType> loanTypes;
    if (request.getAttribute("firstName")!= null && request.getAttribute("lastName")!=null) {
        firstName = request.getAttribute("firstName").toString();
        lastName=request.getAttribute("lastName").toString();
        id=request.getAttribute("id").toString();
        loanTypes=(List<LoanType>) request.getAttribute("loanTypes");
%>

<script>
    function  loanRegistrationValidation(){
        var status=true;
        if(document.getElementById("Duration").value.length==0){
            document.getElementById("DurationRequired").style.display="";
            status=false;
        }
        if(document.getElementById("Amount").value.length==0){
            document.getElementById("AmountRequired").style.display="";
            status=false;
        }
        return status;
    }
</script>

<form id="loanFileRegistration" method="get" onsubmit="return loanRegistrationValidation();">

    <div class="table" style="margin-top: 0px; height: 230px;">
    <input class="input" type="text" name="CustomerId" id="InputCustomerId" size="20" style="display: none" value="<%=id%>">
    <div class="inputRow" style="float: right; margin-right: 10px;">
        <div class="label">نام مشتری:</div>
        <div class="label"><%=firstName%></div>
    </div>
    <div class="inputRow" style="float: right;">
        <div class="label" style="width: 150px">نام خانوادگی مشتری:</div>
        <div class="label"><%=lastName%></div>
    </div>
    <div class="inputRow" style="float: right;">
        <div class="label">نوع تسهیلات:</div>
        <div class="input">
            <select name="LoanType" style="width: 120px; margin-top: 10px;">
                <%
                    Iterator<LoanType> iterator=loanTypes.iterator();
                    while (iterator.hasNext()){
                        LoanType loanType=iterator.next();%>
                <option value="<%=loanType.getId()%>"><%=loanType.getName()%></option>
                    <%}%>
            </select>
        </div>
    </div>
    <div class="inputRow" style="float: right;">
        <div class="label">مدت قرارداد:</div>
        <div class="input">
            <input class="input" type="text" name="Duration" id="Duration" size="20">
            <label id="DurationRequired" class="error" style="display: none; float: right;">*</label>
        </div>
    </div>
    <div class="inputRow" style="float: right;">
        <div class="label">مبلغ قرارداد:</div>
        <div class="input">
            <input class="input" type="text" name="Amount" id="Amount" size="20">
            <label id="AmountRequired" class="error" style="display: none; float: right;">*</label>
        </div>
    </div>
    <div class="inputRow" style="float: right;">
        <div class="buttonDiv">
            <input class="button" type="submit"
                   onclick="document.getElementById('loanFileRegistration').action = 'LoanFileRegistrationServlet';form.submit();"
                   value="ثبت">
        </div>
    </div>
    </div>
</form>
<%}else if(request.getAttribute("notExist")!=null){%>
    <p><%=request.getAttribute("notExist").toString()%></p>
<%}%>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
