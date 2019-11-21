/**
 * Js usuarios
 */
const
UsuarioDTO = function() {
	return {
		idUsuario : 0,
		login : null,
		clave : null,
		perfil : PerfilDTO(),
		nombre : null,
		apellido : null,
		cedula : null,
		fechaNacimiento : null,
		telefono : null,
		sexo : null
	};
}