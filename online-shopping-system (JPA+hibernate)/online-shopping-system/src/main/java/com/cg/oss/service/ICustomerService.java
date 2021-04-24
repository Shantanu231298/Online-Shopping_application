package com.cg.oss.service;

import java.util.List;

import com.cg.oss.entities.Customer;
import com.cg.oss.exception.OSSException;

public interface ICustomerService {
	public Customer addCustomer(Customer cust) throws OSSException;

	public Customer updateCustomer(Customer cust) throws OSSException;

	public Customer removeCustomer(Customer cust) throws OSSException;

	public Customer viewCustomer(Customer cust) throws OSSException;

	public List<Customer> ViewAllCustomers(String location) throws OSSException;
}
