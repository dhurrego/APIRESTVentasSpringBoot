package com.deividurrego.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deividurrego.model.Venta;
import com.deividurrego.repo.IGenericRepo;
import com.deividurrego.service.IVentaService;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {

	@Autowired
	private IGenericRepo<Venta, Integer> repo;
	
	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Venta registrarTransaccional(Venta venta) {
		venta.getDetalleVenta().forEach(det -> det.setVenta(venta));
		return repo.save(venta);
	}

}
