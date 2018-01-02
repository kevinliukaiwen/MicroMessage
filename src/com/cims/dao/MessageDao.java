package com.cims.dao;

import com.cims.bean.Message;
import com.cims.dbacess.DBAcess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/12/29.
 */
public class MessageDao {
    private DBAcess dbAcess = new DBAcess();
    private SqlSession sqlSession = null;
    //通过数据库查询得到消息列表
//    public List<Message> query(String command,String description) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/micromessage";
//            String username = "root";
//            String password = "123";
//            Connection conn = DriverManager.getConnection(url, username, password);
//            List<String> paramList = new ArrayList<>();
//            StringBuilder sql = new StringBuilder("select COMMAND,DESCRIPTION,CONTENT from message where 1 = 1");
//            if (command != null && !command.trim().equals("")) {
//                sql.append(" and COMMAND = ?");
//                paramList.add(command);
//            }
//            if (description != null && !description.trim().equals("")) {
//                sql.append(" and DESCRIPTION like '%' ? '%'");
//                paramList.add(description);
//            }
//            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//            for (int i = 0; i < paramList.size(); i++) {
//                pstmt.setString(i + 1, paramList.get(i));
//            }
//            ResultSet rs = pstmt.executeQuery();
//            List<Message> messagelist = new ArrayList<>();
//            while (rs.next()) {
//                Message message = new Message();
//                message.setCommand(rs.getString("COMMAND"));
//                message.setContent(rs.getString("CONTENT"));
//                message.setDescription(rs.getString("DESCRIPTION"));
//                messagelist.add(message);
//            }
//            return messagelist;
//        }catch (ClassNotFoundException ex) {
//           throw new RuntimeException(ex);
//        }catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
    public List<Message> query(String command,String description) {
        List<Message> messagelist = new ArrayList<>();
        try {
            sqlSession = dbAcess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            messagelist = sqlSession.selectList("Message.query",message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null)
                sqlSession.close();
        }
        return messagelist ;
    }

    /**
     * 单条删除语句
     * @param id
     */
    public void deleteOne(int id) {
        try {
            sqlSession = dbAcess.getSqlSession();
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null)
                sqlSession.close();
        }
    }
    /**
     * 批量删除
     * @param list
     */
    public void deleteBatch(List<Integer> list) {
        try {
            sqlSession = dbAcess.getSqlSession();
            sqlSession.delete("Message.deleteBatch",list);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null)
                sqlSession.close();
        }
    }

//    public static void main(String[] args) {
//        MessageDao messageDao = new MessageDao();
//        messageDao.query("","");
//    }
}
