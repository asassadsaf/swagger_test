package com.fkp.controller;

import com.fkp.entity.User;
import com.fkp.param.BaseResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "用户管理")
public class UserController {

    @ApiOperation(value = "新增用户")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    //post请求也可以通过@RequestParam获取Query Params的参数，测试swagger添加query类型的ApiKey
    public BaseResponse<User> add(@RequestBody User user, @RequestParam(value = "param", required = false) String param){
        System.out.println(param);
        return BaseResponse.success(user);
    }

    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public BaseResponse<User> modify(@RequestBody User user){
        return BaseResponse.success(user);
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public BaseResponse<String> delete(String id){
        return BaseResponse.success(id);
    }

    @ApiOperation(value = "查询用户", authorizations = {@Authorization(value = "queryUserAuthorization")})
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public BaseResponse<String> query(String id){
        return BaseResponse.success(id);
    }
}
