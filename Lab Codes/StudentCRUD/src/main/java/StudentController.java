import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/student")

public class StudentController extends HttpServlet{
    StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        studentService=new StudentService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("txtStuName");
        String addr=req.getParameter("txtStuAddress");
        Student stu=new Student(0,name,addr);
        studentService.addStudent(stu);
        PrintWriter out = resp.getWriter();
        out.print("Student added");
    }
}
