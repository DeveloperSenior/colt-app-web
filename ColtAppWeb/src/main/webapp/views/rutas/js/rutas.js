/**
 * Js rutas
 */
const
RutaDTO = function() {
	return {
	    idRuta:0,
	    descripcion:null,
	    codigo:null,
	    origen:CiudadDTO(),
	    destino:CiudadDTO()
	};
}