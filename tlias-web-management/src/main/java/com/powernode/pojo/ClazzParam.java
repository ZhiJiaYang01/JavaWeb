package com.powernode.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzParam {
    private Integer page = 1;

    private Integer pageSize = 10;

    private String name; //班级名称

    private Integer masterId; //班主任

    private String room; //班级教室

    private LocalDate begin; //开课时间

    private LocalDate end; //结课时间

    private String status; //班级状态 - 未开班 , 在读 , 已结课
}
