package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${cfg.basePath}.common.Result;
import ${cfg.basePath}.common.util.PageUtils;
import ${cfg.basePath}.common.validator.ValidatorUtils;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if cfg.urlPrefix??>${cfg.urlPrefix}</#if><#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${cfg.entityName}</#if>")
@Api(value = "result",description = "${table.comment!}相关操作")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${cfg.entityName}Service;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = ${cfg.entityName}Service.queryPage(params);
        return Result.ok().put("page", page);
    }


    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public Result info(@PathVariable("id") String id){
       ${entity} ${cfg.entityName} = ${cfg.entityName}Service.getById(id);
        return Result.ok().put("${cfg.entityName}", ${cfg.entityName});
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Result save(@RequestBody ${entity} ${cfg.entityName}){
        ValidatorUtils.validateEntity(${cfg.entityName});
        ${cfg.entityName}Service.save(${cfg.entityName});
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@RequestBody ${entity} ${cfg.entityName}){
        ValidatorUtils.validateEntity(${cfg.entityName});
        ${cfg.entityName}Service.updateById(${cfg.entityName});
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result delete(@RequestBody String[] ids){
        ${cfg.entityName}Service.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
</#if>
