import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CityDao;
import dao.ProvinceDao;
import enity.City;
import enity.Province;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CityServlet")
public class CityServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> list=new ArrayList<>();
        String id=request.getParameter("pid");
        list= CityDao.queryCityByProid(id);
        String json=null;
        if(list.size()!=0){
            ObjectMapper obj=new ObjectMapper();
            json=obj.writeValueAsString(list);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out= response.getWriter();
        out.print(json);
        //System.out.println(json);
    }
}
