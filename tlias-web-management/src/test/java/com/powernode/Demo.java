package com.powernode;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class Demo {

    // 秘钥！！最少32字符，HS256强制要求256bit，生产放yml，不要硬编码
    private static final String SECRET_STR = "abcdefghijklmnopqabcdefghijklmnopq";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET_STR.getBytes(StandardCharsets.UTF_8));

    /**
     * 生成JWT
     * @param subject 主题，一般放用户id
     * @param claims 自定义载荷（存放用户信息）
     * @param expireMs 过期时间，单位毫秒
     * @return jwt token
     */
    public static String generateToken(String subject, Map<String, Object> claims, long expireMs){
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .subject(subject)
                .issuedAt(new Date(now))          // iat 签发时间
                .expiration(new Date(now + expireMs)) // exp 过期时间
                .claims(claims)
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析JWT，获取载荷Claims
     * @param token jwt字符串
     * @return Claims
     */
    public static Claims parseToken(String token){
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
