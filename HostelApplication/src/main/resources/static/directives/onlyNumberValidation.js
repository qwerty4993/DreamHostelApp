angular.module('hostelapp').directive('allowOnlyNumbers', function () {  
    return {  
        restrict: 'A',  
        link: function (scope, elm, attrs, ctrl) {  
            elm.on('keydown', function (event) {  
                var $input = $(this);  
                var value = $input.val();  
                value = value.replace(/[^0-9 ]/g, '')  
                $input.val(value);  
                if (event.which == 64 || event.which == 16) {  
                    // to allow numbers  
                    return false;  
                } else if (event.which >= 48 && event.which <= 57) {  
                    // to allow numbers  
                    return true;  
                } else if (event.which >= 96 && event.which <= 105) {  
                    // to allow numpad number  
                    return true;  
                }else if (event.which >= 112 && event.which <= 123) {  
                    // to allow Functional Keys  
                    return true;  
                } else if ([8, 9, 13, 27, 35, 36, 37, 38, 39, 40, 46, 190, 110].indexOf(event.which) > -1) {  
                    /* to allow These following:
                    backspace : 8, 
                    tab : 9, 
                    Enter : 13,
                    Escape : 27,
                    End : 35,
                    Home : 36, 
                    Arrows : 37, 38, 39, 40
                    Delete : 46
                    Decimal Points : 190, 110
                     */
                    return true;  
                } else {  
                    event.preventDefault();  
                    // to stop others  
                    //alert("Sorry Only Numbers Allowed");  
                    return false;  
                }  
            });  
        }  
    }  
});  