package isw.decorator.impl;

public class MP3Player extends AutoDecorator{

	public MP3Player(Vendible vendible) {
		super(vendible);
	}

	@Override
	public String getDescripcion() {
		return getVendible().getDescripcion() + " mas " + getClass().getSimpleName();
	}

	@Override
	public float getPrecio() {
		return getVendible().getPrecio() + 250;
	}

}
