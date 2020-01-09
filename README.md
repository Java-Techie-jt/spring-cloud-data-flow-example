# spring-cloud-data-flow
Spring Cloud Data Flow Example with Kafka-binder 

###### Follow Below Steps

###### 1) Apache-Kafka Binary Distribution [Download](http://apachemirror.wuchna.com/kafka/2.3.1/kafka_2.11-2.3.1.tgz).

###### 2) Strat Zookeeper server
> zookeeper-server-start.bat D:\software\kafka_2.11-2.3.1\config\zookeeper.properties

###### 3) Strat Kafka server 
> kafka-server-start.bat D:\software\kafka_2.11-2.3.1\config\server.properties

###### 4) Download Spring Cloud Data Flow Server jar [Download](https://repo.spring.io/milestone/org/springframework/cloud/spring-cloud-dataflow-server-local/1.7.4.RELEASE/spring-cloud-dataflow-server-local-1.7.4.RELEASE.jar).

###### 5) Strat Spring Cloud Data Flow Server 
> java -jar spring-cloud-dataflow-server-local-1.7.4.RELEASE.jar

###### 6) Download Spring Cloud Data Flow Shell jar [Download](http://repo.spring.io/milestone/org/springframework/cloud/spring-cloud-dataflow-shell/1.3.0.M1/spring-cloud-dataflow-shell-1.3.0.M1.jar).

###### 7) Strat Spring Cloud Data Flow shell 
> java -jar spring-cloud-dataflow-shell-1.3.0.M1.jar

###### 8) Register all 3 microservices to Spring Cloud Data Flow Server using below commands
> app register --name product-service --type source --uri maven://com.javatechie:product-service:jar:0.0.1-SNAPSHOT

> app register --name discount-service --type processor --uri maven://com.javatechie:discount-service:jar:0.0.1-SNAPSHOT

> app register --name courier-service --type sink --uri maven://com.javatechie:courier-service:jar:0.0.1-SNAPSHOT

###### 9) Create Cloud Stream to connect between all microservices registered in spring cloud data flow server
> create --name log-data --definition 'product-service | discount-service | courier-service'

###### 10) Strat & Deploy Stream 
> stream deploy --name log-data
