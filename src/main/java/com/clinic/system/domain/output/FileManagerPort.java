package com.clinic.system.domain.output;

public interface FileManagerPort {

    String perform(byte[] content, String originalFilename) throws Exception;
}
