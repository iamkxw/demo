'use strict';
function startAjax() {
}

function endAjax() {
}

function absolute(url) {
    return url;
    if (url.toUpperCase().indexOf('HTTP') === 0) {
        return url;
    }

    // We set the root url to <base> tag in <head>.
    var root = $('head').first().children('base').attr('href');

    // Make sure root ends with a slash.
    if (root.charAt(root.length - 1) !== '/') {
        root += '/';
    }

    // make sure url doesn't begin with a slash
    if (url.charAt(0) === '/') {
        url = url.substr(1);
    }

    return root + url;
}

function checkRequireCsrf(config) {
    return false;
    var method = config.method.toUpperCase();
    if (method == "PUT" || method === "POST" || method === "DELETE") {
        return true;
    }
    else {
        return false;
    }
}

function interceptor($q, $templateCache, $injector, $cookies, $window) {
    return {
        'request': function (config) {
            if ($templateCache && $templateCache.get(config.url)) {
                return config;
            } else {
                startAjax();
                config.url = absolute(config.url);
                config.cache = false;
                config.headers["X-Requested-With"] = "XMLHttpRequest";
                if (checkRequireCsrf(config)) {
                    config.headers["X-CSRF-TOKEN"] = $("meta[name='_csrf']").data('csrf');
                }
                config.headers["FW-OPENID"] = $cookies.get('FW-OPENID'); //微信浏览器cookie不稳定,参数放header
                config.headers["X-AUTH-USER"] = $cookies.get('X-AUTH-USER'); //微信浏览器cookie不稳定,参数放header
                return config;
            }
        },
        'response': function (response) {
            if ($templateCache && $templateCache.get(response.config.url)) {
                return response;
            }
            endAjax();
            //判断是否beauty域下的接口调用,如果是
            var isBeautyAPI = false;
            (response.headers('isBeautyAPI') == "true" ) ? isBeautyAPI = true : isBeautyAPI = false;
            //如果返回码不为200,认为服务器处理失败
            if (response.status != 200) {
                return $q.reject(response.data);
            }
            //如果返回码为200
            if (response.status == 200) {
                //如果是站外接口调用,直接返回调用结果
                if (!isBeautyAPI) {
                    return response;
                }
                //如果返回结果不为空
                if (response.data) {
                    //如果返回结果为空
                    if (!response.data.result) {
                        console.log("返回结果数据非法,状态字段为空,请联系技术人员检查后端接口" + response.config.url);
                    }
                    //如果返回结果为失败
                    if (response.data.result == "FAIL") {
                        return $q.reject(response.data);
                    } else if (response.data.result == "SUCCESS" || response.data.result == "redirect") {
                        return response.data;
                    } else {
                        console.log("返回结果数据非法,状态字段非法,请联系技术人员检查后端接口" + response.config.url);
                        return $q.reject(response.data);
                    }
                } else {//如果返回结果数据为空
                    console.log("返回结果数据为空,请联系技术人员检查后端接口");
                    return $q.reject(response);
                }
            }
        },
        'responseError': function (response) {
            //处理无权限异常跳转登录页面
            if (response.status == 401) {
                console.log("权限错误,未登录用户");
                var ngDialog = $injector.get('ngDialog');
                ngDialog.open({
                    template: '/statics/templates/signinPop.html',
                    showClose: false
                });
                return $q(function () {
                    return null;
                });
            }
            //防止意外没有返回,返回promise
            return $q.reject(response);
        }
    };
}

angular.module('ajax.interceptor', ['ngDialog', 'ngCookies'])
//构建一个自定义拦截器,函数体为interceptor
    .factory('httpInterceptor', ['$q', '$templateCache', '$injector', '$cookies', interceptor])
    //将构建好的拦截器纳入到httpProvider的拦截器数组中
    .config(['$httpProvider', function ($httpProvider) {
        $httpProvider.interceptors.push('httpInterceptor');
    }]);