package com.gupao.web.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by
 * on 17/3/14.
 * Description:
 */
@Component
public class MonitorHelper {
    private static final Logger logger = LoggerFactory.getLogger(MonitorHelper.class);

    @Autowired
    private RedisTemplate redisTemplate;

    public void count(final String uri) {
        final long seconds = System.currentTimeMillis() / 1000;
        redisTemplate.executePipelined(new RedisCallback<Object>() {
                    public Object doInRedis(RedisConnection connection) throws DataAccessException {
                        for (Integer prec : RedisConstants.PRECISION) {
                            long startSlice = seconds / prec * prec;
                            String hash = String.format("%s:%s", prec, uri);
                            connection.zAdd("known:".getBytes(), 0, hash.getBytes());
                            connection.hIncrBy(("count:" + hash).getBytes(), String.valueOf(startSlice).getBytes(), 1l);
                        }
                logger.info("监控记数执行完成for {}", uri);
                return null;
            }
        });
    }

    public static void main(String args[]) {
        // 5  8  16
        //3    3 6 9 12
        //10   10 20
        //20
        System.out.println(8 / 3 * 3);
    }
}
