package vn.threecents.java_sample_code.dto.response;

public class ResponseError extends ResponseData{
    public ResponseError(int status, String message){
        super(status, message);
    }
}
