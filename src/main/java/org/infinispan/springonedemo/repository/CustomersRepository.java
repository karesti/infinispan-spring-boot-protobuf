package org.infinispan.springonedemo.repository;

import org.infinispan.springonedemo.model.City;
import org.infinispan.springonedemo.model.Customer;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
@CacheConfig(cacheNames = Data.CUSTOMERS_CACHE)
public class CustomersRepository {

   private Map<String, Customer> database = new HashMap<>();

   public CustomersRepository() {
      int id = 1;
      for(String name: Data.NAMES) {
         database.put(id + "", new Customer(Integer.toString(id++), name, City.LONDON));
      }
   }

   @Cacheable
   public Customer findById(String id) {
      return database.get(id);
   }

   @CacheEvict
   public void removeById(String id) {
      database.remove(id);
   }

   public int size() {
      return database.size();
   }

}
