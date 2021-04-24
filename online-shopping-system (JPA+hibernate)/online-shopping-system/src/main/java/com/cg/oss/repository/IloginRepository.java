package com.cg.oss.repository;

import com.cg.oss.entities.User;
import com.cg.oss.exception.OSSException;

public interface IloginRepository {
	public User addUser(User user) throws OSSException;
	public User removeUser(User user)throws OSSException;
	public User validateUser(User user)throws OSSException;
	public User signOut(User user)throws OSSException;
}
