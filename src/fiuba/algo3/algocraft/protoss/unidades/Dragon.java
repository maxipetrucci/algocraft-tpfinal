package fiuba.algo3.algocraft.protoss.unidades;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;

public class Dragon extends UnidadAgresora {
    public static final int VIDA_INICIAL = 100;
    public static final int ESCUDO_INICIAL = 80;
    public static final int VISION = 8;
    public static final int CUPO_TRANSPORTE = 4;
    public static final int TIEMPO_DE_CONSTRUCCION = 9;

    public static int COSTO_MINERAL = 125;
    public static int COSTO_GAS = 50;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    

    public Dragon(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.vitalidad = new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.danyo = new Danyo(20, 20);
        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;
        this.rangoAtaque = new RangoAtaque(4, 4);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
    }
}
