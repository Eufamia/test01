import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
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

@WebServlet(name = "ProvinceServlet")
public class ProvinceServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Province> list=new ArrayList<>();
        list= ProvinceDao.queryProvince();
       String json=null;
        if(list.size()!=0){
            ObjectMapper obj=new ObjectMapper();
            json=obj.writeValueAsString(list);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out= response.getWriter();
        out.print(json);
    }
}
