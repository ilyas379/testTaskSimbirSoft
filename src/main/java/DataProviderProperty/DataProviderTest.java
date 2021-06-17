package DataProviderProperty;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Message;
import pojo.User;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataProviderTest {
    ObjectMapper objectMapper = new ObjectMapper();

    public Message[] readFileMessage(String fileName) throws IOException {
        return objectMapper.readValue(new File(fileName), Message[].class);
    }

    public User[] readFileUser(String fileName) throws IOException {
        return objectMapper.readValue(new File(fileName), User[].class);
    }
}
