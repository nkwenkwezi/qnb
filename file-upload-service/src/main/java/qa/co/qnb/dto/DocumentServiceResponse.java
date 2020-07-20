package qa.co.qnb.dto;

import java.io.Serializable;

public class DocumentServiceResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileUri;
	private String fileName;
	public DocumentServiceResponse(String fileName,String fileUri) {
		super();
		this.fileName = fileName;
		this.fileUri = fileUri;
		
	}
	public String getFileUri() {
		return fileUri;
	}
	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "FileServiceResponse [fileUri=" + fileUri + ", fileName=" + fileName + "]";
	}
	
	
	
	
	
	
}
