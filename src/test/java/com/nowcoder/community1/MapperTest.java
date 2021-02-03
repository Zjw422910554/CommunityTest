package com.nowcoder.community1;

import com.nowcoder.community1.dao.DiscussPostMapper;
import com.nowcoder.community1.dao.UserMapper;
import com.nowcoder.community1.entity.DiscussPost;
import com.nowcoder.community1.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Created by a4229 on 2021/1/30 19:04.
 */
@SpringBootTest
@ContextConfiguration(classes = Community1Application.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        User user=new User();
        System.out.println(user);
        user.setId(1);
        user.setEmail("asdfadsfdasdfsa");
        user.setActivationCode("asdfadsfdasdfsa");
        user.setHeaderUrl("asdfadsfdasdfsa");
        userMapper.insertUser(user);
        System.out.println(userMapper.selectById(1));
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }
}
