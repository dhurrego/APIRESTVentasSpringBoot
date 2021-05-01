package com.deividurrego.service;

import com.deividurrego.model.Venta;

public interface IVentaService extends ICRUD<Venta, Integer>{
	
	Venta registrarTransaccional(Venta venta);
	
}
