angular.module('hostelapp').controller("webCtrl",
		function($state, $scope, $localStorage) {

			$scope.goToHomePage = function() {

				$state.go('web.home');
			}
			$scope.goToForgotPasswordPage = function() {

				$state.go('forgotPasswordPage');
			}

		});
