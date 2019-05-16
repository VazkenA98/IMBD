package Access;

import java.io.IOException;
import java.text.ParseException;


public class Admin extends Persone implements Accessable {
    private String username;
    private String password;


    public Admin() {

    }

    @Override
    protected void libraryOptions() throws ParseException, IOException, ClassNotFoundException {
        goToAccess();
    }

    public Admin(String name, String id, String username, String password) {
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
    public void goToAccess() throws ParseException, IOException, ClassNotFoundException {
        AdminControl admin = new AdminControl();
    }
}

