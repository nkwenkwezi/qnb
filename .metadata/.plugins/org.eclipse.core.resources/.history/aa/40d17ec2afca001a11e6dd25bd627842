package qa.co.qnb.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import qa.co.qnb.constants.Constants;
import qa.co.qnb.domain.Document;
import qa.co.qnb.dto.DocumentServiceResponse;
import qa.co.qnb.exception.DocumentStorageException;
import qa.co.qnb.repository.DocumentRepository;
import qa.co.qnb.service.DocumentService;

@Transactional
@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository filePropertiesRepository;
	private final Path fileStorageLocation;
	private final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);

	@Autowired
	public DocumentServiceImpl(Environment environment) throws DocumentStorageException {
		String uploadDirectory = System.getProperty("user.dir");
		logger.info("fileproperties {}", uploadDirectory);
		this.fileStorageLocation = Paths.get(uploadDirectory).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			logger.info("exception occurred {}", ex.getMessage());
			throw new DocumentStorageException(Constants.STORAGE_NOT_FOUND);
		}
	}

	@Override
	public String upload(MultipartFile file, String userUuid) {
		String fileName = createDocumentName(file.getOriginalFilename(), userUuid);
		logger.info("fileName {}", fileName);
		Path targetLocation = this.fileStorageLocation.resolve(fileName);
		try {
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			logger.info("exception occurred {}", e.getMessage());
			throw new DocumentStorageException(Constants.DOCUMENT_NOT_SAVED);
		}
		Document fileProperty = this.persistDocument(fileName, userUuid, true);
		return fileProperty.getUuid();
	}

	private Document persistDocument(String fileName, String userUuid, boolean status) {
		Optional<Document> value = findDocument(fileName, status);
		Document document = null;
		if (value.isPresent()) {
			document = value.get();
			document.setStatus(status);
		} else {
			String dateCreated = dateFormat.format(new Date());
			String fileLocation = this.fileStorageLocation.resolve(fileName).toString();
			document = new Document(UUID.randomUUID().toString(), fileName, dateCreated, fileLocation,
					userUuid, status);
		}
		return filePropertiesRepository.save(document);

	}

	private Optional<Document> findDocument(String fileName, boolean status) {
		Optional<Document> value = filePropertiesRepository.findDocumentByFileNameAndStatus(fileName,
				status);
		return value;
	}

	@Override
	public Resource retrieveDocument(String fileUuid, String userUuid) {
		Resource resource = null;
		try {
			Optional<Document> fileProperty = filePropertiesRepository.findDocumentByUuidAndStatus(fileUuid, true);
			if (fileProperty.isPresent()) {
				Path filePath = this.fileStorageLocation.resolve(fileProperty.get().getFileName()).normalize();
				resource = new UrlResource(filePath.toUri());
			} else {
				throw new DocumentStorageException(Constants.DOCUMENT_NOT_FOUND );
			}
		} catch (MalformedURLException ex) {
			throw new DocumentStorageException(Constants.DOCUMENT_NOT_FOUND );
		}
		return resource;
	}

	private String createDocumentName(String fileName, String userUuid) {
		StringBuilder builder = new StringBuilder();
		String uploadedFileName = builder.append(userUuid).append(Constants.UNDERSCORE).append(fileName).toString();
		return uploadedFileName;
	}

	@Override
	public List<DocumentServiceResponse> viewDocuments(String userUuid) {
		Optional<List<Document>> results = filePropertiesRepository
				.findDocumentByUserUuidAndStatus(userUuid, true);
		List<Document> list = results.isPresent() ? results.get() : null;
		if(list != null) {
		return list.stream().map(r -> new DocumentServiceResponse(cleanFileName(r.getFileName(), userUuid),
				getDocumentUri(r.getUuid(), userUuid))).collect(Collectors.toList());
		} else {
			throw new DocumentStorageException(Constants.DOCUMENT_NOT_FOUND);
		}
	}

	@Override
	public void deleteFile(String userUuid, String fileName) {
		fileName = createDocumentName(fileName, userUuid);
		Optional<Document> results = filePropertiesRepository.findDocumentByUserUuidAndFileNameAndStatus(userUuid, fileName, true);
		Document file = results.isPresent()?results.get(): null;
		logger.info("FileProperty {}", file);
		if(file == null) {
			throw new DocumentStorageException(Constants.DOCUMENT_NOT_FOUND + fileName);
		}
		Path targetLocation = this.fileStorageLocation.resolve(file.getFileName());
		logger.info("File to delete {}",targetLocation.toAbsolutePath());;
		try {
			Files.delete(targetLocation);
		} catch (IOException e) {
			throw new DocumentStorageException(Constants.DOCUMENT_NOT_FOUND + fileName);
		}
		file.setStatus(false);
		filePropertiesRepository.save(file);
		
		
	}

	public String getDocumentUri(String documentUuid, String userUuid) {
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadDocument/user/").path(userUuid)
				.path("/document/").path(documentUuid).toUriString();
	}

	private String cleanFileName(String fileName, String userUuid) {
		return fileName.substring(userUuid.length() + 1, fileName.length());
	}
}
