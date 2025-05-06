package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.RedisClient;
import com.example.demo.utils.ReturnT;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisClient redisClient;

    public ReturnT<List<User>> login(String userName, String password) {
        try {
            if(userMapper.checkUserName(userName).isEmpty()) {
                return ReturnT.Failed("账号不存在。");
            }
            else if(userMapper.login(userName, password).size() ==1) {
                return ReturnT.Success(userMapper.login(userName,password));
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