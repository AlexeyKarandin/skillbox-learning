import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Course course = session.get(Course.class, 3);
        System.out.println(course.getName() + ". На данном курсе студентов:  " + course.getStudentsCount());

        Teacher teacher = session.get(Teacher.class, 1);
        System.out.println(teacher.getName() + " возраст: " + teacher.getAge());

        Transaction transaction = session.beginTransaction();

        course = session.get(Course.class, 1);
        course.getStudents().forEach(student -> System.out.println(
                student.getId() + " " + student.getName() + " " + student.getRegistrationDate()
        ));
        transaction.commit();

        sessionFactory.close();
    }
}
