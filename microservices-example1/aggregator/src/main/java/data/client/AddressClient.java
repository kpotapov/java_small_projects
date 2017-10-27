package data.client;

import data.client.domain.Address;
import data.client.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="addressClient", url="http://localhost:11012")
public interface AddressClient  {

	@RequestMapping(method = RequestMethod.GET, value = "/address/details/{userid}")
	Address findUserById(@PathVariable("userid") String userId);

}