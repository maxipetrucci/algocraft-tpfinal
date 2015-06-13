package fiuba.algo3.algocraft.protoss.construcciones;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.protoss.unidades.AltoTemplario;

public class ArchivosTemplarios extends Construccion {

    private static final int TIEMPO_DE_CONSTRUCCION = 9;
    private static final int VIDA_INICIAL = 500;
    private static final int ESCUDO_INICIAL = 500;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 200;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public ArchivosTemplarios(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION);

        if (!propietario.tieneConstruccionDeTipo(TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES))
            throw new ExcepcionConstruccionesRequeridasNoCreadas();
    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS;
    }

    public AltoTemplario crearAltoTemplario(Mapa mapa) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNoHayLugarDisponible {
        AltoTemplario altoTemplario = new AltoTemplario(this.propietario);
        mapa.ubicarCercaDeParcela(parcelaUbicacion, altoTemplario);

        return altoTemplario;
    }
}