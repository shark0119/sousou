package com.bdqn.shark.part3.sousou.card.server;

import java.io.Serializable;

import com.bdqn.shark.part3.sousou.card.services.Service;
import com.bdqn.shark.part3.sousou.packages.charac.Consumable;

public interface Server extends Serializable{
	boolean server (Service service, Consumable consume) throws Exception;
}