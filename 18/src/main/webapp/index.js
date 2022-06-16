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

function filterStudents() {
    var firstName = document.getElementById("filter_first_name").value;
    var lastName = document.getElementById("filter_last_name").value;
    var admissionYear = document.getElementById("filter_admission_year").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(resp) {
        console.log(resp);
    }
    xhr.open("GET", "/filter?first_name=" + firstName + "&last_name=" + lastName +  "&admissionYear="  + admissionYear, true);
    return false;
}

function init() {
    // document.getElementsByTagName("form")[0].onsubmit = createStudent;
    document.getElementsByTagName("form")[1].onsubmit = filterStudents;
}