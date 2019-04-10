package com.xdclass.test.wiggin;

import com.xdclass.test.User;
import com.xdclass.test.UserVo;

import java.util.concurrent.locks.ReentrantLock;

public class Test {

    private static final int temp = 123;

    public static void main(String[] args) {
        User user = new User();
        user.setSex(0);
        user.setId(0L);
        user.setName("");
        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                throw new NullPointerException("空指针异常");
            }
            System.out.println("i = " + i);
        }
        UserVo converter = converter(user);

        String json = "{\n" +
                "  \"userName\":\"xdclass\"\n" +
                "}";


    }


    public static UserVo converter(User user) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        UserVo userVo = new UserVo();
        userVo.setName(user.getName());
        userVo.setSex(user.getSex());
        reentrantLock.unlock();
        return userVo;
    }
}
