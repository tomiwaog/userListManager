package listmanager;

import java.util.ArrayList;
import java.util.Date;

public class User {
    //Encapsulation - private access modifiers for instance members;
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String userType;
    private String lastLoginTime;
    public static ArrayList<User> usersList;

    User(int userId, String firstName, String lastName, String userName, String userType, String lastLoginTime){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userType = userType;
        this.lastLoginTime = lastLoginTime;
    }
    //Accessors - getters method
    public void setUserId(int userId){
        this.userId = userId; //Shadowing fields
    }
    
    //Accessors - Setters method
    public int getUserId(){
        return this.userId;
    }


    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the lastLoginTime
     */
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime the lastLoginTime to set
     */
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public String toString( ){
        return userId + "\t" +firstName + "\t"+ lastName + "\t" + userName + "\t" +userType + " \t" +lastLoginTime;
    }
    
    public static ArrayList<User> getList(){
        return usersList;
    }
    
    public static void appendList(User user ){
        usersList.add(user);
    }
}
