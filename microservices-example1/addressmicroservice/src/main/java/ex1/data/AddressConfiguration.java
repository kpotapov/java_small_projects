package ex1.data;

import ex1.data.data.AddressData;
import ex1.data.data.AddressDataMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfiguration {

    @Bean
    public AddressData addressProvider() {
        return new AddressDataMock();
    }


}
