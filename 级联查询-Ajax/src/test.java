import dao.ProvinceDao;
import enity.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws JsonProcessingException {
        /*Province province=new Province();
        province.setId(2);

        province=ProvinceDao.queryProvinceById(province);
      System.out.println(province); */
       /* Province province=new Province(1,"河北","冀","石家庄");
        //使用jackson转成json
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(province);
        System.out.println(json);*/
        List<Province> list=new ArrayList<>();
        list= ProvinceDao.queryProvince();
        String json=null;
        if(list.size()!=0){
            ObjectMapper obj=new ObjectMapper();
            json=obj.writeValueAsString(list);
        }

        System.out.print(json);



    }
}
