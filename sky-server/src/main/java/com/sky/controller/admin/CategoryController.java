package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类管理
 */
@RestController
@RequestMapping("/admin/category")
@Api(tags = "Category Apis")
@Slf4j
public class CategoryController {

//    @Autowired
//    private CategoryService categoryService;
//
//    /**
//     * 新增分类
//     * @param categoryDTO
//     * @return
//     */
//    @PostMapping
//    @ApiOperation("新增分类")
//    public Result<String> save(@RequestBody CategoryDTO categoryDTO){
//        log.info("新增分类：{}", categoryDTO);
//        categoryService.save(categoryDTO);
//        return Result.success();
//    }
//
//    /**
//     * 分类分页查询
//     * @param categoryPageQueryDTO
//     * @return
//     */
//    @GetMapping("/page")
//    @ApiOperation("分类分页查询")
//    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
//        log.info("分页查询：{}", categoryPageQueryDTO);
//        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
//        return Result.success(pageResult);
//    }
//
//    /**
//     * 删除分类
//     * @param id
//     * @return
//     */
//    @DeleteMapping
//    @ApiOperation("删除分类")
//    public Result<String> deleteById(Long id){
//        log.info("删除分类：{}", id);
//        categoryService.deleteById(id);
//        return Result.success();
//    }
//
//    /**
//     * 修改分类
//     * @param categoryDTO
//     * @return
//     */
//    @PutMapping
//    @ApiOperation("修改分类")
//    public Result<String> update(@RequestBody CategoryDTO categoryDTO){
//        categoryService.update(categoryDTO);
//        return Result.success();
//    }
//
//    /**
//     * 启用、禁用分类
//     * @param status
//     * @param id
//     * @return
//     */
//    @PostMapping("/status/{status}")
//    @ApiOperation("启用禁用分类")
//    public Result<String> startOrStop(@PathVariable("status") Integer status, Long id){
//        categoryService.startOrStop(status,id);
//        return Result.success();
//    }
//
//    /**
//     * 根据类型查询分类
//     * @param type
//     * @return
//     */
//    @GetMapping("/list")
//    @ApiOperation("根据类型查询分类")
//    public Result<List<Category>> list(Integer type){
//        List<Category> list = categoryService.list(type);
//        return Result.success(list);
//    }

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    @ApiOperation("Query category by type")
    public Result<List<Category>> list(Integer type) {
        List<Category> categories = categoryService.list(type);
        return Result.success(categories);
    }

    @PutMapping
    @ApiOperation("Update category")
    public Result update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("Query categories by page")
    public Result<PageResult> queryByPage(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult = categoryService.queryByPage(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/status/{status}")
    @ApiOperation("Enable or disable category")
    public Result enableOrDisable(@PathVariable Integer status, Long id) {
        categoryService.enableOrDisable(status, id);
        return Result.success();
    }

    @PostMapping
    @ApiOperation("Create new category")
    public Result create(@RequestBody CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("Delete category")
    public Result deleteById(Long id) {
        categoryService.deleteById(id);
        return Result.success();
    }
}