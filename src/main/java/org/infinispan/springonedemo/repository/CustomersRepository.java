package org.infinispan.springonedemo.repository;

import org.infinispan.springonedemo.model.City;
import org.infinispan.springonedemo.model.Customer;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@CacheConfig(cacheNames = Data.CUSTOMERS_CACHE)
public class CustomersRepository {

   private Map<String, Customer> database = new HashMap<>();
   private Random random = new Random();

   public CustomersRepository() {
      int id = 1;
      City[] values = City.values();
      for(String name: Data.NAMES) {
         database.put(id + "", new Customer(Integer.toString(id++), name, values[random.nextInt(3)], random.nextInt(110)));
      }
   }

   @Cacheable
   public Customer findById(String id) {
      return verySlowDatabaseCall(id);
   }

   @CacheEvict
   public void removeById(String id) {
      database.remove(id);
   }

   private Customer verySlowDatabaseCall(String id) {
      return database.get(id);
   }

   public int size() {
      return database.size();
   }

}
