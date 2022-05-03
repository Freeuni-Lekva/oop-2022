function createStudent() {
    var firstName = document.getElementById("first_name").value;
    var lastName = document.getElementById("last_name").value;
    var admissionYear = document.getElementById("admission_year").value;
    var row = document.getElementById("students").insertRow();
    row.insertCell().innerHTML = firstName;
    row.insertCell().innerHTML = lastName;
    row.insertCell().innerHTML = admissionYear;
    return false;
}

function init() {
    document.getElementsByTagName("form")[0].onsubmit = createStudent;
}
