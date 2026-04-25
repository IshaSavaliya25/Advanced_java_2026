package semester6;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student("Isha", "isha@gmail.com");
        session.save(s1);

        List<Student> students = session.createQuery("from Student", Student.class).list();
        for (Student s : students) {
            System.out.println(s.getId() + " " + s.getName());
        }

        Student s = session.get(Student.class, 1);
        if (s != null) {
            s.setName("Updated Name");
            session.update(s);
        }

        Student d = session.get(Student.class, 2);
        if (d != null) {
            session.delete(d);
        }

        tx.commit();
        session.close();
    }
}
