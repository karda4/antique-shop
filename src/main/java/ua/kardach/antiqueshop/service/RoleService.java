package ua.kardach.antiqueshop.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.RoleDao;
import ua.kardach.antiqueshop.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public Set<Role> getAllByUserId(long userId){
		List<Role> list = roleDao.getAllByUserId(userId);
		if(list != null){
			return new HashSet<>(list);
		}
		return null;
	}
}
