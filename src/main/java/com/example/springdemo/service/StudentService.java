package com.example.springdemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springdemo.mapper.StudentMapper;
import com.example.springdemo.pojo.entity.StudentEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author WangZhen
 * @Date 2024/12/18 22:43
 */
@Service
@AllArgsConstructor
public class StudentService extends ServiceImpl<StudentMapper, StudentEntity> {
    private StringRedisTemplate stringRedisTemplate;

    public String addQuota(String activityId, Long addQuota){
        final String REDIS_KEY = "activity:" + activityId;
        final String luaScript = """
                -- increment.lua
                local current = redis.call('GET', KEYS[1])
                current = tonumber(current)
                if current == nil or current == 'nil' or current == '' or current == 'null' then
                    current = 0
                end
                local incremented = current + tonumber(ARGV[1])
                incremented = tostring(incremented)
                redis.call('SET', KEYS[1], incremented)
                local result = {
                    incremented = incremented,
                    argv1 = ARGV[1]
                }
                return result
                """;
        // 封装 RedisScript
        RedisScript<String> redisScript = RedisScript.of(luaScript, String.class);

        // 执行脚本
        return stringRedisTemplate.execute(
                redisScript, // Lua 脚本
                List.of(REDIS_KEY), // KEYS 参数
                String.valueOf(addQuota) // ARGV 参数
        );
    }

    // test not pass
    public Object addQuota2(String activityId, Long addQuota){
        final String REDIS_KEY = "activity:" + activityId;
        final String luaScript = """
                -- increment.lua
                local current = redis.call('GET', KEYS[1])
                current = tonumber(current)
                if current == nil or current == 'nil' or current == '' or current == 'null' then
                    current = 0
                end
                local incremented = current + tonumber(ARGV[1])
                incremented = tostring(incremented)
                redis.call('SET', KEYS[1], incremented)
                local result = {
                    incremented = incremented,
                    argv1 = ARGV[1]
                }
                return { incremented = incremented, argv1 = ARGV[1] }
                """;
        // 封装 RedisScript
        RedisScript<List> redisScript = RedisScript.of(luaScript, List.class);

        // 执行脚本
        List execute = stringRedisTemplate.execute(
                redisScript, // Lua 脚本
                List.of(REDIS_KEY), // KEYS 参数
                String.valueOf(addQuota) // ARGV 参数
        );
        return execute;
    }

    // test pass
    public Map<String, String> addQuota3(String activityId, Long addQuota){
        final String REDIS_KEY = "activity:" + activityId;
        final String luaScript = """
                -- increment.lua
                local current = redis.call('GET', KEYS[1])
                current = tonumber(current)
                if current == nil or current == 'nil' or current == '' or current == 'null' then
                    current = 0
                end
                local incremented = current + tonumber(ARGV[1])
                incremented = tostring(incremented)
                redis.call('SET', KEYS[1], incremented)
                return {ARGV[1], incremented}
                """;
        // 封装 RedisScript
        RedisScript<List> redisScript = RedisScript.of(luaScript, List.class);

        // 执行脚本
        List list = stringRedisTemplate.execute(
                redisScript, // Lua 脚本
                List.of(REDIS_KEY), // KEYS 参数
                String.valueOf(addQuota) // ARGV 参数
        );
        return listToMap(list, "argv1", "incremented", "test");
    }

    private Map<String, String> listToMap(List list, String ...keys){
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < list.size() && i < keys.length; i++) {
            result.put(keys[i], list.get(i).toString());
        }
        return result;
    }
}
