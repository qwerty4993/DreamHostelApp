angular
		.module('hostelapp')
		.controller(
				"loginctrl",
				function($state, $scope, $http, $stateParams, $localStorage,
						notify, HOSTELAPP_CONSTANTS, $location, loginService) {
					$scope.userName = $stateParams.userName;
					// $scope.loginDetails = {};
					// $scope.gotoDashBoard = function() {
					// var authorization = "Basic "
					// + btoa($scope.loginDetails.username + ":"
					// + $scope.loginDetails.password);
					// console.log(authorization);
					// $localStorage.authorization = authorization;
					// $localStorage.$save();
					//						
					// loginService
					// .doLogin($scope.loginDetails)
					// .then(
					// function(response) {
					// console.log('In Login Ctrl');
					// //
					// console.log($scope.loginDetails.email+"---"+$scope.loginDetails.password);
					//
					// console.log(data.data);
					// // $localStorage.restaurantId =
					// response.data.restaurantId;
					//											
					//
					// });
					// };
					$scope.email = $stateParams.email;
					$scope.user = {};
					$scope.gotoDashBoard = function(loginDetails) {
						var url = HOSTELAPP_CONSTANTS.URL + "login";
						console.log(url);
						console.log($scope.loginDetails);
						$http
								.post(url, $scope.loginDetails)
								.then(
										function(data) {
											console.log(data.data.responseObjects);
											
											if (data.data.statusCode == 200) {
												if (data.data.responseObjects.role.name == 'admin') {
													console.log(data.data.responseObjects.role.features)
													
													$state
															.go('hostel.dashboard');
												} else {
													$state
															.go('hostel.userDashboard');
													console.log("hello")
													// $state.go('hostel.userDashboard');
												}
												$localStorage.user = data.data.responseObjects;
												// we have to keep student and
												// manager id in localstorage
												$localStorage.$save();

											} else {
												$state.go('web.home');
												notify({
													message : "Invalid UserName/Password",
													classes : 'alert-danger',
													duration : 30000
												})

											}

										});

					}

					$scope.goToHomePage = function() {
						$state.go('web.home');
					}
					
					$scope.gotoForgotPasswordPage = function() {
						$state.go('forgotPasswordPage');

					}
					$scope.gotoForgotPassword = function(sendMail) {
						console.log($scope.sendMail.email)
						loginService
								.forgotPassword($scope.sendMail.email)
								.then(
										function(data) {
											if (data.data.statusCode = 302) {
												$state.go('web.home');
												notify({
													message : "We've sent password to your email. Resetting the password!!!",
													classes : 'alert-danger',
												});
											} else {

												notify({
													message : "Email not is Register with Us ",
													classes : 'alert-primary',
												});
											}
										});
					}
					
					$scope.gotoResetPassword = function(rest) {
						console.log(rest)
						
					}
					
					
				});
