package com.kh.mvc04.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}
	//Dto 커맨드 객체에 대한 값 검증을 지원하는 지의 여부를 리턴한다
	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file = (UploadFile) target;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file","errorCode","Pleas select a file");
		}
	}
	

}
