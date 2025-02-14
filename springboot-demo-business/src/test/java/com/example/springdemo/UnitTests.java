package com.example.springdemo;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.example.springdemo.mapper.StudentMapper;
import com.example.springdemo.pojo.entity.StudentEntity;
import com.example.springdemo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(MockitoExtension.class)
class UnitTests {
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentMapper studentMapper;

    @Mock
    private MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean;

    @BeforeEach
    public void beforeEach() {
//        MockitoAnnotations.openMocks(this);
    }


    @Test
    void contextLoads() {
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setId(1L);
//        studentEntity.setUsername("刘");
//        studentEntity.setAge((byte) 18);
//        studentEntity.setSex((byte) 1);
//        studentEntity.setSchool("");
//
//        // Mock lambdaQuery() 的行为
//        LambdaQueryChainWrapper<StudentEntity> mockQueryWrapper = mock(LambdaQueryChainWrapper.class);
//        when(studentService.lambdaQuery()).thenReturn(mockQueryWrapper);
//
//        // Mock list() 方法的行为
//        when(mockQueryWrapper.list()).thenReturn(Arrays.asList(studentEntity));
//
//        List<StudentEntity> studentEntityList = studentService.lambdaQuery().list();
//        System.out.println(JSONUtil.toJsonStr(studentEntityList));
//
//        // 断言结果
//        assertNotNull(studentEntityList);
//        assertEquals(1, studentEntityList.size());
//        assertEquals("刘", studentEntityList.get(0).getUsername());

    }

    @Test
    public void convert(){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(2L);
        studentEntity.setUsername("张三");
        studentEntity.setAge((byte) 18);
        studentEntity.setSex((byte) 1);
        studentEntity.setSchool("光明中学");

        System.out.println(XmlUtil.beanToXml(studentEntity, "http:.."));
    }

}
