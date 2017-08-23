package listmanager;

import java.util.ArrayList;

/**
 *
 * @author tomiwaogun
 */

//Abstraction using interface
public interface ReaderInterface { 
// following methods are forced on classes implementing them
    void reader();
    void printer();
    ArrayList<User> getUsers();
}
