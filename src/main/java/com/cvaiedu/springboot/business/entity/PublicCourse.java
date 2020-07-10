package com.cvaiedu.springboot.business.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * public_course
 * @author 
 */
@Accessors(chain = true)
@NoArgsConstructor
@Data
public class PublicCourse implements Serializable {
    public Long id;

    /**
     * 标题
     */
    private String title;

    public Long teacherId;

    private String desc;

    @TableField(exist = false)
    private List<Student> students;

    @TableField(exist = false)
    private String teacherName;

    @TableField(exist = false)
    private String teacherTag;

    @TableField(exist = false)
    private String teacherImg;

    private static final long serialVersionUID = 1L;

}