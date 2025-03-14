package com.javatoai.business.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javatoai.business.mapper.StudentMapper;
import com.javatoai.business.pojo.entity.StudentEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @Date 2024/12/18 22:43
 */
@Service
@AllArgsConstructor
public class StudentService extends ServiceImpl<StudentMapper, StudentEntity> {

}
