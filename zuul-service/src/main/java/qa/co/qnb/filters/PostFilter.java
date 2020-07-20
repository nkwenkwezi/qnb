package qa.co.qnb.filters;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter extends ZuulFilter {
	private Logger logger = LoggerFactory.getLogger(PostFilter.class);
	@Override
	public String filterType() {
		return POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
	 
	    RequestContext context = RequestContext.getCurrentContext();
	    try (final InputStream responseDataStream = context.getResponseDataStream()) {
	 
	        if(responseDataStream == null) {
	            logger.info("BODY: {}", "");
	            return null;
	        }
	 
	        String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
	        logger.info("BODY: {}", responseData);
	 
	        context.setResponseBody(responseData);
	    }
	    catch (Exception e) {
	        throw new ZuulException(e, INTERNAL_SERVER_ERROR.value(), e.getMessage());
	    }
	 
	    return null;
	}
}
