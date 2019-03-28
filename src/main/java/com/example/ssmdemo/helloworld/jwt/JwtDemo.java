package com.example.ssmdemo.helloworld.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

/**
 * JSON Web Token
 */
public class JwtDemo {

    private static String MY_SECRET = "helloworld";

    /**
     * 创建Token
     *
     * @return
     * @throws Exception
     */
    public static String createToken() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create().withHeader(map)
                .withClaim("act", "act").withClaim("pwd", "pwd")
                .sign(Algorithm.HMAC256(MY_SECRET));
        return token;
    }

    /**
     * 校验Token
     *
     * @param token
     * @param key
     * @return
     * @throws Exception
     */
    public static void verifyToken(String token, String key) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("act").asString());
        System.out.println(claims.get("pwd").asString());
    }

    public static void main(String[] args) {
        try {
            String string = createToken();
            System.out.println(string);
            verifyToken(string, MY_SECRET);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
