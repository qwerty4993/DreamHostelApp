angular.module('hostelapp').directive('preventRightClick', [  
  
            function () {  
                return {  
                    restrict: 'A',  
                    link: function ($scope, $ele) {  
                        $ele.bind("contextmenu", function (e) {  
                            e.preventDefault();  
                            /*alert("Right click is disabled");  */
                        });  
                    }  
                };  
            }  
        ])  