package com.csw.qqzone.service;

import com.csw.qqzone.pojo.Topic;
import com.csw.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic) ;

    Topic getTopic(Integer id);

    //删除日志
    void delTopic(Integer id);
    //获取特定日志信息
    Topic getTopicById(Integer id);


}
