package com.powernode.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SIGN_KEY = "c2VjcmV0a2V5c2VjcmV0a2V5c2VjcmV0a2V5c2VjcmV0";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SIGN_KEY.getBytes(StandardCharsets.UTF_8));
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000L; // 12小时

    /**
     * 生成JWT令牌
     * @param claims 自定义载荷数据
     * @return JWT令牌字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .issuedAt(new Date(now))
                .expiration(new Date(now + EXPIRE_TIME))
                .claims(claims)
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param token JWT令牌字符串
     * @return Claims载荷数据
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}