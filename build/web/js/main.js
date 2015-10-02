var App = angular.module('myApp', []);

App.controller('mainController', function ($scope,$http) {

        $http.get("/Rest-Json/api/addresses/10/fname,lname,street,city")
                .success(function (response) {
                    $scope.data = response;
                });
    });


