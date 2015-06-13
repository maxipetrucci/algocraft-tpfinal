package fiuba.algo3.algocraft.utilidades;

import fiuba.algo3.algocraft.utilidades.unidades.Ataque;
import fiuba.algo3.algocraft.utilidades.unidades.Danyo;
import fiuba.algo3.algocraft.utilidades.unidades.RangoAtaque;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;
import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.*;

public abstract class Interactuable {
	
	protected Jugador propietario;
	protected Vitalidad vitalidad;
	protected int tiempoDeConstruccion;
	protected Parcela parcelaUbicacion;
    //protected int turnosDeConstruccion;

    public Interactuable (Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion) {
        this.propietario = propietario;
        this.vitalidad = vitalidad;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        //this.turnosDeConstruccion = 0;
    }

    public void recibirDanyo(int cantidad) throws ExcepcionEstadoMuerto {
        try {
            (this.vitalidad).recibirDanyo(cantidad);
        }
        catch (ExcepcionEstadoMuerto e) {
            this.destruir();
        }
    }
    
//    public void recibirAtaque(UnidadAgresora agresor, int distancia) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
//    	RangoAtaque rango = agresor.getRangoAtaque();
//    	Danyo danyo = agresor.getDanyo();
//    	if(this.seleccionarRango(rango) < distancia){
//    		throw new ExcepcionEnemigoFueraDeAlcance();
//    	}
//    	this.recibirDanyo(this.seleccionarDanyo(danyo));
//    }
    
    public abstract void recibirAtaque(Ataque ataque) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
    
    public abstract int seleccionarDanyo(Danyo danyo);
    
    public abstract int seleccionarRango(RangoAtaque rango);
    
    
    public void setParcela(Parcela parcela){
    	this.parcelaUbicacion = parcela;
    }
    
    public Parcela getParcela(){
    	return this.parcelaUbicacion;
    }
    
    public int getVida() {
    	return vitalidad.getVida();
    }
    
    public Vitalidad getVitalidad(){
    	return this.vitalidad;
    }

    public abstract void destruir();
    
    public abstract void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

	
}