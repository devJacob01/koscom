package com.koscom.microservices.account.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koscom.microservices.account.model.Account;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/accounts")
@io.swagger.annotations.Api(value = "account", description = "account api")
public class AccountApi {

	private List<Account> accounts;
	
	protected Logger logger = Logger.getLogger(AccountApi.class.getName());
	
	public AccountApi() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111111"));
		accounts.add(new Account(2, 2, "222222"));
		accounts.add(new Account(3, 3, "333333"));
		accounts.add(new Account(4, 4, "444444"));
		accounts.add(new Account(5, 1, "555555"));
		accounts.add(new Account(6, 2, "666666"));
		accounts.add(new Account(7, 2, "777777"));
	}
	
	@ApiOperation(value ="accounts 상세 ")
	@RequestMapping(value="/number/{number}", method=RequestMethod.GET)
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		return accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
	}
	
	@RequestMapping(value="/customer/{customer}", method=RequestMethod.GET)
	public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		return accounts.stream().filter(it -> it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accounts;
	}
	
}
