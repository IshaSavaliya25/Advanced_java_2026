package semester6;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        UserDao userDao=new UserDao();
        User newUser=new User();
        newUser.setName("Isha");
        newUser.setEmail("isha@a.com");
        userDao.saveUser(newUser);
    }
}
