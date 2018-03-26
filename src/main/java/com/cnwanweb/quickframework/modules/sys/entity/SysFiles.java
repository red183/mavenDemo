package com.cnwanweb.quickframework.modules.sys.entity;

import com.cnwanweb.quickframework.common.persistence.DataEntity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class SysFiles extends DataEntity<SysFiles> {
    private static final long serialVersionUID = 1L;
    private String fileName;
    private String extName;
    private Long fileSize;
    private String contentType;
    private String storeType;
    private String codeMd5;
    private String codeSha1;
    private String relativeUrl;

    public SysFiles() {
    }

    public SysFiles(String id) {
        super(id);
    }

    public SysFiles(MultipartFile file) {
        this();
        this.contentType = file.getContentType();
        this.fileSize = Long.valueOf(file.getSize());
        String oriFilename = file.getOriginalFilename();
        int extNameIndex = oriFilename.lastIndexOf(".");
        this.extName = oriFilename.substring(extNameIndex + 1);
        this.fileName = oriFilename.substring(0, extNameIndex);
    }

    @Length(
            min = 1,
            max = 50,
            message = "file_name长度必须介于 1 和 50 之间"
    )
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Length(
            min = 1,
            max = 10,
            message = "ext_name长度必须介于 1 和 10 之间"
    )
    public String getExtName() {
        return this.extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    @NotNull(
            message = "file_size不能为空"
    )
    public Long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Length(
            min = 1,
            max = 100,
            message = "content_type长度必须介于 1 和 100 之间"
    )
    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Length(
            min = 1,
            max = 10,
            message = "store_type长度必须介于 1 和 10 之间"
    )
    public String getStoreType() {
        return this.storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    @Length(
            min = 1,
            max = 64,
            message = "code_md5长度必须介于 1 和 64 之间"
    )
    public String getCodeMd5() {
        return this.codeMd5;
    }

    public void setCodeMd5(String codeMd5) {
        this.codeMd5 = codeMd5;
    }

    @Length(
            min = 1,
            max = 64,
            message = "code_sha1长度必须介于 1 和 64 之间"
    )
    public String getCodeSha1() {
        return this.codeSha1;
    }

    public void setCodeSha1(String codeSha1) {
        this.codeSha1 = codeSha1;
    }

    @Length(
            min = 1,
            max = 200,
            message = "relative_url长度必须介于 1 和 200 之间"
    )
    public String getRelativeUrl() {
        return this.relativeUrl;
    }

    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }
}
