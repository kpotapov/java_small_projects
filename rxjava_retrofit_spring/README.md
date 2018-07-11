# A test project of spring boot, rxjava, retrofit.

# testing
1. run MoonApplication
2. run VenusServiceApplication
3. run ServiceConsumerApplication
4. call the Combined service
```curl http://localhost:9093/combined```                   
expected a similar answer
```
[["1","2","3"],["Hi there","Greetings","Salutations"]]
```
