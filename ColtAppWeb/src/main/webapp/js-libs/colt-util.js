const port = 8082;
const host = 'http://localhost:'+port+'/ColtAppWeb/ColtServices';

   /**
	 * Obtiene el contexto de la aplicacion
	 * @returns
	 */
	function getContextPath() {
		   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	}
	function setUserSession(json){
		sessionStorage.setItem("userSession",utf8_to_b64(angular.toJson(json)));
	}
	function getUserSession(){
		var object = sessionStorage.getItem("userSession");
		if(object != null)return angular.fromJson( b64_to_utf8(object));
		return null;
	}
	

	function utf8_to_b64(str) {
	return window.btoa(unescape(encodeURIComponent(str)));
    }

	function b64_to_utf8(str) {
		return decodeURIComponent(escape(window.atob(str)));
	}