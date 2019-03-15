package isw.decorator.impl;

public class CDPlayer extends AutoDecorator{

	public CDPlayer(Vendible vendible) {
		super(vendible);
	}

	@Override
	public String getDescripcion() {
		return getVendible().getDescripcion() + " mas "+ getClass().getSimpleName();
	}

	@Override
	public float getPrecio() {
		return getVendible().getPrecio() + 100;
	}

}
