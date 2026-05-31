package org.om.utils;

import org.om.model.Token;

public class TokenUtils {
    private final String bronze = "bronze";

    private final String gold = "gold";

    private final String diamond = "diamond";

    private final String platinum = "platinum";

    private final String master = "master";


    public Token setTokenDuration(Token token) {
        String type = token.getType();

        switch (type){
            case bronze:
                token.setDuration(7);
                break;
            case gold:
                token.setDuration(31);
                break;
            case diamond:
                token.setDuration(63);
                break;
            case platinum:
                token.setDuration(126);
                break;
            case master:
                token.setDuration(365);
                break;
        }

        return token;
    }
}
