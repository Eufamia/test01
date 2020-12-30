package dao;

import enity.Province;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao {
    //使用jdbc访问数据库
    public static Province queryProvinceById(String id){
        Connection con=null;
        PreparedStatement state=null;
        ResultSet resultSet=null;
        String sql="select pname,capital,sname from province where id=?";
        Province province=null;
        try {
            con= DBUtil.getConnection();
            state=con.prepareCall(sql);
            state.setInt(1,Integer.valueOf(id));
            resultSet=state.executeQuery();
            while (resultSet.next()){
               String pname= resultSet.getString("pname");
              String capital=  resultSet.getString("capital");
              String sname=resultSet.getString("sname");
                province=new Province(Integer.valueOf(id),pname,sname,capital);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(resultSet,state,con);
        }
        return province;
    }
    public static List<Province> queryProvince(){
        Connection con=null;
        PreparedStatement state=null;
        ResultSet resultSet=null;
        String sql="select id,pname,capital,sname from province order by id";
        Province province=null;
        List<Province> list=new ArrayList<>();
        try {
            con= DBUtil.getConnection();
            state=con.prepareCall(sql);
            resultSet=state.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String pname= resultSet.getString("pname");
                String capital=  resultSet.getString("capital");
                String sname=resultSet.getString("sname");
                province=new Province(id,pname,sname,capital);
                list.add(province);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(resultSet,state,con);
        }
        return list;
    }
}
