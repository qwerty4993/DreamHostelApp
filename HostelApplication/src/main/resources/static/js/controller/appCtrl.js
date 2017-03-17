angular.module('hostelapp').controller(
		"appCtrl",
		function($state, $scope, loginService, $localStorage) {

			$scope.roleName = $localStorage.user.role.name;
			$scope.userName = $localStorage.user.username;
			console.log("--->" + $scope.userName);
			$scope.goToRolesListPage = function() {
				$state.go('hostel.roleList');

			}
			$scope.goToDashBoardPage = function() {
				$state.go('hostel.dashboard');

			}
			$scope.goToDashBoardPage = function() {
				if ($localStorage.user.role.name == 'admin') {
					$state.go('hostel.dashboard');
				} else {
					$state.go('hostel.userDashboard');
				}
			};
			$scope.goToFeaturesListPage = function() {
				$state.go('hostel.featureList');

			};
			$scope.goToHostelRequestListPage = function() {
				$state.go('hostel.HostelRequestList');

			};
			$scope.goToHostelDetaislListPage = function() {
				$state.go('hostel.HostelDetaislList');

			};

			$scope.goToProfilePage = function() {
				$state.go('hostel.profileView');

			};

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

			/* For Logout */
			$scope.doLogout = function() {
				// delete $localStorage.authorization;
				delete $localStorage.user;
				// delete $localStorage.employeeId;
				$localStorage.$save();
				var backlen = history.length;

				history.go(backlen); // Return at the beginning
				$state.go('web.home');
			};

		});
