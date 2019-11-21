angular.module('coltApp').controller('indexCtrl',['$scope', '$compile', '$templateRequest', '$sce', 
                                                   'coltServices', 'templateFactory',
                                           function($scope, $compile, $templateRequest, $sce, coltServices, templateFactory) {
	
	$scope.snSession = 'N';
	const main_container = 'main-container';
	$scope.msg = {
			type:null,
			message:null
	};
	
	$scope.userSession = UsuarioDTO();
	
	$scope.user = UsuarioDTO();
	$scope.users = new Array();
	
	$scope.perfil = PerfilDTO();
	$scope.perfiles = new Array();
	
	$scope.vehiculo = VehiculoDTO();
	$scope.vehiculos = new Array();
	
	$scope.ciudad = CiudadDTO();
	$scope.ciudades = new Array();
	
	$scope.ruta = RutaDTO();
	$scope.rutas = new Array();
	
	$scope.loadTemplate =  function(url, callback){
		templateFactory.loadTemplate(url, main_container, $scope, callback);
	}
	
	$scope.onInit = function(){
		$scope.navigateMenu('index/home.html',null);
	}
	
	
	$scope.navigateMenu = function(page,callback){
		$scope.loadTemplate('views/'+page,callback);
	}
	
	$scope.login = function(){
		
		try{
			if($scope.user.login !== null && $scope.user.clave !== null){
				
				var success = function(response){
					try{
						var userResponse = angular.fromJson(response.data);
						if(userResponse.idUsuario > 0){
							$scope.userSession = userResponse;
							$scope.snSession = 'S';
							$scope.user = UsuarioDTO();
							$("#modalLoginForm").modal('hide');
						}else{
							$scope.type = 'Validación';
							$scope.msg = 'Usuario ingresado no es valido';
							mostarAlerta();
							alert($scope.msg);
						}
					}catch(error){
						$scope.type = 'Error';
						$scope.msg = error.message;
						mostarAlerta();
						alert($scope.msg);
					}
				}
				
				var error = function(response){
					$scope.type = 'Error';
					$scope.msg = response.data;
					mostarAlerta();
					alert($scope.msg);
				}
				coltServices.sendPost(angular.toJson($scope.user),host + '/ColtServiceLogin/login', success, error);
			}else{
				$scope.type = 'Validación';
				$scope.msg = 'Ingrese la informacion requerida';
				mostarAlerta();
				alert($scope.msg);
			}
		}catch(error){
			$scope.type = 'Error';
			$scope.msg = error.message;
			mostarAlerta();
			alert($scope.msg);
		}
		
	}
	
   $scope.logout = function(){
	    $scope.snSession = 'N';
		$scope.user = UsuarioDTO();
		$scope.users = new Array();
		$scope.perfil = PerfilDTO();
		$scope.perfiles = new Array();
		$scope.vehiculo = VehiculoDTO();
		$scope.vehiculos = new Array();
		$scope.ciudad = CiudadDTO();
		$scope.ciudades = new Array();
		$scope.ruta = RutaDTO();
		$scope.rutas = new Array();
		$scope.userSession = UsuarioDTO();
	    $scope.onInit();
	}
	
   
   /**
    * perfil item
    */
	
   $scope.callBackPerfiles = function() {
		$scope.consultarPerfil();
    }
	
	$scope.consultarPerfil = function(){
		try {
			var success = function(response) {
				try {
					$scope.perfiles = angular.fromJson(response.data);
				} catch (error) {
					$scope.type = 'Error';
					$scope.msg = error.message;
					mostarAlerta();
				}
			}
	
			var error = function(response) {
				$scope.type = 'Error';
				$scope.msg = response.data;
				mostarAlerta();
			}
			
			var sendObject = $scope.perfil;
			sendObject.activo = 'S';
			
			coltServices.sendPost(angular.toJson(sendObject), host+ '/ColtCoreServices/consultarPerfil',success, error);
		} catch (error) {
			$scope.type = 'Error';
			$scope.msg = error.message;
			mostarAlerta();
		}
	}
	
	$scope.guardarPerfil = function(){
		try {
			if($scope.perfil !== undefined && $scope.perfil !== null 
					&& $scope.perfil.nombre !== null 
					&& $scope.perfil.nombre !== ''
					){
				
				if($scope.perfil.idPerfil > 0){
					$scope.type = 'Validación';
					$scope.msg = 'El registro ya existe';
					mostarAlerta();
					return false;
				}
				var success = function(response) {
					try {
						$scope.msg = 'Registro almacenado';
						$scope.perfil = PerfilDTO();
						$scope.type = 'Información';
						mostarAlerta();
						$scope.consultarPerfil();
					} catch (error) {
						$scope.type = 'Error';
						$scope.msg = error.message;
						mostarAlerta();
					}
				}
		
				var error = function(response) {
					$scope.type = 'Error';
					$scope.msg = response.data;
					mostarAlerta();
				}
				
				coltServices.sendPost(angular.toJson($scope.perfil), host+ '/ColtCoreServices/grabarPerfil',success, error);
			}else{
				$scope.type = 'Validación';
				$scope.msg = 'Ingrese los valores obligatorios';
				mostarAlerta();
			}
		} catch (error) {
			$scope.type = 'Error';
			$scope.msg = error.message;
			mostarAlerta();
		}		
	}

	$scope.actualizarPerfil = function(){
		try {
			if($scope.perfil !== undefined && $scope.perfil !== null 
					&& $scope.perfil.nombre !== null 
					&& $scope.perfil.nombre !== ''
					){
				
				if($scope.perfil.idPerfil === 0){
					$scope.type = 'Validación';
					$scope.msg = 'El registro no existe';
					mostarAlerta();
					return false;
				}
				
				var success = function(response) {
					try {
						$scope.msg = 'Registro actualizado';
						$scope.perfil = PerfilDTO();
						$scope.type = 'Información';
						mostarAlerta();
						$scope.consultarPerfil();
					} catch (error) {
						$scope.type = 'Error';
						$scope.msg = error.message;
						mostarAlerta();
					}
				}
		
				var error = function(response) {
					$scope.type = 'Error';
					$scope.msg = response.data;
					mostarAlerta();
				}
				
				coltServices.sendPost(angular.toJson($scope.perfil), host+ '/ColtCoreServices/actualizarPerfil',success, error);
			}else{
				$scope.type = 'Validación';
				$scope.msg = 'Ingrese los valores obligatorios';
				mostarAlerta();
			}
		} catch (error) {
			$scope.type = 'Error';
			$scope.msg = error.message;
			mostarAlerta();
		}		
	}

	
	$scope.editPerfil = function(perfil){
		$scope.perfil= perfil;
		if($scope.perfil.activo === null || $scope.user.activo === undefined || $scope.user.activo == ''){
			$scope.perfil.activo = 'N';
		}
	}
	
	$scope.eliminarPerfil = function(perfil){
		$scope.perfil= perfil;
		$scope.perfil.activo = 'N';
		$scope.actualizarPerfil();
	}
	
	   /**
	    * usuarios item
	    */
		
	   $scope.callBackUsuarios = function() {
			$scope.user= UsuarioDTO();
			$scope.consultarUsuarios();
	    }
		
		$scope.consultarUsuarios = function(){
			try {
				var success = function(response) {
					try {
						$scope.users = angular.fromJson(response.data);
					} catch (error) {
						$scope.type = 'Error';
						$scope.msg = error.message;
						mostarAlerta();
					}
				}
		
				var error = function(response) {
					$scope.type = 'Error';
					$scope.msg = response.data;
					mostarAlerta();
				}
				
				var sendObject = $scope.user;
				coltServices.sendPost(angular.toJson(sendObject), host+ '/ColtCoreServices/consultarUsuario',success, error);
			} catch (error) {
				$scope.type = 'Error';
				$scope.msg = error.message;
				mostarAlerta();
			}
		}
		
		$scope.guardarUsuario = function(){
			try {
				var valid = true;
				
				if(valid){
					var success = function(response) {
						try {
							$scope.msg = 'Registro almacenado';
							$scope.user = UsuarioDTO();
							$scope.type = 'Información';
							mostarAlerta();
							$scope.consultarUsuarios();
						} catch (error) {
							$scope.type = 'Error';
							$scope.msg = error.message;
							mostarAlerta();
						}
					}
			
					var error = function(response) {
						$scope.type = 'Error';
						$scope.msg = response.data;
						mostarAlerta();
					}
					coltServices.sendPost(angular.toJson($scope.user), host+ '/ColtCoreServices/grabarUsuario',success, error);
				}else{
					$scope.type = 'Validación';
					$scope.msg = 'Ingrese los valores obligatorios';
					mostarAlerta();
				}
			} catch (error) {
				$scope.type = 'Error';
				$scope.msg = error.message;
				mostarAlerta();
			}		
		}
		
		$scope.actualizarUsuario = function(){
			try {
				var valid = true;
				
				if(valid){
					var success = function(response) {
						try {
						    $scope.msg = 'Registro actualizado';
							$scope.user = UsuarioDTO();
							$scope.type = 'Información';
							mostarAlerta();
							$scope.consultarUsuarios();
						} catch (error) {
							$scope.type = 'Error';
							$scope.msg = error.message;
							mostarAlerta();
						}
					}
			
					var error = function(response) {
						$scope.type = 'Error';
						$scope.msg = response.data;
						mostarAlerta();
					}
					
					coltServices.sendPost(angular.toJson($scope.user), host+ '/ColtCoreServices/actualizarUsuario',success, error);
				}else{
					$scope.type = 'Validación';
					$scope.msg = 'Ingrese los valores obligatorios';
					mostarAlerta();
				}
			} catch (error) {
				$scope.type = 'Error';
				$scope.msg = error.message;
				mostarAlerta();
			}		
		}
		
		$scope.editUser = function(user){
			$scope.user = user;
			angular.forEach($scope.perfiles, function(perfil, index) {
				if(perfil.idPerfil === $scope.user.perfil.idPerfil){
 				   $scope.perfil = perfil;
				}
			});
			
		}
		
		$scope.eliminarUser = function(user){
			$scope.user= user;
			$scope.actualizarUsuario();
		}
		
		   /**
		    * vehiculos item
		    */
			
		   $scope.callBackVehiculos = function() {
				$scope.consultarVehiculos();
		    }
			
			$scope.consultarVehiculos = function(){
				try {
					var success = function(response) {
						try {
							$scope.vehiculos = angular.fromJson(response.data);
						} catch (error) {
							$scope.type = 'Error';
							$scope.msg = error.message;
							mostarAlerta();
						}
					}
			
					var error = function(response) {
						$scope.type = 'Error';
						$scope.msg = response.data;
						mostarAlerta();
					}
					
					var sendObject = $scope.vehiculo;
					sendObject.activo = 'S';
					coltServices.sendPost(angular.toJson(sendObject), host+ '/ColtCoreServices/consultarVehiculo',success, error);
				} catch (error) {
					$scope.type = 'Error';
					$scope.msg = error.message;
					mostarAlerta();
				}
			}
			
			$scope.guardarVehiculo = function(){
				try {
					var valid = true;
					
					if(valid){
						var success = function(response) {
							try {
								$scope.msg = 'Registro almacenado';
								$scope.vehiculo = VehiculoDTO();
								$scope.type = 'Información';
								mostarAlerta();
								$scope.consultarVehiculos();
							} catch (error) {
								$scope.type = 'Error';
								$scope.msg = error.message;
								mostarAlerta();
							}
						}
				
						var error = function(response) {
							$scope.type = 'Error';
							$scope.msg = response.data;
							mostarAlerta();
						}
						
						coltServices.sendPost(angular.toJson($scope.vehiculo), host+ '/ColtCoreServices/grabarVehiculo',success, error);
					}else{
						$scope.type = 'Validación';
						$scope.msg = 'Ingrese los valores obligatorios';
						mostarAlerta();
					}
				} catch (error) {
					$scope.type = 'Error';
					$scope.msg = error.message;
					mostarAlerta();
				}		
			}
			
			$scope.actualizarVehiculo = function(){
				try {
					var valid = true;
					
					if(valid){
						var success = function(response) {
							try {
							    $scope.msg = 'Registro actualizado';
								$scope.vehiculo = VehiculoDTO();
								$scope.type = 'Información';
								mostarAlerta();
								$scope.consultarVehiculos();
							} catch (error) {
								$scope.type = 'Error';
								$scope.msg = error.message;
								mostarAlerta();
							}
						}
				
						var error = function(response) {
							$scope.type = 'Error';
							$scope.msg = response.data;
							mostarAlerta();
						}
						
						coltServices.sendPost(angular.toJson($scope.vehiculo), host+ '/ColtCoreServices/actualizarVehiculo',success, error);
					}else{
						$scope.type = 'Validación';
						$scope.msg = 'Ingrese los valores obligatorios';
						mostarAlerta();
					}
				} catch (error) {
					$scope.type = 'Error';
					$scope.msg = error.message;
					mostarAlerta();
				}		
			}
			
			$scope.editVehiculo = function(vehiculo){
				$scope.vehiculo = vehiculo;	
			}
			
			$scope.eliminarVehiculo = function(vehiculo){
				$scope.vehiculo = vehiculo;
				$scope.actualizarVehiculo();
			}
			
		   /**
		    * ciudades item
		    */
			
		   $scope.callBackCiudades = function() {
				$scope.consultarCiudades();
		    }
			
			$scope.consultarCiudades = function(){
				try {
					var success = function(response) {
						try {
							$scope.ciudades = angular.fromJson(response.data);
						} catch (error) {
							$scope.type = 'Error';
							$scope.msg = error.message;
							mostarAlerta();
						}
					}
			
					var error = function(response) {
						$scope.type = 'Error';
						$scope.msg = response.data;
						mostarAlerta();
					}
					
					var sendObject = $scope.ciudad;
					coltServices.sendPost(angular.toJson(sendObject), host+ '/ColtCoreServices/consultarCiudad',success, error);
				} catch (error) {
					$scope.type = 'Error';
					$scope.msg = error.message;
					mostarAlerta();
				}
			}
			
			$scope.guardarCiudad = function(){
				try {
					var valid = true;
					
					if(valid){
						var success = function(response) {
							try {
								$scope.msg = 'Registro almacenado';
								$scope.ciudad = CiudadDTO();
								$scope.type = 'Información';
								mostarAlerta();
								$scope.consultarCiudades();
							} catch (error) {
								$scope.type = 'Error';
								$scope.msg = error.message;
								mostarAlerta();
							}
						}
				
						var error = function(response) {
							$scope.type = 'Error';
							$scope.msg = response.data;
							mostarAlerta();
						}
						
						coltServices.sendPost(angular.toJson($scope.ciudad), host+ '/ColtCoreServices/grabarCiudad',success, error);
					}else{
						$scope.type = 'Validación';
						$scope.msg = 'Ingrese los valores obligatorios';
						mostarAlerta();
					}
				} catch (error) {
					$scope.type = 'Error';
					$scope.msg = error.message;
					mostarAlerta();
				}		
			}
			
			$scope.actualizarCiudad = function(){
				try {
					var valid = true;
					
					if(valid){
						var success = function(response) {
							try {
							    $scope.msg = 'Registro actualizado';
								$scope.ciudad = CiudadDTO();
								$scope.type = 'Información';
								mostarAlerta();
								$scope.consultarCiudades();
							} catch (error) {
								$scope.type = 'Error';
								$scope.msg = error.message;
								mostarAlerta();
							}
						}
				
						var error = function(response) {
							$scope.type = 'Error';
							$scope.msg = response.data;
							mostarAlerta();
						}
						
						coltServices.sendPost(angular.toJson($scope.ciudad), host+ '/ColtCoreServices/actualizarCiudad',success, error);
					}else{
						$scope.type = 'Validación';
						$scope.msg = 'Ingrese los valores obligatorios';
						mostarAlerta();
					}
				} catch (error) {
					$scope.type = 'Error';
					$scope.msg = error.message;
					mostarAlerta();
				}		
			}
			
			$scope.editCiudad = function(ciudad){
				$scope.ciudad = ciudad;	
			}
			
			$scope.eliminarCiudad = function(ciudad){
				$scope.ciudad = ciudad;
				$scope.actualizarCiudad();
			}
			
			   /**
			    * rutas item
			    */
				
			   $scope.callBackRutas = function() {
					$scope.consultarRutas();
			    }
				
				$scope.consultarRutas = function(){
					try {
						var success = function(response) {
							try {
								$scope.rutas = angular.fromJson(response.data);
							} catch (error) {
								$scope.type = 'Error';
								$scope.msg = error.message;
								mostarAlerta();
							}
						}
				
						var error = function(response) {
							$scope.type = 'Error';
							$scope.msg = response.data;
							mostarAlerta();
						}
						
						var sendObject = $scope.ruta;
						coltServices.sendPost(angular.toJson(sendObject), host+ '/ColtCoreServices/consultarRuta',success, error);
					} catch (error) {
						$scope.type = 'Error';
						$scope.msg = error.message;
						mostarAlerta();
					}
				}
				
				$scope.guardarRuta = function(){
					try {
						if ($scope.ruta.idRuta > 0) {
							$scope.type = 'Validación';
							$scope.msg = 'El registro ya existe';
							mostarAlerta();
							return false;
						}

						var valid = !(
								   $scope.ruta.descripcion === null ||
							       $scope.ruta.codigo === null ||
							       $scope.ruta.origen === null ||
							       $scope.ruta.destino === null
							      );
						
						if(valid){
							var success = function(response) {
								try {
									$scope.msg = 'Registro almacenado';
									$scope.ruta = RutaDTO();
									$scope.type = 'Información';
									mostarAlerta();
									$scope.consultarRutas();
								} catch (error) {
									$scope.type = 'Error';
									$scope.msg = error.message;
									mostarAlerta();
								}
							}
					
							var error = function(response) {
								$scope.type = 'Error';
								$scope.msg = response.data;
								mostarAlerta();
							}
							
							coltServices.sendPost(angular.toJson($scope.ruta), host+ '/ColtCoreServices/grabarRuta',success, error);
						}else{
							$scope.type = 'Validación';
							$scope.msg = 'Ingrese los valores obligatorios';
							mostarAlerta();
						}
					} catch (error) {
						$scope.type = 'Error';
						$scope.msg = error.message;
						mostarAlerta();
					}		
				}
				
				$scope.actualizarRuta = function(){
					try {
						
						if ($scope.ruta.idRuta = 0) {
							$scope.type = 'Validación';
							$scope.msg = 'El registro no existe';
							mostarAlerta();
							return false;
						}

						var valid = !(
								   $scope.ruta.descripcion === null ||
							       $scope.ruta.codigo === null ||
							       $scope.ruta.origen === null ||
							       $scope.ruta.destino === null
							      );

						if(valid){
							var success = function(response) {
								try {
								    $scope.msg = 'Registro actualizado';
									$scope.ruta = RutaDTO();
									$scope.type = 'Información';
									mostarAlerta();
									$scope.consultarRutas();
								} catch (error) {
									$scope.type = 'Error';
									$scope.msg = error.message;
									mostarAlerta();
								}
							}
					
							var error = function(response) {
								$scope.type = 'Error';
								$scope.msg = response.data;
								mostarAlerta();
							}
							
							coltServices.sendPost(angular.toJson($scope.ruta), host+ '/ColtCoreServices/actualizarRuta',success, error);
						}else{
							$scope.type = 'Validación';
							$scope.msg = 'Ingrese los valores obligatorios';
							mostarAlerta();
						}
					} catch (error) {
						$scope.type = 'Error';
						$scope.msg = error.message;
						mostarAlerta();
					}		
				}
				
				$scope.editRuta = function(ruta){
					$scope.ruta = ruta;
					angular.forEach($scope.ciudades, function(ciudad, index) {
						if(ciudad.idCiudad === ruta.origen.idCiudad){
							$scope.ruta.origen = ciudad;
						}
						if(ciudad.idCiudad === ruta.destino.idCiudad){
							$scope.ruta.destino = ciudad;
						}
					});
				}
				
				$scope.eliminarRuta = function(ruta){
					$scope.ruta = ruta;
					$scope.actualizarRuta();
				}

	
	function mostarAlerta(){
		var alert = document.querySelector('#alert_colt');
		alert.className = "alert alert-warning alert-dismissible fade show";
		alert.innerHTML = "<strong>"+$scope.type+":</strong> "+$scope.msg;
		setTimeout(function(){alert.className = "alert alert-warning alert-dismissible fade close";},5000);
	}
	
}]);