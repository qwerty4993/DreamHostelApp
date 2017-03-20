package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.repository.LoginRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public ResponseVO loginValidate(LoginDetails requestVO) {

		LoginDetails dbUser = loginRepository.findByUsername(requestVO.getUsername());
		if (dbUser == null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("InValid UserName / Password");
		}

		if (!bCryptPasswordEncoder.matches(requestVO.getPassword(), dbUser.getPassword())) {

			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("InValid UserName / Password");
		}
		System.out.println(dbUser.toString());
		ResponseVO responseVO = HttpStatusCode.OK.getResponseVO("SUCCESS");
		responseVO.setResponseObjects(dbUser);

		return responseVO;
	}

}
