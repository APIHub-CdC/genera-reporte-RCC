package com.circulodecredito.generarreporte.mapper;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ResumenPorProducto {
	
	private List<ProductoResumen> productoResumen;
	
	@XmlElement(name ="ProductoResumen" )
	public List<ProductoResumen> getProductoResumen() {
		return productoResumen;
	}
	
	public void setProductoResumen(List<ProductoResumen> productoResumen) {
		this.productoResumen = productoResumen;
	}
}
