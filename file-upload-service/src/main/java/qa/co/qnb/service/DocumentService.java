package qa.co.qnb.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import qa.co.qnb.dto.DocumentServiceResponse;

public interface DocumentService {
	public String upload(MultipartFile file,String userUuid);
	public Resource retrieveDocument(String fileUuid, String userUuid);
	public List<DocumentServiceResponse> viewDocuments(String userUuid);
	public void deleteFile(String userUuid,String fileName);
	public String getDocumentUri(String documentUuid, String userUuid);
}
