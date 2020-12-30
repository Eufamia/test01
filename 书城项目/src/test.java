import com.dao.UserDao;
import com.enity.User;

public class test {
    public static void main(String[] args) {
        UserDao dao=new UserDao();
        User user=new User(null,"mike","123456","mike@163.com");
        int result=dao.insert(user);
        System.out.println(result);
    }
}
