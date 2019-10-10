package com.koscom.microservices.user.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koscom.microservices.user.model.User;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@io.swagger.annotations.Api(value = "user", description = "user api")
public class UserApi {

	private List<User> users;
	
	protected Logger logger = Logger.getLogger(UserApi.class.getName());
	
	public UserApi() {
		users = new ArrayList<>();
		users.add(new User(1, 1, "111111"));
		users.add(new User(2, 2, "222222"));
		users.add(new User(3, 3, "333333"));
		users.add(new User(4, 4, "444444"));
		users.add(new User(5, 1, "555555"));
		users.add(new User(6, 2, "666666"));
		users.add(new User(7, 2, "777777"));
	}
	
	@ApiOperation(value ="user 상세 ")
	@RequestMapping(value="/number/{number}", method=RequestMethod.GET)
	public User findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		return users.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
	}
	
	@RequestMapping(value="/user/{user}", method=RequestMethod.GET)
	public List<User> findByCustomer(@PathVariable("user") Integer userId) {
		logger.info(String.format("Account.findByCustomer(%s)", userId));
		return users.stream().filter(it -> it.getCustomerId().intValue()==userId.intValue()).collect(Collectors.toList());
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<User> findAll() {
		logger.info("Account.findAll()");
		return users;
	}
	
}
