package com.cims.service;

import com.cims.bean.Message;
import com.cims.dao.MessageDao;

import java.util.List;

/**
 * Created by kevin on 2017/12/29.
 */
public class ListService {
    private MessageDao messageDao = new MessageDao();
    //调用dao层的方法，得到消息列表
    public List<Message> query(String command,String description) {
        return messageDao.query(command,description);
    }
}
