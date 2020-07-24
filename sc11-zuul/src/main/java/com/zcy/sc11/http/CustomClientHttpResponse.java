package com.zcy.sc11.http;

import com.zcy.sc1.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Component
public class CustomClientHttpResponse implements ClientHttpResponse {
    @Override
    public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.OK;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return HttpStatus.OK.value();
    }

    @Override
    public String getStatusText() throws IOException {
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public void close() {
    }

    @Override
    public InputStream getBody() throws IOException {
        log.info("fallback body");
        String s = JsonResult.err().msg("后台服务错误").toString();
        return new ByteArrayInputStream(s.getBytes("UTF-8"));
    }

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
