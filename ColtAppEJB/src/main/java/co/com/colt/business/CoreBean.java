package co.com.colt.business;

import java.util.List;

import javax.ejb.Stateless;

import co.com.colt.dto.CiudadDTO;
import co.com.colt.dto.PerfilDTO;
import co.com.colt.dto.RutaDTO;
import co.com.colt.dto.UsuarioDTO;
import co.com.colt.dto.VehiculoDTO;
import co.com.colt.facade.CoreFacadeLocal;
import co.com.colt.session.ColtContextLookUp;
import co.com.colt.session.DelegateContextEJB;
import co.com.colt.utilities.ColtException;

@Stateless(name = "CoreBean",
mappedName = "ejb/CoreBean")
public class CoreBean extends ColtContextLookUp implements CoreBeanLocal {
	
	private CoreFacadeLocal facade;
	
	/**
	 * Default constructor
	 */
	public CoreBean(){
		facade = DelegateContextEJB.getCoreFacade();
	}

	@Override
	public RutaDTO grabarRuta(RutaDTO ruta) throws ColtException {
		return facade.grabarRuta(ruta);
	}

	@Override
	public RutaDTO actualizarRuta(RutaDTO ruta) throws ColtException {
		return facade.actualizarRuta(ruta);
	}

	@Override
	public RutaDTO eliminarRuta(RutaDTO ruta) throws ColtException {
		return facade.eliminarRuta(ruta);
	}

	@Override
	public List<RutaDTO> consultarRuta(RutaDTO ruta) throws ColtException {
		return facade.consultarRuta(ruta);
	}

	@Override
	public VehiculoDTO grabarVehiculo(VehiculoDTO vehiculo)
			throws ColtException {
		return facade.grabarVehiculo(vehiculo);
	}

	@Override
	public VehiculoDTO actualizarVehiculo(VehiculoDTO vehiculo)
			throws ColtException {
		return facade.actualizarVehiculo(vehiculo);
	}

	@Override
	public VehiculoDTO eliminarVehiculo(VehiculoDTO vehiculo) throws ColtException {
		return facade.eliminarVehiculo(vehiculo);
	}

	@Override
	public List<VehiculoDTO> consultarVehiculo(VehiculoDTO vehiculo)
			throws ColtException {
		return facade.consultarVehiculo(vehiculo);
	}

	@Override
	public UsuarioDTO grabarUsuario(UsuarioDTO usuario) throws ColtException {
		return facade.grabarUsuario(usuario);
	}

	@Override
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuario)
			throws ColtException {
		return facade.actualizarUsuario(usuario);
	}

	@Override
	public List<UsuarioDTO> consultarUsuario(UsuarioDTO usuario)
			throws ColtException {
		return facade.consultarUsuario(usuario);
	}

	@Override
	public PerfilDTO grabarPerfil(PerfilDTO perfil) throws ColtException {
		return facade.grabarPerfil(perfil);
	}

	@Override
	public PerfilDTO actualizarPerfil(PerfilDTO perfil) throws ColtException {
		return facade.actualizarPerfil(perfil);
	}

	@Override
	public List<PerfilDTO> consultarPerfil(PerfilDTO perfil)
			throws ColtException {
		return facade.consultarPerfil(perfil);
	}

	@Override
	public CiudadDTO grabarCiudad(CiudadDTO ciudad) throws ColtException {
		return facade.grabarCiudad(ciudad);
	}

	@Override
	public CiudadDTO actualizarCiudad(CiudadDTO ciudad) throws ColtException {
		return facade.actualizarCiudad(ciudad);
	}

	@Override
	public CiudadDTO eliminarCiudad(CiudadDTO ciudad) throws ColtException {
		return facade.eliminarCiudad(ciudad);
	}

	@Override
	public List<CiudadDTO> consultarCiudad(CiudadDTO ciudad)
			throws ColtException {
		return facade.consultarCiudad(ciudad);
	}
	
	
}
