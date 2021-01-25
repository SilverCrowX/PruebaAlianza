package com.alianza.rs.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alianza.rs.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	public Client findBySharedKey(String sharedKey);
}
