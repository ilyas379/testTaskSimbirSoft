package DataProviderProperty;

import org.testng.annotations.DataProvider;
import pojo.Message;
import pojo.User;
import java.io.IOException;

public class DataProviderInfo {
    @DataProvider(name = "testData")
    public Object[][] testDataProvider() throws IOException {
        DataProviderTest dataProvider = new DataProviderTest();
        User[] users = dataProvider.readFileUser("src\\main\\resources\\users.json");
        Message[] messages = dataProvider.readFileMessage("src\\main\\resources\\message.json");
        Object[][] result = new Object[users.length * messages.length][2];
        for(int i = 0; i<users.length; i++ ){
            User user = users[i];
            for (int j = 0; j<messages.length; j++){
                Message message = messages[j];
                int resultIndex = i * messages.length + j;
                result[resultIndex][0] = user;
                result[resultIndex][1] = message;
            }
        }
        return result;
    }
}
