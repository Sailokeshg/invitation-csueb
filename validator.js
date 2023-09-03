function confirmClear(){
    document.getElementById("eventForm").reset()
}
function validateEventForm() {
    var eventName = document.getElementById("eventName").value;
    var eventDate = document.getElementById("eventDate").value;
    var eventTime = document.getElementById("eventTime").value;
    var eventLocation = document.getElementById("eventLocation").value;
    var eventDescription = document.getElementById("eventDescription").value;
    
    if (eventName === "" || eventDate === "" || eventTime === "" || eventLocation === "" || eventDescription === "") {
        alert("Please fill out all fields before submitting.");
        return false;
    }

    if (!isValidDateFormat(eventDate)) {
        alert("Please verify the date format mm/dd/yyyy.");
        return false;
    }
    
    return true;
}

function isValidDateFormat(date) {
    var datePattern = /^(0[1-9]|1[0-2])\/(0[1-9]|[12][0-9]|3[01])\/\d{4}$/;
    return datePattern.test(date);
}

function submitForm() {
    if (validateEventForm()) {
        alert("Form submitted successfully!");
        confirmClear()
    }
}
