var module = angular.module('util', []);
//全局统一警告dialog
module.directive('warnDialog', function () {
    return {
        restrict: 'E',
        scope: {
            msg: '=', //alert的信息
            isShown: '='
        },
        template: '<div class="weui_dialog_alert" id="dialog2" ng-show="isShown">' +
        '<div class="weui_mask"></div>' +
        '<div class="weui_dialog">' +
        '<div class="weui_dialog_hd"><strong class="weui_dialog_title" ng-bind="msg">注意</strong></div>' +
        '<div class="weui_dialog_ft">' +
        '<a ng-click="closeToast()" style="font-size: 17px;color: #ff778d;" class="weui_btn_dialog primary">确定</a>' +
        '</div>' +
        '</div>' +
        '</div>'
        ,
        controller: function ($scope) {
            $scope.msg = $scope.msg || '';
            $scope.isShown = $scope.isShown || false;
            $scope.closeToast = function () {
                $scope.isShown = false;
            }
        }
    }
});
module.directive('confirmDialog', ['$timeout', function ($timeout) {
    return {
        restrict: 'E',
        scope: false,
        transclude: false,
        scope: {
            msg: '=',
            isShown: '='
        },
        template: '<div class="weui_dialog_alert" id="dialog" ng-show="isShown">' +
        '<div class="weui_mask"></div>' +
        '<div class="weui_dialog">' +
        '<div class="weui_dialog_hd"><strong class="weui_dialog_title" ng-bind="msg">注意</strong></div>' +
        '<div class="weui_dialog_ft">' +
        '<a ng-click="confirm()" style="font-size: 17px;color: #ff778d;" class="weui_btn_dialog primary">确定</a>' +
        '<a ng-click="cancel()" style="font-size: 17px;color: #ff778d;" class="weui_btn_dialog primary">取消</a>' +
        '</div>' +
        '</div>' +
        '</div>'
        ,
        link: function (scope, element, attrs) {
            $timeout(function () {
                scope.$emit('confirmNotification');
            })
        },
        controller: ['$scope', function ($scope) {
            $scope.msg = $scope.msg || '';
            $scope.isShown = $scope.isShown || false;
            $scope.confirm = function () {
                $timeout(function () {
                    $scope.$emit('confirmNotification');
                })
                $scope.isShown = false;
            };
            $scope.cancel = function () {
                $scope.isShown = false;
            }
        }]

    }
}])
//全局统一警告toast
module.directive('warnToast', function ($timeout) {
    return {
        restrict: 'E',
        scope: {
            msg: '=', //提示的信息
            isShown: '=', //是否展示
        },
        template: '<div id="toast" ng-show="isShown">' +
        '<div class="weui_mask_transparent" ng-click="closeToast()"></div>' +
        '<div class="weui_toast">' +
        '<i class="weui_icon_toast warn_icon"></i>' +
        '<p class="weui_toast_content" ng-bind="msg"></p>' +
        '</div>' +
        '</div>' +
        '<style>' +
        '.warn_icon:before {content: \'\\EA0B\'}' + //用叹号覆盖默认的勾
        '</style>'
        ,
        controller: function ($scope) {
            $scope.msg = $scope.msg || '';
            $scope.isShown = $scope.isShown || false;
            $scope.closeToast = function () {
                $scope.isShown = false;
            }
        }
    }
});
//全局统一提示toast
module.directive('okToast', function ($timeout) {
    return {
        restrict: 'E',
        replace: true,
        scope: {
            msg: '=', //提示的信息
            isShown: '=', //是否展示
            timeOut: '=' //显示多久后消失，0表示不消失
        },
        template: '<div id="toast" ng-show="isShown">' +
        '<div class="weui_mask_transparent"></div>' +
        '<div class="weui_toast">' +
        '<i class="weui_icon_toast"></i>' +
        '<p class="weui_toast_content" ng-bind="msg"></p>' +
        '</div>' +
        '</div>'
        ,
        controller: function ($scope) {
            $scope.msg = $scope.msg || '';
            $scope.isShown = $scope.isShown || false;
            $scope.timeOut = $scope.timeOut || 0;
        },
        link: function (scope, elem, attrs) {
            //定时关闭toast
            var closeToast = function () {
                $timeout(function () {
                    scope.isShown = false;
                }, scope.timeOut * 1000)
            }
            //当timeOut不为0且toast显示是，调用定时关闭方法
            scope.$watch('isShown', function (newVal) {
                if (scope.timeOut != 0 && newVal == true) {
                    closeToast();
                }
            });
        }
    }
});
//全局统一等待toast
module.directive('waitToast', function ($timeout) {
    return {
        restrict: 'E',
        replace: true,
        scope: {
            msg: '=', //提示的信息
            isShown: '=', //是否展示
            timeOut: '=' //显示多久后消失，0表示不消失
        },
        template: '<div id="loadingToast" class="weui_loading_toast" ng-show="isShown">' +
        '<div class="weui_mask_transparent"></div>' +
        '<div class="weui_toast">' +
        '<div class="weui_loading">' +
        '<div class="weui_loading_leaf weui_loading_leaf_0"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_1"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_2"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_3"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_4"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_5"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_6"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_7"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_8"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_9"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_10"></div>' +
        '<div class="weui_loading_leaf weui_loading_leaf_11"></div>' +
        '</div>' +
        '<p class="weui_toast_content" ng-bind="msg"></p>' +
        '</div>' +
        '</div>'
        ,
        controller: function ($scope) {
            $scope.msg = $scope.msg || '请等待';
            $scope.isShown = $scope.isShown || false;
            $scope.timeOut = $scope.timeOut || 0;
        },
        link: function (scope, elem, attrs) {
            //定时关闭toast
            var closeToast = function () {
                $timeout(function () {
                    scope.isShown = false;
                }, scope.timeOut * 1000)
            }
            //当timeOut不为0且toast显示是，调用定时关闭方法
            scope.$watch('isShown', function (newVal) {
                if (scope.timeOut != 0 && newVal == true) {
                    closeToast();
                }
            });
        }
    }
});
//自动按照图片的长款裁剪图片
module.directive('cube', function () {
    return {
        scope: {
            length: "=length"
        },
        link: function (scope, element, attrs) {
            element.bind("load", function (e) {
                if (this.naturalWidth > this.naturalHeight) {
                    element.css({'height': scope.length + 'px'});
                } else {
                    element.css({'width': scope.length + 'px'});
                }
            });
        }
    }
});
//ng-repeat渲染完毕事件
module.directive('onRenderFinshed', function ($timeout) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function () {
                    scope.$emit('ngRepeatFinished');
                });
            }
        }
    };
});
//全局通用服务
module.factory("service", [
    "$timeout",
    "$q",
    "$http",
    function ($timeout, $q, $http) {
        return {
            //图片处理服务
            processImg: function (url, times) {
                return processImg(url, times);
            },
            //同步请求判断用户是否登录
            isCustomerLoggedWithAuth: function () {
                var q = $q.defer();
                $http.get('/api/customer/auth/isCustomerLoggedWithAuth').then(function (resp) {
                    q.resolve(resp);
                }, function (data) {
                    q.reject(data);
                });
                return q.promise;
            },
            //同步请求判断用户是否登录
            isCustomerLogged: function () {
                var isCustomerLogged = false;
                $.ajax({
                    url: '/api/customer/auth/isCustomerLogged',
                    timeout: 2000,
                    cache: false,
                    async: false,
                    type: "GET",
                    success: function (result) {
                        if (result.data == true) {
                            isCustomerLogged = true;
                        }
                    }
                });
                return isCustomerLogged;
            },
            //根据手机号查询用户
            searchCustomerAccountByPhone: function (phone) {
                var q = $q.defer();
                $http.get('/api/admin/customer/phone/' + phone).then(function (resp) {
                    q.resolve(resp);
                }, function (data) {
                    q.reject(data);
                });
                return q.promise;
            },
            //同步请求根据商户获取订单
            getOrdersByMerchant: function () {
                var q = $q.defer();
                $http.get('/api/merchant/order/getOrdersByMerchant').success(function (data) {
                    q.resolve(data);
                }).error(function (data) {
                    q.reject(data);
                });
                return q.promise;
            },
            createOrder: function (data) {
                var q = $q.defer();
                $http.post('/api/order/beautify', data).then(function (resp) {
                    q.resolve(resp);
                }, function (data) {
                    q.reject(data);
                });
                return q.promise;
            },
            auditeOrder: function (data) {
                var q = $q.defer();
                $http.post('/api/order/audite', data).then(function (resp) {
                    q.resolve(resp);
                }, function (data) {
                    q.reject(data);
                });
                return q.promise;
            },
            setAlert: function (scope, level, message) {
                $timeout.cancel(scope.alert.timeout);
                scope.alert.level = level;
                scope.alert.msg = message;
                scope.alert.timeout = $timeout(function () {
                    scope.alert.level = "";
                    scope.alert.msg = null;
                }, 4000);
            },
            setPopup: function (scope, level, message) {
                $timeout.cancel(scope.alert.timeout);
                scope.alert.level = level;
                scope.alert.msg = message;
            },
            setNotify: function (scope, level, message) {
                scope.alert.level = level;
                scope.alert.msg = message;
                scope.alert.timeout = 5000; //对于success以及info级别的通知,统一设置时延为5s
                //对于info级别的通知
                if (scope.alert.level == "success") {
                    $timeout(function () {
                        scope.alert.level = null;
                        scope.alert.msg = null;
                    }, scope.alert.timeout);
                }
                //对于info级别的通知
                if (scope.alert.level == "info") {
                    if (scope.alert.level == "success") {
                        $timeout(function () {
                            scope.alert.level = null;
                            scope.alert.msg = null;
                        }, scope.alert.timeout);
                    }
                }
                //对于警告级别的通知
                if (scope.alert.level == "warning") {
                    //不消失
                }
                //对于错误级别的
                if (scope.alert.level == "danger") {
                    //不消失
                }
            },
            setUrl: function (relativeUrl) {
                location.href = getOAuthUrl(relativeUrl);
            },
            getOAuthUrl: getOAuthUrl,
            formatTs: function (tick, fmt) {
                var timeInfo = new Date(tick);
                var o = {
                    "y+": timeInfo.getFullYear(),
                    "M+": timeInfo.getMonth() + 1, //月份
                    "d+": timeInfo.getDate(), //日
                    "h+": timeInfo.getHours() % 12 == 0 ? 12 : timeInfo.getHours() % 12, //小时
                    "H+": timeInfo.getHours(), //小时
                    "m+": timeInfo.getMinutes(), //分
                    "s+": timeInfo.getSeconds(), //秒
                    "q+": Math.floor((timeInfo.getMonth() + 3) / 3), //季度
                    "S": timeInfo.getMilliseconds() //毫秒
                };
                var week = {
                    "0": "/u65e5",
                    "1": "/u4e00",
                    "2": "/u4e8c",
                    "3": "/u4e09",
                    "4": "/u56db",
                    "5": "/u4e94",
                    "6": "/u516d"
                };
                if (/(y+)/.test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (timeInfo.getFullYear() + "").substr(4 - RegExp.$1.length));
                }
                if (/(E+)/.test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[timeInfo.getDay() + ""]);
                }
                for (var k in o) {
                    if (new RegExp("(" + k + ")").test(fmt)) {
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                    }
                }
                return fmt;
            }
            ,
            statusJsonToArray: function (jsonObj) {
                var arr = [];
                for (var key in jsonObj) {
                    arr.push({id: key, name: jsonObj[key]});
                }
                return arr;
            }
            ,
            //生成缩略图style
            thumbnailPic: function (path) {
                var style = 'thumbnail';
                var newPath = imgServiceHost(path, style);
                return {
                    'background-image': 'url(' + newPath + ')',
                    'background-size': 'cover',
                    'background-repeat': 'no-repeat',
                }
            }
            ,
            //调用toast
            toastOpen: function (scope, type, msg, timeout) {
                switch (type) {
                    case 'info':
                        scope.toast.isInfoShown = true;
                        scope.toast.isWaitShown = false;
                        scope.toast.isWarnShown = false;
                        scope.toast.isDialogShown = false;
                        scope.toast.isConfirmShown = false;
                        scope.toast.msg = msg;
                        scope.toast.timeOut = timeout;
                        break;
                    case 'wait':
                        scope.toast.isWaitShown = true;
                        scope.toast.isInfoShown = false;
                        scope.toast.isWarnShown = false;
                        scope.toast.isDialogShown = false;
                        scope.toast.isConfirmShown = false;
                        scope.toast.msg = msg;
                        scope.toast.timeOut = timeout;
                        break;
                    case 'warn':
                        scope.toast.isWarnShown = true;
                        scope.toast.isInfoShown = false;
                        scope.toast.isWaitShown = false;
                        scope.toast.isDialogShown = false;
                        scope.toast.isConfirmShown = false;
                        scope.toast.msg = msg;
                        break;
                    case 'dialog':
                        scope.toast.isDialogShown = true;
                        scope.toast.isWarnShown = false;
                        scope.toast.isInfoShown = false;
                        scope.toast.isWaitShown = false;
                        scope.toast.isConfirmShown = false;
                        scope.toast.msg = msg;
                        break;
                    case 'confirm':
                        scope.toast.isConfirmShown = true;
                        scope.toast.isDialogShown = false;
                        scope.toast.isWarnShown = false;
                        scope.toast.isInfoShown = false;
                        scope.toast.isWaitShown = false;
                        scope.toast.msg = msg;
                }
            }
            ,
            //手动关闭toast
            toastClose: function (scope, type) {
                switch (type) {
                    case 'info':
                        scope.toast.isInfoShown = false;
                        break;
                    case 'wait':
                        scope.toast.isWaitShown = false;
                        break;
                    case 'warn':
                        scope.toast.isWarnShown = false;
                        break;
                    case 'dialog':
                        scope.toast.isDialogShown = false;
                    default:
                        scope.toast.isInfoShown = false;
                        scope.toast.isWaitShown = false;
                        scope.toast.isWarnShown = false;
                        scope.toast.isDialogShown = false;
                }
            }
        }
    }
]);
//跳转到微信OAuth授权地址
function redirectOAuthUrl(fullUrl) {
    var oauthUrl = getOAuthUrl(fullUrl);
    if (isWithinWechat) {
        window.location.href = oauthUrl;
    } else {
        window.location.href = oauthUrl;
    }
}

