function validateRealCustomerRegistrationForm11() {
    var x = document.forms["realCustomerRegistrationForm"]["NationalCode"].value;

    if (!x.match(/^\d{10}$/)) {
        document.getElementById("NationalCodeNotValid").style.display="inline";
        return false;
    }

    if(nationalCode.length<=0 || isNaN(nationalCode)){
        document.getElementById("NationalCodeNotValid").style.display="inline";
    }
}
