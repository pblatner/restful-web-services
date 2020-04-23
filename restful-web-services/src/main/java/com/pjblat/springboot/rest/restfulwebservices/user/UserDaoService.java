package com.pjblat.springboot.rest.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	static {
		User user1 = new User(1, "Adam", new Date());
		user1.getPosts().add(new Post(1, "subject 1", "details for the first post", new Date()));
		user1.getPosts().add(new Post(2, "subject 2", "details for the second post", new Date()));
		user1.getPosts().add(new Post(3, "subject 3", "details for the third post", new Date()));
		users.add(user1);
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if (user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;		
	}
	
	public User findOne(int id) {
		for (User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator	= users.iterator();
		while (iterator.hasNext())
		{
			User user = iterator.next();
			if (user.getId() == id)
			{
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
