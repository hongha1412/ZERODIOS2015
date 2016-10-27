$(document).ready(function() {
    var screenModel = new ScreenModel();
    ko.applyBindings(screenModel);
});

function ScreenModel() {
    var self = this;
    self.currentNews = ko.observable(new CurrentNews());
    self.lsData = ko.observableArray([]);
    self.selectionChanged = function(evt, ui, data) {
        var rowData = ui.row;
        var selected = ko.utils.arrayFirst(self.lsData(), function(news) {
            return rowData.id === news.id();
        });
        var id = "0";
        if (selected !== undefined) {
            id = rowData.id;
        }
        self.editNews(id);
    }

//    var param = {condition: "{\"id\": \"1\", \"status\": \"1\"}"};
    $.ajax({
        type: "POST",
        url: "/adm/newsservlet",
//        data: param,
        async: true
    }).done(function(result) {
        var rs = $.parseJSON(result.replace(/\\/g, ''));
        if (Array.isArray(rs)) {
            $.each(rs, function() {
                self.lsData.push(new NewsObject(this.id, this.category, this.title, this.description, this.author, this.date, this.remark, this.pin, this.status, this.version));
            });
        } else {
            self.lsData.push(new NewsObject(rs.id, rs.category, rs.title, rs.description, rs.author, rs.date, rs.remark, rs.pin, rs.status, rs.version));
        }

        $("#news-table").igGrid({
            width: "100%",
            autoGenerateColumns: false,
            renderCheckboxes: true,
            primaryKey: "id",
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
                    name: 'Selection',
                    mode: 'row',
                    multipleSelection: false,
                    activation: false,
                    rowSelectionChanged: self.selectionChanged
                },
                {
                    name: "Responsive"
                },
                {
                    name: "Resizing"
                }
            ],
            dataSource: rs,
            rendered: function(evt, ui) {
                $('#news-table').igGridSelection('selectRow', 0);
                self.editNews($('#news-table').igGrid('selectedRow').id);
            }
        });
        
    });
}

ScreenModel.prototype.editNews = function(newsId) {
    var self = this;
    if (newsId === undefined || self.lsData() === undefined || self.lsData().length <= 0) {
        return;
    }
    $.each(self.lsData(), function() {
        if (this.id() + "" === newsId) {
            self.currentNews().load(this);
            return;
        }
    });
    
}

function CurrentNews() {
    var self = this;
    self.id = ko.observable();
    self.category = ko.observable();
    self.title = ko.observable();
    self.description = ko.observable();
    self.author = ko.observable();
    self.date = ko.observable();
    self.pin = ko.observable(false);
    self.remark = ko.observable(0);
    self.status = ko.observable();
    self.version = ko.observable();
}

CurrentNews.prototype.load = function(newsObject) {
    var self = this;
    self.id(newsObject.id());
    self.category(newsObject.category());
    self.title(newsObject.title());
    self.description(newsObject.description());
    self.author(newsObject.author());
    self.date(newsObject.date());
    self.pin(newsObject.pin());
    self.remark(newsObject.remark());
    self.status(newsObject.status());
    self.version(newsObject.version());
}

CurrentNews.prototype.submit = function() {
    var self = this;
    $("#current-news-form").parsley().validate();
}

CurrentNews.prototype.validate = function() {
    var self = this;
}

function NewsObject(id, category, title, description, author, date, remark, pin, status, version) {
    var self = this;
    self.id = ko.observable(id);
    self.category = ko.observable(category);
    self.title = ko.observable(title);
    self.description = ko.observable(description);
    self.author = ko.observable(author);
    self.date = ko.observable(date);
    self.remark = ko.observable(remark);
    self.pin = ko.observable(pin);
    self.status = ko.observable(status);
    self.version = ko.observable(version);
}

function EditIcon(value, data, self) {
    var icon = $("<a href='#edit' class='edit-news' data-bind='click: submit' data-toggle='modal'>").prepend("<i class='fa fa-pencil'>");
    return icon.prop("outerHTML");
}