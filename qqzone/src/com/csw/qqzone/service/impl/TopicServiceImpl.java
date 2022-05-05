package com.csw.qqzone.service.impl;

import com.csw.qqzone.dao.TopicDAO;
import com.csw.qqzone.pojo.Reply;
import com.csw.qqzone.pojo.Topic;
import com.csw.qqzone.pojo.UserBasic;
import com.csw.qqzone.service.ReplyService;
import com.csw.qqzone.service.TopicService;
import com.csw.qqzone.service.UserBasicService;


import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO = null ;
    private ReplyService replyService ;
    private UserBasicService userBasicService ;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic getTopic(Integer id){
        Topic topic = topicDAO.getTopic(id);
        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;
    }

    @Override
    public void delTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        if(topic!=null){
            replyService.delReplyList(topic);
            topicDAO.delTopic(topic);
        }
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);

        return topic ;
    }
}
