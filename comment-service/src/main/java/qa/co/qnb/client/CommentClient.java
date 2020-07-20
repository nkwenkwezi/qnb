package qa.co.qnb.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import qa.co.qnb.dto.CommentDTO;

@FeignClient(value = "comment-service", url = "https://jsonplaceholder.typicode.com/", fallback = CommentFallBack.class)
public interface CommentClient {
	@GetMapping(value = "/post/{postId}/comments")
	public List<CommentDTO> findComments(@PathVariable("postId") long postId);
}
