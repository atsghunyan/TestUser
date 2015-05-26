$(function() {
    $("#paginate").pagination({
        items: $("#itemCount").val() ,
        itemsOnPage: 3,
        displayedPages: 5,
        cssStyle: 'light-theme',
        currentPage: 1,
        hrefTextPrefix: "/#",
        onInit: function(){filTable(1)},
        onPageClick: function(pageNumber){filTable(pageNumber)}
    });
});


function filTable(page) {
    var page = page;
    //alert(page);
    $.ajax({
        url : '/getAll/'+page,
        type : 'POST',

        dataType : 'json',
        error : function() {
            console.log('error');
        },
        success : function(userList) {
            $("#mytbody").empty();

            for (var i = 0; i < userList.length; i++) {
                var id = userList[i].id;
                var name  = userList[i].name;
                var createdDate  = userList[i].createdDate;
                var modifiedDate  = userList[i].modifiedDate;
                $('#mytbody').append('<tr><td>'+id+'</td><td>'+name+'</td><td>'+createdDate+'</td><td>'+modifiedDate+'</td><td>'+'<a href="/editUser/'+id+'" data-toggle="modal" data-target="#detailForm"><b>Edit / Delete</b></a>'+'</td></tr>')
            }
        }

    });

};

function submitUserForm() {
    // getting the user form values
    var name = $('#name').val().trim();

    if(name.length ==0) {
        alert('Please enter name');
        $('#name').focus();
        return false;
    }

    return true;
};


$(function(){

    $( "#ItOp" ).change(function() {
        var rn = $("#ItOp").val();
        var x;
        $(function() {
            x = $("#paginate").pagination('getCurrentPage');
        });
        $(function() {
            $("#paginate").pagination('updateItemsOnPage', rn);
        });
        //$("#itemsOP").val("rn");
        //alert(x );


        $.ajax({
            url : '/itemOnPage/'+rn,
            type : 'POST',

            //dataType : 'json',
            error : function() {
                console.log('error');
            },
            success : function(success) {

                $(function() {
                    $("#paginate").pagination('selectPage', 1);
                });
                filTable(1);

            }
        });
    });
});


$(function() {
    $("#detailForm").on('hide.bs.modal', function () {
    // do something…
        location.reload();
    });
});

