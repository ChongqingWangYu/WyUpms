package com.wy.upms.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TokenUtil
 * @Description Token工具类
 * @Author ChongqingWangYu
 * @DateTime 2019/6/10 13:45
 * @GitHub https://github.com/ChongqingWangYu
 */
public class TokenUtil {
    /*token有效期*/
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;
    private static final String TOKEN_SECRET = "ssm_crm_token";
    /**
     * 生成签名，60分钟过期
     * @param **username**
     * @param **password**
     * @return
     */
    public static String sign(String username, String password) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginName", username)
                    .withClaim("pwd", password)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检验token是否正确
     * @param **token**
     * @return
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 从token中获取username信息
     * @param **token**
     * @return
     */
    public static String getUserName(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        } catch (JWTDecodeException e){
            e.printStackTrace();
            return null;
        }
    }
}
