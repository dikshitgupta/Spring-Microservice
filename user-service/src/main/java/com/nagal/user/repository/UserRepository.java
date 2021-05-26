package com.nagal.user.repository;

import com.nagal.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User,Long> {
	User getByUserId(Long userId);
}
