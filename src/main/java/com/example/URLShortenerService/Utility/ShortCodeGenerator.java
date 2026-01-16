package com.example.URLShortenerService.Utility;

import java.security.SecureRandom;
import java.util.Base64;

public class ShortCodeGenerator {


        private static final SecureRandom secureRandom = new SecureRandom();
        private static final Base64.Encoder base64UrlEncoder =
                Base64.getUrlEncoder().withoutPadding();

        public static String generateShortCode() {
            byte[] randomBytes = new byte[6]; // 6 bytes ≈ 8 Base64 chars
            secureRandom.nextBytes(randomBytes);

            return base64UrlEncoder.encodeToString(randomBytes).substring(0, 8);
        }



}
