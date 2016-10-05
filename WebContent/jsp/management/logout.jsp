<jsp:include page="/jsp/management/inc/header.jsp"></jsp:include>
<div class="modal-over">
  <div class="modal-center animated fadeInUp text-center" style="width:200px;margin:-80px 0 0 -100px;">
    <div class="thumb-md"><img src="/jsp/management/images/avatar.jpg" class="img-circle b-a b-light b-3x"></div>
    <p class="text-white h4 m-t m-b">${accountInfo.name}</p>
    <div class="input-group" data-validate="parsley">
      <input type="password" data-bind="value: relogpassword" class="form-control text-sm" name="relogpassword" id="relogpassword"
            data-required="true" data-minlength="6" data-maxlength="15" placeholder="Enter pwd to continue">
      <span class="input-group-btn">
        <button class="btn btn-success" type="button" data-bind="click: relogsubmit"><i class="fa fa-arrow-right"></i></button>
      </span>
    </div>
  </div>
</div>
<script src="/jsp/management/pagejs/logout.js"></script>