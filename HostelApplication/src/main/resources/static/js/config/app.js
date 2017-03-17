var hostelapp = angular.module('hostelapp', [ 'ui.router', 'ngStorage', 'cgNotify' ]);
hostelapp.config(function($stateProvider, $urlRouterProvider, $httpProvider) {
	$httpProvider.defaults.useXDomain = true;
	$httpProvider.defaults.headers.common = 'Content-Type: application/json';
	delete $httpProvider.defaults.headers.common['X-Requested-With'];
	$stateProvider.state('studentRegister', {
		templateUrl : 'views/studentRegister.html',
		url : '/studentregistration'

	});
	$stateProvider.state('hostelRegister', {
		templateUrl : 'views/hostelRegister.html',
		url : '/hostelregistration'

	});
	$stateProvider.state('studentDashboard', {
		templateUrl : 'views/studentDashboard.html',
		url : '/studentDashboard'

	}).state('hostel', {
		abstract : true,
		templateUrl : 'views/Commons/content.html',
		url : '/hostelapp',
		controller : 'appCtrl'
	}).state('hostel.dashboard', {
		templateUrl : 'views/dashboard.html',
		url : '/dashboard',
		controller : 'dashboradCtrl'	
	}).state('hostel.userDashboard', {
		templateUrl : 'views/userDashboard.html',
		url : '/userdashboard',
		controller : 'dashboradCtrl'	
	});
})/*.run(function($rootScope, $localStorage, $location,$state) {
	$rootScope.$on("$locationChangeStart", function(event, next, current) {
		console.log($state.current);
		if($state.current.name=='resetPassword'){
			alert($state.current.name);
		}
		if($state.current.name!='resetPassword'){
			
			if ($localStorage.authorization == undefined) {
				$location.path('/hem');
			}
		}
	});
})*/;

// //templateUrl : 'views/Restaurant/restaurantList.html',
