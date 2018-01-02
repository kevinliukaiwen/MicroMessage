package com.cims.service;

import com.cims.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/12/31.
 */

/**
 * 维护业务的相关功能
 */
public class MaintainService {
    private MessageDao messageDao = new MessageDao();

    /**
     * 单条删除
     * @param id
     */
    public void deleteOne(int id) {
        messageDao.deleteOne(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteBatch(String[] ids) {
        List<Integer> list  =new ArrayList<>();
        for(String id:ids) {
            list.add(Integer.valueOf(id));
        }
        messageDao.deleteBatch(list);
    }
}
