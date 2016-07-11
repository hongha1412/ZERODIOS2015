$(document).ready(function() {
    $('#news-table').DataTable({
        "order": [[0, "asc"]],
        "aoColumnDefs": [
            {"sClass" : "text-header"}
        ]
    });
});