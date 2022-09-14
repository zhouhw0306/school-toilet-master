package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.po.Comment;
import com.example.service.CommentService;
import com.example.mappers.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author 24668
* @description 针对表【tbl_comment】的数据库操作Service实现
* @createDate 2022-09-12 08:53:54
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




