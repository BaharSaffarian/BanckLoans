function validateRealCustomerRegistrationForm() {
    var status = true;
    if (document.getElementById("FirstName").value.length == 0) {
        document.getElementById("NameRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("LastName").value.length == 0) {
        document.getElementById("LastNameRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("FatherName").value.length == 0) {
        document.getElementById("FatherNameRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("DateOfBirth").value.length == 0) {
        document.getElementById("DateOfBirthRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("NationalCode").value.length == 0) {
        document.getElementById("NationalCodeRequired").style.display = "inline";
        status = false;
    } else if (isNaN(document.getElementById("NationalCode").value)) {
        document.getElementById("NationalCodeNotValid").style.display = "inline";
        status = false;
    } else {
        var nationalCode = document.getElementById("NationalCode").value;
        var sum = 0;
        for (var i = 0; i < (nationalCode.length - 1); i++) {
            sum += nationalCode[i] * (10 - i);
        }
        if (!((sum % 11) == nationalCode[9] || (sum % 11) == (11 - nationalCode[9]))) {
            document.getElementById("NationalCodeNotValid").style.display = "inline";
            status = false;
        }
    }

    return status;
}

function validateLegalCustomerRegistrationForm() {
    var status = true;
    if (document.getElementById("CompanyName").value.length == 0) {
        document.getElementById("CompanyNameRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("RegisterDate").value.length == 0) {
        document.getElementById("RegisterDateRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("EconomicCode").value.length == 0) {
        document.getElementById("EconomicCodeRequired").style.display = "inline";
        status = false;
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

function loanTypeRegistrationValidate() {
    var status = true;
    if (document.getElementById("TypeName").value.length == 0) {
        document.getElementById("TypeNameRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("InterestRate").value.length == 0) {
        document.getElementById("InterestRateRequired").style.display = "inline";
        status = false;
    }
    return status;
}

function GrantConditionDefinitionValidation() {
    var status = true;
    if (document.getElementById("ConditionName").value.length == 0) {
        document.getElementById("ConditionNameRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("MinDuration").value.length == 0) {
        document.getElementById("MinDurationRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("MaxDuration").value.length == 0) {
        document.getElementById("MaxDurationRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("MinAmount").value.length == 0) {
        document.getElementById("MinAmountRequired").style.display = "inline";
        status = false;
    }
    if (document.getElementById("MaxAmount").value.length == 0) {
        document.getElementById("MaxAmountRequired").style.display = "inline";
        status = false;
    }
    return status;
}

function createTableOfGrantConditions(){
    var table=document.getElementById("resultTable");
    table.style.display="";
    document.getElementById("registerButton").style.display="";

    var tableRow=document.createElement("div");
    tableRow.className="tr";
    tableRow.style.width="555px";

    var counter=parseInt(document.getElementById("counter").value);
    document.getElementById("counter").value=counter+1;

    var rowDataId=document.createElement("div");
    rowDataId.className="idtd";
    rowDataId.appendChild(document.createTextNode(counter.toString()));
    tableRow.appendChild(rowDataId);

    var rowDataName=document.createElement("div");
    rowDataName.className="td";
    rowDataName.style.width="95px";
    rowDataName.appendChild(document.createTextNode(document.getElementById("ConditionName").value));
    tableRow.appendChild(rowDataName);

    var rowDataMinDuration=document.createElement("div");
    rowDataMinDuration.className="td";
    rowDataMinDuration.style.width="95px";
    rowDataMinDuration.appendChild(document.createTextNode(document.getElementById("MinDuration").value));
    tableRow.appendChild(rowDataMinDuration);

    var rowDataMaxDuration=document.createElement("div");
    rowDataMaxDuration.className="td";
    rowDataMaxDuration.style.width="95px";
    rowDataMaxDuration.appendChild(document.createTextNode(document.getElementById("MaxDuration").value));
    tableRow.appendChild(rowDataMaxDuration);

    var rowDataMinAmount=document.createElement("div");
    rowDataMinAmount.className="td";
    rowDataMinAmount.style.width="95px";
    rowDataMinAmount.appendChild((document.createTextNode(document.getElementById("MinAmount").value)));
    tableRow.appendChild(rowDataMinAmount);

    var rowDataMaxAmount=document.createElement("div");
    rowDataMaxAmount.className="td";
    rowDataMaxAmount.style.width="95px";
    rowDataMaxAmount.appendChild((document.createTextNode(document.getElementById("MaxAmount").value)));
    tableRow.appendChild(rowDataMaxAmount);

    table.appendChild(tableRow);

    var form=document.getElementById("grantConditionsForm");
    var nameInput=document.createElement("input");
    nameInput.name="ConditionName";
    nameInput.value=document.getElementById("ConditionName").value;
    nameInput.style.display="none";
    form.appendChild(nameInput);


    var minDuration=document.createElement("input");
    minDuration.name="MinDuration";
    minDuration.value=document.getElementById("MinDuration").value;
    minDuration.style.display="none";
    form.appendChild(minDuration);

    var maxDuration=document.createElement("input");
    maxDuration.name="MaxDuration";
    maxDuration.value=document.getElementById("MaxDuration").value;
    maxDuration.style.display="none";
    form.appendChild(maxDuration);

    var minAmount=document.createElement("input");
    minAmount.name="MinAmount";
    minAmount.value=document.getElementById("MinAmount").value;
    minAmount.style.display="none";
    form.appendChild(minAmount);

    var maxAmount=document.createElement("input");
    maxAmount.name="MaxAmount";
    maxAmount.value=document.getElementById("MaxAmount").value;
    maxAmount.style.display="none";
    form.appendChild(maxAmount);

}


