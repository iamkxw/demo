package testcase;

import base.TestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.testng.annotations.Test;

/**
 * 随意测试
 * Created by Sawyer on 2017/1/20.
 */
public class CommonTest extends TestBase {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 测试BCrypt加密
     * Created by Sawyer on 2017/1/20.
     */
    @Test
    public void testBCrypt() {
        String raw1 = "123456";
        String raw2 = "Admin";
        String raw3 = raw1 + raw2;
        System.out.println("raw password: " + raw1 + "\r\n" + "encoded password: " + bCryptPasswordEncoder.encode(raw1));
        System.out.println("raw password: " + raw2 + "\r\n" + "encoded password: " + bCryptPasswordEncoder.encode(raw2));
        System.out.println("raw password: " + raw3 + "\r\n" + "encoded password: " + bCryptPasswordEncoder.encode(raw3));
        System.out.println(bCryptPasswordEncoder.matches(raw1, bCryptPasswordEncoder.encode(raw1)));
        System.out.println(bCryptPasswordEncoder.matches(raw2, bCryptPasswordEncoder.encode(raw2)));
        System.out.println(bCryptPasswordEncoder.matches(raw3, bCryptPasswordEncoder.encode(raw3)));
        System.out.println(bCryptPasswordEncoder.encode(raw1).length());
    }

    @Test
    public void testClass() {
        class Mother {
            private String name;
            private int age;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
        class Son extends Mother {
            Son(Mother mother) {
                setName(mother.getName());
                setAge(20);
            }
        }
        Mother mother = new Mother();
        mother.setAge(50);
        mother.setName("mom");
        Son son = new Son(mother);
        System.out.println("son:");
        System.out.println(son.getAge()); //20
        System.out.println(son.getName()); //mom
        System.out.println("mom");
        System.out.println(mother.getAge()); //50
    }
}
