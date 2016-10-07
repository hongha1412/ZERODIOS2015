$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.applyBindings(screenModel);
});

function ScreenModel() {
    var self = this;
    self.relogpassword = ko.observable();
    self.isError = ko.observable(false);
    self.message = ko.observable();
}

ScreenModel.prototype.relogsubmit = function() {
    var self = this;
    var param = {relogpassword: self.relogpassword()};

    $.ajax({
        type: "POST",
        url: "/adm/relog",
        data: param,
        async: true
    }).done(function(result) {
        if ($.trim(result) === "success") {
            $("#ajaxModal").modal().trigger("click.dismiss.bs.modal");
            $("#ajaxModal").remove();
            location.reload();
        } else {
            var rs = $.parseJSON(result.replace(/\\/g, ''));
            if ($.isArray(rs)) {
                for (var i = 0; i < rs.length; i++) {
                    self.processResponse(rs[i]);
                } 
            } else {
                self.processResponse(rs);
            }
        }
    });
}

ScreenModel.prototype.processResponse = function(rs) {
    var self = this;
    if (rs.controlName !== undefined && rs.controlName !== '') {
        self.isError(true);
        self.message(rs.message);
        self.forceError(rs.controlName, rs.messages);
    } else {
        self.isError(true);
        self.message(rs.message);
    }
}

ScreenModel.prototype.forceError = function(name, message) {
    var self = this;
    var controlName = ""
    if (name !== undefined) {
        controlName = name.trim();
        $("#" + controlName).parsley().options.messages["ZDMessage-" + controlName] = message;
        $("#relog-form").parsley().validate("", controlName);
    }
}