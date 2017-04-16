/**
 * Created by Sawyer on 1/23/17.
 */
(function (angular) {
    var module = angular.module('app', ['util', 'ajax.interceptor']);
    module.controller('ctrl',
        function ($scope, $http, $window, $timeout, service) {
            $scope.toast = {
                isInfoShown: false,
                isWaitShown: false,
                isWarnShown: false,
                isDialogShown: false,
                msg: "",
                timeOut: 0
            };

            $scope.user = {
                account: {},
                agent: {},
                vendor: {},
                type: null
            };

            var MIN_PASSWORD_LENGTH = 5;

            $scope.submit = function () {
                if ($scope.user.type == null) {
                    service.toastOpen($scope, 'dialog', '请选择账号类型');
                    return;
                }
                if (!isPhoneNumberValid($scope.user.account.phone)) {
                    service.toastOpen($scope, 'dialog', '手机号格式有误');
                    return;
                }
                if (isNullOrBlank($scope.user.account.password)) {
                    service.toastOpen($scope, 'dialog', '密码不得为空');
                    return;
                }
                if ($scope.user.account.password.length < MIN_PASSWORD_LENGTH) {
                    service.toastOpen($scope, 'dialog', '密码不得少于' + MIN_PASSWORD_LENGTH + '位');
                    return;
                }
                if ($scope.user.account.password != $("input#rePassword").val()) {
                    service.toastOpen($scope, 'dialog', '两次密码输入不相同');
                    $("input#rePassword").val("");
                    return
                }
                switch ($scope.user.type) {
                    case "agent":
                        if (isNullOrBlank($scope.user.agent.name)) {
                            service.toastOpen($scope, 'dialog', '姓名不得为空');
                            return;
                        } else if (isNullOrBlank($scope.user.agent.pid)) {
                            //TODO 身份证校验
                            service.toastOpen($scope, 'dialog', '身份证不得为空');
                            return;
                        }
                        break;
                    case "vendor":
                        if (isNullOrBlank($scope.user.vendor.name)) {
                            service.toastOpen($scope, 'dialog', '供应商公司名不得为空');
                            return;
                        }
                        break;
                }
                $http.post("/api/auth/registry", $scope.user).then(
                    function (resp) {
                        service.toastOpen($scope, 'info', '注册!', 0);
                        $timeout(
                            function () {
                                service.toastClose($scope, 'info');
                                $window.location.href = '/home';
                            },
                            1000
                        );
                    }, function (err) {
                        service.toastOpen($scope, 'dialog', err.message);
                    }
                )
            }
        }
    );
    //自定义过滤器，用以过滤指定标签的美容项目
}(window.angular));