package com.deividurrego.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deividurrego.model.Producto;
import com.deividurrego.repo.IGenericRepo;
import com.deividurrego.service.IProductoService;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

	@Autowired
	private IGenericRepo<Producto, Integer> repo;
	
	@Override
	protected IGenericRepo<Producto, Integer> getRepo() {
		return repo;
	}

}
