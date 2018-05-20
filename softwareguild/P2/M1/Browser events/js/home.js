$(document).ready(function () {

    //hides all non-main pages at start
    $("#akronInfoDiv").hide();
    $("#minneapolisInfoDiv").hide();
    $("#louisvilleInfoDiv").hide();

    $("#mainButton").on("click", function () {
      $("#akronInfoDiv").hide();
      $("#minneapolisInfoDiv").hide();
      $("#louisvilleInfoDiv").hide();
      $("#mainInfoDiv").show();
    });

    //=====Akron===========

    //shows akron info
    $("#akronButton").on("click", function () {
      $("#mainInfoDiv").hide();
      $("#minneapolisInfoDiv").hide();
      $("#louisvilleInfoDiv").hide();
      $("#akronWeather").hide();
      $("#akronInfoDiv").show();
    });

    //toggles akron weather
    $("#akronWeatherButton").on("click", function () {
      $("#akronWeather").toggle();
      if ($("#akronWeatherButton").text() == "Show Weather") {
        $(this).text("Hide Weather");
      } else {
        $(this).text("Show Weather");
      }
    });

    //======Minneapolis==============

    //shows minneapolis info
    $("#minneapolisButton").on("click", function () {
      $("#mainInfoDiv").hide();
      $("#akronInfoDiv").hide();
      $("#louisvilleInfoDiv").hide();
      $("#minneapolisWeather").hide();
      $("#minneapolisInfoDiv").show();
    });

    //toggles minneapolis weather
    $("#minneapolisWeatherButton").on("click", function () {
      $("#minneapolisWeather").toggle();
      if ($("#minneapolisWeatherButton").text() == "Show Weather") {
        $(this).text("Hide Weather");
      } else {
        $(this).text("Show Weather");
      }
    });

    //======Louisville================

    //shows minneapolis info
    $("#louisvilleButton").on("click", function () {
      $("#mainInfoDiv").hide();
      $("#akronInfoDiv").hide();
      $("#minneapolisInfoDiv").hide();
      $("#louisvilleWeather").hide();
      $("#louisvilleInfoDiv").show();
    });

    //toggles minneapolis weather
    $("#louisvilleWeatherButton").on("click", function () {
      $("#louisvilleWeather").toggle();
      if ($("#louisvilleWeatherButton").text() == "Show Weather") {
        $(this).text("Hide Weather");
      } else {
        $(this).text("Show Weather");
      }
    });


    //white smoke for tables
    $(".table tr").not(":first-child").hover(
      function() {
        $(this).css("background-color", "WhiteSmoke");
      },
      function() {
        $(this).css("background-color", "");
      }
    );

});
