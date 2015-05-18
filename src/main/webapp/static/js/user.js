$(function() {
    $("#paginate").pagination({
        items: $("#itemCount").val() ,
        itemsOnPage: 6,
        displayedPages: 3,
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
                $('#mytbody').append('<tr><td>'+id+'</td><td>'+name+'</td><td>'+createdDate+'</td><td>'+modifiedDate+'</td><td>'+'<a href="editUser">Edit</a>'+'</td><td>'+'<a href="deleteUser">Delete</a>'+'</td></tr>')
            }
        }

    });

};