package com.example.springdemo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhen
 * @Date 2024/12/18 23:40
 */
@ApiModel(description = "student")
@Data
@TableName(value = "student")
public class StudentEntity {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Long id;

    @TableField(value = "username")
    @ApiModelProperty(value = "")
    private String username;

    @TableField(value = "age")
    @ApiModelProperty(value = "")
    private Byte age;

    @TableField(value = "sex")
    @ApiModelProperty(value = "")
    private Byte sex;

    @TableField(value = "school")
    @ApiModelProperty(value = "")
    private String school;
}