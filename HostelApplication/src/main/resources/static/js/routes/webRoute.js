var hostelapp = angular.module('hostelapp');
hostelapp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/home');

	$stateProvider.state('web', {
		templateUrl : 'views/web/web.html',
		url : '/',
		abstract : true

	}).state('web.home', {
		templateUrl : 'views/web/home.html',
		url : 'home',
		controller : 'webCtrl'
	});
});

