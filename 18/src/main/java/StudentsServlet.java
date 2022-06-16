import main.Student;
import main.StudentDao;
import main.filter.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentsServlet extends HttpServlet {
//    private final String contents = "    <html>" +
//            "        <head>" +
//            "    	<title>Students APP</title>" +
//            "    	<script type=\"text/javascript\" src=\"./index.js\"></script>" +
//            "    	<style>" +
//            "    	 table#students {" +
//            "    	     width: 100%;" +
//            "    	     background-color: red;" +
//            "    	 }" +
//            "    	</style>" +
//            "        </head>" +
//            "        <body onload=\"init()\">" +
//            "    	<form action=\"/students\" method=\"POST\">" +
//            "    	    <label for=\"first_name\">First Name</label><input type=\"text\" name=\"first_name\" id=\"first_name\" /><br/>" +
//            "    	    <label for=\"last_name\">Last Name</label><input type=\"text\" name=\"last_name\" id=\"last_name\" /><br/>" +
//            "    	    <label for=\"admission_year\">Admission Year</label><input type=\"text\" name=\"admission_year\" id=\"admission_year\" /><br/>" +
//            "    	    <input type=\"submit\" value=\"Create\" />" +
//            "    	</form>" +
//            "    	<table id=\"students\">" +
//            "    	    <tr>" +
//            "    		<th>First Name</th>" +
//            "    		<th>Last Name</th>" +
//            "    		<th>Admission Year</th>" +
//            "    	    </tr>" +
//            "           __STUDENTS_LIST__" +
//            "    	</table>" +
//            "        </body>" +
//            "    </html>";

    @Override
    public void init() throws ServletException {
        super.init();
        List<Student> students = new ArrayList<>();
        students.add(new Student("foo", "bar", 12));
        students.add(new Student("dev", "null", 2000));
        ServletContext ctx = getServletContext();
        ctx.setAttribute("students", students);
    }

    private StudentDao getStudentDao() {
        ServletContext ctx = getServletContext();
        return (StudentDao) ctx.getAttribute("student_dao");
    }

    private List<Student> filter(StudentDao dao, Filter f) {
        if (f == null) {
            return dao.getStudents();
        } else {
            return dao.getFiltered(f);
        }
//        List<Student> students = dao.getStudents();
//        List<Student> filtered = new ArrayList<>();
//        for (Student st : students) {
//            if (f.filter(st)) {
//                filtered.add(st);
//            }
//        }
//        return filtered;
    }

    private Filter buildFilterFromRequest(HttpServletRequest req) {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String admissionYear = req.getParameter("admission_year");
        And f = new And();
        if (firstName != null && firstName.length() > 0) {
            f.add(new FirstNameFilter(firstName));
        }
        if (lastName != null && lastName.length() > 0) {
            f.add(new LastNameFilter(lastName));
        }
        if (admissionYear != null && admissionYear.length() > 0) {
            f.add(new AdmissionYearFilter(Integer.valueOf(admissionYear)));
        }
        if (f.size() == 0) {
            return null;
        }
        return f;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao students = getStudentDao();
        Filter f = buildFilterFromRequest(req);
        req.setAttribute("students", filter(students, f));
        req.getRequestDispatcher("/WEB-INF/students_view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao dao = (StudentDao) getServletContext().getAttribute("student_dao");
        dao.createStudent(new Student(
                req.getParameter("first_name"),
                req.getParameter("last_name"),
                Integer.valueOf(req.getParameter("admission_year"))));
        resp.sendRedirect("/students");
    }
}
