package com.alianza.rs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianza.rs.client.request.ClientRecordRequest;
import com.alianza.rs.client.request.ClientUpgradeRequest;
import com.alianza.rs.client.response.ClientFindResponse;
import com.alianza.rs.client.response.ClientOperationResponse;
import com.alianza.rs.entity.Client;
import com.alianza.rs.repository.ClientRepository;
import com.alianza.rs.utilities.DateManagement;
import com.alianza.rs.utilities.FLog;

@Service
public class ServiceClient {

	@Autowired
	ClientRepository cr;

	public List<ClientFindResponse> findAll() {
		List<ClientFindResponse> cfrList = new ArrayList<>();
		try {
			List<Client> cList = cr.findAll();
			cList.forEach(cli -> cfrList.add(new ClientFindResponse(cli)));

		} catch (Exception e) {
			FLog.getLogger().error("ServiceClient findAll", e);
		}
		return cfrList;
	}

	public ClientFindResponse findBySharedKey(String sharedKey) {
		try {
			return new ClientFindResponse(cr.findBySharedKey(sharedKey));
		} catch (Exception e) {
			FLog.getLogger().error("ServiceClient findBySharedKey: " + sharedKey, e);
			return new ClientFindResponse(null);
		}
	}

	public ClientOperationResponse create(ClientRecordRequest crr) {
		ClientOperationResponse cor = new ClientOperationResponse();
		try {
			Client c = clientRecord(crr);
			cr.save(c);
			cor.setConfirmation(true);
			cor.setMessage("Cliente Creado");
			cor.setSharedKey(crr.getKey());
		} catch (Exception e) {
			cor.setConfirmation(false);
			cor.setMessage("Error Creando Cliente");
			cor.setSharedKey(crr.getStart());
			FLog.getLogger().error("ServiceClient " + crr.toString(), e);
		}
		return cor;
	}

	public ClientOperationResponse upgrade(ClientUpgradeRequest cur) {
		ClientOperationResponse cor = new ClientOperationResponse();
		try {
			Client c = clientUpgrade(cur);
			cr.save(c);
			cor.setConfirmation(true);
			cor.setMessage("Cliente Actualizado");
			cor.setSharedKey(cur.getKey());
		} catch (Exception e) {
			cor.setConfirmation(false);
			cor.setMessage("Error Actualizando Cliente");
			cor.setSharedKey(cur.getKey());
			FLog.getLogger().error("ServiceClient " + cur.toString(), e);
		}
		return cor;
	}
	
	private Client clientRecord(ClientRecordRequest crr) {
		Client c = new Client();
		c.setBusinessId(crr.getBusinessId());
		c.setDateAdded(DateManagement.getStringToDate(crr.getAdded()));
		c.setDateEnd(DateManagement.getStringToDate(crr.getEnd()));
		c.setDateStart(DateManagement.getStringToDate(crr.getStart()));
		c.setEmail(crr.getEmail());
		c.setPhone(crr.getPhone());
		c.setSharedKey(crr.getKey());
		return c;
	}

	private Client clientUpgrade(ClientUpgradeRequest cur) {
		Optional<Client> cOp = cr.findById(cur.getId());
		if (cOp.isPresent()) {
			cOp.get().setSharedKey(cur.getKey());
			cOp.get().setEmail(cur.getEmail());
			cOp.get().setBusinessId(cur.getBusinessId());
			cOp.get().setPhone(cur.getPhone());
			return cOp.get();
		}
		return null;
	}
}
