var zd;
(function (zd) {
    var utils;
    (function (utils) {
        var request = (function () {
            function request() {
            }
            request.send = function (url, data) {
                var dfd = $.Deferred();
                var postData = null;
                if (data) {
                    postData = JSON.stringify(data, null, 2);
                }
                $.ajax({
                    url: url,
                    type: "POST",
                    data: postData,
                    dataType: this.dataType
                }).done(function (result) {
                    dfd.resolve(JSON.parse(result));
                });
                return dfd.promise();
            };
            request.requestType = "POST";
            request.dataType = "json";
            return request;
        }());
        utils.request = request;
    })(utils = zd.utils || (zd.utils = {}));
})(zd || (zd = {}));
//# sourceMappingURL=ZDUtils.js.map