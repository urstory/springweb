package com.example.springweb.controller;

import com.example.springweb.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.io.IOException;

@Controller
//@RequiredArgsConstructor
public class HelloController {
//    private final ToDoService toDoService;

    @GetMapping("/hello") // /hello요청이오면 해당메소드를 실행하라.
    public String hello() throws IOException {
        // 로직을 수행.
        return "hello"; // hello.jsp 포워딩.
    }

//    @GetMapping("/add")
//    public String add() throws Exception{
//        toDoService.addToDo();
//        return "add";
//    }
}

// URL을 처리하는 컨트롤러의 메소드가 hello를 리턴하면 hello.jsp로 포워딩하고 싶다.
/*
javax.servlet.ServletException: Circular view path [hello]: would dispatch back to the current handler URL [/hello] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
	org.springframework.web.servlet.view.InternalResourceView.prepareForRendering(InternalResourceView.java:210)
	org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:148)
	org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:316)
	org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1405)
	org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1149)
	org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1088)
	org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:964)
	org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
	org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:656)
	org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:765)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
 */