package Access;

import java.io.IOException;
import java.text.ParseException;


public class User extends Persone implements Accessable {

    private String name;
    private String id;
    private String username;
    private String password;

    public User() {

    }

    @Override
    protected void libraryOptions() throws IOException, ClassNotFoundException, ParseException {
        goToAccess();
    }


    public User(String name, String id, String username, String password) {

        super(name, id);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void goToAccess() throws IOException, ClassNotFoundException, ParseException {
        UserControl user = new UserControl();
    }
}