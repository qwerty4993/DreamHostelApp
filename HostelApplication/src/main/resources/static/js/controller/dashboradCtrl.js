angular.module('hostelapp').controller(
		"dashboradCtrl",
		function($state, $scope, $http, $localStorage, HOSTELAPP_CONSTANTS,
				$stateParams, notify, $location) {

			$scope.goToRoleListPage = function() {
				$state.go('hostel.roleList');

			}
			$scope.findAllCount = function() {
				var url = HOSTELAPP_CONSTANTS.URL + "count/";
				$http.get(url).then(function(response) {
					console.log(response.data);
					$scope.count = response.data;
				});
			}

		});
