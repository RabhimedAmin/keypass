package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.ServerService;
import com.example.model.Account;
import com.example.model.Server;
import com.example.repository.AccountRepository;
import com.example.repository.ServerRepository;
@Service("serverService")
public class ServerServiceImpl implements ServerService {

	@Autowired
	public void setServerRepository(ServerRepository serverRepository) {
		this.serverRepository = serverRepository;
	}

	@Autowired
	private ServerRepository serverRepository;

	@Autowired
	private AccountRepository accountRepository;

	

	@Override
	public void deleteServer(long id) {
		// TODO Auto-generated method stub
		serverRepository.delete(id);
	}

	@Override
	public Server modifyServer(Server server) {
		// TODO Auto-generated method stub
		return serverRepository.save(server);
	}

	@Override
	public Server getServer(Long serverId) {
		// TODO Auto-generated method stub
		return serverRepository.findOne(serverId);
	}

	@Override
	public List<Server> getAllServer() {
		return serverRepository.findAll();
	}

	@Override
	public boolean affecteServerToAccounts(Long serverId, List<Long> accountsIds) {
		Server myServer = getServer(serverId);
		for (Long long1 : accountsIds) {
			Account wanted = accountRepository.findOne(long1);
			//wanted.setServer(myServer);
			accountRepository.saveAndFlush(wanted);
		}
		return true;
	}

	@Override
	public Server createServer(Server server) {
		// TODO Auto-generated method stub
		return serverRepository.save(server);
	}

	
}
