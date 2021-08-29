package org.infinispan.springonedemo.config;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;
import org.infinispan.springonedemo.model.CustomersSchemaBuilderImpl;
import org.infinispan.springonedemo.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class ProtobufSchemaUploader {

   public ProtobufSchemaUploader(RemoteCacheManager cacheManager) {
      // Upload the generated schema in the server
      RemoteCache<String, String> metadataCache =
            cacheManager.getCache(ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME);
      GeneratedSchema schema = new CustomersSchemaBuilderImpl();
      metadataCache.put(schema.getProtoFileName(), schema.getProtoFile());
   }

}
