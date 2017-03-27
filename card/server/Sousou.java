package com.bdqn.shark.part3.sousou.card.server;

import com.bdqn.shark.part3.sousou.card.services.Service;
import com.bdqn.shark.part3.sousou.packages.charac.Consumable;

public class Sousou implements Server {

	private static final long serialVersionUID = 3624182579191131263L;

	@Override
	public boolean server(Service service, Consumable consume) throws Exception {
		if (consume.exhausted())
			return false;
		consume.consume(service.doService(), service.getDescription());
		return !consume.exhausted();
	}
}
