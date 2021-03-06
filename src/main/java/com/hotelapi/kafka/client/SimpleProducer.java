package com.hotelapi.kafka.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Simple Kafka Producer
 * 
 * @author vinit
 *
 */
public class SimpleProducer {

	private static Producer<Integer, String> producer;
	private final static Properties properties = new Properties();

	static {
		try {
			InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			properties.load(resourceStream);
		} catch (IOException e) {
			System.err.println("Error while loading kafka  config properties");
		}

		producer = new KafkaProducer<Integer, String>(properties);
	}

	public static void main(String[] args) throws InterruptedException {
		String topic = "test";

		for (int i = 0; i < 120; i++) {
			String messageStr = i + ". Message sent at: " + new Date();
			send(topic, messageStr);
		}
		producer.close();
		System.out.println("Message sent");
	}

	/**
	 * Send message to kafka synchronously
	 * 
	 * @param topic
	 *            kafka topic
	 * @param messageStr
	 *            message string to send
	 */
	public static void send(final String topic, final String messageStr) {
		ProducerRecord<Integer, String> data = new ProducerRecord<Integer, String>(topic, messageStr);
		producer.send(data);
	}
}
