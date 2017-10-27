package data;

import data.data.UserData;
import data.data.UserDataMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserData userProvider() {
        return new UserDataMock();
    }


}
