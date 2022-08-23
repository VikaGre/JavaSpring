package ru.gredychian;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/firstServletNew") //для конфигурации
public class FirstServlet implements Servlet {

    private ServletConfig servletConfig;

    //инициализация сервлета
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig; //нужен для взаимодействия servlet с приложением (tomcat)
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    //отработка запросов на сервлет
    //в ServletRequest есть некоторые атрибуты запроса, котрые посылает клиент
    //ы ServletResponse есть атриуты ответа, которые мы отправляем клиенту
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().println("<h1> Hello world!<h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //завершение ресурса, окторые могли быть открыты при реализации данног servlet
    @Override
    public void destroy() {

    }
}
