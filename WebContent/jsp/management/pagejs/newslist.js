$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.applyBindings(screenModel);
});

function ScreenModel() {
    var self = this;

//    var param = {condition: "{\"id\": \"1\", \"status\": \"1\"}"};
    $.ajax({
        type: "POST",
        url: "/adm/newsservlet",
//        data: param,
        async: true
    }).done(function(result) {
        var rs = $.parseJSON(result.replace(/\\/g, ''));

        $("#news-table").igGrid({
            width: "100%",
            autoGenerateColumns: false,
            renderCheckboxes: true,
            columns: [
                { headerText: "Pin", key: "pin", dataType: "bool", width: "100px", columnCssClass: "table-data-center"},
                { headerText: "Remark", key: "remark", dataType: "string", columnCssClass: "table-data-center", width: "150px"},
                { headerText: "Title", key: "title", dataType: "string"},
                { headerText: "Author", key: "author", dataType: "string", width: "20%"},
                { headerText: "Date", key: "date", dataType: "string", width: "18%"},
                { headerText: "Edit", key: "id", columnCssClass: "table-data-center", width: "100px", formatter: EditIcon},
                { headerText: "Id", key: "id", dataType: "string", hidden: true}
            ],
            features: [
                { 
                    name: "Filtering"
                },
                {
                    name: "Paging",
                    type: "local",
                    pageSize: 50
                },
                {
                    name: "Responsive"
                },
                {
                    name: "Resizing"
                }
            ],
            dataSource: rs
        });
    });
}

ScreenModel.prototype.editNews = function() {
    var self = this;
    alert(a);
}

function booleanFormatter(value, data, self) {
    var isCheck = value ? "checked='checked'" : "";
    var div = $("<div class='checkbox'>");
    var label = $("<label class='checkbox-custom'>");
    var checkbox = $("<input type='checkbox' name='cb-" + data.id + "' " + isCheck + ">");
    var icon = $("<i class='fa fa-fw fa-square-o " + (value ? "checked" : "") + "'>");
    label = $(label).prepend(icon).prepend(checkbox);
    var customCheckbox = $(div).prepend(label);
    return $(customCheckbox).prop("outerHTML");
}

function EditIcon(value, data, self) {
    var icon = $("<a href='#edit' class='edit-news' data-zd='" + value + "' data-toggle='modal' data-bind='click: editNews'>").prepend("<i class='fa fa-pencil'>");
    return icon.prop("outerHTML");
}