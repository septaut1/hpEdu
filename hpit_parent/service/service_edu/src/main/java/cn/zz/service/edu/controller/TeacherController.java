package cn.zz.service.edu.controller;


import cn.zz.service.edu.entity.Teacher;
import cn.zz.service.edu.entity.vo.TeacherQuery;
import cn.zz.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author qf
 * @since 2021-06-15
 */
@RestController
@RequestMapping("/edu/teacher")
@Api(value = "讲师接口")
public class TeacherController {

    //由于不推荐使用属性注入方式（@Autowired），故使用构造方法方式
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //获取teacher表所有数据
    @GetMapping("findAll")
    @ApiOperation(value = "获取所有讲师的信息")
    public List<Teacher> findAll(){
        return teacherService.list();
    }

    //新增讲师
    @PostMapping("save")
    @ApiOperation(value = "新增讲师")
    public boolean save(@RequestBody Teacher teacher){
        return teacherService.save(teacher);
    }

    //根据ID查询讲师
    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询讲师")
    public Teacher getTeacherById(@PathVariable String id){
        return teacherService.getById(id);
    }

    //修改讲师信息
    @PutMapping("update")
    @ApiOperation(value = "修改讲师信息")
    public boolean updateTeacherById(@RequestBody Teacher teacher){
        return teacherService.updateById(teacher);
    }

    //根据id删除讲师信息（为逻辑删除，只是不显示，不是真的从数据库删除）
    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除讲师信息")
    public boolean del(@PathVariable String id){
        return teacherService.removeById(id);
    }

   /* //分页
    @PostMapping("{current}/{limit}")
    public List<Teacher> pageList(@PathVariable Long current,
                                  @PathVariable Long limit){

        //1.创建page对象
        Page<Teacher> teacherPage=new Page<>(current,limit);
        //2.进行分页
        teacherService.page(teacherPage);
        System.out.println(teacherPage.getTotal());//总记录数
        System.out.println(teacherPage.getSize());//每页显示的条数
        System.out.println(teacherPage.getCurrent());//当前页
        teacherPage.getRecords().forEach(System.out::println);
        return teacherPage.getRecords();
    }*/

    //带条件分页查询
    @PostMapping("{current}/{limit}")
    @ApiOperation(value = "根据条件分页查询")
    public List<Teacher> pageList(@PathVariable Long current,
                                  @PathVariable Long limit,
                                  @ApiParam(required = false) @RequestBody TeacherQuery teacherQuery){
        //创建page对象
        Page<Teacher> teacherPage= new Page<>(current,limit);
        // 2.调用service 自定义的方法pageQuery
        IPage<Teacher> teacherIPage = teacherService.pageQuery(teacherPage, teacherQuery);
        return teacherIPage.getRecords();

    }

}

