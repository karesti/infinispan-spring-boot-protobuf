package org.infinispan.springonedemo;

import org.infinispan.springonedemo.model.Customer;
import org.infinispan.springonedemo.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCaching
@RestController
public class CustomersApp {

   @Autowired
   CustomersRepository customersRepository;

   @GetMapping("/")
   public String index() {
      return "Greetings from Spring Boot with Infinispan!";
   }

   @GetMapping("/customers/{id}")
   public Customer getById(@PathVariable Integer id) {
      return customersRepository.findById(id.toString());
   }

   @DeleteMapping("/customers/{id}")
   public String deleteById(@PathVariable Integer id) {
      customersRepository.removeById(id.toString());
      return "Deleted id " + id;
   }

   public static void main(String... args) {
      new SpringApplicationBuilder().sources(CustomersApp.class).run(args);
   }
}
