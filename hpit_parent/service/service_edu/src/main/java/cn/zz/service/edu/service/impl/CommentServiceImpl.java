package cn.zz.service.edu.service.impl;

import cn.zz.service.edu.entity.Comment;
import cn.zz.service.edu.mapper.CommentMapper;
import cn.zz.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author qf
 * @since 2021-06-15
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
