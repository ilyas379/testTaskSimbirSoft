package DataProviderProperty;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataProviderUserProperty {
    InputStream inputStreamUser;
    InputStream inputStreamMessage;

    private String userName;
    private String password;

    private String messageSubject;
    private String messageBody;


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void getPropValues() throws IOException {
        try {
            Properties prop = new Properties();
            String testUsersFile = "testUsers.properties";
            String testMessageFile = "testMessage.properties";

            inputStreamUser = getClass().getClassLoader().getResourceAsStream(testUsersFile);
            inputStreamMessage = getClass().getClassLoader().getResourceAsStream(testMessageFile);

            if (inputStreamUser != null) {
                prop.load(inputStreamUser);
            } else {
                throw new FileNotFoundException("файл с пользователями" + testUsersFile + "не найден");
            }

            if (inputStreamMessage != null) {
                prop.load(inputStreamMessage);
            } else {
                throw new FileNotFoundException("файл с сообщениями" + testMessageFile + "не найден");
            }

            userName = prop.getProperty("userName");
            password = prop.getProperty("password");
            messageSubject =prop.getProperty("subject");
            messageBody =prop.getProperty("messageBody");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStreamUser != null;
            inputStreamUser.close();
            assert inputStreamMessage != null;
            inputStreamMessage.close();
        }
    }
}
