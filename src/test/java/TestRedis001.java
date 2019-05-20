import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestRedis001 {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public  void  testSetValue(){

          //boundValueOps 绑定String类型
        redisTemplate.boundValueOps("name").set("youjiuye");
    }
    @Test
    public  void  testGetValue(){

       String i= (String) redisTemplate.boundValueOps("name").get();
       System.out.println("redis读取到："+i);
    }
    @Test
    public  void  testDelete(){

        redisTemplate.delete("name");
    }


}




