$(function () {
    $.get(
        'updateVisits',
        {},
        function () {
        }
    );
});
$(document).ready(function () {
   $.get(
       'getVisits',
       {},
       function (rst){
           $('#visits').append(rst);
       }
   ) ;
});