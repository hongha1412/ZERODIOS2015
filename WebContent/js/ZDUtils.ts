module zd.utils {
    export class request {
        public static requestType = "POST";
        public static dataType = "json";

        static send(url: string, data?: any) {
            var dfd = $.Deferred();
            var postData = null;
            if (data) {
                postData = JSON.stringify(data, null, 2);
//                postData = postData.replace(/"/g, '\\"');
//                postData = $.makeArray(data);
            }

            $.ajax({
                url: url,
                type: "POST",
                data: postData,
                dataType: this.dataType
            }).done(function(result) {
                dfd.resolve(JSON.parse(result));
            });
            return dfd.promise();
        }
    }
}