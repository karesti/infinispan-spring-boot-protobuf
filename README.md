### Run App
`mvn clean package spring-boot:run`

Heat the cache running `./cache-heater.sh`

### Queries

`from springone.Customer ORDER BY age DESC`

`from springone.Customer c WHERE c.age: [35 to 50] ORDER BY age ASC`

`from springone.Customer c WHERE c.name:'Len'`

`from springone.Customer c WHERE c.name:'Len'~1`