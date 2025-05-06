package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.RedisClient;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisClient redisClient;

    public Object login(String userName, String password) {
        try {
            User user=userMapper.login(userName, password);
            List<User> listUser=userMapper.checkUserName(userName);
            if(listUser.isEmpty()) {
                return ReturnT.Failed("账号不存在。");
            }
            else if(user!=null) {
                String token = createToken(user.getId());
                Map<String,Object> map=new HashMap<>();
                map.put("code",200);
                map.put("msg","操作成功");
                map.put("token",token);
                return map;
            }
            else{
                return ReturnT.Failed("密码不正确。");
            }
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    //    传的值是value=user对象，得到的是key=token
    public String createToken(Object object) {
        String keyToken = UUID.randomUUID().toString().replace("-", "");
        redisClient.set(keyToken,String.valueOf(object), RedisClient.TOKEN_EXPIRES_SECOND);
        return keyToken;
    }

//    public boolean checkToken(String keyToken,String valueUserId) {
//        boolean result = false;
//        if(StringUtils.isNotBlank(valueUserId)) {
//            String userToken = keyToken;
//            String authenticatedUserId = redisClient.get(userToken);
//            if(authenticatedUserId != null && authenticatedUserId.equals(valueUserId)) {
//                redisClient.expire(userToken, RedisClient.TOKEN_EXPIRES_SECOND);
//                result = true;
//            }
//        }
//        return result;
//    }

    //    传的值是key=token，得到的是value=user对象
    public String getToken(String keyToken) {
        return redisClient.get(keyToken);
    }

    public boolean deleteToken(String keyToken) {
        return redisClient.remove(keyToken == null ? null : keyToken);
    }
}