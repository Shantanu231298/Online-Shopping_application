package com.cg.oss.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.cg.oss.entities.User;
import com.cg.oss.exception.OSSException;
import com.cg.oss.repository.IloginRepository;
import com.cg.oss.repository.loginRepositoryImpl;

public class LoginServiceImpl implements IloginService{
public static IloginRepository login=new loginRepositoryImpl();
	@Override
	public User addUser(User user) throws OSSException {
		// TODO Auto-generated method stub
		
			login.addUser(user);
			
		
		
		return user;
	}

	@Override
	public User removeUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User validateUser(User user) throws OSSException {
		// TODO Auto-generated method stub
		User foundUser= login.validateUser(user);
		if(user.getUserId()==foundUser.getUserId()&&user.getPassword()==foundUser.getPassword()&&user.getRole()==foundUser.getRole())
		  return foundUser;
		else throw new OSSException("User credentaials mismatch");
			
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean check(User user) throws OSSException {
		List<String> errorList=new ArrayList<>();
		boolean flag=true;
		if(user.getUserId()==null) {
			flag=false;
			errorList.add("User_Id Not Entered");	
		}
		if(user.getPassword().isEmpty())
			{flag=false;
		    errorList.add("password not found");	}	    
	
	if(user.getRole().isEmpty())
	{flag=false;
    errorList.add("role not found");	}
	if(!errorList.isEmpty())
     throw new OSSException("invalid user" + errorList);
	return flag;
	
} 
}
