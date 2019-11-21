angular
		.module('coltApp',[])
		.config(
				function($httpProvider) {

					var spinnerReqFunction = function(data, headersGetter) {
						if ($('body #loading-backdrop').length <= 0) {
							$('body')
									.append(
											'<div id="loading-backdrop">'
													+ '  <div id="loading">'
													+ '    Cargando <br><img src="'
													+ getContextPath()
													+ '/img/cargando.gif" width="50px" />'
													+ '  </div>' + '</div>');
						}
						return data;
					};

					var spinnerResFunction = function(data, headersGetter) {
						if ($('body #loading-backdrop').length) {
							$('body #loading-backdrop').remove();
						}
						return data;
					};

					$httpProvider.defaults.transformRequest
							.push(spinnerReqFunction);
					$httpProvider.defaults.transformResponse
							.push(spinnerResFunction);
				})

		.factory(
				'templateFactory',
				[
						'$compile',
						'$templateRequest',
						'$sce',
						function($compile, $templateRequest, $sce) {
							var templateFactory = {};
							templateFactory.loadTemplate = function(url,
									container, scope, callback) {
								var templateUrl = $sce
										.getTrustedResourceUrl(url);
								$templateRequest(templateUrl)
										.then(
												function(template) {
													$compile(
															$("#" + container)
																	.html(
																			template)
																	.contents())
															(scope);
													if (callback) {
														callback();
													}
												},
												function() {
													console
															.log('Error cargando el template '
																	+ url
																	+ ', '
																	+ container
																	+ ', '
																	+ scope);
												});
							}
							return templateFactory;
						} ])
		.service(
				'coltServices',
				function($http, $window) {
					$http.defaults.useXDomain = true;
					var headers = {
						'Access-Control-Allow-Methods' : 'POST, GET, OPTIONS, PUT',
						'Access-Control-Allow-Headers' : 'Content-Type, Accept, X-Requested-With',
						'Access-Control-Allow-Origin' : '*',
						'Content-Type' : 'application/json',
						'Accept' : 'application/json',
						'secureToken' : '',
					};

					this.sendGet = function(urlEndPoint, success, error) {
						if (getUserSession() != null) {
							headers.secureToken = getUserSession().secureToken;
						}
						$http({
							url : urlEndPoint,
							method : 'GET',
							headers : headers
						}).then(function(response) {
								success(response);
						}, function(response) {
							if ($('body #loading-backdrop').length) {
								$('body #loading-backdrop').remove();
							}
							error(response);
						});
					}

					this.sendPost = function(json, urlEndPoint, success, error) {
						if (getUserSession() != null) {
							headers.secureToken = getUserSession().secureToken;
						}
						$http({
							url : urlEndPoint,
							method : 'POST',
							data : json,
							headers : headers
						}).then(function(response) {
								success(response);
						}, function(response) {
							if ($('body #loading-backdrop').length) {
								$('body #loading-backdrop').remove();
							}
							error(response);
						});
					}

				});