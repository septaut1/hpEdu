package cn.zz.service.edu.service.impl;

import cn.zz.service.edu.entity.Teacher;
import cn.zz.service.edu.entity.vo.TeacherQuery;
import cn.zz.service.edu.mapper.TeacherMapper;
import cn.zz.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author qf
 * @since 2021-06-15
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public IPage<Teacher> pageQuery(Page<Teacher> teacherPage, TeacherQuery teacherQuery) {
        //判断是普通分页查询还是带条件查询，根据teacherQuery是否为null值
        if (teacherQuery==null){
            return baseMapper.selectPage(teacherPage,null);
        }
        String name=teacherQuery.getName();
        Integer level=teacherQuery.getLevel();
        String begin=teacherQuery.getBegin();
        String end=teacherQuery.getEnd();
        // 条件构造器
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        // 依次判断属性，如果不等于空，那么添加查询条件
        if (!StringUtils.isEmpty(name)) {
            wrapper.likeRight("name", name);
        }

        if (level!=null) {
            wrapper.eq("level", level);
        }

        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified", end);
        }
        return baseMapper.selectPage(teacherPage,wrapper);
    }
}
