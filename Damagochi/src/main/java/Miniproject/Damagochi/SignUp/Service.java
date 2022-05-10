package Miniproject.Damagochi.SignUp;

import Miniproject.Damagochi.dto.User;

public interface Service {
	// 회원가입 : 한명의 사용자 추가
	int insertUser(User user);
	// 로그인 기능
	int loginuser(User user);
	
}
