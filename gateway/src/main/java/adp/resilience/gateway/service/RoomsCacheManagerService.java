package adp.resilience.gateway.service;

import java.time.Duration;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.stereotype.Component;

import adp.resilience.gateway.model.dto.RoomDto;

@Component(value = "roomsCacheManagerService")
public class RoomsCacheManagerService {
    public final String ROOMS_CACHE_KEY = "rooms";
    public final String SINGLE_ROOM_CACHE_KEY = "room-id";

    public final CacheManager cacheManager = CacheManagerBuilder
            .newCacheManagerBuilder()
            .withCache(ROOMS_CACHE_KEY, CacheConfigurationBuilder
                    .newCacheConfigurationBuilder(String.class, RoomDto[].class,
                            ResourcePoolsBuilder.heap(10))
                    .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(5))))
            .withCache(SINGLE_ROOM_CACHE_KEY, CacheConfigurationBuilder
                    .newCacheConfigurationBuilder(Long.class, RoomDto.class,
                            ResourcePoolsBuilder.heap(10))
                    .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(5))))
            .build(true);

}
