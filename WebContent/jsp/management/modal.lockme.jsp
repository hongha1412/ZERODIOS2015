<meta charset="utf-8" />
<meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" /> 
<link rel="stylesheet" href="/jsp/management/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="/jsp/management/css/animate.css" type="text/css" />
<link rel="stylesheet" href="/jsp/management/css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="/jsp/management/css/font.css" type="text/css" />
<link rel="stylesheet" href="/jsp/management/js/calendar/bootstrap_calendar.css" type="text/css" />
<link rel="stylesheet" href="/jsp/management/css/app.css" type="text/css" />
<script src="/jsp/management/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/jsp/management/js/bootstrap.js"></script>
<!-- App -->
<script src="/jsp/management/js/app.js"></script> 
<script src="/jsp/management/js/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/jsp/management/js/charts/easypiechart/jquery.easy-pie-chart.js"></script>
<script src="/jsp/management/js/charts/sparkline/jquery.sparkline.min.js"></script>
<script src="/jsp/management/js/charts/flot/jquery.flot.min.js"></script>
<script src="/jsp/management/js/charts/flot/jquery.flot.tooltip.min.js"></script>
<script src="/jsp/management/js/charts/flot/jquery.flot.resize.js"></script>
<script src="/jsp/management/js/charts/flot/jquery.flot.grow.js"></script>
<script src="/jsp/management/js/charts/flot/demo.js"></script>

<script src="/jsp/management/js/calendar/bootstrap_calendar.js"></script>
<script src="/jsp/management/js/calendar/demo.js"></script>

<script src="/jsp/management/js/sortable/jquery.sortable.js"></script>
<script src="/jsp/management/js/app.plugin.js"></script>
<script src="/jsp/management/js/parsley/parsley.min.js"></script>
<script src="/jsp/management/js/parsley/parsley.extend.js"></script>
<script src="/js/knockout-3.4.0.js"></script>
<!--[if lt IE 9]>
  <script src="/jsp/management/js/ie/html5shiv.js"></script>
  <script src="/jsp/management/js/ie/respond.min.js"></script>
  <script src="/jsp/management/js/ie/excanvas.js"></script>
<![endif]-->


<div class="modal-over">
  <div class="modal-center animated fadeInUp text-center" style="width:200px;margin:-80px 0 0 -100px;">
    <div class="thumb-md"><img src="images/avatar.jpg" class="img-circle b-a b-light b-3x"></div>
    <p class="text-white h4 m-t m-b">${accountInfo.name}</p>
    <div class="input-group">
      <input type="password" class="form-control text-sm" placeholder="Enter pwd to continue">
      <span class="input-group-btn">
        <button class="btn btn-success" type="button" data-dismiss="modal"><i class="fa fa-arrow-right"></i></button>
      </span>
    </div>
  </div>
</div>
<script>$.getScript("/jsp/management/pagejs/logout.js");</script>