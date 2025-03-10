package com.javatoai.business;

import cn.hutool.core.util.XmlUtil;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.javatoai.business.mapper.StudentMapper;
import com.javatoai.business.pojo.entity.StudentEntity;
import com.javatoai.business.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

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
