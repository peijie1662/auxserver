package pj.com.cn.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 下载监控 
 */
public class DownLoadFilter implements Filter{
	
	private static Logger logger = LoggerFactory
			.getLogger(DownLoadFilter.class);

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String path = request.getRequestURI();
		int index = path.indexOf("/lupload/");
		if (index > -1) {
			String fileName = path.substring(index+"/lupload/".length());
			logger.info(" IP:"+request.getRemoteAddr()+" Download_File FileName = "+fileName);
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
