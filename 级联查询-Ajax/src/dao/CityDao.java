package dao;

import enity.City;
import enity.Province;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    public static List<City> queryCityByProid(String proid) {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet resultSet = null;
        String sql = "select id,cname,pid from city where pid=?";
        City city = null;
        List<City> list=new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            state = con.prepareCall(sql);
            state.setInt(1, Integer.valueOf(proid));
            resultSet = state.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String cname = resultSet.getString("cname");
                int pid=resultSet.getInt("pid");
                city=new City(id,cname,pid);
                list.add(city);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,state,con);
        }
        return list;
    }
}
