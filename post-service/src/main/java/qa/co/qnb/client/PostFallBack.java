package qa.co.qnb.client;

import java.util.Collections;
import java.util.List;

import qa.co.qnb.dto.PostDTO;
import org.springframework.stereotype.Component;
@Component
public class PostFallBack implements PostClient {

	@Override
	public List<PostDTO> findPosts(long postId) {
		return Collections.emptyList();
	}
}
