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