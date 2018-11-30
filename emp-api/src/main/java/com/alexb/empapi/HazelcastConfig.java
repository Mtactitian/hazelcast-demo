package com.alexb.empapi;

import com.google.common.collect.ImmutableMap;
import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.eureka.one.EurekaOneDiscoveryStrategyFactory;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

import static java.util.Collections.singletonMap;

//@Configuration
public class HazelcastConfig {


//    @Bean
    public Config config() {
        Config config = new Config();

        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getAwsConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getEurekaConfig().setProperty("name","HAZELCAST");

        config.getNetworkConfig().getJoin().getDiscoveryConfig()
                .addDiscoveryStrategyConfig(new DiscoveryStrategyConfig("com.hazelcast.eureka.one.EurekaOneDiscoveryStrategy",
                       ImmutableMap.of("self-registration",true,
                               "namespace","hazelcast",
                               "shouldUseDns","false")));

        config.setInstanceName("hazelcast-instance");
        config.addMapConfig(
                new MapConfig()
                        .setName("configuration")
                        .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                        .setEvictionPolicy(EvictionPolicy.LRU)
                        .setTimeToLiveSeconds(-1));
        return config;
    }


//    @Bean
    public HazelcastInstance instance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }
}
