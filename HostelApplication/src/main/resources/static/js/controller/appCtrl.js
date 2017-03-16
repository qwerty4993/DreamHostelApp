angular.module('hostelapp').controller(
		"appCtrl",
		function($state, $scope, loginService, $localStorage) {

			$scope.goToRolesListPage = function() {
				$state.go('hostel.roleList');

			}
			$scope.goToDashBoardPage = function() {
				$state.go('hostel.dashboard');

			}
			$scope.goToFeaturesListPage= function() {
				$state.go('hostel.featureList');

			}
			$scope.goToHostelRequestListPage= function() {
				$state.go('hostel.HostelRequestList');

			}
			$scope.goToHostelDetaislListPage= function() {
				$state.go('hostel.HostelDetaislList');

			}
			
			
			$scope.hasFeature = function(name) {
				var found;
				angular.forEach($localStorage.user.role.features, function(
						feature) {

					if (feature.name == name) {
						found = feature;
					}
				});
				return found;
			};
		});
