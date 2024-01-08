package com.example;


import redis.clients.jedis.Jedis;

public class RedisExample {
    public static void main(String[] args) {
        // Connect to Redis server
        Jedis jedis = new Jedis("localhost");

        try {
            // Fetch data from the list
            System.out.println("Data in the list:");
            jedis.lrange("mylist", 0, -1).forEach(System.out::println);
        } finally {
            // Close the connection
            jedis.close();
        }
    }
}
