package cn.zz.service.edu.service;

import cn.zz.service.edu.entity.Teacher;
import cn.zz.service.edu.entity.vo.TeacherQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author qf
 * @since 2021-06-15
 */
public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> pageQuery(Page<Teacher> teacherPage, TeacherQuery teacherQuery);
}
