$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.applyBindings(screenModel);
});

function ScreenModel() {
    var self = this;
    self.relogpassword = ko.observable();
}

ScreenModel.prototype.relogsubmit = function() {
    var self = this;
    var param = {relogpassword: self.relogpassword()};

    $.post("/adm/relog", param, function(result) {
        if ($.trim(result) === "success") {
//            $("#ajaxModal").modal().trigger("click.dismiss.bs.modal");
//            $("#ajaxModal").remove();
            location.reload();
        }
    });
}