//获取微信OAuth地址
function getOAuthUrl(fullUrl) {
    var oauthUrl = "https://open.weixin.qq.com/connect/oauth2/"
        + "authorize?appid=" + $.beauty.constants.appId.fw
        + "&redirect_uri=" + fullUrl
        + "&response_type=code&scope=snsapi_base&state=beauty#wechat_redirect";
    return oauthUrl;
}

//判断微信浏览器环境
function isWithinWechat() {
    var ua = navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == "micromessenger") {
        return true;
    } else {
        return false;
    }
}

//将图片路径替换为定制图片服务url
function imgServiceHost(url, style) {
    var separator = '@!';
    var oldDomain = '.oss-cn-hangzhou.';
    var newDomain = '.img-cn-hangzhou.';
    var newUrl = url.replace(oldDomain, newDomain);
    return newUrl + separator + style;
}

//电话号码格式检查
function isPhoneNumberValid(res) {
    var re = /^1\d{10}$/;
    if (re.test(res)) {
        return true;
    } else {
        return false;
    }
}

//判断字符串是否为null或者空字符串
function isNullOrBlank(str) {
    if (str == null || str == '') {
        return true;
    } else {
        return false;
    }
}

//判断当前页面环境
function checkEnv() {
    var path = window.location.pathname;
    if (path.indexOf("/page/mobile/article") != -1) {
        return "ARTICLE";
    } else if (path.indexOf("/page/mobile/project") != -1) {
        return "PROJECT";
    } else if (path.indexOf("/page/mobile/beauty/intro") != -1) {
        return "BEAUTYINTRO";
    } else if (path.indexOf("/page/mobile/evaluation/") != -1) {
        return "EVALUATION";
    } else if (path.indexOf("/page/mobile/voucher") != -1) {
        return "VOUCHER";
    } else if (path.indexOf("/page/mobile/coupon") != -1) {
        return "COUPON"
    }
    return "UNKNOWN";
}

