package com.fps.mpits.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@Component
@Accessors(fluent = true)
@Data
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.DEFAULT)
public class RequestScope implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ipAddress;
    private String userAgent;
    private String urlRequest;
    private String urlReferer;
    private String clientOS;
    private String clientBrowser;
    private String identifyDevice;
    private String cookie;

}
