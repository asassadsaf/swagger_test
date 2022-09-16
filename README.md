swagger是规范，springfox和springdoc是实现
springfox现已停止维护，支持swagger2和swagger3
1.最新版本springboot集成springfox
2.最新版本springboot集成springdoc

-------------------------------------------------------
1.springfox
参考http://t.csdn.cn/pGQmM
```
@Api 对整个控制层的设置 可以设置tags，tags为数组类型，设置多个会在页面中显示多个控制层
@ApiIgnore 用来排除不需要的接口信息
@ApiOperation 给方法添加描述和提示信息 ，其value 属性必须有值
@ApiParam @ApiImplicitParams，@ApiImplicitParam注解来给参数增加说明
@ApiModel和@ApiModelProperty主要是作用到实体类上当接口中有一个方法的返回值为该对象时就会在文档的model中显示该类的信息
```
-----------------------------------------------------------
2.springdoc
参考http://t.csdn.cn/jtzdB
```
swagger 3 注释替换 swagger 2 注释（它已经包含在springdoc-openapi-ui依赖项中）。swagger 3 注释的包是io.swagger.v3.oas.annotations.

@Api→@Tag
@ApiIgnore→@Parameter(hidden = true)或@Operation(hidden = true)或@Hidden
@ApiImplicitParam→@Parameter
@ApiImplicitParams→@Parameters
@ApiModel→@Schema
@ApiModelProperty(hidden = true)→@Schema(accessMode = READ_ONLY)
@ApiModelProperty→@Schema
@ApiOperation(value = "foo", notes = "bar")→@Operation(summary = "foo", description = "bar")
@ApiParam→@Parameter
@ApiResponse(code = 404, message = "foo")→@ApiResponse(responseCode = "404", description = "foo")
```