//判断是否支持webp
var supportWebP = false;
var isWebPChecked = false;
function checkWebp() {
    var webP = new Image();
    webP.src = 'data:image/webp;base64,UklGRjoAAABXRUJQVlA4IC4AAACyAgCdASoCAAIALmk0mk0iIiIiIgBoSygABc6WWgAA/veff/0PP8bA//LwYAAA';
    if (webP.height === 2) {
        supportWebP = true;
    }
    isWebPChecked = true;
}

//图片实时处理
function initImgCdnUri(url) {
    return initImgCdnUriWithCustomize(url, 1.2);
}

//图片实时处理
function processImg(url, times) {
    //判断图片地址是否为空
    if (!url) {
        console.warn("图片处理传入图片链接为空");
        return url;
    }
    //判断是否为已处理图片
    if (url.indexOf('@!noneRTP') > 0 //不需要实时图片处理
        || url.indexOf('x-oss-process=') > 0) {
        console.log("图片处理传入图片链接为已处理链接直接返回");
        return url;
    }
    //进行图片处理
    //1.抓取图片真实地址
    var uri = "";
    if (url.indexOf("@!") > 0) {
        uri = url.split('@!')[0];
    } else if (url.indexOf("?x-oss-process=image") > 0) {
        uri = url.split('?x-oss-process=image')[0];
    } else if (url.indexOf("?") > 0) {
        uri = url.split('?')[0];
    } else {
        uri = url;
    }
    uri += "?x-oss-process=image";
    // * 处理图片宽度
    var realWidth = Number(document.body.clientWidth * times).toFixed(0);
    realWidth = ((realWidth > 1000) ? 1000 : realWidth);//图片宽度最多不超过1000px
    uri = uri + '/resize' + ",w_" + realWidth;
    // * 处理图片格式
    //对于非GIF工图,统一转换为webbp格式图片
    if (uri.indexOf("png") > 0
        || uri.indexOf("jpg") > 0
        || uri.indexOf("jpeg") > 0) {
        if (!isWebPChecked) {
            checkWebp();
        }
        if (supportWebP) {
            uri = uri + "/format,webp"
        } else {
            uri = uri + "/format,png"
        }
    }
    if (uri.indexOf("gif") > 0) {
        uri = uri + "/format,gif"
    }
    //打印图片处理结果
    console.log("图像处理完毕，结果为：" + uri);
    return uri;
}
function initImgCdnUriWithCustomize(url, times) {
    return processImg(url, times);
}
