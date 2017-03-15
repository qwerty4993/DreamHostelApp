angular
		.module('hostelapp')
		.controller(
				"loginctrl",
				function($state, $scope, $http, $localStorage, notify, HOSTELAPP_CONSTANTS,$location) {
					
//					$scope.loginDetails = {};
//					$scope.gotoDashBoard = function() {
//						var authorization = "Basic "
//								+ btoa($scope.loginDetails.username + ":"
//										+ $scope.loginDetails.password);
//						console.log(authorization);
//						$localStorage.authorization = authorization;
//						$localStorage.$save();
//						
//						loginService
//								.doLogin($scope.loginDetails)
//								.then(
//										function(response) {
//											console.log('In Login Ctrl');
//											// console.log($scope.loginDetails.email+"---"+$scope.loginDetails.password);
//
//											console.log(data.data);
////											$localStorage.restaurantId = response.data.restaurantId;
//											
//
//										});
//					};
					$scope.gotoDashBoard=function(loginDetails){
						var url = HOSTELAPP_CONSTANTS.URL + "login";
						console.log(url);
						console.log($scope.loginDetails);
						$http.post(url, $scope.loginDetails).then(function(data) {
							console.log(data.data);

							if(data.data.statusCode==200){
								$state.go('hostel.dashboard');
							}else {
								$state.go('web.home');
								notify({
									message : "Invalid UserName/Password",
									classes : 'alert-danger',
									duration: 1500
								})
								
							}

						});

						
					}
				});
