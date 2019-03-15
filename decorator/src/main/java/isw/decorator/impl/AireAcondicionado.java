package isw.decorator.impl;

public class AireAcondicionado extends AutoDecorator{

	public AireAcondicionado(Vendible vendible) {
		super(vendible);
	}

	@Override
	public String getDescripcion() {
		return getVendible().getDescripcion() + " mas " + getClass().getSimpleName();
	}

	@Override
	public float getPrecio() {
		return getVendible().getPrecio() + 1500;
	}

}
