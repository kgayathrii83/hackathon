package com.api.payment.beans.response;

import lombok.Getter;
import lombok.Setter;

/** REST API response object */
@Getter
@Setter
public class AccessTokenResponse {
    private String access_token;
    private String token_type;
    private String expires_in;
    public AccessTokenResponse()
    {

    }

    public AccessTokenResponse(String access_token, String token_type, String expires_in) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "AccessTokenResponse{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in='" + expires_in + '\'' +
                '}';
    }
}
