


















function constructStudentFromForm() {
  var firstName = document.getElementById("first_name").value;
  var lastName = document.getElementById("last_name").value;
  var admissionYear = document.getElementById("admission_year").value;
  return new createStudent(firstName, lastName, admissionYear);
}

function createStudentRow(st) {
  var row = document.createElement("tr");  // <tr></tr>
  var firstName = document.createElement("td"); // <td></td>
  var lastName = document.createElement("td");
  var admissionYear = document.createElement("td");
  firstName.className = "first-name";
  firstName.innerHTML = st.firstName; // <td>foo</td>
  lastName.innerHTML = st.lastName;
  admissionYear.innerHTML = st.admissionYear;
  row.appendChild(lastName);  // <tr><td>foo</td><td>..</td></tr>
  row.appendChild(firstName);  // <tr><td>foo</td></tr>
  row.appendChild(admissionYear);
  return row;
}

function addStudentToTable() {
  var st = constructStudentFromForm();
  var row = createStudentRow(st);
  document.getElementById("students").appendChild(row);
  // var row = document.getElementById("students").insertRow();
  // row.insertCell().innerHTML = st.firstName;
  // row.insertCell().innerHTML = st.lastName;
  // row.insertCell().innerHTML = st.admissionYear;
  return false;
}

function createPerson(firstName, lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.getFullName = function() {
    return this.firstName + " " + lastName;
  }
}

function createStudent(firstName, lastName, admissionYear) {
  var person = new createPerson(firstName, lastName);
  // this.prototype = person;
  // this.firstName = firstName;
  // this.lastName = lastName;
  // return 5;
  // return function() {
  //   console.log("asdasdasd");
  // };
  this.admissionYear = admissionYear;
  Object.setPrototypeOf(this, person);
}

function init() {
  document.getElementsByTagName("form")[0].onsubmit = addStudentToTable;

  // var st = new createStudent("foo", "bar", 2020);
  // console.log(st);
  // console.log(st.firstName);
  // console.log(st.lastName);
  // console.log(st.admissionYear);
  // console.log(st.getFullName());
}


function getFirstNamesOfAllStudents() {
  // var all = document.getElementsByTagName("tr");
  // for (var row of all) {
  //   var columns = row.getElementsByTagName("td");
  //   if (columns.length > 0) {
  //     console.log(columns[0].innerHTML);
  //   }
  // }

  var all = document.querySelectorAll("tr td.first-name");
  for (var i of all) {
    console.log(i.innerHTML);
  }
}









