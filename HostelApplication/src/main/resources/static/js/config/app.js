var hostelapp = angular.module('hostelapp', [ 'ui.router', 'ngStorage', 'cgNotify' ]);
hostelapp.config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state('studentRegister', {
		templateUrl : 'views/studentRegister.html',
		url : '/studentregistration'
	}).state('hostelRegister', {
		templateUrl : 'views/hostelRegister.html',
		url : '/hostelregistration'

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
	}).state('forgotPasswordPage', {
		templateUrl : 'views/ForgotPassword.html',
		url : '/forgotpassword',
		controller : 'loginctrl'
		
	}).state('restpassword', {
		templateUrl : 'views/updatePassword.html',
		url : '/restpassword',
		controller : 'loginctrl'
		
	});
})/*.run(function($rootScope, $localStorage, $location,$state) {
	$rootScope.$on("$locationChangeStart", function(event, next, current) {
		console.log($state.current);
		if($state.current.name!='restpassword'){
			
			if ($localStorage.user == undefined) {
				$location.path('/home');
			}
		}
	});
})*/;

// //templateUrl : 'views/Restaurant/restaurantList.html',
