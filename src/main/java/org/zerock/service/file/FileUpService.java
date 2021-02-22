package org.zerock.service.file;

import java.io.InputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.bmc.ConfigFileReader;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorage;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.requests.PutObjectRequest;
import com.oracle.bmc.objectstorage.transfer.UploadConfiguration;
import com.oracle.bmc.objectstorage.transfer.UploadManager;
import com.oracle.bmc.objectstorage.transfer.UploadManager.UploadRequest;

import lombok.Setter;

@Service
public class FileUpService {

	@Setter(onMethod_ = @Autowired)
	private String ociConfigPath;// 빈 주입, root-context.xml
	
	public void transfer(MultipartFile file, String fileName) throws Exception {

		String objectName = file.getOriginalFilename();
		
		if (fileName != null) {
			objectName = fileName;
		}
		
		String contentType = file.getContentType();
		InputStream is = file.getInputStream();
		long size = file.getSize();

		Map<String, String> metadata = null;
		String contentEncoding = null;
		String contentLanguage = null;

		final ConfigFileReader.ConfigFile configFile = ConfigFileReader.parse(ociConfigPath);

		final ConfigFileAuthenticationDetailsProvider provider = new ConfigFileAuthenticationDetailsProvider(
				configFile);

		String namespaceName = configFile.get("namespace_name");
		String bucketName = configFile.get("bucket_name");

		ObjectStorage client = new ObjectStorageClient(provider);
		client.setRegion(com.oracle.bmc.Region.AP_SEOUL_1);

		// configure upload settings as desired
		UploadConfiguration uploadConfiguration = UploadConfiguration.builder().allowMultipartUploads(true)
				.allowParallelUploads(true).build();

		UploadManager uploadManager = new UploadManager(client, uploadConfiguration);

		PutObjectRequest request = PutObjectRequest.builder().bucketName(bucketName).namespaceName(namespaceName)
				.objectName(objectName).contentType(contentType).contentLanguage(contentLanguage)
				.contentEncoding(contentEncoding).opcMeta(metadata).build();

		UploadRequest uploadDetails = UploadRequest.builder(is, size).allowOverwrite(true).build(request);

		uploadManager.upload(uploadDetails);

		// fetch the object just uploaded
		client.getObject(GetObjectRequest.builder().namespaceName(namespaceName)
				.bucketName(bucketName).objectName(objectName).build());
	}
	
}
