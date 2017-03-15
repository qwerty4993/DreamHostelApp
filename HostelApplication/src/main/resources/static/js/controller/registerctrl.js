angular.module('hostelapp').controller("registerctrl",
function($state, $scope, notify,$stateParams) {
					
					
					$scope.addStudent = function(student) {
						console.log(student);
						
										}
					$scope.goToForgotPassword = function() {
						$state.go('forgotPassword');
					};
					$scope.forgotPassword = function(username) {
						loginService
								.forgotPassword(username)
								.then(
										function(response) {

											notify({
												message : "fdfdf!",
												classes : 'alert-success',
											});
										}, function(error) {
											notify({
												message : error.data.message,
												classes : 'alert-danger',
											});
										});
					};
					$scope.resetPassword = function(user) {
						user.username = $scope.userName;
						loginService.resetPassword($scope.user).then(
								function(response) {
									$state.go('login');
								})
					}
				});