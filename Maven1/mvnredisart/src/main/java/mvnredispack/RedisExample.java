package mvnredispack;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.util.List;


public class RedisExample {
    public static void main(String[] args) {
        // Create JedisPoolConfig
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        // Create JedisPool
        try (JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379)) {
            // Get a Jedis instance from the pool
            try (Jedis jedis = jedisPool.getResource()) {
                // Fetch the list data
                List<String> myListData = jedis.lrange("mylist", 0, -1);

                // Print the fetched data
                System.out.println("Data in mylist:");
                for (String value : myListData) {
                    System.out.println(value);
                }
            }
        }
    }
}
