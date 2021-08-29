package org.infinispan.springonedemo.config;

import org.infinispan.commons.marshall.ProtoStreamMarshaller;
import org.infinispan.spring.starter.remote.InfinispanRemoteCacheCustomizer;
import org.infinispan.springonedemo.model.CustomersSchemaBuilderImpl;
import org.infinispan.springonedemo.repository.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class InfinispanConfiguration {

   @Bean
   @Order(Ordered.HIGHEST_PRECEDENCE)
   public InfinispanRemoteCacheCustomizer caches() {
      return b -> {
         URI cacheConfigUri = cacheConfigURI("customersCache.xml");

         b.remoteCache(Data.CUSTOMERS_CACHE)
                 .configurationURI(cacheConfigUri);

         b.remoteCache(Data.CUSTOMERS_CACHE).marshaller(ProtoStreamMarshaller.class);

         // Add marshaller in the client, the class is generated from the interface in compile time
         b.addContextInitializer(new CustomersSchemaBuilderImpl());
      };
   }

   private URI cacheConfigURI(String cacheConfigFile) {
      URI cacheConfigUri;
      try {
         cacheConfigUri = this.getClass().getClassLoader().getResource(cacheConfigFile).toURI();
      } catch (URISyntaxException e) {
         throw new RuntimeException(e);
      }
      return cacheConfigUri;
   }
}
