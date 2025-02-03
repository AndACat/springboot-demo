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
 *
 * @Date 2024/12/18 22:43
 */
@Service
@AllArgsConstructor
public class StudentService extends ServiceImpl<StudentMapper, StudentEntity> {

}
