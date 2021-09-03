### Cross Site Replication 
Run Infinispan with Docker Componse and Cross Site Replication

https://github.com/infinispan/infinispan-simple-tutorials/tree/main/infinispan-remote/cross-site-replication

### More Spring Boot examples
Simple tutorials: https://github.com/infinispan/infinispan-simple-tutorials/tree/main/integrations/spring-boot

Near Caching: https://github.com/infinispan-demos/infinispan-near-cache

### Run App
`mvn clean package spring-boot:run`

Heat the cache running `./cache-heater.sh`

### Queries

`from springone.Customer ORDER BY age DESC`

`from springone.Customer c WHERE c.age: [35 to 50] ORDER BY age ASC`

`from springone.Customer c WHERE c.name:'Len'`

`from springone.Customer c WHERE c.name:'Len'~1`