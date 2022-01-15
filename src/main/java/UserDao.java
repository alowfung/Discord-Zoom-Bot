import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDao {
    private static UserDao userDao;
    private List<String> userList;

    private UserDao(){
        userList = new ArrayList<>();
//        userList = Arrays.asList("A Low", "C. Lo", "Asterlee");
    }

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



    //done: use lazy loading

    //done: use an array or list or hash table instead of a database in the meantime
}
