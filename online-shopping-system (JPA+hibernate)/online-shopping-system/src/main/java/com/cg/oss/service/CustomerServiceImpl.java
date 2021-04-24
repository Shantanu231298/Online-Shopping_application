package com.cg.oss.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.oss.entities.Customer;
import com.cg.oss.exception.OSSException;
import com.cg.oss.repository.CustomerRepositoryImpl;
import com.cg.oss.repository.ICustomerRepository;

public class CustomerServiceImpl implements ICustomerService {
	// public static ICustomerRepository custom=new CustomerRepositoryImpl();

	private ICustomerRepository custom;

	@Override
	public Customer addCustomer(Customer cust) throws OSSException {
		return custom.addCustomer(cust);
	}

	@Override
	public Customer updateCustomer(Customer cust) throws OSSException {
		return custom.updateCustomer(cust);
	}

	@Override
	public Customer removeCustomer(Customer cust) throws OSSException {
		return custom.removeCustomer(cust);
	}

	@Override
	public Customer viewCustomer(Customer cust) throws OSSException {
		return custom.viewCustomer(cust);
	}

	@Override
	public List<Customer> ViewAllCustomers(String location) throws OSSException {
		return custom.ViewAllCustomers(location);
	}

}
