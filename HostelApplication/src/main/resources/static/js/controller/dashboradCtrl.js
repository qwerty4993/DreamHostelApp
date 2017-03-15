angular.module('hostelapp').controller("dashboradCtrl",
		function($state, $scope, $localStorage) {

			$scope.goToRoleListPage = function() {
				$state.go('hostel.roleList');

			}

		});
