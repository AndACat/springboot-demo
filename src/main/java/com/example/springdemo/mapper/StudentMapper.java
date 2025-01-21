package com.example.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springdemo.pojo.entity.StudentEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author WangZhen
 * @Date 2024/12/18 23:40
 */
public interface StudentMapper extends BaseMapper<StudentEntity> {
    int updateBatch(List<StudentEntity> list);

    int updateBatchSelective(List<StudentEntity> list);

    int batchInsert(@Param("list") List<StudentEntity> list);

    int insertOrUpdate(StudentEntity record);

    int insertOrUpdateSelective(StudentEntity record);
}