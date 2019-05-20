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
public class TestRedis003 {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public  void  testSetValue() {

        //boundListOps 绑定list类型
       //从头插入数据,左插入
        redisTemplate.boundListOps("h2").leftPush("aaa");
        redisTemplate.boundListOps("h2").leftPush("bbb");
        redisTemplate.boundListOps("h2").leftPush("ccc");
        redisTemplate.boundListOps("h2").leftPush("ddd");
        redisTemplate.boundListOps("h2").leftPush("eee");
       //从尾插入，右插入
        redisTemplate.boundListOps("h2").rightPush("111");
        redisTemplate.boundListOps("h2").rightPush("222");
        redisTemplate.boundListOps("h2").rightPush("333");
        redisTemplate.boundListOps("h2").rightPush("444");
        redisTemplate.boundListOps("h2").rightPush("555");

    }
    @Test
    public  void  testGetValue(){
        List list = redisTemplate.boundListOps("h2").range(0, -1);//range表示循環讀取
        for (Object o:list){
            System.out.println(o);
        }

        //根據具體的索引來讀取值
        Object index = redisTemplate.boundListOps("h2").index(3);
         System.out.println(index);

    }
    @Test
    public  void  testDelete(){
       //移除某個數據
       redisTemplate.boundListOps("h2").remove(1,"aaa");
       redisTemplate.boundListOps("h2").remove(1,"ccc");
       redisTemplate.boundListOps("h2").remove(1,"ddd");
       redisTemplate.boundListOps("h2").remove(1,"bbb");
    }


}




