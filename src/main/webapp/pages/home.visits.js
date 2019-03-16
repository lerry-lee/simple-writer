
$(function () {
   $.get(
       'getVisits',
       function (rst){
           $('#visits').append(rst);
       }
   ) ;
});