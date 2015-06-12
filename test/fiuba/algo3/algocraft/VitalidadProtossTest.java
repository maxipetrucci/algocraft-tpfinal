package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;

import org.junit.Assert;
import org.junit.Test;

public class VitalidadProtossTest {
    @Test
    public void recibirDanyoRestaElDanyoPrimeroDelEscudo() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int escudoInicial = 100;
        int danyoHecho = 50;
        VitalidadProtoss estado = new VitalidadProtoss(vidaInicial, escudoInicial);

        estado.recibirDanyo(danyoHecho);

        Assert.assertEquals(estado.getVida(), vidaInicial);
        Assert.assertEquals(estado.getEscudo(), escudoInicial - danyoHecho);
    }

    @Test
    public void recibirDanyoMayorAlEscudoDejaAlEscudoEnCeroYComienzaARestarLaVida() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int escudoInicial = 100;
        int danyoHecho = 150;
        VitalidadProtoss estado = new VitalidadProtoss(vidaInicial, escudoInicial);

        estado.recibirDanyo(danyoHecho);

        Assert.assertEquals(estado.getVida(), vidaInicial + escudoInicial - danyoHecho );
        Assert.assertEquals(estado.getEscudo(), 0);
    }

    @Test(expected = ExcepcionEstadoMuerto.class)
    public void recibirDanyoLanzaExcepcionSiElDanyoEsMayorOIgualALaVidaYAlEscudoSumados() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int escudoInicial = 100;
        int danyoHecho = 350;
        VitalidadProtoss estado = new VitalidadProtoss(vidaInicial, escudoInicial);

        estado.recibirDanyo(danyoHecho);
    }
}
