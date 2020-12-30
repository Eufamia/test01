import com.dao.ProvinceDao;
import com.enity.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {
    public static void main(String[] args) throws JsonProcessingException {
        /*Province province=new Province();
        province.setId(2);

        province=ProvinceDao.queryProvinceById(province);
      System.out.println(province); */
        Province province=new Province(1,"河北","冀","石家庄");
        //使用jackson转成json
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(province);
        System.out.println(json);



    }
}
