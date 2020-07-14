package com.fps.mpits.util;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author HieuDT28 - (Hiếu Boy)
 * created 19/05/2020 - 17:30
 */

public class TOTP {
    private static TOTP instance = new TOTP();
    private static final GoogleAuthenticator gAuth = new GoogleAuthenticator();

    private TOTP() {

    }

    public static TOTP getInstance() {
        return instance;
    }

    private String getSecretByUsername(String username) {
        return DigestUtils.md5Hex(Common.getPasswordWithSalt(username, username));
    }

    public Boolean checkTOTP(String username, String totp, long timeStepSizeInMillis, int codeDigits) {
        boolean bRet = false;
        totp = StringUtils.trim(totp);

        if (timeStepSizeInMillis <= 0 && totp.length() < 6 || totp.length() > codeDigits) return bRet;

        GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator(new GoogleAuthenticatorConfigBuilder()
                .setTimeStepSizeInMillis(timeStepSizeInMillis).setCodeDigits(codeDigits).build());
        String secret = getSecretByUsername(username);
        bRet = googleAuthenticator.authorize(secret, Integer.parseInt(totp));

        if (!bRet) bRet = gAuth.authorize(secret, Integer.parseInt(totp.substring(0, 6)));

        return bRet;
    }

}
