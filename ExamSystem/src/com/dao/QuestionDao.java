package com.dao;

import com.entity.Question;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionDao {

    public QuestionDao() {
    }

    public static int questionAdd(Question question) {
        Connection con=null;
        PreparedStatement state=null;
        String sql="insert into question(title,optionA,optionB,optionC,optionD,answer)values(?,?,?,?,?,?)";
        int result=0;
        try {
            con= DBUtil.getConnection();
            state= con.prepareCall(sql);
            state.setString(1,question.getTitle());
            state.setString(2,question.getOptionA());
            state.setString(3,question.getOptionB());
            state.setString(4,question.getOptionC());
            state.setString(5,question.getOptionD());
            state.setString(6,question.getAnswer());
            result=state.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(null,state,con);
        }
        return result;
    }
}
