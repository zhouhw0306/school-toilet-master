package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.constant.Result;
import com.example.constant.ResultCode;
import com.example.po.Comment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhw
 */
@RestController
@RequestMapping("/api/comm")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/addComm")
    public Result submitComm(Comment comm){
        try {
            boolean flag = commentService.save(comm);
            return flag?Result.success():Result.error(ResultCode.ERROR);
        }catch (Exception e){
            return Result.error(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
    }

    @GetMapping("/getComm")
    public Result getCommList(Integer foreignId){
        Result result = new Result();
        try{
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("foreignId",foreignId);
            List<Comment> commentList = commentService.list(queryWrapper);
            result.setData(commentList);
            result.setResultCode(ResultCode.SUCCESS);
        }catch (Exception e){
            result.setResultCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
        return result;
    }
}
