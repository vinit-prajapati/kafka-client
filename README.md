# kafka-client

Download Apache kafka
https://www.apache.org/dyn/closer.cgi?path=/kafka/0.8.2.0/kafka_2.10-0.8.2.0.tgz

Extract folder
> tar -xzf kafka_2.10-0.8.2.0.tgz
> cd kafka_2.10-0.8.2.0

start Zoopkeeper
> bin/zookeeper-server-start.sh config/zookeeper.properties &

Start server
> bin/kafka-server-start.sh config/server.properties 

Create a test topic
> bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 6 --topic test &
