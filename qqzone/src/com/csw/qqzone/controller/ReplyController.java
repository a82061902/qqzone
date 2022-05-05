package com.csw.qqzone.controller;

import com.csw.qqzone.pojo.Reply;
import com.csw.qqzone.pojo.Topic;
import com.csw.qqzone.pojo.UserBasic;
import com.csw.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;

public class ReplyController {

    private ReplyService replyService ;

    public String addReply(String content ,Integer topicId , HttpSession session){
        UserBasic author = (UserBasic)session.getAttribute("userBasic");
        Reply reply = new Reply(content , LocalDateTime.now() , author , new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
        // detail.html
    }

    public String delReply(Integer replyId , Integer topicId){
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
}
