
## API Reference

#### for getting lattitude , longitude and some other locartion details

```https://api.opencagedata.com/geocode/v1/json?key={api_ley}&q={pincode}&pretty=1```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. `767d0ceffae94717836eadb18dee640a` |
| `pincode` | `Integer`| `which you want to search`  |

it takes pincode as parameter and return pincode details..........



#### for getting weather details

```https://api.openweathermap.org/data/2.5/weather?lat={lattitude}&lon={longitude}&dt={unixTime}&appid={your api key}&units=metric```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `appid`      | `string` | **Required**.956df4d89fd7e25fc00ccab4ae566c5d |
| `dt`           | `Long`     | unixtime                        |
| `lon`          | `double`   | longitude                  |
|`lat`           | `double`   | lattitude                  |

it takes lngotude and lattitude and unixtime as parameter and return JsonObject of weather details...............

## Deployment
```properties
 #changing the server port
server.port=8080

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/database
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=username
spring.datasource.password=password



#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

```
### Swagger UI - Link

Use this link to run it on browser.
```swagger
[http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui/)
![image](https://github.com/Jitsu-13/WeatherInfo_Project/assets/107523890/d695f537-7614-4714-a649-98ae6df4e1cc)
![image](https://github.com/Jitsu-13/WeatherInfo_Project/assets/107523890/f49a8fa6-dac3-4bbc-b818-a736be55b4b5)

```
### Postman
![image](https://github.com/Jitsu-13/WeatherInfo_Project/assets/107523890/8f29f91b-f4b2-4527-9ffb-859091308b6a)
![image](https://github.com/Jitsu-13/WeatherInfo_Project/assets/107523890/bc3a402b-eb5b-4c17-b466-ad57f5414887)

# WeatherInfo_Project
