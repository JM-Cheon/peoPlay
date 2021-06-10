$(function () {
  // 파일 첨부
  $(".upload-text").val("파일을 첨부해주세요.");
  $(".input-file").change(function () {
    var i = $(this).val();
    $(".upload-text").val(i);
  });
});
