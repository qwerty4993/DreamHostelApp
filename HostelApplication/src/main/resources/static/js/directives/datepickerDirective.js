angular.module('hostelapp').directive("datepicker", function() {
	return {
		restrict : "A",
		require : "ngModel",
		link : function(scope, elem, attrs, ngModelCtrl) {
			var updateModel = function(dateText) {
				scope.$apply(function() {
					ngModelCtrl.$setViewValue(dateText);
				});
			};
			var options = {
				format : "dd-mm-yyyy",
				onSelect : function(dateText) {
					updateModel(dateText);
				}
			};
			elem.datepicker(options);
		}
	}
});