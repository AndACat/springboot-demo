package com.javatoai.business;

import cn.hutool.json.JSONUtil;
import com.javatoai.business.mapper.StudentMapper;
import com.javatoai.business.pojo.entity.StudentEntity;
import com.javatoai.business.service.QuotaService;
import com.javatoai.business.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
//@TestPropertySource(properties = {
//        "server.port=8081"
//})
@MapperScan("com.javatoai.springdemo.mapper")
//@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
class SpringDemoApplicationTests {

//    @Autowired
    @Autowired
    private StudentService studentService;

    @Autowired
    private QuotaService quotaService;

    @MockBean
    private StudentMapper studentMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        studentEntity.setUsername("刘");
        studentEntity.setAge((byte) 18);
        studentEntity.setSex((byte) 1);
        studentEntity.setSchool("");

        when(studentMapper.selectList(any())).thenReturn(Arrays.asList(studentEntity));
        when(studentMapper.selectList(any())).thenReturn(Arrays.asList(studentEntity));
        doAnswer(invocation -> {
            // 执行你想要的操作，例如修改 studentEntity 的属性
            studentEntity.setAge((byte) 18);
            // 由于 selectList 返回值是 void，所以我们不需要返回任何东西
            return null; // void 方法返回 null
        }).when(studentMapper).selectList(any());

        List<StudentEntity> studentEntityList = studentService.lambdaQuery()
                .notIn(StudentEntity::getUsername, "666")
                .list();
        System.out.println(JSONUtil.toJsonStr(studentEntityList));

        // 断言结果
        assertNotNull(studentEntityList);
        assertEquals(1, studentEntityList.size());
        assertEquals("刘", studentEntityList.get(0).getUsername());

    }

    @Test
    public void test2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk());
    }

    @Test
    public void test3() throws Exception {
//        Object string = studentService.addQuota("act001", System.currentTimeMillis());
        Object string = quotaService.addQuota3("act001", System.currentTimeMillis());
        System.out.println("string = " + JSONUtil.toJsonStr(string));
        System.out.println("string type = " + string.getClass());
    }

}
