package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;

public interface Raza {

    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario);

	public ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes;

	public ExtractorMineral crearExtractorMineral(Jugador propietario);

    public CreadorDeSoldados crearCreadorDeSoldados(Jugador propietario);

    public CreadorDeUnidadesTerrestres crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas;

    public CreadorDeUnidadesAereas crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas;
}
