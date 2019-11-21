package co.com.colt.business;

import java.util.List;

import co.com.colt.dto.CiudadDTO;
import co.com.colt.dto.PerfilDTO;
import co.com.colt.dto.RutaDTO;
import co.com.colt.dto.UsuarioDTO;
import co.com.colt.dto.VehiculoDTO;
import co.com.colt.utilities.ColtException;


public interface CoreBeanLocal {
	
	/**
	 * grabarRuta
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public RutaDTO grabarRuta(RutaDTO ruta)throws ColtException;
	
	/**
	 * actualizarRuta
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public RutaDTO actualizarRuta(RutaDTO ruta)throws ColtException;
	
	/**
	 * actualizarRuta
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public RutaDTO eliminarRuta(RutaDTO ruta)throws ColtException;
	
	/**
	 * consultarRuta
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public List<RutaDTO> consultarRuta(RutaDTO ruta)throws ColtException;
	
	
	/**
	 * grabarVehiculo
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public VehiculoDTO grabarVehiculo(VehiculoDTO vehiculo)throws ColtException;
	
	/**
	 * actualizarVehiculo
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public VehiculoDTO actualizarVehiculo(VehiculoDTO vehiculo)throws ColtException;
	
	/**
	 * eliminarVehiculo
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public VehiculoDTO eliminarVehiculo(VehiculoDTO vehiculo)throws ColtException;
	
	/**
	 * consultarVehiculo
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public List<VehiculoDTO> consultarVehiculo(VehiculoDTO vehiculo)throws ColtException;
	
	/**
	 * grabarUsuario
	 * @param usuario
	 * @return
	 * @throws ColtException
	 */
	public UsuarioDTO grabarUsuario(UsuarioDTO usuario)throws ColtException;
	
	/**
	 * grabarUsuario
	 * @param usuario
	 * @return
	 * @throws ColtException
	 */
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuario)throws ColtException;
	
	/**
	 * consultarUsuario
	 * @param usuario
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuario(UsuarioDTO usuario)throws ColtException;
	
	/**
	 * grabarPerfil
	 * @param perfil
	 * @return
	 * @throws ColtException
	 */
	public PerfilDTO grabarPerfil(PerfilDTO perfil)throws ColtException;
	
	/**
	 * actualizarPerfil
	 * @param perfil
	 * @return
	 * @throws ColtException
	 */
	public PerfilDTO actualizarPerfil(PerfilDTO perfil) throws ColtException;
	
	/**
	 * consultarPerfil
	 * @param perfil
	 * @return
	 * @throws ColtException
	 */
	public List<PerfilDTO> consultarPerfil(PerfilDTO perfil)throws ColtException;
	
	/**
	 * consultarPerfil
	 * @param ciudad
	 * @return
	 * @throws ColtException
	 */
	public CiudadDTO grabarCiudad(CiudadDTO ciudad)throws ColtException;
	
	/**
	 * actualizarCiudad
	 * @param ciudad
	 * @return
	 * @throws ColtException
	 */
	public CiudadDTO actualizarCiudad(CiudadDTO ciudad)throws ColtException;
	
	/**
	 * eliminarCiudad
	 * @param ciudad
	 * @return
	 * @throws ColtException
	 */
	public CiudadDTO eliminarCiudad(CiudadDTO ciudad) throws ColtException;
	
	/**
	 * consultarCiudad
	 * @param ciudad
	 * @return
	 * @throws ColtException
	 */
	public List<CiudadDTO> consultarCiudad(CiudadDTO ciudad)throws ColtException;
	

}
