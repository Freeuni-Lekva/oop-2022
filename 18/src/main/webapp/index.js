function  addStudentToTable(student) {
    var row = document.getElementById("students").insertRow();
    row.insertCell().innerHTML = student.firstName;
    row.insertCell().innerHTML = student.lastName;
    row.insertCell().innerHTML = student.admissionYear;
}

function clearStudentsTable() {
    var table = document.querySelector("#students tbody");
    while (table.children.length > 1) {
           table.removeChild(table.children[1]);
    }
}

function createStudent() {
    var firstName = document.getElementById("first_name").value;
    var lastName = document.getElementById("last_name").value;
    var admissionYear = document.getElementById("admission_year").value;
    addStudentToTable({firstName, lastName, admissionYear});
    return false;
}

function filterStudents() {
    var firstName = document.getElementById("filter_first_name").value;
    var lastName = document.getElementById("filter_last_name").value;
    var admissionYear = document.getElementById("filter_admission_year").value;
    fetch("/filter?first_name=" + firstName + "&last_name=" + lastName +  "&admission_year="  + admissionYear)
        .then(function (resp) {
            if (resp.status !== 200) {
                return;
            }
            resp.json()
                .then(function (students) {
                    clearStudentsTable();
                    for (var student of students) {
                        addStudentToTable({
                            firstName: student.first_name,
                            lastName: student.last_name,
                            admissionYear: student.admission_year
                        });
                    }
                })
                .catch(function (err) {
                   console.log(err);
                });
        })
        .catch(function (err) {
            console.log(err);
        });
//    var xhr = new XMLHttpRequest();
//    xhr.open("GET", "/filter?first_name=" + firstName + "&last_name=" + lastName +  "&admission_year="  + admissionYear, true);
//    xhr.onload = function() {
//        if (xhr.status !== 200)  {
//            return;
//        }
//        var students = JSON.parse(xhr.responseText);
//        clearStudentsTable();
//            for (var student of students) {
//                console.log(student);
//                addStudentToTable({
//                    firstName: student.first_name,
//                    lastName: student.last_name,
//                    admissionYear: student.admission_year
//                });
//            }
//    }
//    xhr.onerror = function(e) {
//        console.log(e);
//    }
//    xhr.send();
    return false;
}

function init() {
    // document.getElementsByTagName("form")[0].onsubmit = createStudent;
    document.getElementsByTagName("form")[1].onsubmit = filterStudents;
}