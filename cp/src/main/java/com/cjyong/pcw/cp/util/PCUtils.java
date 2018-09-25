package com.cjyong.pcw.cp.util;

import com.cjyong.pcw.cp.conf.ApplicationInfo;
import com.cjyong.pcw.cp.main.entity.enums.TokenVerifyResult;
import com.cjyong.pcw.cp.main.exception.ParameterInValidException;
import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/8/5
 * Time: 11:42
 * Description: A util class for
 */
@Slf4j
public class PCUtils {

    //工具类,防止被实例化
    private PCUtils() {
        throw new AssertionError();
    }


    //Qiniuyun相关配置工具方法
    //上传中心设置成单例模式
    private static UploadManager uploadManager = new UploadManager(new Configuration(Zone.zone2()));
    //懒加载密钥
    private static String qnToken;

    private static String getQnToken() {
        if (qnToken != null && !qnToken.isEmpty()) return qnToken;
        qnToken = createQnToken();
        return qnToken;
    }

    private static String createQnToken() {
        Auth auth = Auth.create(ApplicationInfo.getQiniuAccessKey(), ApplicationInfo.getQiniuSecretKey());
        return auth.uploadToken(ApplicationInfo.getQinniuBucket());
    }

    public static void uploadFinished() {
        qnToken = null;
    }

    public static String uploadImage(MultipartFile file) throws Exception{
        byte[] uploadBytes = file.getBytes();
        Response response = uploadManager.put(uploadBytes, null, getQnToken());
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        return putRet.key;
    }

    //检查参数是否存在空值
    public static boolean hasEmpty(String... strings){
        for (String str : strings)
            if (str == null || str.isEmpty())
                return true;

        return false;
    }

    /**
     *  使用HMAC方法参数Hash值
     *
     * @param secrete
     * @param body
     * @return
     */
    public String HMACHashValue(String secrete, String body) {
        //TODO
        return "";
    }

    //检查用户ID
    public static void checkUserId(long userId, String method) throws Exception{
        if (userId != 1 && userId != 2) {
            throw new ParameterInValidException(method + "(" + userId + ")用户ID不存在");
        }
    }

    /**
     *JWT生成Token
     *
     * @param ttlMillis  token生命周期(单位:毫秒)
     * @return 加密后JWT token字符串
     */
    public static String createJWT(long ttlMillis, String key) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(System.currentTimeMillis());

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId("cp")
                .setIssuedAt(now)
                .setSubject("token")
                .setIssuer("cjyong")
                .signWith(signatureAlgorithm, signingKey);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    /**
     * 校验JWT
     *
     * @param key
     * @param jwt
     * @return
     */
    public static TokenVerifyResult JwtVerify(final String key, final String jwt){
        try {
            Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                    .parseClaimsJws(jwt);
        } catch (ExpiredJwtException e) {
            return TokenVerifyResult.expired;
        } catch (SignatureException e) {
            return TokenVerifyResult.illegalSignature;
        }
        return TokenVerifyResult.success;
    }
}
