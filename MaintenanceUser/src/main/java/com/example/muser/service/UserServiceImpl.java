package com.example.muser.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.muser.entity.User;
import com.example.muser.entity.UserCond;
import com.example.muser.entity.UserUp;
import com.example.muser.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public List<User> findListAll() {

		List<User> list = userRepository.selectListAll();

		return list;
	}

	@Override
	@Transactional
	public void regist(UserUp userUp) {

		userRepository.insert(userUp);

	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findListByConditions(UserCond cond) {

		List<User> list = userRepository.selectListByConditions(cond);

		return list;
	}

	@Override
	@Transactional
	public void edit(UserUp userUp) {

		userRepository.update(userUp);

	}

	@Override
	@Transactional
	public void remove(Integer userId) {

		userRepository.delete(userId);
		
	}

}
