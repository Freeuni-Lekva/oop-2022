import main.Student;
import main.StudentDao;
import main.filter.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FilterServlet extends HttpServlet {
    private StudentDao getStudentDao() {
        ServletContext ctx = getServletContext();
        return (StudentDao) ctx.getAttribute("student_dao");
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

    private List<Student> filter(StudentDao dao, Filter f) {
        if (f == null) {
            return dao.getStudents();
        } else {
            return dao.getFiltered(f);
        }
    }

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = filter(
                getStudentDao(),
                buildFilterFromRequest(req));
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/filter_view.jsp").forward(req, resp);
    }
}
