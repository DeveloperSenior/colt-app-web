package co.com.colt.services;

import javax.ws.rs.core.Response;

import co.com.colt.dto.CiudadDTO;
import co.com.colt.dto.PerfilDTO;
import co.com.colt.dto.RutaDTO;
import co.com.colt.dto.UsuarioDTO;
import co.com.colt.dto.VehiculoDTO;
import co.com.colt.services.base.ColtResponseBase;
import co.com.colt.session.DelegateContextEJB;
import co.com.colt.utilities.ColtException;

public class ColtCoreServices extends ColtResponseBase implements IColtCoreServices{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Response grabarRuta(RutaDTO ruta) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().grabarRuta(ruta));
	}

	@Override
	public Response actualizarRuta(RutaDTO ruta) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().actualizarRuta(ruta));
	}

	@Override
	public Response eliminarRuta(RutaDTO ruta) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().eliminarRuta(ruta));
	}

	@Override
	public Response consultarRuta(RutaDTO ruta) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().consultarRuta(ruta));
	}

	@Override
	public Response grabarVehiculo(VehiculoDTO vehiculo) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().grabarVehiculo(vehiculo));
	}

	@Override
	public Response actualizarVehiculo(VehiculoDTO vehiculo)
			throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().actualizarVehiculo(vehiculo));
	}

	@Override
	public Response eliminarVehiculo(VehiculoDTO vehiculo) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().eliminarVehiculo(vehiculo));
	}

	@Override
	public Response consultarVehiculo(VehiculoDTO vehiculo)
			throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().consultarVehiculo(vehiculo));
	}

	@Override
	public Response grabarUsuario(UsuarioDTO usuario) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().grabarUsuario(usuario));
	}

	@Override
	public Response actualizarUsuario(UsuarioDTO usuario) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().actualizarUsuario(usuario));
	}

	@Override
	public Response consultarUsuario(UsuarioDTO usuario) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().consultarUsuario(usuario));
	}

	@Override
	public Response grabarPerfil(PerfilDTO perfil) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().grabarPerfil(perfil));
	}

	@Override
	public Response actualizarPerfil(PerfilDTO perfil) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().actualizarPerfil(perfil));
	}

	@Override
	public Response consultarPerfil(PerfilDTO perfil) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().consultarPerfil(perfil));
	}

	@Override
	public Response grabarCiudad(CiudadDTO ciudad) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().grabarCiudad(ciudad));
	}

	@Override
	public Response actualizarCiudad(CiudadDTO ciudad) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().actualizarCiudad(ciudad));
	}

	@Override
	public Response eliminarCiudad(CiudadDTO ciudad) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().eliminarCiudad(ciudad));
	}

	@Override
	public Response consultarCiudad(CiudadDTO ciudad) throws ColtException {
		return getResponse(DelegateContextEJB.getCoreBean().consultarCiudad(ciudad));
	}
		

}
