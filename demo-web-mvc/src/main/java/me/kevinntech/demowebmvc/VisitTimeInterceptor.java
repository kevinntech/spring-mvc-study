package me.kevinntech.demowebmvc;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class VisitTimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if(session.getAttribute("visitTime") == null){ // 세션에 visitTime에 해당하는 것이 없다면
            session.setAttribute("visitTime", LocalDateTime.now()); // 세션에 visitTime를 현재 서버 시각에 맞게 넣어준다.
        }

        return true; // 다음 핸들러나 인터셉터까지 요청 처리 되도록 함
    }
}
