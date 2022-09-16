package com.fkp.controller;

import com.fkp.entity.User;
import com.fkp.param.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "用户管理")
public class UserController {

    @Operation(summary = "新增用户")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "400", description = "请求参数没填好"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponse<User> add(@RequestBody User user){
        return BaseResponse.success(user);
    }

    @Operation(summary = "修改用户")
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public BaseResponse<User> modify(@RequestBody User user){
        return BaseResponse.success(user);
    }

    @Operation(summary = "删除用户")
    @Parameters(value = {
            @Parameter(name = "id", description = "用户id", required = true, in = ParameterIn.QUERY)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public BaseResponse<String> delete(String id){
        return BaseResponse.success(id);
    }

    @Operation(summary = "查询用户", security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public BaseResponse<String> query(String id){
        return BaseResponse.success(id);
    }
}
