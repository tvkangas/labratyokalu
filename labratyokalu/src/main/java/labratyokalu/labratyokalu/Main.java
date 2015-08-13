package labratyokalu.labratyokalu;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.SwingUtilities;
import labratyokalu.labratyokalu.ajastin.*;
import labratyokalu.labratyokalu.laskin.*;
import labratyokalu.labratyokalu.yksikkomuunnin.*;

public class Main {

    public static void main(String[] args) throws Exception {
//        Kayttoliittyma k = new Kayttoliittyma();
//        k.kaynnista();
        
//        Yksikkomuunnin kilometristaMailiin = new Yksikkomuunnin(1/1.609344, "mailia");
//        System.out.println(kilometristaMailiin.muunna(1.5) + " " + kilometristaMailiin.getYksikko());
        
//        GraafinenLaskin gl = new GraafinenLaskin();
//        gl.run();
        
        GraafinenYksikkomuunninValikko gy = new GraafinenYksikkomuunninValikko();
        gy.run();
    }

}
