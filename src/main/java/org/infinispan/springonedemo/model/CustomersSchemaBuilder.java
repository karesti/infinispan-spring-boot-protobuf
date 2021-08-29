package org.infinispan.springonedemo.model;

import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(schemaPackageName = "springone",
      includeClasses = {Customer.class, City.class})
public interface CustomersSchemaBuilder extends GeneratedSchema {

}


