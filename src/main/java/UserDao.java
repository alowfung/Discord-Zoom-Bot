import java.util.ArrayList;
import java.util.List;

// TODO: 1/17/2022 Sub data structure for actual database
public class UserDao {
    private static UserDao userDao;
    private List<String> userList;

    private UserDao(){
        userList = new ArrayList<>();
    }

    //Singleton + Lazy loading
    public static UserDao getInstance(){
        if(userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    public void put(String username){
        userList.add(username);
    }

    public void delete(String username){
        userList.remove(username);
    }

    public List<String> getAll(){
        //Returning a deep copy of userList
        return new ArrayList<>(userList);
    }

}
