package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Server;
public interface ServerService {

	public Server createServer(Server server);

	public void deleteServer(long id);

	public Server modifyServer(Server server);

	public Server getServer(Long serverId);

	public List<Server> getAllServer();

	public boolean affecteServerToAccounts(Long serverId, List<Long> accountsIds);

}
