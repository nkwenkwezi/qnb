package qa.co.qnb.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import qa.co.qnb.dto.CommentDTO;
@Component
public class CommentFallBack implements CommentClient{

	@Override
	public List<CommentDTO> findComments(long postId) {
		return Collections.emptyList();
	}

}
