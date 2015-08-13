package com.ztx.qa.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by s016374 on 15/8/12.
 */
@Component
public class HelloView implements View {
    @Override
    public String getContentType() {
        return "helloView";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("HelloView, Date:" + new Date());
    }
}
