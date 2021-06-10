$(function () {
  // FAQ
  var article = $(".p-board-faq>.p-faq-item");
  article.addClass("hide");
  article.find(".p-faq-answer").hide();
  article.eq(0).removeClass("hide");
  article.eq(0).find(".p-faq-answer").show();
  $(".p-faq-question").click(function () {
    var myArticle = $(this).parents(".p-faq-item");
    if (myArticle.hasClass("hide")) {
      article.addClass("hide").removeClass("show");
      article.find(".p-faq-answer").slideUp(400);
      myArticle.removeClass("hide").addClass("show");
      myArticle.find(".p-faq-answer").slideDown(400);
    } else {
      myArticle.removeClass("show").addClass("hide");
      myArticle.find(".p-faq-answer").slideUp(400);
    }
    return false;
  });
});
