$(document).ready(function() {

loadVendingMachine();

$("#addDollarBtn").on('click', function() {
  addMoney(1);
});

$('#addQuarterBtn').on('click', function() {
  addMoney(.25);
});

$('#addDimeBtn').on('click', function() {
  addMoney(.1);
});

$('#addNickelBtn').on('click', function() {
  addMoney(.05);
});

$('#changeReturnBtn').on('click', function() {
  loadVendingMachine();
  clearErrorMessage();
  var returnedChange = returnChange();
  $('#changeOutput').val(returnedChange[0] + " quarters, " + returnedChange[1] + " dimes, " + returnedChange[2] + " nickels, " + returnedChange[3] + " pennies.");
  $('#messageBox').val('');
  $('#itemInput').val('');
  $('#cashInput').val('');
});

$('#makePurchaseBtn').on('click', function() {
  clearErrorMessage();
  makePurchase();
});

}); //docment ready end

function loadVendingMachine() {

  var contentContainer = $("#displayVendingItems");
  contentContainer.empty();

  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/items',
        success: function(data, status) {
          $.each(data, function (index, item) {
            var itemNumber = item.id;
            var itemName = item.name;
            var itemPrice = item.price;
            var itemQuantity = item.quantity;

            var displayItem = '<div class = "col-md-4"><div class="panel panel-default">'
            + '<a id=item'+itemNumber+'><div class = "panel-body">'
            + '<p class="text-left">' + itemNumber + '</p>'
            + '<p class="text-center">' + itemName + '</p>'
            + '<p class="text-center">' + itemPrice + '</p>'
            + '<br><p class="text-center">' + itemQuantity + '</p>'
            + '</div></a></div></div>';

            contentContainer.append(displayItem);

            $('#item'+itemNumber).on('click', function() {
              $('#itemInput').val(itemNumber);
            });
          });
        },
        error: function() {
          displayErrorMessage('Error calling web service.  Please try again later.');
        } //error end
    }); //ajax end
} //function end

function addMoney(cashValue) {
  var cash = $("#cashInput");
  if (cash.val() != "") {
    var fromInput = cash.val();
    var money = (fromInput * 1) + cashValue;
    cash.val(money.toFixed(2));
  } else {
    cash.val(cashValue);
  }
}

function makePurchase() {
  if(inputValidation()) {
    $.ajax({
      type: 'GET',
      url: 'http://localhost:8080/money/' + $('#cashInput').val()+'/item/'+$('#itemInput').val(),
      success: function (data, status) {
          $('#changeOutput').val(data.quarters + " quarters, " + data.dimes + " dimes, " + data.nickels + " nickels, " + data.pennies + " pennies.");
          $('#messageBox').val('Thank You!!!');
          loadVendingMachine();
          $('#itemInput').val('');
          $('#cashInput').val('');
      },
      error: function(response, status, error) {
        if (response.status == 422) {
          var r = jQuery.parseJSON(response.responseText);
          $('#messageBox').val(r.message);
        } else {
          displayErrorMessage('Error calling web service.  Please try again later.');
        }
      } //error end
    });

  } //inputValidation end


}

function displayErrorMessage(message) {

  $('#errorMessages')
    .append($('<li>')
      .attr({class: 'list-group-item list-group-item-danger'})
      .text(message));
}

function clearErrorMessage() {
  $('#errorMessages').empty();
}

function inputValidation() {
  var message = $('#messageBox');
  if ($('#cashInput').val() == '') {
    displayErrorMessage('Please input cash');
    return false;
  } else if ($('#itemInput').val() == '') {
    displayErrorMessage('Please choose a selection');
    return false;
  }
  return true;
}

function returnChange() {
  var cash = $('#cashInput').val();
  var quarters = 0;
  var dimes = 0;
  var nickels = 0;
  var pennies = 0;

  while (cash > 0) {
    if (cash >= 0.25) {
      cash -= 0.25;
      quarters++;
    } else if (cash >= 0.10) {
      cash -= 0.10;
      dimes++;
    } else if (cash >= 0.05) {
      cash -= 0.05;
      nickels++;
    }
    cash = cash.toFixed(2);
  }

return [quarters, dimes, nickels, pennies];

}
