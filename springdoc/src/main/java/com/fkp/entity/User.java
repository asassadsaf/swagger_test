package com.fkp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Schema(description = "用户id")
    private String id;
    @Schema(description = "用户名称")
    private String name;
    @Schema(description = "用户年龄")
    private Integer age;
    @Schema(description = "用户地址")
    private String address;
}
