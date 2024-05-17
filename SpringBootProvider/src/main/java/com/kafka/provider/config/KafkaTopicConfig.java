package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic generateTopic(){
        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // estamos configurando como se van a borrar los mensajes CLEANUP_POLICY_DELETE elimina y CLEANUP_POLICY_COMPACT mantiene el mas actual
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //Cuanto va ha ser el tiempo que duran los mensajes en el topic por defecto viene en -1 nunca se va ha borrar
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Cual es el tamaño maximo que pueden tener los segmentos en bytes
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); //tamaño maximo de un mensaje en bytes

        return TopicBuilder.name("estudiantes-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
