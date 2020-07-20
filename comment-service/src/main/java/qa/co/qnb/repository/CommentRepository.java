package qa.co.qnb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.co.qnb.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {
	public Optional<List<Comment>> findCommentByPostId(long postId);
}
