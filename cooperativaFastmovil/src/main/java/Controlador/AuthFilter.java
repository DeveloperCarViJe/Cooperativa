package Controlador;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización del filtro, si es necesario
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        String loginURI = httpRequest.getContextPath() + "/Login.jsp";

        // Verifica si hay una sesión activa
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);

        // Si está logueado o intentando acceder a Login.jsp, permite el acceso
        if (loggedIn || loginRequest) {
            chain.doFilter(request, response); // Continuar con la solicitud
        } else {
            httpResponse.sendRedirect(loginURI); // Redirige a Login.jsp
        }
    }

    public void destroy() {
        // Limpieza del filtro, si es necesario
    }
}

