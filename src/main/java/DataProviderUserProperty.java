import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataProviderUserProperty {
    InputStream inputStreamUser;

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void getPropValues() throws IOException {
        try {
            Properties prop = new Properties();
            String testUsersFile = "config.properties";

            inputStreamUser = getClass().getClassLoader().getResourceAsStream(testUsersFile);

            if (inputStreamUser != null) {
                prop.load(inputStreamUser);
            } else {
                throw new FileNotFoundException("файл с пользователями " + testUsersFile + " не найден");
            }

            userName = prop.getProperty("userName");
            password = prop.getProperty("password");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStreamUser != null;
            inputStreamUser.close();
        }
    }
}
