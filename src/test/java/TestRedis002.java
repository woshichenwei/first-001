import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestRedis002 {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public  void  testSetValue(){

          //boundHashOps 绑定set类型
        redisTemplate.boundHashOps("h2").put("id","0001");
        redisTemplate.boundHashOps("h2").put("age","18");
        redisTemplate.boundHashOps("h2").put("sex","men");
        redisTemplate.boundHashOps("h2").put("adress","湖北襄阳");
        redisTemplate.boundHashOps("h2").put("phone","12313213233");
        redisTemplate.boundHashOps("h2").put("name","陈威");
    }
    @Test
    public  void  testGetValue(){

        String id=(String) redisTemplate.boundHashOps("h2").get("id");
        String age=(String) redisTemplate.boundHashOps("h2").get("age");
        String sex=(String) redisTemplate.boundHashOps("h2").get("sex");
        String adress=(String) redisTemplate.boundHashOps("h2").get("adress");
        String phone=(String) redisTemplate.boundHashOps("h2").get("phone");
        String name=(String) redisTemplate.boundHashOps("h2").get("name");
        System.out.println("id:"+id);
        System.out.println("age:"+age);
        System.out.println("sex:"+sex);
        System.out.println("adress:"+adress);
        System.out.println("phone:"+phone);
        System.out.println("name:"+name);
        //获取所有值
        List list = redisTemplate.boundHashOps("h2").values();

        for(Object l:list){
          System.out.println(l);
        }
        //获取所有键,键不能重复是set集合
        Set list1= (Set) redisTemplate.boundHashOps("h2").keys();
        for (Object o:list1){
            System.out.println(o);
        }
        //获取所有键值对，entries封装的是键值对对象
        Map entries=  redisTemplate.boundHashOps("h2").entries();
        Set set = (Set) entries.entrySet();
        for(Object s:set){
            System.out.println(s);
        }
    }
    @Test
    public  void  testDelete(){

        redisTemplate.boundHashOps("h2").delete("id");
    }


}




