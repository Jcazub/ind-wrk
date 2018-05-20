$(document).ready(function () {
    $('H1').css("text-align", "center");
    $('H2').css("text-align", "center");
    $(".col-md-6 ul").css({"text-align": "center", "list-style" : "inside"});
    $(".myBannerHeading").addClass("page-header");
    $(".page-header").removeClass("myBannerHeading");
    $("#yellowHeading").text("Yellow Team");
    var colorList = ["orange", "red", "blue", "yellow"];
    for (var i = 0; i < colorList.length; i++) {
      $("." + colorList[i]).css("background-color", colorList[i]);
    }
    $("#yellowTeamList").append("<li>Joseph Banks</li><li>Simon Jones</li>");
    $("#oops").hide();
    $("#footerPlaceholder").remove();
    $("#footer").append("p").html("Jesse Azubuike<br/>jcazub@gmail.com").css({"font-family": "Courier", "font-size": "24px", "text-align" : "center"});
});
