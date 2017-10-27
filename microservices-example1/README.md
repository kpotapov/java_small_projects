# an example of microservices use
* usermicroservice - a service provides user information
    curl http://localhost:11011/user/details/1

* addressmicroservice - a service provides complimentary user's address information
    curl http://localhost:11012/address/details/1

* aggregator - a service provides the main entry points
1.  rest end   curl http://localhost:11022/user/details/1
1.  a web page      http://localhost:11022/user/details/view/1

# techs list
 * "Feign"     - clients was created to make services calls
 *"thymeleaf" - web page
 * spring-boot
 * spring-cloud
 * spring-webmvc
 * tomcat
 * jetty


