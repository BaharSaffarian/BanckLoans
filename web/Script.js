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

function validateLegalCustomerRegistrationForm() {
    var status=true;
    if(document.getElementById("CompanyName").value.length==0){
        document.getElementById("CompanyNameRequired").style.display="inline";
        status=false;
    }
    if(document.getElementById("RegisterDate").value.length==0){
        document.getElementById("RegisterDateRequired").style.display="inline";
        status=false;
    }
    if(document.getElementById("EconomicCode").value.length==0){
        document.getElementById("EconomicCodeRequired").style.display="inline";
        status=false;
    }
    return status;
}

function visible(count) {
    document.getElementById("firstName" + count).style.display = "inline";
    document.getElementById("lastName" + count).style.display = "inline";
    document.getElementById("fatherName" + count).style.display = "inline";
    document.getElementById("birthDate" + count).style.display = "inline";
    document.getElementById("nationalCode" + count).style.display = "inline";
    document.getElementById("send" + count).style.display = "inline";

    document.getElementById("firstNameLabel" + count).style.display = "none";
    document.getElementById("lastNameLabel" + count).style.display = "none";
    document.getElementById("fatherNameLabel" + count).style.display = "none";
    document.getElementById("birthDateLabel" + count).style.display = "none";
    document.getElementById("nationalCodeLabel" + count).style.display = "none";
    document.getElementById("choose" + count).style.display = "none";
}
function validateRealCustomer(count) {
    var status=true;
    if(document.getElementById("firstName" + count).value.length==0){
        document.getElementById("firstNameRequired" + count).style.display="inline";
        status=false;
    }
    if(document.getElementById("lastName"+ + count).value.length==0){
        document.getElementById("lastNameRequired" + count).style.display="inline";
        status=false;
    }
    if(document.getElementById("fatherName" + count).value.length==0){
        document.getElementById("fatherNameRequired" + count).style.display="inline";
        status=false;
    }
    if(document.getElementById("birthDate" + count).value.length==0){
        document.getElementById("birthDateRequired" + count).style.display="inline";
        status=false;
    }
    if(document.getElementById("nationalCode" + count).value.length==0){
        document.getElementById("nationalCodeRequired" + count).style.display="inline";
        status=false;
    }else if(isNaN(document.getElementById("nationalCode" + count).value)){
        document.getElementById("nationalCodeNotValid" + count).style.display="inline";
        status=false;
    }else{
        var nationalCode=document.getElementById("nationalCode").value;
        var sum=0;
        for(var i=0;i<(nationalCode.length-1);i++){
            sum+=nationalCode[i]*(10-i);
        }
        if(!((sum%11)==nationalCode[9] || (sum%11)==(11-nationalCode[9]))) {
            document.getElementById("nationalCodeNotValid" + count).style.display = "inline";
            status = false;
        }
    }
    return status;

}
function doDelete(count) {
    var form = document.getElementById("myform" + count);
    form.action = 'RealCustomerDeleteServlet';
    form.submit();
    form.target = '';
}