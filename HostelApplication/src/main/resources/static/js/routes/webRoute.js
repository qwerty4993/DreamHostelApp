var hostelapp = angular.module('hostelapp');
hostelapp.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/home');

	$stateProvider.state('web', {
		templateUrl : 'views/web/web.html',
		url : '/',
		abstract : true,
		controller : 'webCtrl'
	}).state('web.home', {
		templateUrl : 'views/web/home.html',
		url : 'home',
		controller : 'webCtrl'
	}).state('web.contact', {
		templateUrl : 'views/web/contactus.html',
		url : 'contactus',
		controller : 'webCtrl'
	});
});

