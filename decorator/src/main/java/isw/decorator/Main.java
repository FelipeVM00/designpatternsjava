package isw.decorator;

import isw.decorator.impl.AireAcondicionado;
import isw.decorator.impl.CDPlayer;
import isw.decorator.impl.Fiat500;
import isw.decorator.impl.FordFiesta;
import isw.decorator.impl.MP3Player;
import isw.decorator.impl.Vendible;

public class Main 
{
    public static void main( String[] args )
    {
        Vendible auto = new Fiat500();
        Vendible auto2 = new FordFiesta();
        
        auto = new CDPlayer(auto);
        
        auto2 = new AireAcondicionado(auto2);
        auto2 = new MP3Player(auto2);
        
        System.out.println("La descripcion es: " + auto.getDescripcion() + " y el precio es: "+ auto.getPrecio() + ".");
        System.out.println("La descripcion es: " + auto2.getDescripcion() + " y el precio es: "+ auto2.getPrecio() + ".");
        
        
        
    }
}
