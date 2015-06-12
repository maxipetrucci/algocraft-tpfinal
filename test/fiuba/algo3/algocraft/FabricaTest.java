package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.terran.unidades.Golliat;

import org.junit.Assert;
import org.junit.Test;

public class FabricaTest {
    @Test
    public void crearGolliatCreaUnGolliat() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(700);
        unJugador.sumarGasVespeno(700);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(3, 3));

        Assert.assertNotNull(fabrica.crearGolliat(mapa));
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(1, 1));
        Fabrica fabrica = new Fabrica(unJugador);

        Assert.assertEquals(fabrica.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES);
    }

    @Test
    public void crearUnGolliatCreaLaUnidadAlrededorDeLaFabrica() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(700);
        unJugador.sumarGasVespeno(700);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(3, 3));

        Golliat golliat = fabrica.crearGolliat(mapa);

        Assert.assertEquals(golliat.getParcela().getCoordenada(), new Coordenada(2, 3));
    }


    @Test(expected = ExcepcionNoHayLugarDisponible.class)
    public void crearUnGolliatLanzaExcepcionSiLasParcelasAlrededorDeLaFabricaNoPuedenContenerAlGolliat() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        //Rodeo el lugar de la fabrica por parcelas volcan
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(2, 3)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(2, 4)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(3, 2)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(3, 4)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(4, 2)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(4, 3)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(4, 4)));
        unJugador.sumarMinerales(700);
        unJugador.sumarGasVespeno(700);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(3, 3));

        fabrica.crearGolliat(mapa);
    }
}
