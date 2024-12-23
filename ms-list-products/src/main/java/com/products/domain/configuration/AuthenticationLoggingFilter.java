package com.products.domain.configuration;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;

public class AuthenticationLoggingFilter implements Filter {

  private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class
      .getName());

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain filterChain) throws IOException, ServletException {
    var httpRequest = (HttpServletRequest) request;
    var requestId = httpRequest.getHeader("Request-Id");

    logger.info("Request ID: " + requestId);
    filterChain.doFilter(request, response);

  }
}
